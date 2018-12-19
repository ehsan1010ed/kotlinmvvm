package ir.ehsanet.hashpod.kotlinmvvm.data.di

import dagger.Module
import dagger.Provides
import ir.ehsanet.hashpod.kotlinmvvm.App
import ir.ehsanet.hashpod.kotlinmvvm.data.GitHubService
import ir.ehsanet.hashpod.kotlinmvvm.data.rpo.ProjectsListRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule (private val app : App){

    @Provides
    @Singleton
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun projectsRepo(retroft : Retrofit) : ProjectsListRepository {
        return ProjectsListRepository(retroft)
    }
}