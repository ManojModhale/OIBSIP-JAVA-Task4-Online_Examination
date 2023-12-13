package com.exam.bean;

public class User 
{
	private int rollno;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
	public User() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int rollno, String username, String password, String firstname, String lastname) {
		super();
		this.rollno = rollno;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public User(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [rollno=" + rollno + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + "]";
	}	
}
