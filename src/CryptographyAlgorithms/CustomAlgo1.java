package CryptographyAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CustomAlgo1 implements ExecutionLayout{

    Scanner sc = new Scanner(System.in);
    char choice;
    boolean flag=true;
    String text;
    int key;

    List<Character> originalTextChars = new ArrayList<>();
    List<Character> encryptedTextChars = new ArrayList<>();
    List<Character> decryptedTextChars = new ArrayList<>();

    CustomAlgo1(){

        System.out.println("\n\n*********** WELCOME TO NOVICE ALGORITHM SECURITY ***********\n");


        System.out.print("Enter Text : ");
        text = sc.nextLine();


        // Original text into arraylist

        // List<Character> originalTextChars = new ArrayList<>();
        for (char ch : text.toCharArray()) {
            originalTextChars.add(ch);
        }

        System.out.print("Original Text : ");
        for (char ch : originalTextChars) {
            System.out.print(ch);
        }
        System.out.println("\n");

        newKey();
        askUser();
    }


    @Override
    public void askUser() {

        while (flag){
            System.out.println("\n\nWhat do you want to do ?");
            System.out.println("N : NewKey, G : GetKey, E : Encrypt, D : Decrypt, Q : Quit");
            choice = Character.toUpperCase(sc.nextLine().charAt(0));

            switch (choice) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    flag=false;
                    break;
                default:
                    System.out.println("Not a valid choice!!");
            }
        }

    }

    @Override
    public void newKey() {

        System.out.print("Enter value for the key : ");
        key = sc.nextInt();
        /* Scanner.nextInt() method does not read the newline character in your input created by hitting "Enter" and skipping
        * the immediate use of scanner.nextLine() method. So, as to not happen this I have added a
        * Scanner.nextLine() method after the use of Scanner.nextInt(). */
        sc.nextLine();


        /* So, basically .clear() method is added to clear all elements presents in encryptedTextChars & decryptedTextChars ArrayList
        * so if we want to encrypt or decrypt the text with the newKey than no old characters present in that list will interfere
        * this new encrypted and decrypted text. */
        encryptedTextChars.clear();
        decryptedTextChars.clear();

        System.out.println("*New Key has been generated.*");

    }

    @Override
    public void getKey() {
        System.out.println("User inputted key value:-\nKey : " + key);
    }

    @Override
    public void encrypt() {

        // Original text + key = Encrypted Text and then converting into arraylist

        //List<Character> encryptedTextChars = new ArrayList<>();
        for (char x : text.toCharArray()) {
            encryptedTextChars.add((char) (x+key));
        }

        System.out.print("Encrypted Text : ");
        for (char x : encryptedTextChars) {
            System.out.print(x);
        }

    }

    @Override
    public void decrypt() {

        // Encrypted Text - key = Decrypted Text and then converting into arraylist

        // List<Character> decryptedTextChars = new ArrayList<>();
        for (char x : encryptedTextChars) {
            decryptedTextChars.add((char) (x-key));
        }

        System.out.print("Decrypted Text : ");
        for (char x : decryptedTextChars) {
            System.out.print(x);
        }

    }

}
