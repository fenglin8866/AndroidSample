/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(ExperimentalMaterial3Api::class)

package androidx.compose.material3.samples

import androidx.annotation.Sampled
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.then
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.maxTextLength
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly

@Preview
@Sampled
@Composable
fun SimpleTextFieldSample() {

}

@Preview
@Sampled
@Composable
fun SimpleOutlinedTextFieldSample() {

}

@Preview
@Sampled
@Composable
fun TextFieldWithTransformations() {

}

@Preview
@Sampled
@Composable
fun TextFieldWithIcons() {

}

@Preview
@Sampled
@Composable
fun TextFieldWithPlaceholder() {

}

@Preview
@Sampled
@Composable
fun TextFieldWithPrefixAndSuffix() {

}

@Preview
@Sampled
@Composable
fun TextFieldWithErrorState() {

}

@Preview
@Sampled
@Composable
fun TextFieldWithSupportingText() {

}

@Preview
@Sampled
@Composable
fun PasswordTextField() {

}

@Preview
@Sampled
@Composable
fun TextFieldWithInitialValueAndSelection() {

}

@Preview
@Sampled
@Composable
fun OutlinedTextFieldWithInitialValueAndSelection() {

}

@Preview
@Sampled
@Composable
fun DenseTextFieldContentPadding() {

}

@Preview
@Sampled
@Composable
fun TextFieldWithHideKeyboardOnImeAction() {

}

@Composable
fun TextArea() {
    val state =
        rememberTextFieldState(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quisque " +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non  proident, sunt in " +
                "culpa qui officia deserunt mollit anim id est laborum."
        )
//    TextField(state = state, modifier = Modifier.height(120.dp), label = { Text("Label") })
}

@Preview
@Sampled
@Composable
fun CustomTextFieldUsingDecorator() {
    val state = rememberTextFieldState()
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val isError = false
    val lineLimits = TextFieldLineLimits.SingleLine


}

@Preview
@Sampled
@Composable
fun CustomOutlinedTextFieldUsingDecorator() {

}

@Preview
@Sampled
@Composable
fun CustomTextFieldBasedOnDecorationBox() {
    var text by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val isError = false
    val singleLine = true

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier,
        interactionSource = interactionSource,
        enabled = enabled,
        singleLine = singleLine,
        textStyle = LocalTextStyle.current,
        decorationBox = { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = text,
                innerTextField = innerTextField,
                visualTransformation = VisualTransformation.None,
                singleLine = singleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource,
                container = {
                    TextFieldDefaults.Container(
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        // Update indicator line thickness
                        unfocusedIndicatorLineThickness = 2.dp,
                        focusedIndicatorLineThickness = 4.dp,
                    )
                }
            )
        }
    )
}

@Preview
@Sampled
@Composable
fun CustomOutlinedTextFieldBasedOnDecorationBox() {
    var text by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val isError = false
    val singleLine = true

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier,
        interactionSource = interactionSource,
        enabled = enabled,
        singleLine = singleLine,
        textStyle = LocalTextStyle.current,
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = text,
                innerTextField = innerTextField,
                visualTransformation = VisualTransformation.None,
                singleLine = singleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource,
                container = {
                    OutlinedTextFieldDefaults.Container(
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        // Update border thickness and shape
                        shape = RectangleShape,
                        unfocusedBorderThickness = 2.dp,
                        focusedBorderThickness = 4.dp
                    )
                },
            )
        }
    )
}
