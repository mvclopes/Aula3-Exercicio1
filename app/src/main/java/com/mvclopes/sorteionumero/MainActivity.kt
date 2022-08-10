package com.mvclopes.sorteionumero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    // Obtendo referências das views da tela
    private val btnSortear: Button by lazy { findViewById(R.id.btnSortear) }
    private val texto: TextView by lazy { findViewById(R.id.txtResultado) }
    private val numeroEditText: EditText by lazy { findViewById(R.id.numeroEscolhido) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adicionado listener ao botão, para escutar clique no mesmo
        btnSortear.setOnClickListener {
            // Obtenção de número randomico entre 0 e 10
            val numeroSorteado = Random().nextInt(11)

            // Obtenção do número digitado pelo usuário
            val numeroDigitado = numeroEditText.text.toString().toInt()

            // Chamada ao método para validar a aposta do usuário
            validaAposta(numeroSorteado, numeroDigitado)
        }
    }

    // Método para validar a aposta do usuário
    private fun validaAposta(numeroSorteado: Int, numeroDigitado: Int) {
        if (entradaValida(numeroDigitado)) {
            validaResultado(numeroDigitado, numeroSorteado)
        } else {
            exibeMensagem("Favor digite um valor entre 0 e 10")
        }
    }

    // Método para validar se número digitado pelo usuário é o mesmo que o número sorteado
    private fun validaResultado(numeroDigitado: Int, numeroSorteado: Int) {
        // Concatenando string contendo número sorteado, que será exibido ao usuário
        texto.text = "O número sorteado é: $numeroSorteado"

        // Condicional para determinar qual mensagem exibir ao usuário
        if (numeroDigitado == numeroSorteado) {
            exibeMensagem("Parabéns acertou o número!")
        } else {
            exibeMensagem("Que pena, não foi dessa vez!")
        }
    }

    // Método para validar se valor digitado pelo usuário está correto
    private fun entradaValida(numeroDigitado: Int): Boolean {
        return (numeroDigitado in 0..10)
    }

    // Método para exibir mensagem visual ao usuário
    private fun exibeMensagem(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}