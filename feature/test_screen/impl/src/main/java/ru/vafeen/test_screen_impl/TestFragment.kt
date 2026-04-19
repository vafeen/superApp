package ru.vafeen.test_screen_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vafeen.test_screen_impl.databinding.FragmentTestBinding

internal class TestFragment : Fragment() {
    private var binding: FragmentTestBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentTestBinding.inflate(layoutInflater).also { binding = it }.root
}