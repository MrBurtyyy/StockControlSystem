package com.mrburtyyy.stockcontrol.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Alex
 */
public class LoginAuthController implements ILoginAuthController {

    @Override
    public boolean CheckUsername(String username) {
        return "MrBurtyyy".equals(username);
    }

    @Override
    public boolean CheckPassword(String hash, String salt, String passwordToCheck, int iterations) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA1" );
            PBEKeySpec spec = new PBEKeySpec( passwordToCheck.toCharArray(), salt.getBytes(), iterations, 256 );
            SecretKey key = skf.generateSecret( spec );
            byte[] res = key.getEncoded();
            
            System.out.println(res.toString());
            
            return hash.getBytes() == res;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginAuthController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginAuthController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean VerifyLogin(String usernameToCheck, char[] passwordToCheck) {
        PreparedStatement getAdmins = null;
        String selectStatement = "SELECT Username, HashValue, Salt, Iterations FROM Admin WHERE Username = ?";
        String HashValue = null, Salt = null;
        int Iterations = 0;
        
        try {
            Connection conn = DBConnection.GetInstance().GetConnection();
            getAdmins = conn.prepareStatement(selectStatement);
            getAdmins.setString(1, usernameToCheck);
            
            // Execute select SQL statement
            ResultSet rs = getAdmins.executeQuery();
            
            while (rs.next()) {
                String username = rs.getString("Username");
                if (username.equals(usernameToCheck)) {
                    HashValue = rs.getString("HashValue");
                    Salt = rs.getString("Salt");
                    Iterations = rs.getInt("Iterations");
                    System.out.println(HashValue);
                    System.out.println(Salt);
                    System.out.println(Iterations);
                    break;
                }
            }
        
            return CheckPassword(HashValue, Salt, Arrays.toString(passwordToCheck), Iterations);            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginAuthController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
}