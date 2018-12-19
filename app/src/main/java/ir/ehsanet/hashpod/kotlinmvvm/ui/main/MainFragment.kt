package ir.ehsanet.hashpod.kotlinmvvm.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import ir.ehsanet.hashpod.kotlinmvvm.R
import ir.ehsanet.hashpod.kotlinmvvm.data.Status
import ir.ehsanet.hashpod.kotlinmvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : BaseFragment<MainViewModel>() {

    override var layout: Int = R.layout.main_fragment
    override val vmClass: Class<MainViewModel> = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun showLoading(show: Boolean) {

    }

    override fun start(savedInstanceState: Bundle?) {
        viewModel.start()
        viewModel.responseLive.observe(this,
            Observer { response ->
                if (response?.status == Status.LOADING) {
                    message.text = "LOADING"
                }
                else if(response?.status == Status.ERROR){
                    message.text = "ERROR"
                }
                else if(response?.status == Status.SUCCESS)
                    message.text = "SUCCUSSFULL"
            })
    }
}
