
import edu.duke.*;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
    int currIndex = dna.indexOf(stopCodon,startIndex+3);
            while (currIndex != -1 ) {
               int diff = currIndex - startIndex;
               if (diff % 3  == 0) {
                   return currIndex;
               }
               else {
                   currIndex = dna.indexOf(stopCodon, currIndex + 1);
               }
            }
            return dna.length();
    
    }
   
    public void tesTFindStopCodon(){
         findStopCodon("ATGATCTAATTTATGCTGCAACGGTGAAGA" ,0,"TAA");
          findStopCodon( "ATGATCATAAGAAGATAATAGAGGGCCATGTAA",0,"TGA");
           findStopCodon("ATGATCGG",0,"TAG");
           
         }
         
         
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex,tgaIndex));
        
        if (minIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex,minIndex + 3);
    }
    
    
   public StorageResource getAllGenes(String dna) {
       StorageResource geneList = new StorageResource ();
       
      
      int startIndex = 0;
      
      while ( true ) {
          //Find the next gene after startIndex
          String currentGene = findGene(dna,startIndex);
          //If no gene was found, leave this loop 
          if (currentGene.isEmpty()) {
              break;
          }
          //Print that gene out
          geneList.add(currentGene);
          //Set startIndex to just past the end of the gene
          startIndex = dna.indexOf(currentGene, startIndex) +
                       currentGene.length();
        }
        return geneList;
    }
    
    
    public float cgRatio(String dna){
        int len = dna.length();
        int CGCount = 0;
        float ratio = 0;
        int count =0;
        for(int i=0; i<len; i++){
             
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                
                CGCount++;
            }
                ratio = (float)CGCount/len;
            
        
    }
return ratio;
}

public int countCTG(String dna){
   int count=0;
 int  startIndex = dna.indexOf("CTG");
   while(startIndex!= -1){
      count ++;
            
            
     startIndex = dna.indexOf("CTG", startIndex + 3);
            
      }
    return count;
  }
  
  public void processGenes(StorageResource sr){
    int longCounter=0;
    int ratioCounter=0;
      int longest=0;
      
  
    for (String s:sr.data()){
        
        if (s.length() > 60 ){
            System.out.println(s);
            longCounter++;
        }
        
        float cgRatio = cgRatio(s);
        if (cgRatio > 0.35){
            ratioCounter++;
        }
        
        if(s.length() > longest){
            longest=s.length();
        }
          
    }
    
    System.out.println("more than 60 Are: "+ longCounter);
    System.out.println("The ration counter longer than 0.35 "+ratioCounter);
    System.out.println("the longest string is "+ longest);
    
      
     
  }
  public void testProcessGenes(){
      //StorageResource storage = new StorageResource();
       URLResource fr = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
             String dna = fr.asString();
    //storage.add(dna);

   // processGenes(storage);
    StorageResource geneList = getAllGenes(dna);
     System.out.println("Ta genes einai "+ geneList.size());
   processGenes(geneList);
   
      
   int stavros =  countCTG(dna);
   System.out.println("Ta CTG einai " +stavros);
   }
  
 
    }
  
