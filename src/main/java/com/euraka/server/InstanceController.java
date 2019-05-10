package com.euraka.server;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstanceController {

	@Autowired
	private EurekaClient eurekaClient;
	@Value("${spring.application.name}")
	private String applicationName;

	@GetMapping("eureka-instance")
	public String serverUrl() {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(applicationName.toUpperCase(), false);
		return instanceInfo.getHomePageUrl();
	}


}
