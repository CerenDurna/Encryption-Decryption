//The Caesar Cipher is a type of shift cipher
//Shift Ciphers work by using the modulo operator to encrypt and decrypt messages
//We have 2 methods in this class
// With methods encryptTheFile and decryptTheFile we shift letters as much as user wants
package com.company;

public class Cipher {
    //method that encrypts the file
    public static String encryptTheFile(String text, int shift) {
        //The Shift Cipher has a key which is an integer from 0 to 25.
        // Since we only have 26 choices for the key
        // 'a'=0, 'b'=1, 'c'=2, ... , 'z'=25
        //  Y = (X + K) (mod 26)
        // where x is the character we are encrypting where k is the key (the shift) applied to each letter
        shift %= 26;
        if (shift == 0) return text;

        //create a StringBuilder object, use append method
        StringBuilder sb = new StringBuilder(text.length());

        //shift every letter by the input value(shift)
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c += shift;
                if (c > 'Z') c -= 26;
            } else if (c >= 'a' && c <= 'z') {
                c += shift;
                if (c > 'z') c -= 26;
            }
            //append a char value
            sb.append((char) c);
        }
        //turn it to the string
        return sb.toString();
    }

    //method that decrypts the file
    public static String decryptTheFile(String text, int shift){
        //The Shift Cipher has a key which is an integer from 0 to 25.
        // Since we only have 26 choices for the key
        //where x is the character we are encrypting where k is the key (the shift) applied to each letter.
        // After applying this function the result is a number which must then be translated back into a letter.
        //Y = (X - K) (mod 26)
        shift %= 26;
        if (shift == 0) return text;

        //create a StringBuilder object, use append method
        StringBuilder sb = new StringBuilder(text.length());

        //shift every letter by the input value(shift)
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c -= shift;
                if (c > 'Z') c += 26;
            } else if (c >= 'a' && c <= 'z') {
                c -= shift;
                if (c > 'z') c += 26;
            }
            //append a char value
            sb.append((char) c);
        }
        //turn it to the string
        return sb.toString();
    }
}