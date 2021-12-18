package com.example.petexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.PatternsCompat
import com.example.petexpress.databinding.ActivityRegistroBinding
import java.util.regex.Pattern

class Registro : AppCompatActivity() {
    private lateinit var binding:ActivityRegistroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnregistrar.setOnClickListener{ validate()}

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