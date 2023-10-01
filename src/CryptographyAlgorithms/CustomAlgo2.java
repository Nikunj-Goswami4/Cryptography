package CryptographyAlgorithms;

import java.util.Scanner;

class CustomAlgo2 implements ExecutionLayout{

    Scanner sc = new Scanner(System.in);
    char choice;
    boolean flag=true;
    String text;

    @Override
    public void askUser() {

        System.out.println("\n\n*********** WELCOME TO INTERMEDIATE ALGORITHM SECURITY ***********\n");


        System.out.print("Enter Text : ");
        text = sc.nextLine();


        while (flag) {
            System.out.println("\nWhat do you want to do ?");
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

    }

    @Override
    public void getKey() {

    }

    @Override
    public void encrypt() {

    }

    @Override
    public void decrypt() {

    }

}
