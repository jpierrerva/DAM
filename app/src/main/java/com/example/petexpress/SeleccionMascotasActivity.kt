package com.example.petexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petexpress.databinding.ActivityLoginBinding
import com.example.petexpress.databinding.ActivitySeleccionMascotaBinding

class SeleccionMascotasActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeleccionMascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeleccionMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animal=""

        binding.imgPerro.setOnClickListener{
            animal = "perro";
            val intent = Intent(this, ArticulosActivity::class.java)
            val bundle = Bundle();
            bundle.putString("key_animal",animal)
            intent.putExtras(bundle)
            startActivity(intent);
        }
        binding.imgGato.setOnClickListener{
            animal = "gato";
            val intent = Intent(this, ArticulosActivity::class.java)
            val bundle = Bundle();
            bundle.putString("key_animal",animal)
            intent.putExtras(bundle)
            startActivity(intent);
        }

        binding.imgGato.setOnClickListener{
            animal = "conejo";
            val intent = Intent(this, ArticulosActivity::class.java)
            val bundle = Bundle();
            bundle.putString("key_animal",animal)
            intent.putExtras(bundle)
            startActivity(intent);
        }

        binding.imgGato.setOnClickListener{
            animal = "pollo";
            val intent = Intent(this, ArticulosActivity::class.java)
            val bundle = Bundle();
            bundle.putString("key_animal",animal)
            intent.putExtras(bundle)
            startActivity(intent);
        }

        binding.imgGato.setOnClickListener{
            animal = "pez";
            val intent = Intent(this, ArticulosActivity::class.java)
            val bundle = Bundle();
            bundle.putString("key_animal",animal)
            intent.putExtras(bundle)
            startActivity(intent);
        }


    }


}