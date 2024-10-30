// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
// Autogenerated from Pigeon (v22.4.1), do not edit directly.
// See also: https://pub.dev/packages/pigeon

#undef _HAS_EXCEPTIONS

#include "messages.g.h"

#include <flutter/basic_message_channel.h>
#include <flutter/binary_messenger.h>
#include <flutter/encodable_value.h>
#include <flutter/standard_message_codec.h>

#include <map>
#include <optional>
#include <string>

namespace file_selector_windows {
using flutter::BasicMessageChannel;
using flutter::CustomEncodableValue;
using flutter::EncodableList;
using flutter::EncodableMap;
using flutter::EncodableValue;

FlutterError CreateConnectionError(const std::string channel_name) {
  return FlutterError(
      "channel-error",
      "Unable to establish connection on channel: '" + channel_name + "'.",
      EncodableValue(""));
}

// TypeGroup

TypeGroup::TypeGroup(const std::string& label, const EncodableList& extensions)
    : label_(label), extensions_(extensions) {}

const std::string& TypeGroup::label() const { return label_; }

void TypeGroup::set_label(std::string_view value_arg) { label_ = value_arg; }

const EncodableList& TypeGroup::extensions() const { return extensions_; }

void TypeGroup::set_extensions(const EncodableList& value_arg) {
  extensions_ = value_arg;
}

EncodableList TypeGroup::ToEncodableList() const {
  EncodableList list;
  list.reserve(2);
  list.push_back(EncodableValue(label_));
  list.push_back(EncodableValue(extensions_));
  return list;
}

TypeGroup TypeGroup::FromEncodableList(const EncodableList& list) {
  TypeGroup decoded(std::get<std::string>(list[0]),
                    std::get<EncodableList>(list[1]));
  return decoded;
}

// SelectionOptions

SelectionOptions::SelectionOptions(bool allow_multiple, bool select_folders,
                                   const EncodableList& allowed_types)
    : allow_multiple_(allow_multiple),
      select_folders_(select_folders),
      allowed_types_(allowed_types) {}

bool SelectionOptions::allow_multiple() const { return allow_multiple_; }

void SelectionOptions::set_allow_multiple(bool value_arg) {
  allow_multiple_ = value_arg;
}

bool SelectionOptions::select_folders() const { return select_folders_; }

void SelectionOptions::set_select_folders(bool value_arg) {
  select_folders_ = value_arg;
}

const EncodableList& SelectionOptions::allowed_types() const {
  return allowed_types_;
}

void SelectionOptions::set_allowed_types(const EncodableList& value_arg) {
  allowed_types_ = value_arg;
}

EncodableList SelectionOptions::ToEncodableList() const {
  EncodableList list;
  list.reserve(3);
  list.push_back(EncodableValue(allow_multiple_));
  list.push_back(EncodableValue(select_folders_));
  list.push_back(EncodableValue(allowed_types_));
  return list;
}

SelectionOptions SelectionOptions::FromEncodableList(
    const EncodableList& list) {
  SelectionOptions decoded(std::get<bool>(list[0]), std::get<bool>(list[1]),
                           std::get<EncodableList>(list[2]));
  return decoded;
}

// FileDialogResult

FileDialogResult::FileDialogResult(const EncodableList& paths)
    : paths_(paths) {}

FileDialogResult::FileDialogResult(const EncodableList& paths,
                                   const int64_t* type_group_index)
    : paths_(paths),
      type_group_index_(type_group_index
                            ? std::optional<int64_t>(*type_group_index)
                            : std::nullopt) {}

const EncodableList& FileDialogResult::paths() const { return paths_; }

void FileDialogResult::set_paths(const EncodableList& value_arg) {
  paths_ = value_arg;
}

const int64_t* FileDialogResult::type_group_index() const {
  return type_group_index_ ? &(*type_group_index_) : nullptr;
}

void FileDialogResult::set_type_group_index(const int64_t* value_arg) {
  type_group_index_ =
      value_arg ? std::optional<int64_t>(*value_arg) : std::nullopt;
}

void FileDialogResult::set_type_group_index(int64_t value_arg) {
  type_group_index_ = value_arg;
}

EncodableList FileDialogResult::ToEncodableList() const {
  EncodableList list;
  list.reserve(2);
  list.push_back(EncodableValue(paths_));
  list.push_back(type_group_index_ ? EncodableValue(*type_group_index_)
                                   : EncodableValue());
  return list;
}

FileDialogResult FileDialogResult::FromEncodableList(
    const EncodableList& list) {
  FileDialogResult decoded(std::get<EncodableList>(list[0]));
  auto& encodable_type_group_index = list[1];
  if (!encodable_type_group_index.IsNull()) {
    decoded.set_type_group_index(std::get<int64_t>(encodable_type_group_index));
  }
  return decoded;
}

PigeonInternalCodecSerializer::PigeonInternalCodecSerializer() {}

EncodableValue PigeonInternalCodecSerializer::ReadValueOfType(
    uint8_t type, flutter::ByteStreamReader* stream) const {
  switch (type) {
    case 129: {
      return CustomEncodableValue(TypeGroup::FromEncodableList(
          std::get<EncodableList>(ReadValue(stream))));
    }
    case 130: {
      return CustomEncodableValue(SelectionOptions::FromEncodableList(
          std::get<EncodableList>(ReadValue(stream))));
    }
    case 131: {
      return CustomEncodableValue(FileDialogResult::FromEncodableList(
          std::get<EncodableList>(ReadValue(stream))));
    }
    default:
      return flutter::StandardCodecSerializer::ReadValueOfType(type, stream);
  }
}

void PigeonInternalCodecSerializer::WriteValue(
    const EncodableValue& value, flutter::ByteStreamWriter* stream) const {
  if (const CustomEncodableValue* custom_value =
          std::get_if<CustomEncodableValue>(&value)) {
    if (custom_value->type() == typeid(TypeGroup)) {
      stream->WriteByte(129);
      WriteValue(EncodableValue(
                     std::any_cast<TypeGroup>(*custom_value).ToEncodableList()),
                 stream);
      return;
    }
    if (custom_value->type() == typeid(SelectionOptions)) {
      stream->WriteByte(130);
      WriteValue(
          EncodableValue(
              std::any_cast<SelectionOptions>(*custom_value).ToEncodableList()),
          stream);
      return;
    }
    if (custom_value->type() == typeid(FileDialogResult)) {
      stream->WriteByte(131);
      WriteValue(
          EncodableValue(
              std::any_cast<FileDialogResult>(*custom_value).ToEncodableList()),
          stream);
      return;
    }
  }
  flutter::StandardCodecSerializer::WriteValue(value, stream);
}

/// The codec used by FileSelectorApi.
const flutter::StandardMessageCodec& FileSelectorApi::GetCodec() {
  return flutter::StandardMessageCodec::GetInstance(
      &PigeonInternalCodecSerializer::GetInstance());
}

// Sets up an instance of `FileSelectorApi` to handle messages through the
// `binary_messenger`.
void FileSelectorApi::SetUp(flutter::BinaryMessenger* binary_messenger,
                            FileSelectorApi* api) {
  FileSelectorApi::SetUp(binary_messenger, api, "");
}

void FileSelectorApi::SetUp(flutter::BinaryMessenger* binary_messenger,
                            FileSelectorApi* api,
                            const std::string& message_channel_suffix) {
  const std::string prepended_suffix =
      message_channel_suffix.length() > 0
          ? std::string(".") + message_channel_suffix
          : "";
  {
    BasicMessageChannel<> channel(binary_messenger,
                                  "dev.flutter.pigeon.file_selector_windows."
                                  "FileSelectorApi.showOpenDialog" +
                                      prepended_suffix,
                                  &GetCodec());
    if (api != nullptr) {
      channel.SetMessageHandler(
          [api](const EncodableValue& message,
                const flutter::MessageReply<EncodableValue>& reply) {
            try {
              const auto& args = std::get<EncodableList>(message);
              const auto& encodable_options_arg = args.at(0);
              if (encodable_options_arg.IsNull()) {
                reply(WrapError("options_arg unexpectedly null."));
                return;
              }
              const auto& options_arg = std::any_cast<const SelectionOptions&>(
                  std::get<CustomEncodableValue>(encodable_options_arg));
              const auto& encodable_initial_directory_arg = args.at(1);
              const auto* initial_directory_arg =
                  std::get_if<std::string>(&encodable_initial_directory_arg);
              const auto& encodable_confirm_button_text_arg = args.at(2);
              const auto* confirm_button_text_arg =
                  std::get_if<std::string>(&encodable_confirm_button_text_arg);
              ErrorOr<FileDialogResult> output = api->ShowOpenDialog(
                  options_arg, initial_directory_arg, confirm_button_text_arg);
              if (output.has_error()) {
                reply(WrapError(output.error()));
                return;
              }
              EncodableList wrapped;
              wrapped.push_back(
                  CustomEncodableValue(std::move(output).TakeValue()));
              reply(EncodableValue(std::move(wrapped)));
            } catch (const std::exception& exception) {
              reply(WrapError(exception.what()));
            }
          });
    } else {
      channel.SetMessageHandler(nullptr);
    }
  }
  {
    BasicMessageChannel<> channel(binary_messenger,
                                  "dev.flutter.pigeon.file_selector_windows."
                                  "FileSelectorApi.showSaveDialog" +
                                      prepended_suffix,
                                  &GetCodec());
    if (api != nullptr) {
      channel.SetMessageHandler(
          [api](const EncodableValue& message,
                const flutter::MessageReply<EncodableValue>& reply) {
            try {
              const auto& args = std::get<EncodableList>(message);
              const auto& encodable_options_arg = args.at(0);
              if (encodable_options_arg.IsNull()) {
                reply(WrapError("options_arg unexpectedly null."));
                return;
              }
              const auto& options_arg = std::any_cast<const SelectionOptions&>(
                  std::get<CustomEncodableValue>(encodable_options_arg));
              const auto& encodable_initial_directory_arg = args.at(1);
              const auto* initial_directory_arg =
                  std::get_if<std::string>(&encodable_initial_directory_arg);
              const auto& encodable_suggested_name_arg = args.at(2);
              const auto* suggested_name_arg =
                  std::get_if<std::string>(&encodable_suggested_name_arg);
              const auto& encodable_confirm_button_text_arg = args.at(3);
              const auto* confirm_button_text_arg =
                  std::get_if<std::string>(&encodable_confirm_button_text_arg);
              ErrorOr<FileDialogResult> output = api->ShowSaveDialog(
                  options_arg, initial_directory_arg, suggested_name_arg,
                  confirm_button_text_arg);
              if (output.has_error()) {
                reply(WrapError(output.error()));
                return;
              }
              EncodableList wrapped;
              wrapped.push_back(
                  CustomEncodableValue(std::move(output).TakeValue()));
              reply(EncodableValue(std::move(wrapped)));
            } catch (const std::exception& exception) {
              reply(WrapError(exception.what()));
            }
          });
    } else {
      channel.SetMessageHandler(nullptr);
    }
  }
}

EncodableValue FileSelectorApi::WrapError(std::string_view error_message) {
  return EncodableValue(
      EncodableList{EncodableValue(std::string(error_message)),
                    EncodableValue("Error"), EncodableValue()});
}

EncodableValue FileSelectorApi::WrapError(const FlutterError& error) {
  return EncodableValue(EncodableList{EncodableValue(error.code()),
                                      EncodableValue(error.message()),
                                      error.details()});
}

}  // namespace file_selector_windows
