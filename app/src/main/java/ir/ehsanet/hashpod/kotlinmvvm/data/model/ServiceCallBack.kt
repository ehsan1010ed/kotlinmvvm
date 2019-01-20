package ir.ehsanet.hashpod.kotlinmvvm.data.model

interface ServiceCallback<R> {
    fun onSuccuss(reponse: R)
    fun onError(serviceError: ServiceError)
}
