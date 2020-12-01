package br.com.desafiowebservice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiowebservice.R
import br.com.desafiowebservice.entities.Quadrinho
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_quadrinho.view.*

class AdapterQuadrinho() : RecyclerView.Adapter<AdapterQuadrinho.QuadrinhoViewHolder>() {
    private val listaQuadrinhos = ArrayList<Quadrinho>()
    private var quadrinhoNSA = 0

    class QuadrinhoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgQuadrinhoCapa: ImageView = view.imgQuadrinhoCapa
        val tvNumeroQuadrinho: TextView = view.tvQuadrinhoNumero
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuadrinhoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_quadrinho, parent, false)
        return QuadrinhoViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuadrinhoViewHolder, position: Int) {
        val quadrinho = listaQuadrinhos[position]
        holder.tvNumeroQuadrinho.text = nextNSA()
        Picasso.get().load(quadrinho.thumbnail.getFullPath())
            .into(holder.imgQuadrinhoCapa)
    }

    fun addQuadrinho(quadrinho: Quadrinho) {
        listaQuadrinhos.add(quadrinho)
        notifyDataSetChanged()
    }

    private fun nextNSA(): String {
        return "#${(quadrinhoNSA++)}"
    }

    override fun getItemCount() = listaQuadrinhos.count()
}