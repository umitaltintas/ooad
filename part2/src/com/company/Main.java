package com.company;

import com.company.mail.Mail;
import com.company.mail.MailGroup;
import com.company.mail.MailList;
import com.company.mail.PersonalMail;

public class Main {

	public static void main(String[] args) {

		var mail1 = new PersonalMail("mail1@m.com", "m1");
		var mail2 = new PersonalMail("mail2@m.com", "m2");
		var mail3 = new PersonalMail("mail3@m.com", "m3");
		var mail4 = new PersonalMail("mail4@m.com", "m4");
		var mail5 = new PersonalMail("mail5@m.com", "m5");
		var mail6 = new PersonalMail("mail6@m.com", "m6");
		var mail7 = new PersonalMail("mail7@m.com", "m7");

		var group1 = new MailGroup("g1@g.com");
		group1.add(mail1);
		group1.add(mail2);
		group1.add(mail3);

		var group2 = new MailGroup("g2@g.com");
		group2.add(mail4);
		group2.add(mail5);
		group2.add(mail6);
		var mailList = new MailList();
		mailList.add(group1);
		mailList.add(group2);
		mailList.add(mail7);

		for(Mail mail : mailList){
			System.out.println(mail);
		}

	}
}
