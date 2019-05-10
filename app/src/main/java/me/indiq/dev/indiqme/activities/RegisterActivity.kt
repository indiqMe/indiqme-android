package me.indiq.dev.indiqme.activities

import android.os.Bundle
import me.indiq.dev.indiqme.R

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupToolbar(getString(R.string.cadastre_se))
    }
}
