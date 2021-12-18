package com.example.petexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petexpress.databinding.ActivityArticulosBinding

class ArticulosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_articulos)
        val binding = ActivityArticulosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundleRecepcion = intent.extras



       // val animal = bundleRecepcion!!.getString("key_animal")

    }
}