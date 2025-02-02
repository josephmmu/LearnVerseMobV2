package com.example.newlearnverse

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newlearnverse.components.HeadingTextComponents
import com.example.newlearnverse.components.MyButtonComponent
import com.example.newlearnverse.components.NormalTextComponents
import com.example.newlearnverse.components.PasswordTextFieldComponent
import com.example.newlearnverse.components.TextFieldComponent


@Composable
fun LoginScreen() {

    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White) // Color to be Changed
        .padding(28.dp)
    ) {

        Column (modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

        ) {
            NormalTextComponents(value = stringResource(id = R.string.login))
            HeadingTextComponents(value = stringResource(id = R.string.app_name))
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponent(labelValue = stringResource(id = R.string.email_textField), painterResource(R.drawable.email_icon))
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password_textField),
                painterResource(R.drawable.password_icon))

            // UnderlinedTextComponent for "Forgot Password 5:58 timestamp
            Spacer(modifier = Modifier.height(20.dp))
            MyButtonComponent(value = stringResource(id = R.string.btn_login))
        }




    }

}
