package br.com.desafiowebservice.ui

import android.content.Intent
import android.os.Bundle
import android.text.SpannedString
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import br.com.desafiowebservice.R
import br.com.desafiowebservice.entities.Quadrinho
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes_quadrinho.*
import java.text.SimpleDateFormat
import java.util.*

class DetalhesQuadrinhoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_quadrinho)

        val quadrinho = intent.getSerializableExtra("quadrinho") as Quadrinho

        toolbarDetalhes.setNavigationOnClickListener {
            onBackPressed()
        }

        ivDetalheQuadrinhoCapa.setOnClickListener {
            startActivity(
                Intent(this, CapaActivity::class.java)
                    .putExtra("urlCapaQuadrinho", quadrinho.thumbnail.getFullPath())
            )
        }

        Picasso.get().load(quadrinho.getImage())
            .into(ivDetalheQuadrinhoFundo)

        Picasso.get().load(quadrinho.thumbnail.getFullPath())
            .into(ivDetalheQuadrinhoCapa)

        tvDetalheQuadrinhoTitulo.text = quadrinho.title
        tvDetalheQuadrinhoDescricao.text = quadrinho.description ?: "No description"
        tvDetalheQuadrinhoPreco.text = makeBold("Price:", "$ " + quadrinho.getPrice().toString())
        tvDetalheQuadrinhoPaginas.text = makeBold("Pages:", quadrinho.pageCount.toString())

        val oldPattern: Date =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssss").parse(quadrinho.getDate())
        val newPattern = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        val dateFormated = newPattern.format(oldPattern)

        tvDetalheQuadrinhoDataPublicacao.text =
            makeBold("Published:", dateFormated)
    }

    private fun makeBold(p1: String, p2: String): SpannedString {
        return buildSpannedString {
            bold {
                append(p1)
            }
            append(" $p2")
        }
    }
}