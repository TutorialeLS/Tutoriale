package pl.javastart.model;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_details")
    private Long id;
    @Column(name = "firstname",nullable = true)
    private String firstName;
    @Column(name = "lastname",nullable = true)
    private String lastName;
    @Column(name = "adress",nullable = true)
    private String address;
    @OneToOne(mappedBy = "details")
    private User user;
    
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserDetails() {}
    public UserDetails(String firstName, String lastName, String address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "UserDetails [id=" + id + ", firstName=" + firstName + ", "
                + "lastName=" + lastName + ", address=" + address + "]";
    }
}