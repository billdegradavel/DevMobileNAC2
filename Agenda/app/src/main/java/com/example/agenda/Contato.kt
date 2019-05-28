package com.example.agenda

import java.util.regex.Pattern

class Contato (_nome : String, _email : String, _celular : String, _cep : String, _logradouro : String, _bairro : String, _cidade : String, _estado : String){

    private var nome : String
    private var email : String
    private var celular : String
    private var cep : String
    private var logradouro : String
    private var bairro : String
    private var cidade : String
    private var estado : String
    private val validEmailAddressRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

    init {
        nome = _nome
        email = _email
        celular = _celular
        cep = _cep
        logradouro = _logradouro
        bairro = _bairro
        cidade = _cidade
        estado = _estado
    }

    fun isValidEmail(emailStr : String) : Boolean {
        val matcher = validEmailAddressRegex.matcher(emailStr)
        return matcher.find()
    }


    fun validar():String{
        var retorno = "OK"

        if (nome.length<=0 || nome.length>=101){
            retorno = "Tamanho do nome inválido, deve conter entre 1 a 100 caracteres."
        }
        else if (!isValidEmail(this.email)) {
            retorno = "E-mail inválido."
        }
        else if (celular.length<8||celular.length>19){
            retorno = "Celular Inválido"
        }
        else if (cep.length!=8){
            retorno = "CEP Inválido"
        }
        else if (logradouro.length<=0 || logradouro.length>=201){
            retorno = "Logradouro inválido"
        }
        else if (bairro.length<=0 || bairro.length>=51){
            retorno = "Bairro inválido"
        }
        else if (cidade.length<=0 || cidade.length>=51){
            retorno = "Cidade inválida"
        }
        else if (estado.length<=0 || estado.length>=51){
            retorno = "Estado inválido"
        }

        return retorno
    }

    override fun toString(): String {
        return nome + " | " + email + " | " + celular + " | " +
                cep + " | " + logradouro + " | " + bairro  + " | " +
                cidade + " | " + estado
    }

    fun salvar () : Boolean{
        var retorno = false


        return retorno
    }
}
