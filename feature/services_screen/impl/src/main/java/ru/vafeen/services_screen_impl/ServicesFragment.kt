package ru.vafeen.services_screen_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.vafeen.services_screen_impl.databinding.FragmentServicesBinding
import ru.vafeen.services_screen_impl.recycler.ServicesListAdapter

@AndroidEntryPoint
internal class ServicesFragment : Fragment() {
    private var adapter: ServicesListAdapter? = null
    private var binding: FragmentServicesBinding? = null
    private val viewModel: ServicesViewModel by viewModels()

    @Inject
    fun inject(servicesListAdapter: ServicesListAdapter) {
        adapter = servicesListAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentServicesBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            setupRecyclerView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun FragmentServicesBinding.setupRecyclerView() {
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewModel.metadata.collectLatest { adapter?.submitList(it) }
        }
    }
}