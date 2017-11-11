import edu.duke.*;
import java.io.*;
import java.util.*;
public class WordsInFiles {
    private HashMap<String ,ArrayList<String>> map;
    public WordsInFiles(){
        map = new HashMap<String ,ArrayList<String>> ();
        
        }
    public void addWordsFromFile  (File f){
        FileResource fr = new FileResource(f);
        String fileName = f.getName();
        for(String w: fr.words()){
            if(!map.keySet().contains(w)){
                ArrayList<String> namesList = new ArrayList<String>();
                namesList.add(fileName);
                map.put(w,namesList);
              
            }
            else{
                if(!map.get(w).contains(fileName)){
                    
                    map.get(w).add(fileName);
                    
                    }
            }
         }
    }  
    
    public void buildWordFileMap (){
       map.clear();
         DirectoryResource dr = new DirectoryResource();
       for (File file : dr.selectedFiles()) {
             addWordsFromFile(file);
            }
    }
    
    public int maxNumber(){
       int currNum=0;
       int maxNum =0;
       for(String s :map.keySet()){
         currNum = map.get(s).size();
          if(currNum>maxNum){
            maxNum = currNum;
           }
      }
      return maxNum;
   }
   
   public ArrayList<String> wordsInNumFiles (int number){
       int  wordAppearance = 0;
       ArrayList<String> listOfWords = new ArrayList<String>();
       for(String word: map.keySet()){
        wordAppearance=map.get(word).size();
         if(wordAppearance==number){
          listOfWords.add(word);
         }
        }
       return listOfWords;
      }

   public void printFilesIn (String word){
       //buildWordFileMap();
       System.out.println("The word  "+word+" is in :");
       ArrayList<String> listOfFiles = new ArrayList<String>();
        for (String currWord: map.keySet()) {           

            if (currWord.equals(word)){  
              listOfFiles=map.get(currWord);
                  System.out.println("i irw einai xazi");
            } 
       }
       
       for (int i = 0; i < listOfFiles.size(); i++) {          
            System.out.println(listOfFiles.get(i));
       }
   }
   
   
   public void tester(){
       
       buildWordFileMap();
       int fileNum =maxNumber() ;
              //System.out.println(map);
       ArrayList<String> list = wordsInNumFiles(fileNum);
      for (int i = 0; i < list.size(); i++) {
           //int size = list.size();
            //printFilesIn(list.get(i));
         //  System.out.println(size);
           printFilesIn(list.get(i));
       }
    }
     public void FilesContainingWord (String word) {
       buildWordFileMap();
        if (map.keySet().contains(word)) {
            System.out.println("The word "+ word +" occurs in");
            for (String fileOfWord : map.get(word)) {
                System.out.println(fileOfWord);
            }
        }
    }
    
    
}