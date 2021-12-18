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

        binding.imgPerro.setOnClickListener{
            val intent = Intent(this, ArticulosActivity::class.java)
            startActivity(intent)
        }


    }
}