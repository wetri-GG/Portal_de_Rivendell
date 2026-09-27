package com.example.portalderivendell

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.portalderivendell.R.id.*

class seguna_pantalla : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seguna_pantalla)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val NombreHeroe = findViewById<EditText>(name)
        NombreHeroe.requestFocus()
        NombreHeroe.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {

                if (NombreHeroe.text.isEmpty()) NombreHeroe.error = "¡Tu héroe necesita un nombre!"
            }
        }
        val Raza = findViewById<Spinner>(spinner)
        Raza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val RazaSelecionada = parent?.getItemAtPosition(position).toString()
                Log.d("Personaje", "Raza selecionada: $RazaSelecionada")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

}