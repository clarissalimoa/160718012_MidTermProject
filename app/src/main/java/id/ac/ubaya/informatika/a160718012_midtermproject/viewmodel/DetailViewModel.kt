package id.ac.ubaya.informatika.a160718012_midtermproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.a160718012_midtermproject.model.Book

class DetailViewModel: ViewModel() {
    var bookLD = MutableLiveData<Book>()

    fun fetch(bookList:List<Book>, bookId:Int) {
        val book:Book = bookList[bookId-1]
        bookLD.value = book
    }
}