package substitution.cipher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Encryption 
{
    private ArrayList<Character> characters= new ArrayList<>();     
    private ArrayList<Character> tmp= new ArrayList<>();       ///Templete from characters will removed after take all char s
    private ArrayList<Character> keySpace= new ArrayList<>();
    private String cipheredText = "";
    
    public void __initialize__()
    {
        ///We know work on characters and tmp
        ///Initialize the capital characters from [A,Z]
        for(int i=65; i<91; i++)
        {
            characters.add((char)i);
            tmp.add((char)i);
        }
        
        ///Add the space to the array lists
        characters.add(' ');
        tmp.add(' ');
        
        ///Initialize the small characters from [a,z]
        for(int i=97; i<123; i++)
        {
            characters.add((char)i);
            tmp.add((char)i);
        }
    }
    
    public void __getKey__()
    {
        ///We know work to get the keySpace
        ///Loop on characters array [A,B,C,.......,x,y,z]
        for(int i=0; i<characters.size(); i++)
        {
            Random rand = new Random();             ///Intialize random 
            int index = rand.nextInt(tmp.size());   ///Get rand number from [0,tmp_size - 1]
            keySpace.add(tmp.get(index));           ///Get the character of this index from tmp and add it to ketSpace
            tmp.remove(index);                      ///Remove this character
        }
        
        ///Print the characters and keySpace arrays
        System.out.println(Arrays.toString(characters.toArray()));
        System.out.println(Arrays.toString(keySpace.toArray()));
    }
    
    public void __encrypt__(String plainText)
    {
        ///Loop on the plainText
        for(int i=0; i<plainText.length(); i++)
        {
            char ch = plainText.charAt(i);          ///Get char by char
            int index = characters.indexOf(ch);     ///Get the index of this char from characters array
            cipheredText += keySpace.get(index);    ///Get the char of this index from keySpace and add it to cipheredText
        }
        
        ///Print the Encrypted text
        System.out.println("\nThe Encryption Of The Plain Text:");
        System.out.println(cipheredText);
    }
    
    public void __fileWrite__() throws FileNotFoundException, IOException
    {
        ///Write the two arrays in the file
        FileOutputStream file = new FileOutputStream(new File("Text.txt"));
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(characters);
        out.writeObject(keySpace);
        out.close();
        file.close();
    }
}
