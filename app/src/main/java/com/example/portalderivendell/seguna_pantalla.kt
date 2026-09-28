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
import android.widget.ImageButton


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
        //variable del nombre
        val NombreHeroe = findViewById<EditText>(name)
        //ponemos focus para que sea lo primero que hagas
        NombreHeroe.requestFocus()
        NombreHeroe.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {

                if (NombreHeroe.text.isEmpty()) NombreHeroe.error = "¡Tu héroe necesita un nombre!"
            }
        }
        //variable de raza
        val Raza = findViewById<Spinner>(spinner)
        //Que escuche que raza eliges y que te muestre en el log cual eliges
        Raza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val RazaSelecionada = parent?.getItemAtPosition(position).toString()
                Log.d("Personaje", "Raza selecionada: $RazaSelecionada")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        //variable de cual es la faccion que escoges
        val rgFaccion = findViewById<RadioGroup>(R.id.Grupo)
        //Toast para mostrar texto en pantalla al selecionar una faccion
        rgFaccion.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.Comunidad -> Toast.makeText(
                    this,
                    "Has elegido el camino de la Luz",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Mordor -> Toast.makeText(
                    this,
                    "Te has aliado con la Sombra de Sauron",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        //los dos valores de sigilo y espada y su log correspondiente
        val cbSigilo = findViewById<CheckBox>(R.id.cbSigilo)
        cbSigilo.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Log.d("Habilidad", "Has adquirido la habilidad de sigilo")
            }
        }
        val cbEspada = findViewById<CheckBox>(R.id.cbEspada)
        cbEspada.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Log.d("Habilidad", "Has adquirido la habilidad de combate con espada")

//--------------------------------------------------------------------------------------------------
                //Boton registro
                val btnRegistrar = findViewById<ImageButton>(R.id.BotonEscudo)

                // 2. Función lambda: recibe nombre, raza, facción y habilidades,
                //    y escribe todo en Logcat (no devuelve nada, por eso Unit)

                val registrarEnLogcat: (String, String, String, List<String>) -> Unit =
                    { nombre, raza, faccion, habilidades ->
                        Log.d(
                            "Personaje",
                            "Nombre: $nombre | Raza: $raza | Facción: $faccion | Habilidades: $habilidades"
                        )
                    }

                // 3. Al pulsar leemos lo que hay elegido en el formulario
                btnRegistrar.setOnClickListener {
                    val nombre = NombreHeroe.text.toString()
                    val raza = Raza.selectedItem.toString()

                    val faccion = when (rgFaccion.checkedRadioButtonId) {
                        R.id.Comunidad -> "Comunidad del Anillo"
                        R.id.Mordor -> "Huestes de Mordor"
                        else -> "Sin elegir"
                    }

                    val habilidades = mutableListOf<String>()
                    if (cbSigilo.isChecked) habilidades.add("Sigilo")
                    if (cbEspada.isChecked) habilidades.add("Combate con Espada")

                    // 3b. Texto explicacion cosas
                    val resumen = "Héroe: $nombre\nRaza: $raza\nFacción: $faccion\n" +
                            "Habilidades: ${
                                if (habilidades.isEmpty()) "Ninguna" else habilidades.joinToString(
                                    ", "
                                )
                            }"

                    // 3c. Lo enseñamos en toast como pide el profe
                    Toast.makeText(this, resumen, Toast.LENGTH_LONG).show()

                    // 3d. Lo registramos en Logcat llamando a la lambda (lo ve el programador)
                    registrarEnLogcat(nombre, raza, faccion, habilidades)
                }
            }

        }
    }
}