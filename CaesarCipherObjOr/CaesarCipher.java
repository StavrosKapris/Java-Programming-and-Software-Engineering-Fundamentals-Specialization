
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
         String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) +alphabet.substring(0,key);
         //mainKey=key;
    }
    
    public String encrypt(String input){
       StringBuilder encrypted = new StringBuilder(input);
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
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
}

}