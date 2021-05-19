package com.gmail.apigeoneer.aesteroids.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gmail.apigeoneer.aesteroids.R
import com.gmail.apigeoneer.aesteroids.databinding.FragmentOverviewBinding
import com.gmail.apigeoneer.aesteroids.detail.DetailViewModel

class OverviewFragment : Fragment() {

    // data binding
    private lateinit var binding: FragmentOverviewBinding

    // lazily initialize our [OverviewViewModel]
    private val overviewViewModel: OverviewViewModel by lazy {
        ViewModelProvider(this, OverviewViewModel.Factory(requireActivity().application))
            .get(OverviewViewModel::class.java)
    }

    // lazily initialize our [DetailViewModel]
    private val detailViewModel: DetailViewModel by lazy {
        ViewModelProvider(this, DetailViewModel.Factory(requireActivity().application))
                .get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access tp the [OverviewViewModel]
        binding.viewModel = overviewViewModel

        binding.asteroidsRv.adapter = AsteroidAdapter(AsteroidAdapter.OnClickListener {
            detailViewModel.displayAsteroidDetails(it)
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}