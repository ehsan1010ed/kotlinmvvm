package ir.ehsanet.hashpod.kotlinmvvm.data.rpo

import android.arch.lifecycle.MutableLiveData
import ir.ehsanet.hashpod.kotlinmvvm.data.Resource
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit



abstract class BaseRepository<RQ,RS> (protected val retrofit : Retrofit){

    fun call(responseLive: MutableLiveData<Resource<RS>>, vararg path : String){
        responseLive.value = Resource.loading(null)
        var client = buildCall(*path)
        launch(UI){
            val x = client.await()
            if(x.isSuccessful){
                responseLive.value = Resource.success(x.body())
            }
            else
                responseLive.value = Resource.error("" , null)
        }
    }

    abstract fun buildCall(vararg path : String): Deferred<Response<RS>>
}