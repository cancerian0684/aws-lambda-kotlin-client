package com.shunya.lambdaclient

import com.amazonaws.services.lambda.invoke.LambdaFunction

interface MathService {

    @LambdaFunction(functionName = "number-reversal-java")
    fun reverse(input: LambdaInput): LambdaOutput
}
