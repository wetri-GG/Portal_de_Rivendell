package com.example.portalderivendell

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private val TAG = "Ciclo"
    private var cp = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d(TAG, "onCreate: El Anillo Único es forjado en las llamas del Orodruin.")

        // Vinculación de vistas
        val tvSaludo = findViewById<TextView>(R.id.saludo)
        val btnForjar = findViewById<Button>(R.id.boton)
        val tvContador = findViewById<TextView>(R.id.contador)

        //Ver cuando se hace click en el boton
        btnForjar.setOnClickListener {
            // Cambiar texto del saludo
            tvSaludo.text = "¡La Comunidad del Anillo ha partido hacia Mordor!"

            // Incrementar contador y actualizar texto
            cp++
            tvContador.text = "Miembros reunidos: $cp"
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: La Concilio de Elrond se reúne en Rivendell.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: La Comunidad inicia su marcha hacia el sur.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: La Comunidad hace una pausa en las Minas de Moria.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Frodo y Sam acampan ocultos de los Ojos de Sauron.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: El Anillo cae en el Monte del Destino. La misión ha terminado.")
    }
}