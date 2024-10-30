// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
// Autogenerated from Pigeon (v22.4.1), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package io.flutter.plugins.urllauncher;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression", "serial"})
public class Messages {

  /** Error class for passing custom error details to Flutter via a thrown PlatformException. */
  public static class FlutterError extends RuntimeException {

    /** The error code. */
    public final String code;

    /** The error details. Must be a datatype supported by the api codec. */
    public final Object details;

    public FlutterError(@NonNull String code, @Nullable String message, @Nullable Object details) {
      super(message);
      this.code = code;
      this.details = details;
    }
  }

  @NonNull
  protected static ArrayList<Object> wrapError(@NonNull Throwable exception) {
    ArrayList<Object> errorList = new ArrayList<>(3);
    if (exception instanceof FlutterError) {
      FlutterError error = (FlutterError) exception;
      errorList.add(error.code);
      errorList.add(error.getMessage());
      errorList.add(error.details);
    } else {
      errorList.add(exception.toString());
      errorList.add(exception.getClass().getSimpleName());
      errorList.add(
          "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }
    return errorList;
  }

  @Target(METHOD)
  @Retention(CLASS)
  @interface CanIgnoreReturnValue {}

  /**
   * Configuration options for an in-app WebView.
   *
   * <p>Generated class from Pigeon that represents data sent in messages.
   */
  public static final class WebViewOptions {
    private @NonNull Boolean enableJavaScript;

    public @NonNull Boolean getEnableJavaScript() {
      return enableJavaScript;
    }

    public void setEnableJavaScript(@NonNull Boolean setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"enableJavaScript\" is null.");
      }
      this.enableJavaScript = setterArg;
    }

    private @NonNull Boolean enableDomStorage;

    public @NonNull Boolean getEnableDomStorage() {
      return enableDomStorage;
    }

    public void setEnableDomStorage(@NonNull Boolean setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"enableDomStorage\" is null.");
      }
      this.enableDomStorage = setterArg;
    }

    private @NonNull Map<String, String> headers;

    public @NonNull Map<String, String> getHeaders() {
      return headers;
    }

    public void setHeaders(@NonNull Map<String, String> setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"headers\" is null.");
      }
      this.headers = setterArg;
    }

    /** Constructor is non-public to enforce null safety; use Builder. */
    WebViewOptions() {}

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      WebViewOptions that = (WebViewOptions) o;
      return enableJavaScript.equals(that.enableJavaScript)
          && enableDomStorage.equals(that.enableDomStorage)
          && headers.equals(that.headers);
    }

    @Override
    public int hashCode() {
      return Objects.hash(enableJavaScript, enableDomStorage, headers);
    }

    public static final class Builder {

      private @Nullable Boolean enableJavaScript;

      @CanIgnoreReturnValue
      public @NonNull Builder setEnableJavaScript(@NonNull Boolean setterArg) {
        this.enableJavaScript = setterArg;
        return this;
      }

      private @Nullable Boolean enableDomStorage;

      @CanIgnoreReturnValue
      public @NonNull Builder setEnableDomStorage(@NonNull Boolean setterArg) {
        this.enableDomStorage = setterArg;
        return this;
      }

      private @Nullable Map<String, String> headers;

      @CanIgnoreReturnValue
      public @NonNull Builder setHeaders(@NonNull Map<String, String> setterArg) {
        this.headers = setterArg;
        return this;
      }

      public @NonNull WebViewOptions build() {
        WebViewOptions pigeonReturn = new WebViewOptions();
        pigeonReturn.setEnableJavaScript(enableJavaScript);
        pigeonReturn.setEnableDomStorage(enableDomStorage);
        pigeonReturn.setHeaders(headers);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<>(3);
      toListResult.add(enableJavaScript);
      toListResult.add(enableDomStorage);
      toListResult.add(headers);
      return toListResult;
    }

    static @NonNull WebViewOptions fromList(@NonNull ArrayList<Object> pigeonVar_list) {
      WebViewOptions pigeonResult = new WebViewOptions();
      Object enableJavaScript = pigeonVar_list.get(0);
      pigeonResult.setEnableJavaScript((Boolean) enableJavaScript);
      Object enableDomStorage = pigeonVar_list.get(1);
      pigeonResult.setEnableDomStorage((Boolean) enableDomStorage);
      Object headers = pigeonVar_list.get(2);
      pigeonResult.setHeaders((Map<String, String>) headers);
      return pigeonResult;
    }
  }

  /**
   * Configuration options for in-app browser views.
   *
   * <p>Generated class from Pigeon that represents data sent in messages.
   */
  public static final class BrowserOptions {
    /** Whether or not to show the webpage title. */
    private @NonNull Boolean showTitle;

    public @NonNull Boolean getShowTitle() {
      return showTitle;
    }

    public void setShowTitle(@NonNull Boolean setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"showTitle\" is null.");
      }
      this.showTitle = setterArg;
    }

    /** Constructor is non-public to enforce null safety; use Builder. */
    BrowserOptions() {}

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      BrowserOptions that = (BrowserOptions) o;
      return showTitle.equals(that.showTitle);
    }

    @Override
    public int hashCode() {
      return Objects.hash(showTitle);
    }

    public static final class Builder {

      private @Nullable Boolean showTitle;

      @CanIgnoreReturnValue
      public @NonNull Builder setShowTitle(@NonNull Boolean setterArg) {
        this.showTitle = setterArg;
        return this;
      }

      public @NonNull BrowserOptions build() {
        BrowserOptions pigeonReturn = new BrowserOptions();
        pigeonReturn.setShowTitle(showTitle);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<>(1);
      toListResult.add(showTitle);
      return toListResult;
    }

    static @NonNull BrowserOptions fromList(@NonNull ArrayList<Object> pigeonVar_list) {
      BrowserOptions pigeonResult = new BrowserOptions();
      Object showTitle = pigeonVar_list.get(0);
      pigeonResult.setShowTitle((Boolean) showTitle);
      return pigeonResult;
    }
  }

  private static class PigeonCodec extends StandardMessageCodec {
    public static final PigeonCodec INSTANCE = new PigeonCodec();

    private PigeonCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 129:
          return WebViewOptions.fromList((ArrayList<Object>) readValue(buffer));
        case (byte) 130:
          return BrowserOptions.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof WebViewOptions) {
        stream.write(129);
        writeValue(stream, ((WebViewOptions) value).toList());
      } else if (value instanceof BrowserOptions) {
        stream.write(130);
        writeValue(stream, ((BrowserOptions) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface UrlLauncherApi {
    /** Returns true if the URL can definitely be launched. */
    @NonNull
    Boolean canLaunchUrl(@NonNull String url);
    /** Opens the URL externally, returning true if successful. */
    @NonNull
    Boolean launchUrl(@NonNull String url, @NonNull Map<String, String> headers);
    /**
     * Opens the URL in an in-app Custom Tab or WebView, returning true if it opens successfully.
     */
    @NonNull
    Boolean openUrlInApp(
        @NonNull String url,
        @NonNull Boolean allowCustomTab,
        @NonNull WebViewOptions webViewOptions,
        @NonNull BrowserOptions browserOptions);

    @NonNull
    Boolean supportsCustomTabs();
    /** Closes the view opened by [openUrlInSafariViewController]. */
    void closeWebView();

    /** The codec used by UrlLauncherApi. */
    static @NonNull MessageCodec<Object> getCodec() {
      return PigeonCodec.INSTANCE;
    }
    /** Sets up an instance of `UrlLauncherApi` to handle messages through the `binaryMessenger`. */
    static void setUp(@NonNull BinaryMessenger binaryMessenger, @Nullable UrlLauncherApi api) {
      setUp(binaryMessenger, "", api);
    }

    static void setUp(
        @NonNull BinaryMessenger binaryMessenger,
        @NonNull String messageChannelSuffix,
        @Nullable UrlLauncherApi api) {
      messageChannelSuffix = messageChannelSuffix.isEmpty() ? "" : "." + messageChannelSuffix;
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger,
                "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.canLaunchUrl"
                    + messageChannelSuffix,
                getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                String urlArg = (String) args.get(0);
                try {
                  Boolean output = api.canLaunchUrl(urlArg);
                  wrapped.add(0, output);
                } catch (Throwable exception) {
                  wrapped = wrapError(exception);
                }
                reply.reply(wrapped);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger,
                "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.launchUrl"
                    + messageChannelSuffix,
                getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                String urlArg = (String) args.get(0);
                Map<String, String> headersArg = (Map<String, String>) args.get(1);
                try {
                  Boolean output = api.launchUrl(urlArg, headersArg);
                  wrapped.add(0, output);
                } catch (Throwable exception) {
                  wrapped = wrapError(exception);
                }
                reply.reply(wrapped);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger,
                "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.openUrlInApp"
                    + messageChannelSuffix,
                getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                String urlArg = (String) args.get(0);
                Boolean allowCustomTabArg = (Boolean) args.get(1);
                WebViewOptions webViewOptionsArg = (WebViewOptions) args.get(2);
                BrowserOptions browserOptionsArg = (BrowserOptions) args.get(3);
                try {
                  Boolean output =
                      api.openUrlInApp(
                          urlArg, allowCustomTabArg, webViewOptionsArg, browserOptionsArg);
                  wrapped.add(0, output);
                } catch (Throwable exception) {
                  wrapped = wrapError(exception);
                }
                reply.reply(wrapped);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger,
                "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.supportsCustomTabs"
                    + messageChannelSuffix,
                getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                try {
                  Boolean output = api.supportsCustomTabs();
                  wrapped.add(0, output);
                } catch (Throwable exception) {
                  wrapped = wrapError(exception);
                }
                reply.reply(wrapped);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger,
                "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.closeWebView"
                    + messageChannelSuffix,
                getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<>();
                try {
                  api.closeWebView();
                  wrapped.add(0, null);
                } catch (Throwable exception) {
                  wrapped = wrapError(exception);
                }
                reply.reply(wrapped);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
}