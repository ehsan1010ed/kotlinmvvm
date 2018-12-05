package ir.ehsanet.hashpod.kotlinmvvm.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object ProjectRepository {

    val gitHubService: GitHubService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        gitHubService = retrofit.create(GitHubService::class.java)
    }


}
