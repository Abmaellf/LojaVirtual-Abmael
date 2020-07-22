package com.lojavirtualabmael.service;

import com.lojavirtualabmael.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;


public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);

}
