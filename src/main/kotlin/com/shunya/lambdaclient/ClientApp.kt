package com.shunya.lambdaclient

import com.amazonaws.services.lambda.AWSLambdaClientBuilder
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class ClientApp

fun main(args: Array<String>) {
	runApplication<ClientApp>(*args)
}

@Component
class LambdaClient : ApplicationRunner {
	override fun run(args: ApplicationArguments?) {
		val uppercaseService = LambdaInvokerFactory.builder()
				.lambdaClient(AWSLambdaClientBuilder.defaultClient())
				.build(MathService::class.java)

		val request = LambdaInput(12345)
		println("Invoking aws lambda")
		val response = uppercaseService.reverse(request)
		println("Lambda Response = ${response.result}")
	}

}
