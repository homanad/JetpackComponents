package com.hmman.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var retService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

//        getRequestWithQueryParameters()
//        getRequestWithPathParameters()
        uploadAlbum()
    }

    private fun uploadAlbum() {
        val album = AlbumsItem(0, "MHMH", 991)
        val postResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.uploadAlbum(album)
            emit(response)
        }

        postResponse.observe(this, Observer {
            txt.text = it.body().toString()
        })
    }

    fun getRequestWithPathParameters() {
        val responseAlbum: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        responseAlbum.observe(this, Observer {
            it.body()?.let {
                txt.append(it.toString() + "\n\n")
            }
        })
    }

    fun getRequestWithQueryParameters() {
        val responseData: LiveData<Response<Albums>> = liveData {
            val response = retService.getSortedAlbums(3)
            emit(response)
        }

        responseData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumItem = albumsList.next()
                    Log.i("mytag", albumItem.toString())
                    txt.append(albumItem.toString() + "\n\n")
                }
            }
        })
    }

}
