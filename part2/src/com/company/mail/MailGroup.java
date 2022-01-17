package com.company.mail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * mail group which has own mail and children mails
 */
public class MailGroup implements Mail, Iterable<Mail> {
	private String groupMail;
	private final List<Mail> mailList = new ArrayList<>();


	public MailGroup(String groupMail) {
		this.groupMail = groupMail;
	}

	/**
	 * add mail to mail group
	 *
	 * @param mail to add
	 */
	public void add(Mail mail) {
		mailList.add(mail);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MailGroup mail = (MailGroup) o;

		return groupMail.equals(mail.groupMail);
	}

	@Override
	public int hashCode() {
		return groupMail.hashCode();
	}

	/**
	 * remove mail from mail group
	 *
	 * @param mail to remove
	 * @return is removing successful
	 */
	public boolean remove(Mail mail) {
		return mailList.remove(mail);
	}


	public Mail remove(int index) {
		return mailList.remove(index);
	}

	/**
	 * get mail from index
	 *
	 * @param index of mail
	 * @return mail at index
	 */
	public Mail get(int index) {
		return mailList.get(index);
	}

	/**
	 * @return iterator of mail list
	 */
	@Override
	public Iterator<Mail> iterator() {
		return mailList.iterator();
	}

	/**
	 * mail of mail group
	 *
	 * @return mail of mail group
	 */
	@Override
	public String getMail() {
		return groupMail;
	}

	@Override
	public String toString() {
		return
				"\n------------\n" + "Mail=" + groupMail + "\nmails:" + mailList + "\n-----------------";
	}
}
