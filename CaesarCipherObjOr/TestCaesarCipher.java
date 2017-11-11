

import edu.duke.*;


public class TestCaesarCipher {
    
    public int maxIndex(int[] vals){
    int maxDex = 0;
    for(int i =0; i<vals.length; i++){
        if(vals[i]>vals[maxDex]){
          maxDex = i;
        
        }
        
        }
    return maxDex;
  }
    
    private int[] countLetters(String message){
        String alph = "abcdefghijklmnoqprstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
  }
  
  public void simpleTests(){
      FileResource fr = new FileResource();
      String asstring = fr.asString();
      CaesarCipher c = new CaesarCipher(18);
      String encrypted=c.encrypt(asstring);
      System.out.println("The message encrypted is "+encrypted);
      String decrypted = c.decrypt(encrypted);
      String decrypted2= breakCaesarCipher(encrypted);
      System.out.println(decrypted2);
  }
   
  public String breakCaesarCipher(String input){
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipher a = new CaesarCipher(dkey);
        return a.decrypt(input);
  }

}
