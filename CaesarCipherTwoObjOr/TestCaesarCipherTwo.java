import edu.duke.*;

public class TestCaesarCipherTwo {
    
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
   
   public void simpleTests(){
        FileResource a = new FileResource();
        String b = a.asString();
        CaesarCipherTwo c = new CaesarCipherTwo(17, 3);
        String encrypted = c.encrypt(b);
        System.out.println(encrypted);
        String decrypted = c.decrypt(encrypted);
        System.out.println(breakCaesarCipher(b));
    }
    
    public int getKey(String s){
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    
    public String breakCaesarCipher(String input){
        int dkey1 = getKey(halfOfString(input, 0));
        int dkey2 = getKey(halfOfString(input, 1));
        System.out.println(dkey1 + "\t" + dkey2);
        CaesarCipherTwo a = new CaesarCipherTwo(dkey1, dkey2);
        return a.decrypt(input);
    }
    
    
    }
    

