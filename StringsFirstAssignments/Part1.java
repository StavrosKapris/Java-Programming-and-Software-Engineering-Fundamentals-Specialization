

public class Part1 {
    
    public class FindGeneSimpleAndTest {
        
    public String findGeneSimple(String dna){
        
    String result = "";
    
    int startIndex = dna.indexOf("ATG");
    if (startIndex ==-1){
        return"";
    }
    int stopIndex = dna.indexOf("TAA",startIndex + 3);
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
    String dna = "AATGCGTAATATGGT";
    System.out.println("DNA strand " + dna);
    String gene = findGeneSimple(dna);
    System.out.println("Gene is " + gene);
    
    
    dna = "AATGCGTGGGTAATATGGT";
    System.out.println("DNA strand " + dna);
     gene = findGeneSimple(dna);
    System.out.println("Gene is " + gene);
    
    dna = "AATGCGTACGCAACGCACGTCTATTACTATATGGT";
    System.out.println("DNA strand " + dna);
     gene = findGeneSimple(dna);
    System.out.println("Gene is " + gene);
    
    dna = "AATGCGTAATTGTGTGTGCATGGT";
    System.out.println("DNA strand " + dna);
    gene = findGeneSimple(dna);
    System.out.println("Gene is " + gene);
    
    

}
}
}
