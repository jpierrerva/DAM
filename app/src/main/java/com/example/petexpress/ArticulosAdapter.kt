package com.example.petexpress

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petexpress.Model.Articulo
import com.example.petexpress.databinding.ItemproductoBinding
import com.squareup.picasso.Picasso

class ArticulosAdapter constructor (var articulos: List<Articulo> = listOf(), var context: Context)
    : RecyclerView.Adapter<ArticulosAdapter.ArticulosAdpaterViewHolder>(){
    //2. Viewholder, es una clase que me va a pintar la informacion: XML(plantilla) y data
    inner class ArticulosAdpaterViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding: ItemproductoBinding= ItemproductoBinding.bind(itemView)

        fun bind(Articulo: Articulo){
            //pintar
            binding.tvNombre.text=Articulo.nombre
            Picasso.get().load(Articulo.url).into(binding.imgArticulo)
        }
    }

    fun updateList(Articulo: List<Articulo>){
        this.articulos = Articulo
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticulosAdpaterViewHolder {
        //Inflar una vista view=item_Articulos.xml
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemproducto,parent,false)
        return ArticulosAdpaterViewHolder(view)
    }

    //se va a ejecutar tantas veces elementos tenga mi lista
    override fun onBindViewHolder(holder: ArticulosAdpaterViewHolder, position: Int) {
        val Articulo: Articulo =articulos[position]
        holder.bind(Articulo)
    }

    //cuantos elementos tiene mi lista de datos
    override fun getItemCount(): Int {
        return articulos.size
    }
}