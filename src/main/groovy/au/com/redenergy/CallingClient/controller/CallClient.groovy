/**
 * Copyright 2018 Red Energy Limited
 * User: miriyaln 
 * Date: 17/12/18 11:49 AM
 */
package au.com.redenergy.CallingClient.controller

import groovy.util.logging.Slf4j

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.ServiceInstance
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/v1.0/call")
@Slf4j
class CallClient {
  @Autowired
  DiscoveryClient discoveryClient

  @GetMapping
  String callClient() {
    RestTemplate restTemplate = new RestTemplate()
    List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICELCIENT")

    log.info("Application name ${instances.first().instanceId}")
    log.info("Application name ${instances.first().getUri().toString()}")
    log.info("Application name ${instances.first().getUri().toString()}/greeting")
    String url="${instances.first().getUri().toString()}/greeting"
    ResponseEntity<String> entity = restTemplate.getForEntity(url, String)
    log.info(entity.body)

    return entity.body
  }
}
