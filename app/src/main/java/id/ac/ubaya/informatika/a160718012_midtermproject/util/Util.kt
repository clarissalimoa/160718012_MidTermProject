package id.ac.ubaya.informatika.a160718012_midtermproject.util

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.a160718012_midtermproject.R
import java.lang.Exception

fun ImageView.loadImage(url:String?, progressBar: ProgressBar){
    Picasso.get()
        .load(url)
        .resize(900, 1350)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback{
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                Log.d("errorLoadImage", e.toString())

            }

        })

}