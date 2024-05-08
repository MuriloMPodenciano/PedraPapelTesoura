package com.example.pedrapapeltesoura

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.ActivityDoisjogadoresBinding

class DoisJogadoresActivity: AppCompatActivity() {
    private val adjb: ActivityDoisjogadoresBinding by lazy {
        ActivityDoisjogadoresBinding.inflate(layoutInflater)
    }
    private val choices = listOf("pedra", "papel", "tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(adjb.root)
        adjb.mainTb.apply {
            title = getString(R.string.app_name)
            subtitle = this@DoisJogadoresActivity.javaClass.simpleName
            setSupportActionBar(this)
        }
        adjb.pedraBt.setOnClickListener { onPlayerChoice("pedra") }
        adjb.papelBt.setOnClickListener { onPlayerChoice("papel") }
        adjb.tesouraBt.setOnClickListener { onPlayerChoice("tesoura")}

    }

    private fun onPlayerChoice(playerChoice: String){
        val computerChoice = choices.random()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val winner = determineWinner(playerChoice, computerChoice)
            showResult(winner, playerChoice, computerChoice)
        }, 3000)
    }

    private fun determineWinner(playerChoice: String, computerChoice: String): String {
        return when {
            playerChoice == computerChoice -> "Empate"
            (playerChoice == "pedra" && computerChoice == "tesoura") ||
                    (playerChoice == "papel" && computerChoice == "pedra") ||
                    (playerChoice == "tesoura" && computerChoice == "papel") -> "Você venceu!"
            else -> "Você perdeu!"
        }
    }

    private fun showResult(winner: String, playerChoice: String, computerChoice: String) {
        val message = "Você: $playerChoice\nComputador: $computerChoice\nResultado: $winner"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
