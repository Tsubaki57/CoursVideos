/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Sha {
    public static String hash256(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            return bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SHA-256 ? Connait pas.");
        }
        return "";
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}