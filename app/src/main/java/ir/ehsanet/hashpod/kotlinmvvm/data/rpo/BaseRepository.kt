package ir.ehsanet.hashpod.kotlinmvvm.data.rpo

import androidx.lifecycle.MutableLiveData
import ir.ehsanet.hashpod.kotlinmvvm.data.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit


abstract class BaseRepository<RQ, RS> : CoroutineScope {

    override val coroutineContext = Main

    fun call(liveData: MutableLiveData<Resource<RS>>, vararg path: String) {
        liveData.value = Resource.loading(null)
        var client = buildApiCall(*path)
        launch {
            val x = async { client.getCompleted() }.await()
            if (x.isSuccessful)
                liveData.value = Resource.success(x.body())
            else
                liveData.value = Resource.error("", null)
        }
    }

    abstract fun buildApiCall(vararg path: String): Deferred<Response<RS>>
    abstract fun buildDbCall(vararg path : String): Unit
}