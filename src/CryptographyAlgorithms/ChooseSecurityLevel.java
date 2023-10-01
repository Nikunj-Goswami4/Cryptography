package CryptographyAlgorithms;

import java.util.Scanner;

class ChooseSecurityLevel{
    Scanner sc = new Scanner(System.in);
    char choice;


    //Constructor
    public ChooseSecurityLevel(){
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("1. Novice\n2. Intermediate\n3. Advanced");
            System.out.print("\nChoose Security Level : ");
            int level = sc.nextInt();


            /* Scanner.nextInt() method does not read the newline character in your input created by hitting "Enter" and skipping
            the immediate use of scanner.nextLine() method. So, as to not happen this I have added a
            Scanner.nextLine() method after the use of Scanner.nextInt(). */
            sc.nextLine();


            if (level == 1) {
                CustomAlgo1 customAlgo1 = new CustomAlgo1();
                customAlgo1.askUser();
            }
            else if (level == 2) {
                CustomAlgo2 customAlgo2 = new CustomAlgo2();
                customAlgo2.askUser();
            }
            else if (level == 3) {
                AES aes = new AES();
            }
            else {
                System.out.println("Please enter valid Security Level!!!");
            }

            System.out.println("-----");
            System.out.println("Do you want to select any other Security Level or else you want to exit ?");
            choice = Character.toUpperCase(sc.next().charAt(0));
            System.out.println("-----");
            System.out.println("\n");
        }while (choice == 'Y');

    }
}
