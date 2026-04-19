package ru.vafeen.superapp

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.vafeen.common.navigation.Feature

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initNavigator(supportFragmentManager)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addOnBackPressedCallbackForClosingActivityOnEmptyStack()
        if (savedInstanceState == null) {
            viewModel.openFeature(Feature.Services)
        }
    }

    private fun addOnBackPressedCallbackForClosingActivityOnEmptyStack() {
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                private val MINIMAL_FRAGMENT_COUNT = 1
                override fun handleOnBackPressed() {
                    val fragmentManager = supportFragmentManager
                    if (fragmentManager.backStackEntryCount > MINIMAL_FRAGMENT_COUNT) {
                        fragmentManager.popBackStack()
                    } else {
                        finish()
                    }
                }
            })
    }

    override fun onDestroy() {
        viewModel.shutdownNavigator()
        super.onDestroy()
    }
}