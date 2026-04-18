package ru.vafeen.superapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.Lazy
import jakarta.inject.Inject
import ru.vafeen.common.ViewModelFactory
import ru.vafeen.common.navigation.FeatureNavigation
import ru.vafeen.superapp.app.App


internal class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: Lazy<ViewModelFactory>
    private val navigator: MainNavigator by lazy {
        viewModelFactory.get().create(MainNavigator::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        navigator.openFeature(FeatureNavigation.Feature.Test)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}