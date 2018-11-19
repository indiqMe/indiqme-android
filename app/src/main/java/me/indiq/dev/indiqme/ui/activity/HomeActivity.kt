package me.indiq.dev.indiqme.ui.activity

import android.os.Bundle
import me.indiq.dev.indiqme.R

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupToolbar(getString(R.string.app_name))
    }
}
