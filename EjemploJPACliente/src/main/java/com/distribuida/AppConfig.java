package com.distribuida;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.distribuida.interfaces.Servicio;


@Configuration
@ComponentScan("com")
public class AppConfig {
	
	/*@Bean("servicio")
	public HttpInvokerProxyFactoryBean servicioOperaciones(){
		HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
		proxy.setServiceUrl("http://localhost:9090/servicioPersonas");
		proxy.setServiceInterface(Servicio.class);
		return proxy;
	}*/
	
	@Bean("servicio")
	public HessianProxyFactoryBean servicioPersonas(){
		HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
		proxy.setServiceUrl("http://localhost:9090/servicioPersonas");
		proxy.setServiceInterface(Servicio.class);
		return proxy;
	}
		
}
