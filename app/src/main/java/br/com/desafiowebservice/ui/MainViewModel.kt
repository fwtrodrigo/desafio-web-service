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

    fun getListaQuadrinhos(offset: Int) {
        try {
            viewModelScope.launch {
                val response = repository.getListaQuadrinhos(
                    "1",
                    "02d2f6f10a3e8afb2368ab1949529eb2",
                    "9deccc737e48d9681dac6ab07f678b6d",
                    offset,
                    10,
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