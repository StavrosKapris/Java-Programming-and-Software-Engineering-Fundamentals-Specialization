
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabetByKey1;
    private String shiftedAlphabetByKey2;
    private int finalKey1;
    private int finalKey2;   
    
    public CaesarCipherTwo(int key1, int key2){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetByKey1 = alphabet.substring(key1) +alphabet.substring(0,key1);
        String shiftedAlphabetByKey2 = alphabet.substring(key2) +alphabet.substring(0,key2);
        finalKey1 = key1;
        finalKey2 = key2;
    }
    public String encrypt(String input){
      StringBuilder encryptedByTwo = new StringBuilder(input);  
    
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
    
    public String decrypt(String input){
        CaesarCipherTwo a = new CaesarCipherTwo(26 -finalKey1, 26 - finalKey2);
        return a.encrypt(input);
     }
}
