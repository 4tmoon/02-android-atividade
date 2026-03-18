package com.github.atmoon.atividade_kotlin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FilmeScreen(modifier: Modifier = Modifier, navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C2A39))
            .padding(32.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {

            Text(
                text = "Interestelar",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Ano: 2014",
                color = Color.White,
                fontSize = 18.sp
            )
            Text(
                text = "Diretor: Christopher Nolan",
                color = Color.White,
                fontSize = 18.sp
            )
            Text(
                text = "Gênero: Ficção Científica",
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Um grupo de astronautas viaja através de um buraco de minhoca em busca de um novo lar para a humanidade.",
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = { navController.navigate("menu") },
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(
                    text = "Voltar",
                    fontSize = 20.sp
                )
            }
        }
    }
}