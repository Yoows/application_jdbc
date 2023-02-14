package model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private String login;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public void sePresenter() {
		System.out.println("Login: " + login );
		System.out.print("password: " );
		printStar(password.length());
		System.out.println();
		
	}
	
	private void printStar(int n){
	    if(n > 0){
	        System.out.print("*");
	        printStar(n-1);
	    }
	}

}
