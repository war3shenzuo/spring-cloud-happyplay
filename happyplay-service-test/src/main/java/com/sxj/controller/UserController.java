package com.sxj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	/**
	 * 作用：
	 * ① 测试服务实例的相关内容
	 * ② 为后来的服务做提供
	 * @author eacdy
	 */
	  @Autowired
	  private DiscoveryClient discoveryClient;

	  /**
	   * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
	   * @RequestMapping(value = "/id", method = RequestMethod.GET)
	   * 类似的注解还有@PostMapping等等
	   * @param id
	   * @return user信息
	   */
	  @GetMapping("/{name}")
	  public String holle(@PathVariable String name) {
		  
	    return name + "你好";
	  }
	  
	  @GetMapping()
	  public String haha() {
	    return  "哈哈哈";
	  }

	  /**
	   * 本地服务实例的信息
	   * @return
	   */
	  @GetMapping("/instance-info")
	  public ServiceInstance showInfo() {
	    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
			return localServiceInstance;
	  }
}
