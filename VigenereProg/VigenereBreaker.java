import java.util.*;
import edu.duke.*;
import java.io.File;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
    	for ( int i = whichSlice; i< message.length() ; i+= totalSlices) {
    		sb.append(message.charAt(i));
    	}
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength ; i++) {
        	String s = sliceString(encrypted, i, klength);
        	key[i]= cc.getKey(sliceString(encrypted, i, klength));
        	
        }
        
        return key;
    }

    public void breakVigenere () {
    
    	FileResource fr = new FileResource();
    	String message = fr.asString();
    	int [] key = tryKeyLength(message, 6, 'e');
    	VigenereCipher vc = new VigenereCipher(key);
    	System.out.println(vc.decrypt(message));
    	
    	
    	
    	//FileResource dc = new FileResource();
        //HashSet<String> dictionary = readDictionary(dc);
    	//System.out.println("Most common char is : "+mostCommonCharIn(dictionary));
    	//System.out.println(breakForLanguage(message,dictionary));
    	
    	
        /*DirectoryResource dr = new DirectoryResource();
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        
        for (File f: dr.selectedFiles()){
          FileResource fr2 = new FileResource(f);
         map.put(f.getName(), readDictionary(fr2));
        }
        breakForAllLanguages(message, map);*/
    }
    public HashSet<String> readDictionary(FileResource fr){
    	HashSet<String> dictionary= new HashSet<String>();
    	for (String line: fr.lines()) {
    	  line.toLowerCase();
    	  dictionary.add(line);
    	}
    	return dictionary;
     }
     
     public int countWords(String message, HashSet<String> dictionary){
    	int validWords = 0;
    	String[] words = message.split("\\W+");
      for(int i =0; i<words.length; i++){
    	   if(dictionary.contains(words[i])){
    	     validWords++;
    	   }
    	   }
      return validWords;
   }
     public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        
        int[] words = new int[100];
    	for (int i = 0; i < 100; i++) {
            int[] key = tryKeyLength(encrypted, i+1, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String result = vc.decrypt(encrypted);
            words[i] = countWords(result, dictionary);
        }
    	
    	int maxWords = 0;
    	int index = 0;
    	for (int i = 0; i < 100; i++) {
            if (words[i] > maxWords) {
                maxWords = words[i];
                index = i;
            }
        }
    	
    	 int finalKey = index + 1;
        System.out.println("The key is " +finalKey);
    	 char mostCommonChar = mostCommonCharIn(dictionary).charAt(0);
    	 int[] key = tryKeyLength(encrypted, finalKey, mostCommonChar);
         VigenereCipher vc = new VigenereCipher(key);
         return vc.decrypt(encrypted);
   }
     public String mostCommonCharIn(HashSet<String> dictionary){
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
    	for (char ch = 'a'; ch <= 'z'; ++ch) {
    		  map.put(String.valueOf(ch), 0); 
        }
    	for(String word: dictionary) {
    		word.toLowerCase();
    		String[] letters = word.split("");
            for (String letter: map.keySet()) {
                for (int i=0; i<letters.length; i++) {
                    if (letters[i].equals(letter)) {
                    	map.put(letter, map.get(letter)+1);
                    }
                }
            }
    	}
    	
    	int max = 0;
    	String result ="";
         
    	for (Map.Entry<String, Integer> e : map.entrySet()) {
    	    if (max < e.getValue()) {
                max = e.getValue();
                result = e.getKey();
            }
    	}
      
        return result;
   }  
   public void   breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages){
     String language = null;
     String  messageDecr=null;
     int  maxValidWords=0;
     for (String currLang: languages.keySet()){
         messageDecr=  breakForLanguage(encrypted, languages.get(currLang));
        int validWords=countWords(messageDecr, languages.get(currLang));
        if(validWords>maxValidWords){
           maxValidWords=validWords;
           language=currLang;
        
        }
        
        }
     System.out.println("Message language is : "+language);
     System.out.println(messageDecr);
    }
        
 }
   
   
   
   
