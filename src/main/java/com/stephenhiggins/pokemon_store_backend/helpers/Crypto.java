package com.stephenhiggins.pokemon_store_backend.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Crypto {
  public Crypto() {}

  public static String hash(String data, byte[] salt) throws NoSuchAlgorithmException {
    String sha256 = "SHA-256";
    //    System.out.println("SALT: " + salt);
    //        String md5 = "MD5";
    //        byte[] md5Salt = generateSalt();
    String sha256Hash = generateHash(data, sha256, salt);
    //        String md5Hash = generateHash(data, md5, md5Salt);
    //    System.out.println(sha256Hash);
    //        System.out.println(md5Hash);
    return sha256Hash;
  }

  public static byte[] generateSalt() {
    byte[] bytes = new byte[20];
    SecureRandom random = new SecureRandom();
    random.nextBytes(bytes);
    return bytes;
  }

  private static String generateHash(String data, String algorithm, byte[] salt)
      throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance(algorithm);
    md.reset();
    md.update(salt);
    byte[] hash = md.digest(data.getBytes());
    return bytesToStringHex(hash);
  }

  private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

  public static String bytesToStringHex(byte[] bytes) {
    char[] chars = new char[bytes.length * 2];
    for (int i = 0; i < bytes.length; i++) {
      int v = bytes[i] & 0xFF;
      chars[i * 2] = hexArray[v >>> 4];
      chars[i * 2 + 1] = hexArray[v & 0x0f];
    }
    return new String(chars);
  }
}
