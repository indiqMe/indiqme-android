package me.indiq.dev.indiqme.activities.RegisterSteps

import android.os.Bundle
import me.indiq.dev.indiqme.activities.BaseActivity
import me.indiq.dev.indiqme.R

class RegisterCity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_city)
        setupToolbar(getString(R.string.cadastroCidade))
    }
}
