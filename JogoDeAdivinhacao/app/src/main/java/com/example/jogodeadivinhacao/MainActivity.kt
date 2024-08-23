package com.example.jogodeadivinhacao

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodeadivinhacao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val Animais = mapOf(
        "Cavalo" to "Horse",
        "Coelho" to "Bunny",
        "Macaco" to "Monkey",
        "Cachorro" to "Dog",
         "Gato" to "Cat",
        "Rato" to "Mouse",
        "Vaca" to "Cow",
         "Pato" to "Duck"

    )

    private lateinit var animalPortugues: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSair.setOnClickListener {
// Criando uma Intent para iniciar a atividade InicioActivity
            val intent = Intent(this, StartActivity::class.java)
//inicia a atividade do intent
            startActivity(intent)
        }
        // Configura o jogo
        setupGame()

        // Configura os botões
        binding.Animal1.setOnClickListener { checkAnswer(binding.Animal1.text.toString()) }
        binding.Animal2.setOnClickListener { checkAnswer(binding.Animal2.text.toString()) }
        binding.Animal3.setOnClickListener { checkAnswer(binding.Animal3.text.toString()) }
        binding.Animal4.setOnClickListener { checkAnswer(binding.Animal4.text.toString()) }
        binding.Animal5.setOnClickListener { checkAnswer(binding.Animal5.text.toString()) }
        binding.Animal6.setOnClickListener { checkAnswer(binding.Animal6.text.toString()) }
        binding.Animal7.setOnClickListener { checkAnswer(binding.Animal7.text.toString()) }
        binding.Animal8.setOnClickListener { checkAnswer(binding.Animal8.text.toString()) }

    }

    private fun setupGame() {
        // Escolhe uma animal aleatória em português
        animalPortugues = Animais.keys.random()
        binding.AnimalPortuguesac.text = animalPortugues

        // Embaralha as opções de resposta
        val animalCerta = Animais[animalPortugues]
        val todosanimais = Animais.values.shuffled()

        binding.Animal1.text = todosanimais[0]
        binding.Animal2.text = todosanimais[1]
        binding.Animal3.text = todosanimais[2]
        binding.Animal4.text = todosanimais[3]
        binding.Animal5.text = todosanimais[4]
        binding.Animal6.text = todosanimais[5]
        binding.Animal7.text = todosanimais[6]
        binding.Animal8.text = todosanimais[7]
    }

    private fun checkAnswer(selectedColor: String) {
        val animalCerta = Animais[animalPortugues]
        if (selectedColor == animalCerta) {
            Toast.makeText(this, "Correto!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Poxa, você errou! Correto é $animalCerta.", Toast.LENGTH_SHORT).show()
        }

        // Reinicia o jogo
        setupGame()
    }
}



