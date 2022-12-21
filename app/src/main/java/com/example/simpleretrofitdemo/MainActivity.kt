package com.example.simpleretrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData

import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO: 1. Create an instance of Retrofit
        val retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getAlbums()
            emit(response)
        }
        val textView = findViewById<TextView>(R.id.tv)
        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    val result = " " + "Album title: ${albumsItem.title}" + "\n" +
                            " " + "Album id: ${albumsItem.id}" + "\n" +
                            " " + "User id: ${albumsItem.userId}" + "\n\n\n"
                    textView.append(result)

                }
            }
        })

    }
}