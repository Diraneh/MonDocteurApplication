package org.poeiscrumproject.gp2.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "utilisateurs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    @NotEmpty
    private String firstname;

    @Column(name="lastname")
    @NotEmpty
    private String lastname;

    @Column(name="username")
    @NotEmpty
    private String username;

    @Column(name="email")
    @NotEmpty
    private String email;
    
    @Column(name="subscriber")
    private String subscriber;

    @Column(name="password")
    @NotEmpty
    private String password;

    @Column(name="securitycode")
    private String securityCode;

    public User(String firstname, String lastname, String username, String email, String subscriber, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.subscriber=subscriber;
        this.password = password;
        this.securityCode="";
    }

    public User() {
    }

    public int getId(){
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
