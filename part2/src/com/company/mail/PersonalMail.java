package com.company.mail;


/**
 * personal mail which implements mail interface
 */
public class PersonalMail implements Mail {
	private String personalMail;
	private String name;

	/**
	 * @param personalMail is  mail of the person
	 * @param name is name of the person
	 */
	public PersonalMail(String personalMail, String name) {
		this.personalMail = personalMail;
		this.name = name;
	}

	/**
	 * @return  personal mail
	 */
	public String getPersonalMail() {
		return personalMail;
	}

	/**
	 * @param personalMail  set personal mail 
	 */
	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	/**
	 * @param name set name
	 */
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PersonalMail that = (PersonalMail) o;

		return personalMail.equals(that.personalMail);
	}

	@Override
	public int hashCode() {
		return personalMail.hashCode();
	}

	@Override
	public String getMail() {
		return personalMail;
	}

	public String getName() {
		return name;
	}

	/**
	 * @return mail and name in string format
	 */
	@Override
	public String toString() {
		return "{mail=" + personalMail + ", name=" + name + '}';
	}
}
