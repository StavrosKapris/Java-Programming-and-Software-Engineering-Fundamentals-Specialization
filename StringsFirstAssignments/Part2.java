

public class Part2 {
     
    public class FindGeneSimpleAndTest {
        
    public String findGeneSimple(String dna , String startCodon , String stopCodon){
        
    String result = "";
    
    int startIndex = dna.indexOf(startCodon);
    if (startIndex ==-1){
        return"";
    }
    int stopIndex = dna.indexOf(stopCodon,startIndex + 3);
    if(stopIndex ==-1){
        return "";
    }
    result = dna.substring(startIndex,stopIndex + 3);
    if(result.length()%3==0){
    
    return result;
}
     else{
        return "";
    }
}

public void testFindGeneSimple(){
    String startCodon = "ATG";
    String stopCodon ="TAA";
    String dna = "AATGCGTAATATGGT";
    System.out.println("DNA strand " + dna);
    String gene = findGeneSimple(dna ,startCodon , stopCodon);
    System.out.println("Gene is " + gene);
    
    
    dna = "AATGCGTGGGTAATATGGT";
    
    System.out.println("DNA strand " + dna);
     gene = findGeneSimple(dna ,startCodon , stopCodon);
    System.out.println("Gene is " + gene);
    
    dna = "AATGCGTACGCAACGCACGTCTATTACTATATGGT";
    
    System.out.println("DNA strand " + dna);
     gene = findGeneSimple(dna ,startCodon , stopCodon);
    System.out.println("Gene is " + gene);
    
    dna = "AATGCGTAATTGTGTGTGCATGGT";
    
    System.out.println("DNA strand " + dna);
    gene = findGeneSimple(dna ,startCodon , stopCodon);
    System.out.println("Gene is " + gene);
    
    

}
}

}
