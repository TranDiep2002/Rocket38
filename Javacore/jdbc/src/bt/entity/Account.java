package bt.entity;

import java.io.Serializable;

public class Account implements Serializable{
	private int id;
	private String email;
	private String name;
	private String pass;
	private int deId;
	private int poId;
	private String date;
	public Account(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	public Account() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getDeId() {
		return deId;
	}
	public void setDeId(int deId) {
		this.deId = deId;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Account [email=" + email + ", name=" + name + "]";
	}
	
}
