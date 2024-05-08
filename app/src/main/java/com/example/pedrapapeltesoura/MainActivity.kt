package com.example.pedrapapeltesoura

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        amb.mainTb.apply {
            title = getString(R.string.app_name)
            subtitle = this@MainActivity.javaClass.simpleName
            setSupportActionBar(this)
        }

        amb.doisJogadoresBt.setOnClickListener {
            val intent = Intent(this, DoisJogadoresActivity::class.java)
             startActivity(intent)
        }
        amb.tresJogadoresBt.setOnClickListener {
            val intent = Intent(this, TresJogadoresActivity::class.java)
            startActivity(intent)
        }

    }
}