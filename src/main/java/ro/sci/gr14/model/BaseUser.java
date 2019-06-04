package ro.sci.gr14.model;

import javax.persistence.*;

@Entity
@Table(name="base_user")
public class BaseUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String city;
    private String county;
    private String role;

    public BaseUser(){
    }

    public BaseUser(Long id, String userName, String password, String email, String fullName, String phoneNumber, String city, String county, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.county = county;
        this.role=role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "BaseUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}