package ir.ehsanet.hashpod.kotlinmvvm

import android.app.Application
import ir.ehsanet.hashpod.kotlinmvvm.data.di.AppComponent
import ir.ehsanet.hashpod.kotlinmvvm.data.di.AppModule
import ir.ehsanet.hashpod.kotlinmvvm.data.di.DaggerAppComponent

class App : Application() {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

    fun getAppComponent():AppComponent{
        return component;
    }

    companion object {
        lateinit var instance: App private set
    }
}
