/**
 * Copyright 2018 Red Energy Limited
 * User: miriyaln 
 * Date: 18/12/18 10:38 AM
 */
package au.com.redenergy.CallingClient.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController("/v1.0/ribbon")
class RibbonClient {
  @Autowired
  RestTemplate restTemplate
  @GetMapping
  String callRibbon(){
    ResponseEntity<String> entity = restTemplate.getForEntity("http://MICROSERVICELCIENT/greeting", String)
    return entity.body
  }
}
