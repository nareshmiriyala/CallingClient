package au.com.redenergy.CallingClient

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
class CallingClientApplication {

	static void main(String[] args) {
		SpringApplication.run CallingClientApplication, args
	}
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate()
	}
}

