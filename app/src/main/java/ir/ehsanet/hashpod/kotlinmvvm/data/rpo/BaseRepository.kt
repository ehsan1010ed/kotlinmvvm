package ir.ehsanet.hashpod.kotlinmvvm.data.rpo

import androidx.lifecycle.MutableLiveData
import ir.ehsanet.hashpod.kotlinmvvm.data.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlinx.coroutines.launch



abstract class BaseRepository<RQ,RS> (protected val retrofit : Retrofit) : CoroutineScope{

//    fun call(responseLive: MutableLiveData<Resource<RS>>, vararg path : String){
 //       responseLive.value = Resource.loading(null)
//        buildCall(*path).enqueue(object : Callback<RS> {
//            override fun onFailure(call: Call<RS>, t: Throwable) {
//                responseLive.value = Resource.error("",null)
//            }
//
//            override fun onResponse(call: Call<RS>, response: Response<RS>) {
//                if(response.isSuccessful){
//                    responseLive.value = Resource.success(response.body())
//                }
//                else{
//                    responseLive.value = Resource.error("",null)
//                }
//            }
//        })
 //   }

    fun call(responseLive: MutableLiveData<Resource<RS>>, vararg path : String){
        responseLive.value = Resource.loading(null)
        var client = buildCall(*path)
        launch {
            val x = client.await()
            if(x){
                responseLive.value = Resource.success(x.body())
            }
            else
                responseLive.value = Resource.error("" , null)

        }
    }

    abstract fun buildCall(vararg path : String): Deferred<RS>
}