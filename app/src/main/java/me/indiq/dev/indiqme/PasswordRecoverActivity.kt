package me.indiq.dev.indiqme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class PasswordRecoverActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_recover)
        setupToolbar(getString(R.string.recuperar_senha))
    }
}
