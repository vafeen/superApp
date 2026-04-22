package ru.vafeen.test_screen_impl

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.vafeen.common.binding.viewBinding
import ru.vafeen.test_screen_impl.databinding.FragmentTestBinding

@AndroidEntryPoint
internal class TestFragment @Inject constructor() : Fragment(R.layout.fragment_test) {
    private val viewModel: TestViewModel by viewModels()
    private val binding: FragmentTestBinding by viewBinding(FragmentTestBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.flow.collectLatest {
                binding.tv.text = "counter: $it"
            }
        }
        binding.buttonPlus.setOnClickListener {
            viewModel.plus()
        }
        binding.buttonOpenNew.setOnClickListener {
            viewModel.openNew()
        }
    }

}