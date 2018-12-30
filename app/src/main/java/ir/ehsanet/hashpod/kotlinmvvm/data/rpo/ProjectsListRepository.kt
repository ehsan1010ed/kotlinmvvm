package ir.ehsanet.hashpod.kotlinmvvm.data.rpo

import ir.ehsanet.hashpod.kotlinmvvm.data.GitHubService
import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit

class ProjectsListRepository(retrofit: Retrofit) : BaseRepository<Void, List<Project>>(retrofit) {

    override fun buildCall(vararg path: String): Deferred<List<Project>> {
        return retrofit.create(GitHubService::class.java).getProjectList(path[0])
    }

    private inline fun <reified T> createApi(retrofit: Retrofit) = retrofit.create(T::class.java)


}
