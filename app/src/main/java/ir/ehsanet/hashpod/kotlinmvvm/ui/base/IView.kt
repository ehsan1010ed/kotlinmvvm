package ir.ehsanet.hashpod.kotlinmvvm.ui.base

interface IView {
    fun showMessage(message : String)
    fun showMessage(messageResource : Int)
    fun showLoading(show : Boolean)

}