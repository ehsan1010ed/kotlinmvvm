package ir.ehsanet.hashpod.kotlinmvvm.ui.base

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ir.ehsanet.hashpod.kotlinmvvm.R
import ir.ehsanet.hashpod.kotlinmvvm.ui.main.MainViewModel
import ir.ehsanet.hashpod.kotlinmvvm.data.model.Project



open abstract class BaseFragment<VM : BaseViewModel> : Fragment(), IView{

    protected lateinit var viewModel: VM
    protected abstract var layout: Int
    protected abstract val vmClass: Class<VM>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(vmClass)
        start(savedInstanceState)
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity,message, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(messageResource: Int) {
        Toast.makeText(activity,messageResource, Toast.LENGTH_LONG).show()
    }

    protected abstract fun start(savedInstanceState: Bundle?)

}