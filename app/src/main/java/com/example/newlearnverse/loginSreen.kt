package com.example.newlearnverse

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlearnverse.components.HeadingTextComponents
import com.example.newlearnverse.components.MyButtonComponent
import com.example.newlearnverse.components.MyTextField
import com.example.newlearnverse.components.NormalTextComponents
import com.example.newlearnverse.components.PasswordTextFieldComponent
import com.example.newlearnverse.components.TextFieldComponent

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column() {
            Image(
                // Subject to change
                painter = painterResource(R.drawable.profile),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth(0.25f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Login",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,


            )

        }

        MyTextField(
            textFieldState = TextFieldState(),
            hint = "Email",
            leadingIcon = Icons.Outlined.Email,
            trailingIcon = Icons.Outlined.Check,
            modifier = Modifier.fillMaxWidth())

        MyTextField(
            textFieldState = TextFieldState(),
            hint = "Password",
            leadingIcon = Icons.Outlined.Email,
            trailingText = "Forgot?",
            isPassword = true,
            modifier = Modifier.fillMaxWidth())

        OutlinedButton (
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Login",
                fontSize = 17.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

    }

}
