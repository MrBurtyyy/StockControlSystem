/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.orm;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex
 */
@Entity
@Table(catalog = "ecommerce", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findById", query = "SELECT a FROM Admin a WHERE a.id = :id"),
    @NamedQuery(name = "Admin.findByUsername", query = "SELECT a FROM Admin a WHERE a.username = :username"),
    @NamedQuery(name = "Admin.findByHashValue", query = "SELECT a FROM Admin a WHERE a.hashValue = :hashValue"),
    @NamedQuery(name = "Admin.findBySalt", query = "SELECT a FROM Admin a WHERE a.salt = :salt"),
    @NamedQuery(name = "Admin.findByIterations", query = "SELECT a FROM Admin a WHERE a.iterations = :iterations")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false)
    private int id;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String username;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String hashValue;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String salt;
    @Basic(optional = false)
    @Column(nullable = false)
    private int iterations;

    public Admin() {
    }

    public Admin(String username) {
        this.username = username;
    }

    public Admin(String username, int id, String hashValue, String salt, int iterations) {
        this.username = username;
        this.id = id;
        this.hashValue = hashValue;
        this.salt = salt;
        this.iterations = iterations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mrburtyyy.stockcontrol.orm.Admin[ username=" + username + " ]";
    }
    
}
