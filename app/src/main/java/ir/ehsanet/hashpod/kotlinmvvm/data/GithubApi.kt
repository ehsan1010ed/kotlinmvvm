package ir.ehsanet.hashpod.kotlinmvvm.data

import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    companion object {
        const val HTTPS_API_GITHUB_URL = "https://api.github.com/"
    }

    @GET("users/{user}/repos")
    fun getProjectList(@Path("user") user: String): Deferred<Response<List<Project>>>

    @GET("/repos/{user}/{reponame}")
    fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Call<Project>

}

