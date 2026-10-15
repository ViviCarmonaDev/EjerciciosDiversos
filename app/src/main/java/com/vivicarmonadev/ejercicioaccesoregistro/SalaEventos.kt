package com.vivicarmonadev.ejercicioaccesoregistro

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ControlAforo() {

    var contadorPersonas by remember { mutableStateOf(0) }
    var ultimoRegistro by remember { mutableStateOf("Ninguno") }
    var nombreInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "CONTROL DE AFORO")
        Spacer(Modifier.height(26.dp))

        Text(text = "Personas adentro: $contadorPersonas")
        Text(text = "Último registro: $ultimoRegistro")

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(

            value = nombreInput,
            onValueChange = { nombreInput = it },
            label = { Text("Nombre del invitado") },
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                if (nombreInput.isNotBlank()) {
                    ultimoRegistro = nombreInput.trim()
                    contadorPersonas += 1
                    nombreInput = ""
                }
            },
        ){
            Text("Registrar e Ingresar")
        }

        Spacer(Modifier.height(20.dp))

        Row(){
            Button(
                onClick = {
                    if (contadorPersonas > 0) {
                        contadorPersonas -= 1
                    }
                },
            ){
                Text("Salida (-1)")
            }

            Spacer(Modifier.width(20.dp))


            Button(
                onClick = {
                    contadorPersonas = 0
                    ultimoRegistro = "Ninguno"
                },
            ){
                Text("Reiniciar")
            }
        }
    }
}

