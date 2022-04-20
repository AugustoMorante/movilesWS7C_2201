package com.example.app_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_jpc.ui.theme.App_jpcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Text(text = "Saludos desde Moviles XS7C")
            PersonalData(name = "la universidad UPC")
        }
    }
}

@Composable
private fun PersonalData(name: String){
    Column() {
        Text(text = "Saludos desde $name", style= MaterialTheme.typography.h6)
        Text(text = "Semana 2")
        Text(text = "Jueves 31")
    }
}

@Preview
@Composable
fun PreviewPersonalData(){
    PersonalData(name = "la mejor universidad, mi UPC")
}