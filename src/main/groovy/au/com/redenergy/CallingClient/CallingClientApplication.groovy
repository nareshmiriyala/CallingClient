package au.com.redenergy.CallingClient

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class CallingClientApplication {

	static void main(String[] args) {
		SpringApplication.run CallingClientApplication, args
	}

}

