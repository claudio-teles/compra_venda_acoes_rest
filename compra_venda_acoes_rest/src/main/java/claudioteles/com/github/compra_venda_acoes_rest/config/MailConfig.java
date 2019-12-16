package claudioteles.com.github.compra_venda_acoes_rest.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
	public JavaMailSender enviarEmail() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		
		mailSenderImpl.setHost("smtps.bol.com.br");
		mailSenderImpl.setPort(587);
		mailSenderImpl.setUsername("claudio-theles");
		mailSenderImpl.setPassword("");
		
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.connectiontimout", 10000);
		
		mailSenderImpl.setJavaMailProperties(properties);
		
		return mailSenderImpl;
	}

}
