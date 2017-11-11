
import edu.duke.*;
import java.util.*;
public class WordFrequencies {
   private ArrayList<String> myWords;
   private ArrayList<Integer> myFreqs;
  
   public WordFrequencies(){
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
     }
    
   public void findUnique(){
     myWords.clear();
     myFreqs.clear();
     FileResource file = new FileResource();
     for(String s: file.words()){
         s=s.toLowerCase();
         int index = myWords.indexOf(s);
         if (index == -1){
             myWords.add(s);
             myFreqs.add(1);
         }
         else{
            int value = myFreqs.get(index);
             myFreqs.set(index,value+1);
         }
      }
    }
    
   public void tester(){
       findUnique();
       System.out.println("# unique words : "+ myWords.size());
       //for (int i = 0; i < myWords.size(); i++) {
         //System.out.println("I lexi "+myWords.get(i)+" emfanizete "+myFreqs.get(i));
         //}
         int lexi = findIndexOfMax();
         System.out.println("I lexi me tin megalyteri syxnotita einai : "+myWords.get(lexi)+" me syxnotita "+myFreqs.get(lexi));
   }
   
   public int findIndexOfMax(){
       int max =myFreqs.get(0);
       int maxIndex=0;
       for(int i=0; i<myFreqs.size(); i++){
         if(myFreqs.get(i)>max){
             max = myFreqs.get(i);
             maxIndex =i; 
            }
        
        }
       return maxIndex;
   } 
}
