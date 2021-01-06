package br.edu.ifsp.scl.ads.s5.pdm.dices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import br.edu.ifsp.scl.ads.s5.pdm.dices.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }

    fun onClick(view: View) {
        if (view == activityMainBinding.jogarBt) {
            val resultado: Int = Random(System.currentTimeMillis()).nextInt(6) + 1;
            activityMainBinding.resultadoTv.text = resultado.toString()
            // Gerando nome da imagem
            val resultadoImagem = "dice_$resultado"
            activityMainBinding.resultadoIv.setImageResource(
                    resources.getIdentifier(resultadoImagem, "drawable", packageName)
            )
        }
    }

    fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mi_settings -> {
                openSettingsActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}