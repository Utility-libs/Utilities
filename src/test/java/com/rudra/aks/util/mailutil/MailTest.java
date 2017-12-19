package com.rudra.aks.util.mailutil;

import org.junit.Test;

import com.rudra.aks.util.bo.MailAttachBO;
import com.rudra.aks.util.bo.SimpleMailBO;

public class MailTest {

	
	@Test
	public void sendMailTest() {
		
		SimpleMailBO mailBO = new SimpleMailBO();
		mailBO.setFrom("test@mailutil.com");
		mailBO.setFromName("Test : admin");
		mailBO.setTo("awf-averman@zetaglobal.com");
		mailBO.setSubject("Test Mail");;
		mailBO.setContent("Hello JARVIS");
		
		MailUtil util = new MailUtil();
		util.sendMail(mailBO);
	}
	
	@Test
	public void sendMailWithAttachTest() {
		
		MailAttachBO mailBO = new MailAttachBO();
		mailBO.setFrom("test@mailutil.com");
		mailBO.setFromName("Test : admin");
		mailBO.setTo("awf-averman@zetaglobal.com");
		mailBO.setSubject("Test Mail");;
		mailBO.setFileName("./src/main/resources/test1.txt");
		
		MailUtil util = new MailUtil();
		util.sendMailWithAttachement(mailBO);
	}
}
