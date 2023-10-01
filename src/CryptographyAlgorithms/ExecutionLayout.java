package CryptographyAlgorithms;

import java.util.Scanner;

//Interface Class
interface ExecutionLayout{

    public void askUser();
    public void newKey();
    public void getKey();
    public void encrypt();
    public void decrypt();
    default void quit(){
        System.out.println("Thank You for choosing this algo!!");
        System.out.println("\n\t\t\t\t-X-\n\n");
    }
}