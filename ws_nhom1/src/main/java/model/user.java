package model;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class user{
	private String username, password, role, answer;

	public user(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	
	public user(String username, String password, String answer) {
		this.username = username;
		this.password = password;
		this.answer = answer;
	}



	public user(String username, String password, String role, String answer) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.answer = answer;
	}

	public user() {
		this.username = "";
		this.password = "";
		this.role = "hv";
		this.answer = "";
	}
	
	@Id
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + ", role=" + role + ", answer=" + answer + "]";
	}
	
}
