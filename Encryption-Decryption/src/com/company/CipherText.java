//We created an project with an easy encryption approach which called Caesar cipher.
// With user entered input values the program decides what operation is going to be held (encryption or decryption),
// in which text file, how much numbers of letters is going to be shifted.
//Ceren Durna 20191701059

package com.company;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CipherText {

    public static void main(String[] args)
        //handles the IO exception
        throws IOException
    {   // output the greeting message and ask for whether the user wants to decrypt or encrypt the file
        System.out.println("Greetings, what would you like to do?");
        System.out.println("1 - Encrypt the file");
        System.out.println("2 - Decrypt the file");

        //takes the input from the user
        Scanner key = new Scanner(System.in);
        //this input is going to decide whether the user wants to decrypt or encrypt the file
        int choose = key.nextInt();

        System.out.println("Please provide a file name.");
        //this input is going to take the file name
        String name = key.next();

        System.out.println("What will be your key?");
        //this input is going to shift ...letters for each character
        int shift = key.nextInt();

        //reads from a text file where String name is the name of the text file we want to read
        try (Scanner input = new Scanner(new File(name))) {
            //processing loop
            while (input.hasNextLine()) {
               // creation a PrintStream object for writing
                PrintStream output = new PrintStream(new File(name));

                //if the input is 1 output will be encrypted in the same file
                if (choose == 1) {
                    //call the class, call the method put the instant variables
                    // write to a file
                    output.println(Cipher.encryptTheFile(input.nextLine(), shift));
                    //message to the user that operation is done
                    System.out.println("Done! File "+ name + " encrypted and saved.");
                }
                //if the input is 2 output will be decrypted in the same file
                else if (choose == 2) {
                    //call the class, call the method put the instant variables
                    // write to a file
                    output.println(Cipher.decryptTheFile(input.nextLine(), shift));
                    //message to the user that operation is done
                    System.out.println("Done! File "+ name + " decrypted and saved.");
                }
            }
        }
    }
}