import java.util.Scanner;

public class Cryptography {
    public static void main(String[] args){

        // Beginner (Novice) ....Security (key : only adding character)
        // Intermediate ....Security (key : adding character in array + randomizing that characters in that array)
        // Advanced ....Security (AES)

        //to make access modifiers PRIVATE from public as it's a program for security

        System.out.println("---------------------------------");
        System.out.println("\t\t CRPYPTOGRAPHY");
        System.out.println("---------------------------------\n\n");

        ChooseSecurityLevel CSL = new ChooseSecurityLevel();

    }
}

class ChooseSecurityLevel{
    Scanner sc = new Scanner(System.in);

    //Constructor
    public ChooseSecurityLevel(){
        System.out.print("1. Novice\n2. Intermediate\n3. Advanced");
        System.out.print("\nChoose Security Level : ");
        int level = sc.nextInt();

        if (level==1){
            CustomAlgo1 customAlgo1 = new CustomAlgo1();
        }
        else if (level==2) {
            CustomAlgo2 customAlgo2 = new CustomAlgo2();
        }
        else if (level==3) {
            AES aes = new AES();
        }
        else {
            System.out.println("Please enter valid Security Level!!!");
        }

    }
}

//Interface Class
interface ExecutionLayout{

    public void askUser();
    public void newKey();
    public void getKey();
    public void encrypt();
    public void decrypt();
}

class CustomAlgo1{

}

class CustomAlgo2{

}

class AES{

}