package com.vicky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "",key = "";
        try {
            System.out.println("Enter the word:");
            str = br.readLine();
            System.out.println("Enter the Key word:");
            key = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //encrypt(str, key);
            decrypt(str, key);
        }
    }

    private static void encrypt(String toEncrypt, String key) {
        if (toEncrypt.length() == key.length()) {
            toEncrypt = toEncrypt.toUpperCase();
            key = key.toUpperCase();

            String encryptedWord = "";

            for (int i = 0; i < toEncrypt.length(); i++) {
                int a = (toEncrypt.charAt(i) + key.charAt(i)) % 26;
                a += 'A';
                encryptedWord += (char) a;
            }

            System.out.println("Encrypted Word - \t" + encryptedWord);
        } else {
            System.out.println("Length of Key and Word doesn't Match");
        }
    }

    private static void decrypt(String encryptedWord, String key)
    {
        encryptedWord = encryptedWord.toUpperCase();
        key = key.toUpperCase();

        String originalStr = "";

        for (int i = 0; i < encryptedWord.length(); i++)
        {
            int a = (encryptedWord.charAt(i) - key.charAt(i) + 26) % 26;
            a += 'A';
            originalStr += (char)a;
        }

        System.out.println("Decrypted Word - \t" + originalStr);
    }
}
