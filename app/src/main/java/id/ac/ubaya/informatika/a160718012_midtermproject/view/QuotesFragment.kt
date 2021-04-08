package id.ac.ubaya.informatika.a160718012_midtermproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ubaya.informatika.a160718012_midtermproject.R
import id.ac.ubaya.informatika.a160718012_midtermproject.util.loadImage
import kotlinx.android.synthetic.main.fragment_quotes.*


class QuotesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtName.setText("Think Like A Monk")
        txtBadge.setText("Jay Shetty")
        txtQOTD.setText("When you try to live your most authentic life, some of your relationships will be put in jeopardy. Losing them is a risk worth bearing; finding a way to keep them in your life is a challenge worth taking on.")
        imgCoverQ.loadImage("https://images-na.ssl-images-amazon.com/images/I/71ru1Xg+VyL.jpg", loadProfilePic)
    }



}