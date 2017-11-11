import edu.duke.*;
public class WordLengths {
    
    public void countWordLengths (FileResource resource,int [] counts){
    for(String s:resource.words()){
        int lengthOfWord=s.length();
        if(Character.isLetter(s.charAt(0))== false){
        lengthOfWord -=1;
          }
        else if(Character.isLetter(s.charAt(s.length() -1))== false){
         
         lengthOfWord -=1;
        
       }
        counts[lengthOfWord]++;
        }
  }
  
    public void testCountWordLengths (){
     FileResource fr = new FileResource();
     int[] counts = new int[31];
     countWordLengths(fr,counts);
     for(int i=0; i<31; i++){
       System.out.println(counts[i] + " words of length " + i);
            
     }
     System.out.println("Tthe index position of the largest element in counts is "+indexOfMax(counts));
  }
  public int indexOfMax (int[] values){
    int max = 0;
    for (int i= 0; i < values.length; i++) {
        if (values[i] > max) {
            max = i;
        }
    }
    return max;
    
    }
    
   }


