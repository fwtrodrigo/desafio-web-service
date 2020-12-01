package br.com.desafiowebservice.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.desafiowebservice.entities.Quadrinho
import br.com.desafiowebservice.services.Repository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val listaQuadrinho = MutableLiveData<ArrayList<Quadrinho>>()

    fun getListaQuadrinhos() {
        try {
            viewModelScope.launch {
                val response = repository.getListaQuadrinhos(
                    "1",
                    "6eb7e8896ec5850c52515a8a23ee97f0",
                    "40a3aa568bb269dfad85ae0c4a297181",
                    1,
                    10
                )

                val results = response.get("data").asJsonObject.get("results")
                val comics = Gson().fromJson(
                    results,
                    object : TypeToken<List<Quadrinho>>() {}.type
                ) as ArrayList<Quadrinho>

                listaQuadrinho.value = comics
            }
        } catch (e: Exception) {
            throw java.lang.Exception()
        }
    }
}