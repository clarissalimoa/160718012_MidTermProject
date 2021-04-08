package id.ac.ubaya.informatika.a160718012_midtermproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.a160718012_midtermproject.R
import id.ac.ubaya.informatika.a160718012_midtermproject.util.loadImage
import id.ac.ubaya.informatika.a160718012_midtermproject.util.loadImageSquare
import id.ac.ubaya.informatika.a160718012_midtermproject.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_reading_list.*

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        txtName.setText("Clarissa Limoa")
        txtBadge.setText("Newbie (Ongoing Nerdy)")
        imgCoverQ.loadImageSquare("https://i.pinimg.com/originals/1a/d7/29/1ad7293ae30b38b331e056366ab938d6.jpg", loadProfilePic)


    }
}