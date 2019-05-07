package me.indiq.dev.indiqme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.indiq.dev.indiqme.model.Usuario

class RegistroViewModel : ViewModel() {
    private val currentPage = MutableLiveData<Int>()
    var tecnologias: List<String> = listOf() // TODO: trocar por um modelo

    init {
        currentPage.postValue(1)
    }

    fun currentPageLiveData(): LiveData<Int> {
        return currentPage
    }

    fun pushPage() {
        this.currentPage.postValue(currentPage.value!! + 1)
    }

    fun popPage() {
        this.currentPage.postValue(currentPage.value!! - 1)
    }

    fun setCurrentPage(page: Int) {
        this.currentPage.postValue(page)
    }

    fun getCurrentPage(): Int {
        return this.currentPage.value!!
    }
}