package com.piyush.demo.model;

/**
 * Created by : Piyush Kumar
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "UserProfile", schema = "", catalog = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String address;
    private String contactNo;
    private String email;
    private Date dob;

    public User() {
    }

    public User(String name, String address, String contactNo, String email, Date dob) {
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.dob = dob;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId",nullable = false, insertable = false,updatable = false)
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "userName", nullable = false, insertable = true, updatable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "userAddress", nullable = false, insertable = true, updatable = true)
    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "userContactNo", nullable = true, insertable = true, updatable = true)
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Basic
    @Column(name = "userEmailId", nullable = false, insertable = true, updatable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "userDOB", nullable = false, insertable = true, updatable = true)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}


