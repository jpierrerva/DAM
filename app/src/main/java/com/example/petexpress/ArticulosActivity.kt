package com.example.petexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petexpress.Model.Articulo
import com.example.petexpress.databinding.ActivityArticulosBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_articulos.*

class ArticulosActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    private var articuloGlobal:MutableList<Articulo> = mutableListOf()

    lateinit var adaptador: ArticulosAdapter

    lateinit var binding: ActivityArticulosBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_articulos)
        binding = ActivityArticulosBinding.inflate(layoutInflater)
        setContentView(binding.root)
<<<<<<< HEAD


        val bundleRecepcion = intent.extras

        // val animal = bundleRecepcion!!.getString("key_animal")

        var animal = bundleRecepcion!!.getString("key_animal")

        when (animal) {
            "perro" -> {

            }
            "gato" -> {
                //img1.setImageResource(R.drawable.salmon)
            }
        }

        setupAdapter()

        database = Firebase.database.reference


        database.child("productos").get().addOnSuccessListener {
           it.children.forEach{

               val id = it.key as String
               val nombre = it.child("nombre").getValue() as String

               val categoria = it.child("categoria").getValue() as String
               val mascota = it.child("mascota").getValue() as String
               val precio = it.child("precio").getValue() as Double

               val stock = it.child("stock").getValue() as Long
               val url = it.child("imagen").getValue() as String
=======
        val bundleRecepcion = intent.extras



       // val animal = bundleRecepcion!!.getString("key_animal")
>>>>>>> c7a917b956750f0c2dcb8800d6283e5b98d97129

               val articulo1 =  Articulo(id, nombre, categoria, mascota, precio, stock.toInt(), url)

               articuloGlobal.add(articulo1)
           }
            adaptador.updateList(articuloGlobal)

        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.itCarrito -> {
                val intent = Intent(this, CarritoActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun setupAdapter() {
        adaptador= ArticulosAdapter(context=this) //instanciando
        binding.rvArticulos.adapter = adaptador
        binding.rvArticulos.layoutManager= LinearLayoutManager(this) //formato lineal
        //binding.rvPokedex.layoutManager=GridLayoutManager(this,4) // formato grilla
    }

}