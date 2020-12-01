package br.com.desafiowebservice.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiowebservice.R
import br.com.desafiowebservice.adapters.AdapterQuadrinho
import br.com.desafiowebservice.services.repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapterQuadrinho: AdapterQuadrinho
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var rcQuadrinho: RecyclerView

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcQuadrinho = mainRcQuadrinho
        adapterQuadrinho = AdapterQuadrinho()
        gridLayoutManager = GridLayoutManager(this, 3)
        rcQuadrinho.adapter = adapterQuadrinho
        rcQuadrinho.layoutManager = gridLayoutManager

        viewModel.listaQuadrinho.observe(this) {
            it.forEach { quadrinho ->
                adapterQuadrinho.addQuadrinho(quadrinho)
            }
        }
        viewModel.getListaQuadrinhos()
    }
}