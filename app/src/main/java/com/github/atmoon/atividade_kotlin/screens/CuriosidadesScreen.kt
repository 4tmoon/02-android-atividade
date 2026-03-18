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
fun CuriosidadesScreen(modifier: Modifier = Modifier, navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF223344))
            .padding(32.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {

            Text(
                text = "Curiosidades",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "• O filme ganhou o Oscar de Melhores Efeitos Visuais.",
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "• No planeta Miller, 1 hora equivale a 7 anos na Terra.",
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "• O campo de milho mostrado no início do filme foi plantado de verdade.",
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