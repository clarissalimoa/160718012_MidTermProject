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
import id.ac.ubaya.informatika.a160718012_midtermproject.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_book_list.*
import kotlinx.android.synthetic.main.fragment_quotes.*
import kotlinx.android.synthetic.main.fragment_quotes.refreshLayoutRead
import kotlinx.android.synthetic.main.fragment_reading_list.*
import kotlinx.android.synthetic.main.fragment_reading_list.recView
import kotlin.random.Random


class QuotesFragment : Fragment() {
    private lateinit var viewModel:ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        refreshLayoutRead.setOnRefreshListener {
            viewModel.refresh()
            refreshLayoutRead.isRefreshing = false
            observeViewModel()
        }

        observeViewModel()


    }

    fun observeViewModel() {
        viewModel.quotesLD.observe(viewLifecycleOwner, Observer {
            val num = Random.nextInt(0,3)
            txtName.setText(it[num].title)
            txtBadge.setText(it[num].author)
            txtQOTD.setText(it[num].quote)
            imgCoverQ.loadImage(it[num].cover_url, loadProfilePic)


        })

    }




}