package com.example.myapp.presentation.Screen.component



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R


@Composable
fun AppLogin(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isEnabled = username.isNotBlank() && password.isNotBlank()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.White)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.ne), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to App ",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(4.dp))

            Text(text = "Login to your Account")

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = { Text(text = "Enter Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = { navController.navigate("AppUI")},
                  enabled = isEnabled) {
                Text(text = "Login")

                Spacer(modifier = Modifier.size(16.dp))


            }
            Spacer(modifier = Modifier.size(30.dp))
            Text(text = "Forgot password ", modifier = Modifier.clickable { })

            Spacer(modifier = Modifier.size(16.dp))

            Text(text = "or sign in with")

            Spacer(modifier = Modifier.size(16.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(painter = painterResource(id = R.drawable.go), contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clickable { })


                Image(painter = painterResource(id = R.drawable.fa), contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clickable { })

                Image(painter = painterResource(id = R.drawable.tw), contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clickable { }
                )


            }
        }
    }
}



@Preview
@Composable
fun Screen(){
    val navController = rememberNavController() 
    AppLogin(navController)
}


