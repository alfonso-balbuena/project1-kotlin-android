package com.udacity.shoestore.shoeList

import android.content.res.Resources
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R

import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModel.ShoeListViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val sharedViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        sharedViewModel.shoeList.observe(viewLifecycleOwner, Observer { newList: List<Shoe> ->
            newList.forEach { shoe: Shoe ->
                binding.layoutShowList.addView(createViewItem(shoe))
            }
        })
        binding.fab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        Timber.d("On create menu options")
        inflater?.inflate(R.menu.menu_activity, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item!!,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    private fun createViewItem(shoe: Shoe): View {
        val containerLayout = makeContainer()
        containerLayout.addView(
            makeChild(
                getString(R.string.text_item, shoe.name),
                R.style.TitleItem
            )
        )
        containerLayout.addView(
            makeChild(
                getString(
                    R.string.text_detail_item,
                    shoe.company,
                    shoe.description,
                    shoe.size
                ), R.style.DetailsItem
            )
        )
        return containerLayout
    }

    private fun makeContainer(): LinearLayout {
        val containerLayout = LinearLayout(requireContext())
        containerLayout.orientation = LinearLayout.VERTICAL
        containerLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        return containerLayout
    }

    private fun makeChild(data: String, style: Int): View {
        val child = TextView(requireContext())
        child.text = data
        child.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            child.setTextAppearance(style)
        }
        return child
    }
}