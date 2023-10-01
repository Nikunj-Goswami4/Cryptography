package CryptographyAlgorithms;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;
import java.util.Scanner;

public class AES {

    String text;
    private SecretKey key;
    private final int KEY_SIZE = 128;
    private final int DATA_LENGTH = 128;
    private Cipher encryptionCipher;

    Scanner sc = new Scanner(System.in);


    AES(){
        System.out.println("\n\n*********** WELCOME TO ADVANCED ALGORITHM SECURITY ***********\n");

        System.out.print("Enter Text : ");
        text = sc.nextLine();

        try {
            init();

            String encryptedData = encrypt(text);
            String decryptedData = decrypt(encryptedData);

            displayEncryptedDecryptedText(text, encryptedData, decryptedData);
        }
        catch (Exception ignored) {
        }

    }

    public void init() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(KEY_SIZE);
        key = keyGenerator.generateKey();
    }

    public String encrypt(String data) throws Exception {
        byte[] dataInBytes = data.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(dataInBytes);
        return encode(encryptedBytes);
    }


    public String decrypt(String encryptedData) throws Exception {
        byte[] dataInBytes = decode(encryptedData);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(DATA_LENGTH, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(dataInBytes);
        return new String(decryptedBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }


    public void displayEncryptedDecryptedText(String text, String encryptedData, String decryptedData){
        System.out.println("\nOriginal Text : " + text);
        System.out.println("Encrypted Text : " + encryptedData);
        System.out.println("Decrypted Text : " + decryptedData);


        System.out.println("\nThank You for choosing this algo!!");
        System.out.println("\n\t\t\t\t-X-\n\n");
    }

}

