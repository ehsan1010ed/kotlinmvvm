package ir.ehsanet.hashpod.kotlinmvvm.data.di

import dagger.Component
import dagger.Module
import ir.ehsanet.hashpod.kotlinmvvm.data.rpo.ProjectsListRepository
import ir.ehsanet.hashpod.kotlinmvvm.ui.main.MainViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{
    fun inject( repo : MainViewModel)
}