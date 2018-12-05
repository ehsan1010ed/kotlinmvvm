package ir.ehsanet.hashpod.kotlinmvvm.data.rpo

import android.arch.lifecycle.MutableLiveData
import ir.ehsanet.hashpod.kotlinmvvm.data.GitHubService
import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project
import retrofit2.Call

class ProjectsListRepository : BaseRepository<Void, List<Project>>() {

    override fun buildCall(vararg path : String) : Call<List<Project>> {
        return retrofit.create(GitHubService::class.java).getProjectList(path[0])
}


}
