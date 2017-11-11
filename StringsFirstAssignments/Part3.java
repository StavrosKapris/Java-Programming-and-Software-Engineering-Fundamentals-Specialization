

public class Part3 {

    public String  twoOccurrences(String stringa , String stringb){
         String result ="FALSE"; 
       
       int startIndex=stringb.indexOf(stringa);
       if (startIndex ==-1) {
           return "FALSE";
    }
    
    int stopIndex=stringb.indexOf(stringa, startIndex+stringa.length());
    if (stopIndex ==-1) {
        return "FALSE";
    }
    
    return "TRUE";
        
       
}

    
    public void test() {
        
        String stringb = "Discodancer in Kazakstahn"; 
        String stringa = "a";
     
         
        String occur = twoOccurrences(stringb,stringa);
         System.out.println("occurance "+ occur);
        
     
        
    }
}
