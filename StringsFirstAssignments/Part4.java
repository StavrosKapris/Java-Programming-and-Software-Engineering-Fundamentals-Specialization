import edu.duke.*;

public class Part4 {
    
    public void findYouTube(){
        
    URLResource site = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html" );
    for (String words : site.words()){
        String wordsLower = words.toLowerCase();
           int thesi = wordsLower.indexOf("youtube.com");
      
        if(thesi!= -1){
           int start = words.lastIndexOf("\"",thesi);
          int end = words.indexOf("\"", thesi+1);
           System.out.println(words.substring(start+1,end));
        }
        
        
        
        
    }
    
    
    
}
}