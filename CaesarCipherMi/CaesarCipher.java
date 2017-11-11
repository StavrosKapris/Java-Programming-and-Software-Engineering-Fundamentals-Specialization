import edu.duke.*;

public class CaesarCipher {
    
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
         String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) +alphabet.substring(0,key);
      for(int i=0; i < encrypted.length(); i++){
           char currChar = encrypted.charAt(i);
        if(Character.isLowerCase(currChar)== true){
            int index = alphabet.toLowerCase().indexOf(currChar);
            if(index!=-1){
               char newChar= shiftedAlphabet.toLowerCase().charAt(index);
             encrypted.setCharAt(i,newChar);
             }
            }
        else{
             int index = alphabet.indexOf(currChar);
             if(index!=-1){
             char newChar = shiftedAlphabet.charAt(index);
              encrypted.setCharAt(i,newChar);
            }
          }
        }
    
        return encrypted.toString();
    }
    public void testCaesar() {
        int key=17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        //String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encryptedByTwo = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetByKey1 = alphabet.substring(key1) +alphabet.substring(0,key1);
        String shiftedAlphabetByKey2 = alphabet.substring(key2) +alphabet.substring(0,key2);
      for(int i=0; i < encryptedByTwo.length(); i+=2){
           char currChar = encryptedByTwo.charAt(i);
        if(Character.isLowerCase(currChar)== true){
            int index = alphabet.toLowerCase().indexOf(currChar);
            if(index!=-1){
               char newChar= shiftedAlphabetByKey1.toLowerCase().charAt(index);
             encryptedByTwo.setCharAt(i,newChar);
             }
            }
        else{
             int index = alphabet.indexOf(currChar);
             if(index!=-1){
             char newChar = shiftedAlphabetByKey1.charAt(index);
              encryptedByTwo.setCharAt(i,newChar);
            }
          }
        }
      for(int i=1; i < encryptedByTwo.length(); i+=2){
           char currChar = encryptedByTwo.charAt(i);
        if(Character.isLowerCase(currChar)== true){
            int index = alphabet.toLowerCase().indexOf(currChar);
            if(index!=-1){
               char newChar= shiftedAlphabetByKey2.toLowerCase().charAt(index);
             encryptedByTwo.setCharAt(i,newChar);
             }
            }
        else{
             int index = alphabet.indexOf(currChar);
             if(index!=-1){
             char newChar = shiftedAlphabetByKey2.charAt(index);
              encryptedByTwo.setCharAt(i,newChar);
            }
          }
        }
    
        
      return encryptedByTwo.toString();
    }
}
