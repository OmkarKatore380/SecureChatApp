package com.example.SecureChatApp.util;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.X509EncodedKeySpec; // Added this import
import java.util.Base64;

public class RSAUtil {
    public static String encrypt(String plainText, String publicKeyStr) throws Exception {
        byte[] publicBytes = Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
    }
}