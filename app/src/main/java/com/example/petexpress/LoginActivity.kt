package com.example.petexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.petexpress.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val correo = binding.edtEmail.text.toString()
            val contra = binding.edtContrasenia.text.toString()

            if (correo.isEmpty()){

                Toast.makeText(this, "Debe ingresar correo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (contra.isEmpty()){

                Toast.makeText(this, "Debe ingresar contrasenia", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SeleccionMascotasActivity::class.java)
            startActivity(intent)
        }

        binding.tvRegistrate.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }


    }
}