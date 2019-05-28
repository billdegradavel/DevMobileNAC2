package com.example.agenda

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class CadastroActivity : AppCompatActivity() {

    lateinit var nome : EditText
    lateinit var email : EditText
    lateinit var celular : EditText
    lateinit var cep : EditText
    lateinit var logradouro : EditText
    lateinit var bairro : EditText
    lateinit var cidade : EditText
    lateinit var estado : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_activity)
        
        nome = findViewById(R.id.linCampoNomeText)
        email = findViewById(R.id.linCampoEmailText)
        celular = findViewById(R.id.linCampoCelularText)
        cep = findViewById(R.id.linCampoCepText)
        logradouro = findViewById(R.id.linCampoLogradouroText)
        bairro = findViewById(R.id.linCampoBairroText)
        cidade = findViewById(R.id.linCampoCidadeText)
        estado = findViewById(R.id.linCampoEstadoText)
    }

    fun retornar(v : View){
        val intent = Intent(this, MainActivity::class.java).apply { putExtra(AlarmClock.EXTRA_MESSAGE, "teste") }
        startActivity(intent)
    }

    fun salvarContato(v : View){
        val _nome = nome.text.toString()
        val _email = email.text.toString()
        val _celular = celular.text.toString()
        val _cep = cep.text.toString()
        val _logradouro= logradouro.text.toString()
        val _bairro = bairro.text.toString()
        val _cidade = cidade.text.toString()
        val _estado= estado.text.toString()
        var contato = Contato(_nome,_email,_celular,_cep,_logradouro,_bairro,_cidade,_estado)
            Log.d("SALVAR CONTATO", contato.toString())
        var mensagem = "CONTATO SALVO COM SUCESSO!"
        var valido = contato.validar();
            Log.d("VALIDO=",valido)
        if (valido.equals("OK")) {
            var retorno = contato.salvar()
            if (retorno) {
                mensagem = "HOUVE UMA FALHA AO SALVAR O CONTATO! TENTE NOVAMENTE."
            }
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
            retornar(v)
        }
        else{
            mensagem = valido
                Log.d("ELSE",mensagem)
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
        }
    }
}
