package com.example.pedrapapeltesoura

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.ActivityTresjogadoresBinding

class TresJogadoresActivity : AppCompatActivity() {
    private val atjb: ActivityTresjogadoresBinding by lazy {
        ActivityTresjogadoresBinding.inflate(layoutInflater)
    }
    private val choices = listOf("pedra", "papel", "tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(atjb.root)
        atjb.mainTb.apply {
            title = getString(R.string.app_name)
            subtitle = this@TresJogadoresActivity.javaClass.simpleName
            setSupportActionBar(this)
        }
        atjb.pedraBt.setOnClickListener { onPlayerChoice("pedra") }
        atjb.papelBt.setOnClickListener { onPlayerChoice("papel") }
        atjb.tesouraBt.setOnClickListener { onPlayerChoice("tesoura") }
    }

    private fun onPlayerChoice(playerChoice: String) {
        val computerChoice1 = choices.random()
        val computerChoice2 = choices.random()

        when (playerChoice) {
            "pedra" -> atjb.pedraBt.setImageResource(R.drawable.rock2)
            "papel" -> atjb.papelBt.setImageResource(R.drawable.paper2)
            "tesoura" -> atjb.tesouraBt.setImageResource(R.drawable.scissor2)
        }

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val winner = determineWinner(playerChoice, computerChoice1, computerChoice2)
            showResult(winner, playerChoice, computerChoice1, computerChoice2)
        }, 2000)
    }

    private fun determineWinner(playerChoice: String, computerChoice1: String, computerChoice2: String): String {
        return when {
            (playerChoice == "pedra" && computerChoice1 == "tesoura" && computerChoice2 == "tesoura") ||
                    (playerChoice == "papel" && computerChoice1 == "pedra" && computerChoice2 == "pedra") ||
                    (playerChoice == "tesoura" && computerChoice1 == "papel" && computerChoice2 == "papel") -> "Player 1 venceu!"
            (playerChoice == "pedra" && computerChoice1 == "papel" && computerChoice2 == "pedra") ||
                    (playerChoice == "papel" && computerChoice1 == "tesoura" && computerChoice2 == "papel") ||
                    (playerChoice == "tesoura" && computerChoice1 == "pedra" && computerChoice2 == "tesoura") -> "Computador 1 venceu!"
            (playerChoice == "tesoura" && computerChoice1 == "tesoura" && computerChoice2 == "pedra") ||
                    (playerChoice == "pedra" && computerChoice1 == "pedra" && computerChoice2 == "papel") ||
                    (playerChoice == "papel" && computerChoice1 == "papel" && computerChoice2 == "tesoura") -> "Computador 1 venceu!"
            else -> "Empate!"
        }
    }

    private fun showResult(winner: String, playerChoice: String, computerChoice1: String, computerChoice2: String) {
        val message = "Player 1: $playerChoice\nComputador 1: $computerChoice1\nComputador 2: $computerChoice2\nResultado: $winner"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        atjb.pedraBt.setImageResource(R.drawable.rock1)
        atjb.papelBt.setImageResource(R.drawable.paper1)
        atjb.tesouraBt.setImageResource(R.drawable.scissor1)
    }
}