package com.example.orderviewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClick:(MutableList<String>) -> Unit
) {
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }
    var alamatTxt by remember {
        mutableStateOf("")
    }
    var telponTxt by remember {
        mutableStateOf("")
    }
    var listDataTxt: MutableList<String> = mutableListOf(namaTxt, alamatTxt, telponTxt)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        Text(
            text = "Data Pelanggan",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(value = namaTxt, onValueChange = {
            namaTxt = it
        }, label = {
            Text(text = "Masukkan Nama")
        })
        OutlinedTextField(value = alamatTxt, onValueChange = {
            alamatTxt = it
        }, label = {
            Text(text = "Masukkan Alamat")
        })
        OutlinedTextField(value = telponTxt, onValueChange = {
            telponTxt= it
        }, label = {
            Text(text = "Masukkan No Telepon")
        })

    }
}