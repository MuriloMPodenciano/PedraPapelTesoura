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
    private val choices = listOf("pedra", "papel", "tesoura", "lagarto", "spock")

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
        atjb.lagartoBt.setOnClickListener { onPlayerChoice("lagarto") }
        atjb.spockBt.setOnClickListener { onPlayerChoice("spock") }
    }

    private fun onPlayerChoice(playerChoice: String) {
        val computerChoice1 = choices.random()
        val computerChoice2 = choices.random()

        when (playerChoice) {
            "pedra" -> atjb.pedraBt.setImageResource(R.drawable.rock2)
            "papel" -> atjb.papelBt.setImageResource(R.drawable.paper2)
            "tesoura" -> atjb.tesouraBt.setImageResource(R.drawable.scissor2)
            "lagarto" -> atjb.lagartoBt.setImageResource(R.drawable.lagarto) //temporary
            "spock" -> atjb.spockBt.setImageResource(R.drawable.spock) //temporary
        }

        val computerImageView1 = atjb.computadorIv1
        when (computerChoice1) {
            "pedra" -> computerImageView1.setImageResource(R.drawable.rock2)
            "papel" -> computerImageView1.setImageResource(R.drawable.paper2)
            "tesoura" -> computerImageView1.setImageResource(R.drawable.scissor2)
            "lagarto" -> computerImageView1.setImageResource(R.drawable.lagarto)
            "spock" -> computerImageView1.setImageResource(R.drawable.spock)
        }
        val computerImageView2 = atjb.computadorIv2
        when (computerChoice2) {
            "pedra" -> computerImageView2.setImageResource(R.drawable.rock2)
            "papel" -> computerImageView2.setImageResource(R.drawable.paper2)
            "tesoura" -> computerImageView2.setImageResource(R.drawable.scissor2)
            "lagarto" -> computerImageView2.setImageResource(R.drawable.lagarto)
            "spock" -> computerImageView2.setImageResource(R.drawable.spock)
        }

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val winner = determineWinner(playerChoice, computerChoice1, computerChoice2)
            showResult(winner, playerChoice, computerChoice1, computerChoice2)
        }, 1000)
    }

    private fun determineWinner(playerChoice: String, computerChoice1: String, computerChoice2: String): String {
        return when {
            //PLAYER 1 VENCE
            //pedra vence
            (playerChoice == "pedra" && computerChoice1 == "tesoura" && computerChoice2 == "tesoura") ||
                    (playerChoice == "pedra" && computerChoice1 == "tesoura" && computerChoice2 =="lagarto")||
                    (playerChoice == "pedra" && computerChoice1 == "lagarto" && computerChoice2 =="tesoura")||
                    (playerChoice == "pedra" && computerChoice1 == "lagarto" && computerChoice2 =="lagarto")||
                    //papel vence
                    (playerChoice == "papel" && computerChoice1 == "pedra" && computerChoice2 =="pedra")||
                    (playerChoice == "papel" && computerChoice1 == "pedra" && computerChoice2 =="spock")||
                    (playerChoice == "papel" && computerChoice1 == "spock" && computerChoice2 =="pedra")||
                    (playerChoice == "papel" && computerChoice1 == "spock" && computerChoice2 =="spock")||
                    //tesoura vence
                    (playerChoice == "tesoura" && computerChoice1 == "papel" && computerChoice2 =="papel")||
                    (playerChoice == "tesoura" && computerChoice1 == "papel" && computerChoice2 =="lagarto")||
                    (playerChoice == "tesoura" && computerChoice1 == "lagarto" && computerChoice2 =="papel")||
                    (playerChoice == "tesoura" && computerChoice1 == "lagarto" && computerChoice2 =="lagarto")||
                    //lagarto vence
                    (playerChoice == "lagarto" && computerChoice1 == "papel" && computerChoice2 =="papel")||
                    (playerChoice == "lagarto" && computerChoice1 == "papel" && computerChoice2 =="spock")||
                    (playerChoice == "lagarto" && computerChoice1 == "spock" && computerChoice2 =="papel")||
                    (playerChoice == "lagarto" && computerChoice1 == "spock" && computerChoice2 =="spock")||
                    //spock vence
                    (playerChoice == "spock" && computerChoice1 == "pedra" && computerChoice2 =="pedra")||
                    (playerChoice == "spock" && computerChoice1 == "pedra" && computerChoice2 =="tesoura")||
                    (playerChoice == "spock" && computerChoice1 == "tesoura" && computerChoice2 =="pedra")||
                    (playerChoice == "spock" && computerChoice1 == "tesoura" && computerChoice2 =="tesoura")
            -> "Player 1 venceu!"

            //COMPUTADOR 1 VENCE
            //pedra vence
            (playerChoice == "tesoura" && computerChoice1 == "pedra" && computerChoice2 == "tesoura") ||
                    (playerChoice == "tesoura" && computerChoice1 == "pedra" && computerChoice2 =="lagarto")||
                    (playerChoice == "lagarto" && computerChoice1 == "pedra" && computerChoice2 =="tesoura")||
                    (playerChoice == "lagarto" && computerChoice1 == "pedra" && computerChoice2 =="lagarto")||
                    //papel vence
                    (playerChoice == "pedra" && computerChoice1 == "papel" && computerChoice2 =="pedra")||
                    (playerChoice == "pedra" && computerChoice1 == "papel" && computerChoice2 =="spock")||
                    (playerChoice == "spock" && computerChoice1 == "papel" && computerChoice2 =="pedra")||
                    (playerChoice == "spock" && computerChoice1 == "papel" && computerChoice2 =="spock")||
                    //tesoura vence
                    (playerChoice == "papel" && computerChoice1 == "tesoura" && computerChoice2 =="papel")||
                    (playerChoice == "papel" && computerChoice1 == "tesoura" && computerChoice2 =="lagarto")||
                    (playerChoice == "lagarto" && computerChoice1 == "tesoura" && computerChoice2 =="papel")||
                    (playerChoice == "lagarto" && computerChoice1 == "tesoura" && computerChoice2 =="lagarto")||
                    //lagarto vence
                    (playerChoice == "papel" && computerChoice1 == "lagarto" && computerChoice2 =="papel")||
                    (playerChoice == "papel" && computerChoice1 == "lagarto" && computerChoice2 =="spock")||
                    (playerChoice == "spock" && computerChoice1 == "lagarto" && computerChoice2 =="papel")||
                    (playerChoice == "spock" && computerChoice1 == "lagarto" && computerChoice2 =="spock")||
                    //spock vence
                    (playerChoice == "pedra" && computerChoice1 == "spock" && computerChoice2 =="pedra")||
                    (playerChoice == "pedra" && computerChoice1 == "spock" && computerChoice2 =="tesoura")||
                    (playerChoice == "tesoura" && computerChoice1 == "spock" && computerChoice2 =="pedra")||
                    (playerChoice == "tesoura" && computerChoice1 == "spock" && computerChoice2 =="tesoura")
            -> "Computador 1 venceu!"

            //COMPUTADOR 2 VENCE
            //pedra vence
            (playerChoice == "tesoura" && computerChoice1 == "tesoura" && computerChoice2 == "pedra") ||
                    (playerChoice == "tesoura" && computerChoice1 == "lagarto" && computerChoice2 =="pedra")||
                    (playerChoice == "lagarto" && computerChoice1 == "tesoura" && computerChoice2 =="pedra")||
                    (playerChoice == "lagarto" && computerChoice1 == "lagarto" && computerChoice2 =="pedra")||
                    //papel vence
                    (playerChoice == "pedra" && computerChoice1 == "pedra" && computerChoice2 =="papel")||
                    (playerChoice == "pedra" && computerChoice1 == "spock" && computerChoice2 =="papel")||
                    (playerChoice == "spock" && computerChoice1 == "pedra" && computerChoice2 =="papel")||
                    (playerChoice == "spock" && computerChoice1 == "spock" && computerChoice2 =="papel")||
                    //tesoura vence
                    (playerChoice == "papel" && computerChoice1 == "papel" && computerChoice2 =="tesoura")||
                    (playerChoice == "papel" && computerChoice1 == "lagarto" && computerChoice2 =="tesoura")||
                    (playerChoice == "lagarto" && computerChoice1 == "papel" && computerChoice2 =="tesoura")||
                    (playerChoice == "lagarto" && computerChoice1 == "lagarto" && computerChoice2 =="tesoura")||
                    //lagarto vence
                    (playerChoice == "papel" && computerChoice1 == "papel" && computerChoice2 =="lagarto")||
                    (playerChoice == "papel" && computerChoice1 == "spock" && computerChoice2 =="lagarto")||
                    (playerChoice == "spock" && computerChoice1 == "papel" && computerChoice2 =="lagarto")||
                    (playerChoice == "spock" && computerChoice1 == "spock" && computerChoice2 =="lagarto")||
                    //spock vence
                    (playerChoice == "pedra" && computerChoice1 == "pedra" && computerChoice2 =="spock")||
                    (playerChoice == "pedra" && computerChoice1 == "tesoura" && computerChoice2 =="spock")||
                    (playerChoice == "tesoura" && computerChoice1 == "pedra" && computerChoice2 =="spock")||
                    (playerChoice == "tesoura" && computerChoice1 == "tesoura" && computerChoice2 =="spock")
            -> "Computador 2 venceu!"

            else -> "Empate!"
        }
    }

    private fun showResult(winner: String, playerChoice: String, computerChoice1: String, computerChoice2: String) {
        val message = "Player 1: $playerChoice\nComputador 1: $computerChoice1\nComputador 2: $computerChoice2\nResultado: $winner"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        atjb.pedraBt.setImageResource(R.drawable.rock1)
        atjb.papelBt.setImageResource(R.drawable.paper1)
        atjb.tesouraBt.setImageResource(R.drawable.scissor1)
        atjb.lagartoBt.setImageResource(R.drawable.lagarto) //temporary
        atjb.spockBt.setImageResource(R.drawable.spock) //temporary
    }
}