package br.com.desafiowebservice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.desafiowebservice.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_capa.*

class CapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa)

        toolbarTelaCapa.setNavigationOnClickListener {
            onBackPressed()
        }

        val capaQuadrinho = intent.getStringExtra("urlCapaQuadrinho")

        Picasso.get().load(capaQuadrinho)
            .into(imgCapa)
    }
}