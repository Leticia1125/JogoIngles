package com.example.jogodeadivinhacao
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodeadivinhacao.databinding.ActivityStartBinding
class StartActivity: AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//Aqui esta sendo inflando o layout da tela principal.
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root) //App ira usar esse layout na tela

// Definindo um listener de clique para o botão "button1"
        binding.button1.setOnClickListener {

// Criando uma intent para iniciar a MainActivity
            val intent = Intent(this, MainActivity::class.java)

// Iniciando a atividade MainActivity
            startActivity(intent)
        }

    }
}