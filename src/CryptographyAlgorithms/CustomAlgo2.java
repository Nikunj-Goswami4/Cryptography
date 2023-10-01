package CryptographyAlgorithms;

import java.util.*;

class CustomAlgo2 implements ExecutionLayout{

    Scanner sc = new Scanner(System.in);

    char choice;
    boolean flag=true;
    String text;
    ArrayList<Character> list = new ArrayList<>();
    ArrayList<Character> shuffledList= new ArrayList<>();
    char character=' ';
    char[] originalTextChars;


    CustomAlgo2(){

        System.out.println("\n\n*********** WELCOME TO INTERMEDIATE ALGORITHM SECURITY ***********\n");

        System.out.print("Enter Text : ");
        text = sc.nextLine();

        originalTextChars = text.toCharArray();

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

        character = ' ';
        list.clear();
        shuffledList.clear();

        for(int i=32; i<127; i++){
            list.add(Character.valueOf(character));
//            list.add(character);
            character++;
        }

        shuffledList = new ArrayList<>(list);  //providing list in parentheses we make a copy of list with the name of shuffledList. This is how u make a copy in ArrayList.
        Collections.shuffle(shuffledList);

        System.out.println("*New Key has been generated.*");

    }

    @Override
    public void getKey() {

        System.out.println("--KEY--");
        System.out.println("Characters in Key :");
        for(char x : list){
            System.out.print(x);
        }

        System.out.println("\nAssociated character :");
        for(char x : shuffledList){
            System.out.print(x);
        }
        System.out.println("\n-------");

    }

    @Override
    public void encrypt() {

        for(int i=0; i<originalTextChars.length; i++){

            for (int j=0; j<list.size(); j++){
                if (originalTextChars[i] == list.get(j)) {
                    originalTextChars[i] = shuffledList.get(j);
                    break;
                }
            }
        }

        System.out.print("Encrypted Text : ");
        for (char x : originalTextChars){
            System.out.print(x);
        }
        System.out.println();

    }

    @Override
    public void decrypt() {

        for(int i=0; i<originalTextChars.length; i++){

            for (int j=0; j<shuffledList.size(); j++){
                if (originalTextChars[i] == shuffledList.get(j)) {
                    originalTextChars[i] = list.get(j);
                    break;
                }
            }
        }

        System.out.print("Decrypted Text : ");
        for (char x : originalTextChars){
            System.out.print(x);
        }
        System.out.println();

    }

}
