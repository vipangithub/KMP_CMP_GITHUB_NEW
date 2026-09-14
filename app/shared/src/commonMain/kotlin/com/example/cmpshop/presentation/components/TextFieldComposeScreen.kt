package com.example.cmpshop.presentation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmpshop.app.shared.generated.resources.Res
import cmpshop.app.shared.generated.resources.eye_off
import cmpshop.app.shared.generated.resources.eye_on
import org.jetbrains.compose.resources.painterResource

@Composable
fun TextFieldComposeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TextField Example") }
            )
        }
    ) { inner ->
        var textFiled1 by remember { mutableStateOf("") }
        var emailTextFiled by remember { mutableStateOf("") }
        var passwordFiled by remember { mutableStateOf("") }
        var rememberVisible by remember { mutableStateOf(false) }
        var mobileField by remember { mutableStateOf("") }
        val isInValid = mobileField.isNotEmpty() && (mobileField.length !in 9..10)

        Column(
            modifier = Modifier.padding(inner)
                .padding(20.dp)
                .verticalScroll(ScrollState(1)),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // TextFiled
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textFiled1,
                onValueChange = {
                    textFiled1 = it
                },
                label = { Text("TextFiled1") },
                placeholder = { Text("Enter Text") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailTextFiled,
                onValueChange = {
                    emailTextFiled = it
                },
                label = { Text("Email",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                    ) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                placeholder = {
                    Text("Enter Email",
                    //    color = Color.Gray
                        color = MaterialTheme.colorScheme.onSurfaceVariant

                    )
                },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "",
                        tint = Color.Blue
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "",
                        tint = Color.Blue
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordFiled,
                onValueChange = { passwordFiled = it },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            rememberVisible = !rememberVisible
                        }
                    ) {
                        Icon(
                            painter =
                                if (rememberVisible) {
                                    painterResource(Res.drawable.eye_on)
                                } else {
                                    painterResource(Res.drawable.eye_off)
                                }, tint = Color.Blue,
                            contentDescription = ""
                        )
                    }
                },
                singleLine = true,
                label = { Text("Password") },
                placeholder = { Text("Enter Password") },
                visualTransformation = if (!rememberVisible) PasswordVisualTransformation('#')
                else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = mobileField,
                onValueChange = {mobileField = it},
                label = {Text("Mobile", color = MaterialTheme.colorScheme.primary)},
                // instead of color here used TextFieldDefaults color
                placeholder = {Text("Enter mobile")},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                ),

                singleLine = true,
                isError = isInValid,
                supportingText = {
                    if(isInValid) Text("Mobile number invalid")
                    else Text("")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    errorBorderColor = MaterialTheme.colorScheme.error,
                    errorLabelColor =MaterialTheme.colorScheme.error,
                    errorSupportingTextColor = MaterialTheme.colorScheme.error,
                    errorSuffixColor = MaterialTheme.colorScheme.error,

                   // focusedLabelColor = Color.Blue,
                   // unfocusedLabelColor = Color.Gray,

//                    // Border
//                    focusedBorderColor = Color.Blue,
//                    unfocusedBorderColor = Color.Gray,
//
//                    // Text
//                    focusedTextColor = Color.Black,
//                    unfocusedTextColor = Color.DarkGray,
//
//                    // Cursor
//                    cursorColor = Color.Blue,

                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,

                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface,

                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,

                    cursorColor = MaterialTheme.colorScheme.primary

//                    focusedIndicatorColor = Color.Blue,
//        unfocusedIndicatorColor = Color.Gray,
//        focusedLabelColor = Color.Blue,
//        unfocusedLabelColor = Color.Gray,
//        focusedLeadingIconColor = Color.Blue,
//        unfocusedLeadingIconColor = Color.Gray,
//        focusedTrailingIconColor = Color.Red,
//        unfocusedTrailingIconColor = Color.Gray,
//        focusedPlaceholderColor = Color.LightGray,
//        unfocusedPlaceholderColor = Color.Gray
                ),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )

        }

    }
}