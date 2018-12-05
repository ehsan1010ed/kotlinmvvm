package ir.ehsanet.hashpod.kotlinmvvm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ir.ehsanet.hashpod.kotlinmvvm.ui.base.BaseActivity
import ir.ehsanet.hashpod.kotlinmvvm.ui.main.MainFragment

class MainActivity : BaseActivity() {

    override fun showLoading(show: Boolean) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            replaceFragment(MainFragment.newInstance())
        }
    }
}
