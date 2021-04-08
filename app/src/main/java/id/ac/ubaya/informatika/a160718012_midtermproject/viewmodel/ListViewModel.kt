package id.ac.ubaya.informatika.a160718012_midtermproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.a160718012_midtermproject.model.Book

class ListViewModel(application: Application): AndroidViewModel(application){
    //bookS -> jamak, nampung banyak object -> List<Book>
    //LD = LiveData biar programmer tau ini variable utk LiveData, bukan var biasa
    var booksLD = MutableLiveData<List<Book>>()
    //menyimpan kondisi apakah recyclerView berhasil load/ada error?
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    //loading data dari  dummy source
    fun refresh(){
        val book1 = Book(1,"Masih Belajar","Iman Usman","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1558424509l/45901103._SY475_.jpg", 100, 25, 4.7, "Indonesia", "Lewat berbagai prestasi dan karyanya, Iman membuktikan bahwa kesuksesan karir dan berdampak sosial bisa berjalan beriringan. Di usianya yang baru 27 tahun, Iman sudah mendirikan perusahaan teknologi pendidikan yang kini mempekerjakan ribuan pegawai, menjalankan berbagai organisasi dan inisiatif sosial, menjadi pembicara dan pengajar di berbagai penjuru dunia, dan meraih gelar master di salah satu perguruan tinggi terbaik di dunia. ");
        val book2 = Book(2,"Think Like A Monk","Jay Shatty","https://images-na.ssl-images-amazon.com/images/I/71ru1Xg+VyL.jpg", 328, 99, 4.26, "English", "Jay Shetty, social media superstar and host of the #1 podcast On Purpose, distills the timeless wisdom he learned as a monk into practical steps anyone can take every day to live a less anxious, more meaningful life.\n" +
                "\n" +
                "When you think like a monk, you’ll understand:\n" +
                "- How to overcome negativity\n" +
                "- How to stop overthinking\n" +
                "- Why comparison kills love\n" +
                "- How to use your fear\n" +
                "- Why you can’t find happiness by looking for it\n" +
                "- How to learn from everyone you meet\n" +
                "- Why you are not your thoughts\n" +
                "- How to find your purpose\n" +
                "- Why kindness is crucial to success\n" +
                "- And much more...\n" +
                "\n" +
                "Shetty grew up in a family where you could become one of three things—a doctor, a lawyer, or a failure. His family was convinced he had chosen option three: instead of attending his college graduation ceremony, he headed to India to become a monk, to meditate every day for four to eight hours, and devote his life to helping others. After three years, one of his teachers told him that he would have more impact on the world if he left the monk’s path to share his experience and wisdom with others. Heavily in debt, and with no recognizable skills on his résumé, he moved back home in north London with his parents.");
        val book3 = Book(3,"The 7 Habits of Highly Effective People","Stephen R. Covey","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1421842784l/36072.jpg",
            372, 30, 4.13, "English", "When Stephen Covey first released The Seven Habits of Highly Effective People, the book became an instant rage because people suddenly got up and took notice that their lives were headed off in the wrong direction; and more than that, they realized that there were so many simple things they could do in order to navigate their life correctly. This book was wonderful education for people, education in how to live life effectively and get closer to the ideal of being a ‘success’ in life.\n" +
                "\n" +
                "But not everyone understands Stephen Covey’s model fully well, or maybe there are some people who haven’t read it yet. This is definitely true because we still see so much failure all around us. Now, I am not saying that by using Covey’s model, or anyone else’s model for that matter, you can become a sure-shot success, but at least we should have seen many more successes around us already judging by the number of copies the book has sold! So, where is the shortcoming?");
        val book4 = Book(4,"Sapiens","Yuval Noah Harari","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1595674533l/23692271._SY475_.jpg"
            , 512, 60, 4.40, "English", "How did our species succeed in the battle for dominance? Why did our foraging ancestors come together to create cities and kingdoms? How did we come to believe in gods, nations and human rights; to trust money, books and laws; and to be enslaved by bureaucracy, timetables and consumerism? And what will our world be like in the millennia to come?");
        val book5 = Book(5,"The Psychology of Money","Morgan Housel","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1581527774l/41881472._SY475_.jpg"
            , 100, 100, 4.7, "English", "");
        val book6 = Book(6,"You Do You","Fellexandro Ruby","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1608193312l/56317605._SX318_.jpg"
            , 100, 100, 4.7, "English", "");


        var books:ArrayList<Book> = arrayListOf<Book>(book1, book2, book3, book4, book5, book6);
        booksLD.value = books;
        loadingLD.value = true
        loadingErrorLD.value = false

    }

    //dipanggil saat observer / fragment list lagi onStop/onDestroy
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}