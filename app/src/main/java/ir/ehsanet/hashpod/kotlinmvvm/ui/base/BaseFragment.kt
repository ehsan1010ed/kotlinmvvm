package ir.ehsanet.hashpod.kotlinmvvm.ui.base
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders



public abstract class BaseFragment<VM : BaseViewModel> : Fragment(), IView{

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