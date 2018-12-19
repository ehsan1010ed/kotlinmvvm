package ir.ehsanet.hashpod.kotlinmvvm.data.rpo

import android.arch.lifecycle.MutableLiveData
import ir.ehsanet.hashpod.kotlinmvvm.App
import ir.ehsanet.hashpod.kotlinmvvm.data.GitHubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


abstract class BaseRepository<RQ,RS> (protected val retrofit : Retrofit){

    fun call(responseLive: MutableLiveData<RS>, errorLive: MutableLiveData<Error>, vararg path : String){
        buildCall(*path).enqueue(object : Callback<RS> {
            override fun onFailure(call: Call<RS>, t: Throwable) {
                errorLive.value = Error()
            }

            override fun onResponse(call: Call<RS>, response: Response<RS>) {
                if(response.isSuccessful){
                    responseLive.value = response.body()
                }
                else{
                    errorLive.value = Error()
                }
            }
        })
    }

    abstract fun buildCall(vararg path : String): Call<RS>
}