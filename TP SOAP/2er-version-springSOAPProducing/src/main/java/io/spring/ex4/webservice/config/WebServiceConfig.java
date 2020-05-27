package io.spring.ex4.webservice.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "hotel")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema hotelsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("HotelPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/ex4/webservice");
		wsdl11Definition.setSchema(hotelsSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema hotelsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("webservice.xsd"));
	}
	
	@Bean(name = "reservation")
	public DefaultWsdl11Definition defaultWsdl11DefinitionReservation(XsdSchema hotelsSchemaReservation) {
		DefaultWsdl11Definition wsdl11Definition1 = new DefaultWsdl11Definition();
		wsdl11Definition1.setPortTypeName("ReservationPort");
		wsdl11Definition1.setLocationUri("/ws");
		wsdl11Definition1.setTargetNamespace("http://spring.io/ex4/webservice");
		wsdl11Definition1.setSchema(hotelsSchemaReservation);
		return wsdl11Definition1;
	}

	@Bean
	public XsdSchema hotelsSchemaReservation() {
		return new SimpleXsdSchema(new ClassPathResource("webservice.xsd"));
	}
	
	 
	
	
}