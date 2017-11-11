
public class WordPlay {
        
    public boolean isVowel(char ch){
        String vowels = "aeiou";
        char lower = Character.toLowerCase(ch);
        if (vowels.indexOf(lower) != -1){
            return true;
        }
        else{
            return false;
         }
       }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder replace = new StringBuilder(phrase);
      
        for (int i=0; i<replace.length(); i++){
        char currCh = replace.charAt(i);
       
        if(isVowel(currCh) ==true){
         replace.setCharAt(i,ch);
         
          }
      }
        return replace.toString();
        }
    public String emphasize(String phrase, char ch){
      StringBuilder emphaSize = new StringBuilder(phrase);
       
      for(int i=0; i<emphaSize.length(); i++){
          
          if(emphaSize.charAt(i)== ch|| emphaSize.charAt(i)==Character.toUpperCase(ch)){
              if (i % 2 == 0){
                    emphaSize.setCharAt(i, '*');
                }
                else{
                    emphaSize.setCharAt(i, '+');
                }
            }
        }
       return emphaSize.toString();
     }
      

      }
    
      
    

    
   

