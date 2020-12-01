package br.com.desafiowebservice.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.desafiowebservice.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        loginTvCreateAccount.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
            finish()
        }
    }
}