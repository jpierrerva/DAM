package com.example.petexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.petexpress.databinding.ActivityLoginBinding
import com.example.petexpress.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.btnLogin.setOnClickListener{
            val correo = binding.edtEmail.text.toString()
            val contra = binding.edtContrasenia.text.toString()

            if (correo.isEmpty()){

                Toast.makeText(this, "Debe ingresar correo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (contra.isEmpty()){

                Toast.makeText(this, "Debe ingresar contrasenia", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                verificarLogin(correo, contra)
            }

        }

        binding.tvRegistrate.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }


    }

    private fun verificarLogin(correo : String, contrasenia : String){
        auth.signInWithEmailAndPassword(correo, contrasenia)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, SeleccionMascotasActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

}