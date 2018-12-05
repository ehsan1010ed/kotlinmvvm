package ir.ehsanet.hashpod.kotlinmvvm.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import ir.ehsanet.hashpod.kotlinmvvm.R
import ir.ehsanet.hashpod.kotlinmvvm.ui.base.BaseFragment


class MainFragment : BaseFragment<MainViewModel>() {

    override var layout: Int = R.layout.main_fragment
    override val p: Class<MainViewModel> = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun showLoading(show: Boolean) {

    }

    override fun start(savedInstanceState: Bundle?) {
        viewModel.start()
        viewModel.responseLive.observe(this,
            Observer { projects ->
                if (projects != null) {
                    showMessage("Hello")
                }
                else{
                    showMessage("Bye")
                }
            })
    }
}
