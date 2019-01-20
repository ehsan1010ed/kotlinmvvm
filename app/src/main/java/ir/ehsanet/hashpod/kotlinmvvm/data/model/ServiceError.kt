package ir.ehsanet.hashpod.kotlinmvvm.data.model

data class ServiceError(var code: String?, var message: String? ){
    constructor() : this("-1",null)
}

fun ServiceError(block: ServiceError.() -> Unit) : ServiceError = ServiceError().apply(block)
