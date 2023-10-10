package com.example.pets.petViewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import kotlin.math.log

class PetViewModel: ViewModel() {

    val dog_img_url = MutableLiveData<String>()
    val dogImageUrl: LiveData<String> get() = dog_img_url



    fun GetDogImageURl() {

        val client = AsyncHttpClient()
        client.get("https://dog.ceo/api/breeds/image/random",object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e("Dog Image", "Failed to get dog image: $throwable")
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                json.let {
                    val url = json?.jsonObject?.get("message").toString()
                    dog_img_url.postValue(url)

                }
                Log.i("Dog Image", "Success: $json")

            }

        })

    }
}