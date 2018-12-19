package ir.ehsanet.hashpod.kotlinmvvm.ui.base

import android.arch.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    abstract fun start()
}