package substitution.cipher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SubstitutionCipher 
{
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException 
    {
        Encryption enc = new Encryption();      ///Object of Encryption
        enc.__initialize__();                   ///To initialize alphapete characters capital and small
        enc.__getKey__();                       ///To Get the key of Encryption
        
        ///Take the plain text as input
        Scanner input = new Scanner(System.in);
        System.out.println("_____________________________________________________");
        System.out.println("\nPlease Enter A Plain Text:");
        String plainText = input.nextLine();
        
        enc.__encrypt__(plainText);             ///To make the Encryption to the plain text
        enc.__fileWrite__();                    ///To save the alphapete characters and keySpace in File
        
        ///Take the ciphered text as input
        System.out.println("_____________________________________________________");
        System.out.println("\nPlease Enter A Ciphered Text:");
        String cipheredText = input.nextLine();
        
        Decryption dec = new Decryption();      ///Object of Decryption
        dec.__fileRead__();                     ///Take the data from the file
        dec.__decrypt__(cipheredText);          ///To make the Decryption to the ciphered text
    }
    
}
