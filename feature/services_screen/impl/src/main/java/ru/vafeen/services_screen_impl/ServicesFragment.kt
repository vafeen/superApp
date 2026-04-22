package ru.vafeen.services_screen_impl

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.vafeen.common.binding.viewBinding
import ru.vafeen.services_screen_impl.databinding.FragmentServicesBinding
import ru.vafeen.services_screen_impl.recycler.ServicesListAdapter

@AndroidEntryPoint
internal class ServicesFragment : Fragment(R.layout.fragment_services) {
    private var adapter: ServicesListAdapter? = null
    private val binding: FragmentServicesBinding by viewBinding(FragmentServicesBinding::bind)
    private val viewModel: ServicesViewModel by viewModels()

    @Inject
    fun inject(servicesListAdapter: ServicesListAdapter) {
        adapter = servicesListAdapter
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            setupRecyclerView()
        }
    }


    private fun FragmentServicesBinding.setupRecyclerView() {
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewModel.metadata.collectLatest { adapter?.submitList(it) }
        }
    }
}