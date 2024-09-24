package com.example.foodappbymyself

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodappbymyself.Adapters.PopularAdapter
import com.example.foodappbymyself.Models.PopularModel
import com.example.foodappbymyself.Models.SharedModel
import com.example.foodappbymyself.databinding.FragmentSearchBinding




class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    private lateinit var adapter : PopularAdapter
    private lateinit var list : ArrayList<PopularModel>
    private lateinit var sharedModel : SharedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel :: class.java)


        list = ArrayList()
        list.add(PopularModel(R.drawable.pop_menu_burger, "Сендвич",7, 7,1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Момо",8, 8,1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Бургер",5, 5,1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Сендвич",7, 7,1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Момо",8, 8,1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Бургер",5, 5,1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Сендвич",7, 7,1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Момо",8, 8,1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Бургер",5, 5,1))


        adapter = PopularAdapter(requireContext(),list)
        adapter.setSharedModel(sharedModel)
        binding.searchMenuRv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchMenuRv.adapter = adapter

        searchMenuFood()
        return binding.root
    }

    private fun searchMenuFood(){
        binding.searchMenuItem.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterList(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(input : String?){
        val filteredList = if(input.isNullOrEmpty()){
            list
        }else{
            list.filter{item->
                item.getFoodName().contains(input, ignoreCase = true)
            }
        }

        adapter.updateList(filteredList as ArrayList<PopularModel>)
    }


}