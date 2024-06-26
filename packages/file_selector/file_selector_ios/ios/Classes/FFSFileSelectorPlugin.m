// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

#import "FFSFileSelectorPlugin.h"
#import "FFSFileSelectorPlugin_Test.h"
#import "messages.g.h"

#import <objc/runtime.h>

// TODO(stuartmorgan): When migrating to Swift, eliminate this in favor of
// adding FFSViewPresenter conformance to UIViewController.
@interface FFSPresentingViewController : NSObject <FFSViewPresenter>
- (instancetype)initWithViewController:(nullable UIViewController *)controller;
// The wrapped controller.
@property(nonatomic) UIViewController *controller;
@end

@implementation FFSPresentingViewController
- (instancetype)initWithViewController:(nullable UIViewController *)controller {
  self = [super init];
  if (self) {
    _controller = controller;
  }
  return self;
}

- (void)presentViewController:(UIViewController *)viewControllerToPresent
                     animated:(BOOL)animated
                   completion:(void (^__nullable)(void))completion {
  [self.controller presentViewController:viewControllerToPresent
                                animated:animated
                              completion:completion];
}
@end

#pragma mark -

@implementation FFSFileSelectorPlugin

#pragma mark - FFSFileSelectorApi

- (void)openFileSelectorWithConfig:(FFSFileSelectorConfig *)config
                        completion:(void (^)(NSArray<NSString *> *_Nullable,
                                             FlutterError *_Nullable))completion {
  UIDocumentPickerViewController *documentPicker =
      self.documentPickerViewControllerOverride
          ?: [[UIDocumentPickerViewController alloc]
                 initWithDocumentTypes:config.utis
                                inMode:UIDocumentPickerModeImport];
  documentPicker.delegate = self;
  documentPicker.allowsMultipleSelection = config.allowMultiSelection;

  id<FFSViewPresenter> presenter =
      self.viewPresenterOverride
          ?: [[FFSPresentingViewController alloc]
                 initWithViewController:UIApplication.sharedApplication.delegate.window
                                            .rootViewController];
  if (presenter) {
    objc_setAssociatedObject(documentPicker, @selector(openFileSelectorWithConfig:completion:),
                             completion, OBJC_ASSOCIATION_COPY_NONATOMIC);
    [presenter presentViewController:documentPicker animated:YES completion:nil];
  } else {
    completion(nil, [FlutterError errorWithCode:@"error"
                                        message:@"Missing root view controller."
                                        details:nil]);
  }
}

#pragma mark - FlutterPlugin

+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar> *)registrar {
  FFSFileSelectorPlugin *plugin = [[FFSFileSelectorPlugin alloc] init];
  SetUpFFSFileSelectorApi(registrar.messenger, plugin);
}

#pragma mark - UIDocumentPickerDelegate

- (void)documentPicker:(UIDocumentPickerViewController *)controller
    didPickDocumentsAtURLs:(NSArray<NSURL *> *)urls {
  NSMutableArray *paths = [NSMutableArray arrayWithCapacity:urls.count];
  for (NSURL *url in urls) {
    [paths addObject:url.path];
  };
  [self sendBackResults:paths error:nil forPicker:controller];
}

- (void)documentPickerWasCancelled:(UIDocumentPickerViewController *)controller {
  [self sendBackResults:@[] error:nil forPicker:controller];
}

#pragma mark - Helper Methods

- (void)sendBackResults:(NSArray<NSString *> *)results
                  error:(FlutterError *)error
              forPicker:(UIDocumentPickerViewController *)picker {
  void (^completionBlock)(NSArray<NSString *> *, FlutterError *) =
      objc_getAssociatedObject(picker, @selector(openFileSelectorWithConfig:completion:));
  if (completionBlock) {
    completionBlock(results, error);
    objc_setAssociatedObject(picker, @selector(openFileSelectorWithConfig:completion:), nil,
                             OBJC_ASSOCIATION_ASSIGN);
  }
}

@end
