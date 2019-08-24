package me.indiq.dev.indiqme.activities

import android.os.Bundle
import me.indiq.dev.indiqme.R

class PasswordRecoverActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_recover)
        setupToolbar(getString(R.string.recuperar_senha))
    }
}
