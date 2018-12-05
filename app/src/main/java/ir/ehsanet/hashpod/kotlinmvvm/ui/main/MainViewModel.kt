package ir.ehsanet.hashpod.kotlinmvvm.ui.main

import android.arch.lifecycle.MutableLiveData
import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project
import ir.ehsanet.hashpod.kotlinmvvm.data.rpo.ProjectsListRepository
import ir.ehsanet.hashpod.kotlinmvvm.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    var responseLive: MutableLiveData<List<Project>> = MutableLiveData()
    var errorLive: MutableLiveData<Error> = MutableLiveData()

    init {

    }

    override fun start() {
        fetchProject("Google")
    }

    fun fetchProject(id : String){
        var repo = ProjectsListRepository()
        repo.call(responseLive,errorLive ,id)
    }
}
