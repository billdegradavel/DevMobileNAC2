package com.example.agenda

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.support.design.widget.Snackbar
import android.view.View

class MainActivity : AppCompatActivity() {



    lateinit var fabAdd: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_activity)

        fabAdd = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener { view ->
            val intent = Intent(this, CadastroActivity::class.java).apply { putExtra(AlarmClock.EXTRA_MESSAGE, "teste") }
            startActivity(intent)
        }
    }
}
