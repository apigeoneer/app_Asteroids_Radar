package com.gmail.apigeoneer.aesteroids.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gmail.apigeoneer.aesteroids.R
import com.gmail.apigeoneer.aesteroids.databinding.FragmentOverviewBinding
import com.gmail.apigeoneer.aesteroids.detail.DetailViewModel

class OverviewFragment : Fragment() {

    // data binding
    private lateinit var binding: FragmentOverviewBinding

    // lazily initialize our [OverviewViewModel]
    private val overviewViewModel: OverviewViewModel by lazy {
        ViewModelProvider(this, OverviewViewModel.OverviewViewModelFactory(requireActivity().application))
            .get(OverviewViewModel::class.java)
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
            overviewViewModel.displayAsteroidDetails(it)
        })

        // this observer calls navigate() to go to the detail screen when the MarsProperty is not null
        overviewViewModel.navigateToSelectedAsteroid.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                overviewViewModel.displayAsteroidDetailsComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}