package id.ac.ubaya.informatika.a160718012_midtermproject.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.a160718012_midtermproject.R
import id.ac.ubaya.informatika.a160718012_midtermproject.util.loadImage
import id.ac.ubaya.informatika.a160718012_midtermproject.viewmodel.DetailViewModel
import id.ac.ubaya.informatika.a160718012_midtermproject.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_detail_book.*

class DetailBookFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var listViewModel: ListViewModel
    var idBook = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_book, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        listViewModel= ViewModelProvider(this).get(ListViewModel::class.java)
        listViewModel.refresh()
        arguments?.let{
            idBook = DetailBookFragmentArgs.fromBundle(requireArguments()).bookId
            Log.d("bookid", idBook.toString())

        }
        observeBookList()
    }
    fun observeViewModel() {
        Log.d("detail", "observeViewModel book detail")

        viewModel.bookLD.observe(viewLifecycleOwner, Observer {
            Log.d("detail", it.toString())
            Log.d("detail", "changetext"+it.title)
            txtTitleD.setText(it.title)
            txtAuthorD.setText(it.author)
            txtDescD.setText(it.description)
            txtStack.setText(it.rate.toString())
            txtPage.setText(it.totalPage.toString())
            txtCompleted.setText(it.language)
            imgCoverQ.loadImage(it.cover_url, loadProfilePic)
        })
    }

    fun observeBookList() {
        Log.d("detail", "observeBookList")

        listViewModel.booksLD.observe(viewLifecycleOwner, Observer {
            viewModel.fetch(it, idBook)
            observeViewModel()
        })

    }
    
}