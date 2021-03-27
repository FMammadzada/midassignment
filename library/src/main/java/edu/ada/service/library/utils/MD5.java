package edu.ada.service.library.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5 {
    public static String hashing(String input)
    {
        try {


            MessageDigest messageDigest1 = MessageDigest.getInstance("MD5");



            byte[] md = messageDigest1.digest(input.getBytes());


            BigInteger no = new BigInteger(1, md);


            String hash = no.toString(16);
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
            return hash;
        }


        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
