package com.company.mail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  iterable mail list
 */
public class MailList implements Iterable<Mail> {

	private final List<Mail> mailList = new ArrayList<>();

	/**
	 * add mail to mail list
	 * @param mail mail to add
	 */
	public void add(Mail mail) {
		mailList.add(mail);
	}

	/**
	 * remove mail
	 * @param mail to removing
	 * @return is removing successful
	 */
	public boolean remove(Mail mail) {
		return mailList.remove(mail);
	}

	/**
	 * get mail from index
	 * @param index index of mail
	 * @return mail at index
	 */
	public Mail get(int index){
		return mailList.get(index);
	}


	/**
	 *
	 * @return iterator of mail list
	 */
	@Override
	public Iterator<Mail> iterator() {
		return mailList.iterator();
	}

}
