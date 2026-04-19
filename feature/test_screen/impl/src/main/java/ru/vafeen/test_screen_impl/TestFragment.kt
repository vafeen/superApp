package ru.vafeen.test_screen_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.vafeen.test_screen_impl.databinding.FragmentTestBinding

@AndroidEntryPoint
internal class TestFragment : Fragment() {
    private val viewModel: TestViewModel by viewModels()
    private var binding: FragmentTestBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentTestBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.flow.collectLatest {
                binding?.tv?.text = "counter: $it"
            }
        }
        binding?.buttonPlus?.setOnClickListener {
            viewModel.plus()
        }
        binding?.buttonOpenNew?.setOnClickListener {
            viewModel.openNew()
        }
    }
}