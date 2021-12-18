package com.example.petexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.example.petexpress.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern

class Registro : AppCompatActivity() {
    private lateinit var binding:ActivityRegistroBinding
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.btnregistrar.setOnClickListener{

            val correo = binding.correo.text.toString()
            val contra = binding.contra.text.toString()

            if(correo.isEmpty()){
                Toast.makeText(this, "Ingrese correo", Toast.LENGTH_SHORT).show()
            } else if ( contra.isEmpty()){
                Toast.makeText(this, "Ingrese contrasenia", Toast.LENGTH_SHORT).show()
            } else{
                createAccount(correo, contra)
            }

        }

        binding.btnCancelar.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun createAccount(correo : String, contrasenia : String){
        auth.createUserWithEmailAndPassword(correo, contrasenia)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Se ha registrado correctamente", Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun validate(){
        val result= arrayOf(validarCorreo(),validarCotra())
        if (false in result){
            return
        }
    }

    private fun validarCorreo(): Boolean {
        val email = binding.correo.editableText.toString()
        return if (email.isEmpty()){
            binding.correo.error="Incorrecto"
            false
        }else if(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            binding.correo.error="Escribe un correo electronico valido"
            false
        }else{
            binding.correo.error=null
            true
        }

    }

    private fun validarCotra(): Boolean {
        val password = binding.contra.editableText.toString()
        val passwordRegex= Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +        //at least 1 lower case letter
                    "(?=.*[A-Z])" +        //at least 1 upper case letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$"
        )
        return if (password.isEmpty()){
            binding.contra.error="Incorrecto"
            false
        }else if (!passwordRegex.matcher(password).matches()){
            binding.contra.error = "Password is too weak"
            false
        }else{
            binding.contra.error = null
            true
        }

    }

}