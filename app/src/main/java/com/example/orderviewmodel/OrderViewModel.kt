package com.example.orderviewmodel

import androidx.lifecycle.ViewModel
import com.example.orderviewmodel.Data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat


private const val HARGA_PER_CUP = 3000

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val  stateUI:StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlhEsJumbo:Int){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlhEsJumbo,
                harga = hitunganHarga(jumlah=jmlhEsJumbo)
            )
        }
    }

    fun setRasa(rasaPilihan:String){
        _stateUI.update { stateSaatini ->
            stateSaatini.copy(rasa=rasaPilihan)
        }
    }
    fun  resetOrder(){
        _stateUI.value= OrderUIState()
    }
    private fun hitunganHarga(
        jumlah:Int = _stateUI.value.jumlah,
    ): String{
        val KalkulasiHarga =jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(KalkulasiHarga)
    }
    fun setContact(listData: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                alamat = listData[1],
                noTelp = listData[2]
            )
        }
    }
}