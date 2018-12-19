package ir.ehsanet.hashpod.kotlinmvvm.ui.main

import android.arch.lifecycle.MutableLiveData
import ir.ehsanet.hashpod.kotlinmvvm.App
import ir.ehsanet.hashpod.kotlinmvvm.data.Resource
import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project
import ir.ehsanet.hashpod.kotlinmvvm.data.rpo.ProjectsListRepository
import ir.ehsanet.hashpod.kotlinmvvm.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    var responseLive: MutableLiveData<Resource<List<Project>>> = MutableLiveData()

    @Inject
    lateinit var  projectsListRepository: ProjectsListRepository

    init {

    }

    override fun start() {
        App.instance.getAppComponent().inject(this)
        fetchProject("Google")
    }

    fun fetchProject(id : String){
        projectsListRepository.call(responseLive,id)
    }
}
