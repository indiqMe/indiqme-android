package me.indiq.dev.indiqme.Activities

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import me.indiq.dev.indiqme.Activities.RegisterSteps.RegisterPersonalData
import me.indiq.dev.indiqme.R

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_entrar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        tv_cadaste_se.setOnClickListener {
            val intent = Intent(this, RegisterPersonalData::class.java)
            startActivity(intent)
        }

        tv_esqueci_minha_senha.setOnClickListener {
            val intent = Intent(this, PasswordRecoverActivity::class.java)
            startActivity(intent)
        }

    }
}
