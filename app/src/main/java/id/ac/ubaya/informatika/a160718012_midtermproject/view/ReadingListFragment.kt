package id.ac.ubaya.informatika.a160718012_midtermproject.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.a160718012_midtermproject.R
import id.ac.ubaya.informatika.a160718012_midtermproject.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_book_list.*
import kotlinx.android.synthetic.main.fragment_book_list.recView
import kotlinx.android.synthetic.main.fragment_reading_list.*

class ReadingListFragment : Fragment() {

    private lateinit var viewModel:ListViewModel
    private val bookListAdapter = ReadingListAdapter(arrayListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reading_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        //layout manager: linear/grid/stager
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = bookListAdapter



        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.booksLD.observe(viewLifecycleOwner, Observer {
            bookListAdapter.updatebookList(it)
            recView.visibility = View.VISIBLE
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer{
            txtErrorRead.setText(R.string.error_load)
            txtErrorRead.visibility =if(it) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer{
            progLoadRead.visibility =if(it) View.VISIBLE else View.GONE
            Log.d("showLoadingListFragment", it.toString())
        })
    }

}