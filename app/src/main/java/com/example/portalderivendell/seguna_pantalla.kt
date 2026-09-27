package com.example.portalderivendell

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.portalderivendell.R.id.*
import android.widget.RadioGroup

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

        val rgFaccion = findViewById<RadioGroup>(R.id.Grupo)
        rgFaccion.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId){
                R.id.Comunidad -> Toast.makeText(this, "Has elegido el camino de la Luz", Toast.LENGTH_SHORT).show()
                R.id.Mordor -> Toast.makeText(this, "Te has aliado con la Sombra de Sauron", Toast.LENGTH_SHORT).show()
            }
        }

        val cbSigilo = findViewById<CheckBox>(R.id.cbSigilo)
        cbSigilo.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Log.d("Habilidad","Has adquirido la habilidad de sigilo")
            }
        }
        val cbEspada = findViewById<CheckBox>(R.id.cbEspada)
        cbEspada.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Log.d("Habilidad","Has adquirido la habilidad de combate con espada")
            }
        }

    }

}