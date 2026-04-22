package ru.vafeen.flowers_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.vafeen.common.binding.viewBinding
import ru.vafeen.flowers_screen.databinding.FragmentFlowersBinding
import ru.vafeen.flowers_screen.recycler_list_view.FlowersListAdapter
import javax.inject.Inject

@AndroidEntryPoint
internal class FlowersFragment : Fragment(R.layout.fragment_flowers) {
    private val viewModel by viewModels<FlowersViewModel>()
    private val binding: FragmentFlowersBinding by viewBinding(FragmentFlowersBinding::bind)
    private var flowersListAdapter: FlowersListAdapter? = null

    @Inject
    fun inject(adapter: FlowersListAdapter) {
        flowersListAdapter = adapter
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.flowersListView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.flowersListView.adapter = this.flowersListAdapter
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewModel.flow.collectLatest {
                flowersListAdapter?.submitList(it)
            }
        }
    }

}