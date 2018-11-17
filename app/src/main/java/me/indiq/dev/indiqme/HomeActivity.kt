package me.indiq.dev.indiqme

import android.os.Bundle

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupToolbar(getString(R.string.app_name))
    }
}
