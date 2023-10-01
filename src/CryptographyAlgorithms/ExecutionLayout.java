package CryptographyAlgorithms;


//Interface Class
interface ExecutionLayout{

    void askUser();
    void newKey();
    void getKey();
    void encrypt();
    void decrypt();
    default void quit(){
        System.out.println("Thank You for choosing this algo!!");
        System.out.println("\n\t\t\t\t-X-\n\n");
    }
}