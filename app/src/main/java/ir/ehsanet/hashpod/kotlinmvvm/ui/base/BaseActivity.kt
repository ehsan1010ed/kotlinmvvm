package ir.ehsanet.hashpod.kotlinmvvm.ui.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.ehsanet.hashpod.kotlinmvvm.R
import ir.ehsanet.hashpod.kotlinmvvm.ui.main.MainFragment

abstract class BaseActivity : AppCompatActivity(),IView {

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun showMessage(messageResource: Int) {
        Toast.makeText(this,messageResource,Toast.LENGTH_LONG).show()
    }

    protected fun replaceFragment(instance: MainFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, instance)
            .commitNow()
    }
}