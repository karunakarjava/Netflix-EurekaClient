package com.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/eureka")
public class BasicController {
	
	@Autowired
	private RestTemplateBuilder rtb;
	
	@Autowired
	private EurekaClient client;
	
	@Value("${endpoint.url}")
	private String urll;
	
	@Autowired
	private RestTemplate template;
	
	@RequestMapping("/client")
	public String foo() {
		
		
		String url="http://eurekaservice/eurekaservice/service";
		return template.getForObject(url,String.class);
		/*RestTemplate rt=rtb.build();
		
		InstanceInfo info=client.getNextServerFromEureka("eurekaserver",false);
		String url=info.getHomePageUrl();
		ResponseEntity<String> rsp=rt.exchange(url,HttpMethod.GET,null,String.class);
		
		return rsp.getBody();
		*/
	}
	@RequestMapping("/client2")
	public String foo2() {
		
		String url="http://kafkaproducer/emp/emps";
		String empdata= template.getForObject(url,String.class);
		return empdata;
	}
	
	@RequestMapping("/config")
	public String foo3() {
		String empdata= template.getForObject(urll,String.class);
		return empdata;
	}
	
	
}
