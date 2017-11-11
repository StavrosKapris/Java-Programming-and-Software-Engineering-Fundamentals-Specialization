
import edu.duke.*;
import java.util.*;

 
public class CodonCount {
    private HashMap<String, Integer> codonMap ;
    
    public CodonCount(){
    
       codonMap=new HashMap<String,Integer>();
    
    }
    
    
    public void buildCodonMap(int start,String dna){
       codonMap.clear(); 
        String current;
      for(int i = 0;i < (dna.length() - start)/3;i++){
      
    	  current = dna.substring(start+i*3, start+i*3+3);
          if (!codonMap.containsKey(current)){
              codonMap.put(current, 1);
            }
          else{
              codonMap.put(current, codonMap.get(current)+1);
            }
      
        }
      }
      
    public String getMostCommonCodon (){
        int keyValue = 0;
        int maxValue = 0;
        String keyWithMaxValue = null;
      for(String key : codonMap.keySet()){
        keyValue = codonMap.get(key);
        
         if(keyValue>maxValue){
            
            maxValue = keyValue;
            keyWithMaxValue= key;
            }
     }
        
     return keyWithMaxValue;
   }
    
   public void printCodonCounts (int start,int end){
       int codonCount = 0;
     for(String key : codonMap.keySet()){
        codonCount = codonMap.get(key);
         if(codonCount >= start && codonCount<= end){
            System.out.println( key +": " + codonCount +"\t");
            }
     }
   }
   public void tester(String dna){
     //FileResource fr = new FileResource();
     //String dna = fr.asString().trim();
     dna = dna.toUpperCase();
     int start =7 ;
      int end = 7;
      
      buildCodonMap(0,dna);
      System.out.println("Reading frame starting with 0 results in "+codonMap.size()+" unique codons");
      String largestCount=getMostCommonCodon();
      System.out.println("The codon tha appears more often is "+largestCount+" with frequency "+codonMap.get(largestCount));
      System.out.println("Codons with number of occurrences between "+start+" and "+end+" are : ");
      printCodonCounts(start ,end);
       
      //buildCodonMap(1,dna);
     // System.out.println("Reading frame starting with 1 results in "+codonMap.size()+" unique codons");
    //String  largestCount=getMostCommonCodon();
     // System.out.println("The codon tha appears more often is "+largestCount+" with frequency "+codonMap.get(largestCount));
      //System.out.println("Codons with number of occurrences between "+start+" and "+end+" are : ");
     // printCodonCounts(start ,end);
      
      //buildCodonMap(2,dna);
      //System.out.println("Reading frame starting with 2 results in "+codonMap.size()+" unique codons");
      //String largestCount=getMostCommonCodon();
     // System.out.println("The codon tha appears more often is "+largestCount+" with frequency "+codonMap.get(largestCount));
     // System.out.println("Codons with number of occurrences between "+start+" and "+end+" are : ");
      //printCodonCounts(start ,end);
      }
 }
 


