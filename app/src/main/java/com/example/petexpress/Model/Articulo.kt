package com.example.petexpress.Model

import java.io.Serializable

data class Articulo (val id:String, val categoria: String, val mascota: String, val nombre: String,
                     val precio: Double, val stock : Int,  val url: String): Serializable

