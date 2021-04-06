package com.udacity.shoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _list : MutableList<Shoe> = mutableListOf()
    private val _shoeList : MutableLiveData<List<Shoe>> = MutableLiveData()
    val shoeList : LiveData<List<Shoe>>
        get() = _shoeList
    var newShoe : Shoe = Shoe("",0.0,"","")

    init {
        _list.add(Shoe(name = "Grey Boots",size = 3.4,company = "Levis",description = "Really nice boots",listOf("")))
        _list.add(Shoe(name = "Blue Boots",size = 3.4,company = "North face",description = "Really nice boots for walking",listOf("")))
        _shoeList.value = _list
    }

    fun add(newShoe : Shoe) {
        _list.add(newShoe)
        _shoeList.value = _list
    }

    fun makeNewShoe() {
        newShoe = Shoe("",0.0,"","")
    }

}