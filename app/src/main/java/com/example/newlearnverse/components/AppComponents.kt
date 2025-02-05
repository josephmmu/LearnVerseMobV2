package com.example.newlearnverse.components

import android.media.audiofx.AudioEffect.Descriptor
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlearnverse.R
import com.example.newlearnverse.ui.theme.Pink40
import com.example.newlearnverse.ui.theme.Purple40

@Composable
fun NormalTextComponents(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(min = 80.dp),
        style = TextStyle(
            fontSize =  18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
        , color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponents(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(min = 80.dp),
        style = TextStyle(
            fontSize =  30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun PasswordTextFieldComponent(labelValue: String, painterResource: Painter, errorStatus: Boolean = false) {

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            unfocusedContainerColor = colorResource(id = R.color.colorGray)
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus
    )
}

@Composable
fun TextFieldComponent(labelValue: String, painterResource: Painter) {

    val textValue = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .border( BorderStroke(1.dp, color = colorResource(id = R.color.colorGray) ))
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            unfocusedContainerColor = colorResource(id = R.color.colorGray)
        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,

        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it

        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },

        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    )
}

@Composable
fun MyButtonComponent(value: String) {

    Button(onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Purple40, Pink40)),
                shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    onOpenDrawer: () -> Unit
) {
    TopAppBar(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(100.dp)), // To make it rounded
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        windowInsets = WindowInsets(top = 0.dp),
        title = {
            Text(text = "Home",
                color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                fontSize = 17.sp)
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(27.dp)
                    .clickable{ onOpenDrawer() }
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(30.dp)
            )
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 4.dp, end = 16.dp)
                    .size(30.dp)
            )
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyTextField(modifier : Modifier = Modifier,
                   leadingIcon: ImageVector? = null,
                   trailingIcon: ImageVector? = null,
                   trailingText: String? = null,
                   textFieldState: TextFieldState,
                   hint: String,
                   keyboardType: KeyboardType = KeyboardType.Text,
                   isPassword: Boolean = false,
                   onLeadingClick: () -> Unit = {},
                   onTrailingClick: () -> Unit = {}) {
    if (isPassword) {
        PasswordTextField(
            modifier = modifier,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            trailingText = trailingText,
            textFieldState = textFieldState,
            hint = hint,
            onLeadingClick = onLeadingClick,
            onTrailingClick = onTrailingClick
        )
    } else {
        EmailTextField(
            modifier = modifier,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            trailingText = trailingText,
            textFieldState = textFieldState,
            hint = hint ,
            keyboardType = keyboardType,
            onLeadingClick = onLeadingClick,
            onTrailingClick = onTrailingClick
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EmailTextField(
    modifier : Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    trailingText: String? = null,
    textFieldState: TextFieldState,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onLeadingClick: () -> Unit = {},
    onTrailingClick: () -> Unit = {}
) {
    BasicTextField2(
        state = textFieldState,
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onBackground
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        lineLimits = TextFieldLineLimits.SingleLine,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        modifier = modifier,
        decorator = {innerTextField ->
            Column {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    if(leadingIcon != null) {
                        Icon(
                            imageVector = leadingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f),
                            modifier = Modifier
                                .clickable{onLeadingClick()}
                        )

                        Spacer(modifier = Modifier.width(16.dp))
                    }

                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if (textFieldState.text.isEmpty()) {
                            Text(text = hint,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.4f),
                                modifier = Modifier.fillMaxWidth())
                        }
                        innerTextField()
                    }

                    if(trailingIcon != null) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f),
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clickable{onTrailingClick()}
                        )
                    } else if  (trailingText != null){
                        Text(
                            text = trailingText,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(end = 4.dp)
                                .clickable{onTrailingClick()}
                        )
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))

                HorizontalDivider(modifier = Modifier.alpha(0.7f))
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PasswordTextField(
    modifier : Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    trailingText: String? = null,
    textFieldState: TextFieldState,
    hint: String,
    onLeadingClick: () -> Unit = {},
    onTrailingClick: () -> Unit = {}
) {
    BasicSecureTextField(
        state = textFieldState,
        textObfuscationMode = TextObfuscationMode.Hidden ,
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onBackground
        ),
        keyboardType = KeyboardType.Password,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        modifier = modifier,
        decorator = {innerTextField ->
            Column {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    if(leadingIcon != null) {
                        Icon(
                            imageVector = leadingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f),
                            modifier = Modifier
                                .clickable{onLeadingClick()}
                        )

                        Spacer(modifier = Modifier.width(16.dp))
                    }

                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if (textFieldState.text.isEmpty()) {
                            Text(text = hint,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.4f),
                                modifier = Modifier.fillMaxWidth())
                        }
                        innerTextField()
                    }

                    if(trailingIcon != null) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f),
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clickable{onTrailingClick()}
                        )
                    } else if  (trailingText != null){
                        Text(
                            text = trailingText,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(end = 4.dp)
                                .clickable{onTrailingClick()}
                        )
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))

                HorizontalDivider(modifier = Modifier.alpha(0.7f))
            }
        }
    )
}



