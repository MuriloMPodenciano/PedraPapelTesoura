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
    private val choices = listOf("pedra", "papel", "tesoura", "lagarto", "spock")

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
        adjb.lagartoBt.setOnClickListener { onPlayerChoice("lagarto") }
        adjb.spockBt.setOnClickListener { onPlayerChoice("spock")}

    }

    private fun onPlayerChoice(playerChoice: String){
        val computerChoice = choices.random()

        when (playerChoice) {
            "pedra" -> adjb.pedraBt.setImageResource(R.drawable.rock2)
            "papel" -> adjb.papelBt.setImageResource(R.drawable.paper2)
            "tesoura" -> adjb.tesouraBt.setImageResource(R.drawable.scissor2)
            "lagarto" -> adjb.papelBt.setImageResource(R.drawable.lagarto) //temporary
            "spock" -> adjb.tesouraBt.setImageResource(R.drawable.spock) //temporary
        }

        val computerImageView = adjb.computadorIv
        when (computerChoice) {
            "pedra" -> computerImageView.setImageResource(R.drawable.rock2)
            "papel" -> computerImageView.setImageResource(R.drawable.paper2)
            "tesoura" -> computerImageView.setImageResource(R.drawable.scissor2)
            "lagarto" -> computerImageView.setImageResource(R.drawable.lagarto)
            "spock" -> computerImageView.setImageResource(R.drawable.spock)
        }

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val winner = determineWinner(playerChoice, computerChoice)
            showResult(winner, playerChoice, computerChoice)
        }, 1000)
    }

    private fun determineWinner(playerChoice: String, computerChoice: String): String {
        return when {
            playerChoice == computerChoice -> "Empate"
            //pedra
            (playerChoice == "pedra" && computerChoice == "tesoura") ||
                    (playerChoice == "pedra" && computerChoice == "lagarto") ||
                    (playerChoice == "papel" && computerChoice == "pedra") ||
                    (playerChoice == "spock" && computerChoice == "pedra") ||
                    //papel (sem pedra)
                    (playerChoice == "papel" && computerChoice == "spock") ||
                    (playerChoice == "lagarto" && computerChoice == "papel") ||
                    (playerChoice == "tesoura" && computerChoice == "papel") ||
                    //tesoura (sem papel & pedra)
                    (playerChoice == "tesoura" && computerChoice == "lagarto") ||
                    (playerChoice == "spock" && computerChoice == "tesoura") ||
                    //resto
                    (playerChoice == "lagarto" && computerChoice == "spock")-> "Você venceu!"
            else -> "Você perdeu!"
        }
    }

    private fun showResult(winner: String, playerChoice: String, computerChoice: String) {
        val message = "Você: $playerChoice\nComputador: $computerChoice\nResultado: $winner"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        adjb.pedraBt.setImageResource(R.drawable.rock1)
        adjb.papelBt.setImageResource(R.drawable.paper1)
        adjb.tesouraBt.setImageResource(R.drawable.scissor1)
        adjb.lagartoBt.setImageResource(R.drawable.lagarto) //temporary
        adjb.spockBt.setImageResource(R.drawable.spock) //temporary
    }
}
