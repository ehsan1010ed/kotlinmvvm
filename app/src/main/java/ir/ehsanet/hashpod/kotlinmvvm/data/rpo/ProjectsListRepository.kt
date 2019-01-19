package ir.ehsanet.hashpod.kotlinmvvm.data.rpo

import ir.ehsanet.hashpod.kotlinmvvm.data.GithubApi
import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project
import kotlinx.coroutines.Deferred
import retrofit2.Response

class ProjectsListRepository(val githubApi : GithubApi) : BaseRepository<Void, List<Project>>() {

    override fun buildApiCall(vararg path: String): Deferred<Response<List<Project>>> {
        return githubApi.getProjectList(path[0])
    }

    override fun buildDbCall(vararg path: String) {

    }
}
