/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.orm;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alex
 */
@Entity
@Table(catalog = "ecommerce", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerID", query = "SELECT c FROM Customer c WHERE c.customerID = :customerID"),
    @NamedQuery(name = "Customer.findByTitle", query = "SELECT c FROM Customer c WHERE c.title = :title"),
    @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customer.findByAddressOne", query = "SELECT c FROM Customer c WHERE c.addressOne = :addressOne"),
    @NamedQuery(name = "Customer.findByAddressTwo", query = "SELECT c FROM Customer c WHERE c.addressTwo = :addressTwo"),
    @NamedQuery(name = "Customer.findByTown", query = "SELECT c FROM Customer c WHERE c.town = :town"),
    @NamedQuery(name = "Customer.findByCounty", query = "SELECT c FROM Customer c WHERE c.county = :county"),
    @NamedQuery(name = "Customer.findByPostcode", query = "SELECT c FROM Customer c WHERE c.postcode = :postcode"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByPhoneNo", query = "SELECT c FROM Customer c WHERE c.phoneNo = :phoneNo")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer customerID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String title;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String firstName;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String lastName;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String addressOne;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String addressTwo;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String town;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String county;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String postcode;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String email;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String phoneNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID", fetch = FetchType.LAZY)
    private List<CustomerOrder> customerOrderList;

    public Customer() {
    }

    public Customer(Integer customerID) {
        this.customerID = customerID;
    }

    public Customer(Integer customerID, String title, String firstName, String lastName, String addressOne, String addressTwo, String town, String county, String postcode, String email, String phoneNo) {
        this.customerID = customerID;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.town = town;
        this.county = county;
        this.postcode = postcode;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @XmlTransient
    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public void setCustomerOrderList(List<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mrburtyyy.stockcontrol.orm.Customer[ customerID=" + customerID + " ]";
    }
    
}
