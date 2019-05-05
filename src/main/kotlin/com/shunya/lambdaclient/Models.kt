package com.shunya.lambdaclient

data class LambdaInput(
        val input: Long?
)

data class LambdaOutput(
        val result: Long? = null
)
