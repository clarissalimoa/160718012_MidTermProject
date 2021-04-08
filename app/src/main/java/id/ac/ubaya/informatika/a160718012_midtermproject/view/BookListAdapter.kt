package id.ac.ubaya.informatika.a160718012_midtermproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160718012_midtermproject.R
import id.ac.ubaya.informatika.a160718012_midtermproject.model.Book
import id.ac.ubaya.informatika.a160718012_midtermproject.util.loadImage
import kotlinx.android.synthetic.main.book_list_item.view.*


class BookListAdapter (val bookList:ArrayList<Book>):RecyclerView.Adapter<BookListAdapter.BookViewHolder>(){
    class BookViewHolder(val view:View):RecyclerView.ViewHolder(view)

    //wajib ada utk update list jika ada perubahan, jadi ga usah destroy-create ulang
    fun updateBookList(newBookList:List<Book>){
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged() //utk render ulang dgn data teraktual pada recyclerView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        //memasang layout pada setiap item dalam recyclerView
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder(v)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.view.txtName.text = bookList[position].title
        holder.view.txtBadge.text = bookList[position].author

        holder.view.imgCoverQ.loadImage(bookList[position].cover_url, holder.view.loadProfilePic)

        holder.view.cardView.setOnClickListener{
            val action = BookListFragmentDirections.actionHomeToDetail(bookList[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }

}