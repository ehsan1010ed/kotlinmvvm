package ir.ehsanet.hashpod.kotlinmvvm.data.rpo

import ir.ehsanet.hashpod.kotlinmvvm.App
import ir.ehsanet.hashpod.kotlinmvvm.data.GitHubService
import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class ProjectsListRepository(retrofit: Retrofit) : BaseRepository<Void, List<Project>>(retrofit) {

    override fun buildCall(vararg path : String) : Deferred<Response<List<Project>>> {
        return retrofit.create(GitHubService::class.java).getProjectList(path[0])
}


}
