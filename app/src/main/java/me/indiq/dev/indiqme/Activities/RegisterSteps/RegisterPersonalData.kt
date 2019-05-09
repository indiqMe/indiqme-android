package me.indiq.dev.indiqme.Activities.RegisterSteps

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_personal_data.*
import me.indiq.dev.indiqme.Activities.BaseActivity
import me.indiq.dev.indiqme.R

class RegisterPersonalData : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_personal_data)

        setupToolbar(getString(R.string.cadastroDadosPessoal))

        btNext.setOnClickListener {
            val intent = Intent(this, RegisterCity::class.java)
            startActivity(intent)
        }

    }
}
