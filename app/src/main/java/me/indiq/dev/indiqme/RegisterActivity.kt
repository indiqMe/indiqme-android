package me.indiq.dev.indiqme

import android.os.Bundle

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupToolbar(getString(R.string.cadastre_se))
    }
}
