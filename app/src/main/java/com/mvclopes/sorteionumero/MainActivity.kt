package com.mvclopes.sorteionumero

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Obtendo referências das views da tela
        val btnSortear = findViewById<Button>(R.id.btnSortear)
        val texto = findViewById<TextView>(R.id.txtResultado)

        // Adicionado listener ao botão, para escutar clique no mesmo
        btnSortear.setOnClickListener {
            // Obtenção de número randomico entre 0 e 10
            val numeroSorteado = Random().nextInt(11)
            // Concatenando string contendo número sorteado, que será exibido ao usuário
            texto.text = "O número sorteado é: $numeroSorteado"
        }
    }
}