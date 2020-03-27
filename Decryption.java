package substitution.cipher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Decryption 
{
    private ArrayList<Character> characters= new ArrayList<>();
    private ArrayList<Character> keySpace= new ArrayList<>();
    String plainText = "";
    
    public void __fileRead__() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ///Read the two arrays from the file
        FileInputStream file = new FileInputStream(new File("Text.txt"));
        ObjectInputStream out = new ObjectInputStream(file);
        characters = (ArrayList<Character>)out.readObject();
        keySpace = (ArrayList<Character>)out.readObject();
        out.close();
        file.close();
    }
    
    public void __decrypt__(String cipheredText)
    {
        ///Loop on the cipheredText
        for(int i=0; i<cipheredText.length(); i++)
        {
            char ch = cipheredText.charAt(i);       ///Get char by char
            int index = keySpace.indexOf(ch);       ///Get the index of this char from keySpace array
            plainText += characters.get(index);     ///Get the char of this index from characters and add it to plainText
        }
        
        ///Print the Decrypted text
        System.out.println("\nThe Decryption Of The Ciphered Text:");
        System.out.println(plainText);
    }
}
