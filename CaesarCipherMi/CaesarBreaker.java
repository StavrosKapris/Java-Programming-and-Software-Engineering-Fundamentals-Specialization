import edu.duke.*;
public class CaesarBreaker {
    
    public String decrypt(String encrypted){
      CaesarCipher cc= new CaesarCipher();
      int [] freqs = countLetters (encrypted);
       int maxDex = maxIndex(freqs);
       int dkey =maxDex -4;
       if(maxDex < 4){
        dkey = 26 - (4- maxDex);
        }
     return cc.encrypt(encrypted, 26-dkey);
  }
  public int maxIndex(int[] vals){
    int maxDex = 0;
     for(int i =0; i<vals.length; i++){
        if(vals[i]>vals[maxDex]){
          maxDex = i;
        
        }
        
        }
    return maxDex;
    }
    
    public int[] countLetters(String message){
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
  
  public String halfOfString(String message, int start){
    String half="";
     StringBuilder sb = new StringBuilder(message);
    for(int i=start; i < message.length(); i += 2){
      char letter = message.charAt(i);
      half=half +letter;
    }
    return half;
   }
  public int getKey(String s){
    int []frequencies =countLetters(s);
    int maxDex = maxIndex(frequencies);
    int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
  }
  public String decryptTwoKeys(String encrypted){
    String firstHalf =halfOfString(encrypted, 0);
    String secondHalf = halfOfString(encrypted, 1);
    int dkey1 = getKey(firstHalf);
    int dkey2 = getKey(secondHalf);
    System.out.println(dkey1 + "\t" + dkey2);
     CaesarCipher last= new CaesarCipher();
     return last.encryptTwoKeys(encrypted,26-dkey1,26-dkey2);
    }
    
    
 }
  
  
  
  
  
  
  