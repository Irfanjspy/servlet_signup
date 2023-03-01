package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class whatsapp_User {

	String name;
	@Id
	long number;
	String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
