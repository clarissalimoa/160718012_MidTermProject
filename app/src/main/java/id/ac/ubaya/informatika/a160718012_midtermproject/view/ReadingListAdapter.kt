package id.ac.ubaya.informatika.a160718012_midtermproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160718012_midtermproject.R
import id.ac.ubaya.informatika.a160718012_midtermproject.model.Book
import id.ac.ubaya.informatika.a160718012_midtermproject.util.loadImage
import kotlinx.android.synthetic.main.reading_list_item.view.*
import kotlinx.android.synthetic.main.reading_list_item.view.imgCoverQ
import kotlinx.android.synthetic.main.reading_list_item.view.loadProfilePic


class ReadingListAdapter (val bookList:ArrayList<Book>):RecyclerView.Adapter<ReadingListAdapter.ListViewHolder>(){
    class ListViewHolder(val view:View):RecyclerView.ViewHolder(view)

    //wajib ada utk update list jika ada perubahan, jadi ga usah destroy-create ulang
    fun updatebookList(newBookList:List<Book>){
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged() //utk render ulang dgn data teraktual pada recyclerView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        //memasang layout pada setiap item dalam recyclerView
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.reading_list_item, parent, false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //ngeload data yang sesuai dari arrayList student dan dipasang/render ke dalam layoutnya
        holder.view.txtTitleRead.text = bookList[position].title
        holder.view.txtAuthorRead.text = bookList[position].author
        holder.view.progressBar3.progress = bookList[position].readPage*100/bookList[position].totalPage
        holder.view.txtProgress.text = (bookList[position].readPage*100/bookList[position].totalPage).toString() + "% Completed"

        holder.view.imgCoverQ.loadImage(bookList[position].cover_url, holder.view.loadProfilePic)


    }

}