import java.util.*;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> charactersFreqs;
   
  public CharactersInPlay(){
        characters = new ArrayList<String>();
        charactersFreqs = new ArrayList<Integer>();
  }
    
   public void update(String person){
      
    int index = characters.indexOf(person);
		if (index == -1) {
			characters.add(person);
			charactersFreqs.add(1);
		} else {
			int value =charactersFreqs.get(index);
			charactersFreqs.set(index, value + 1);
		}
  }
   
  public void findAllCharacters(){
      characters.clear();
      charactersFreqs.clear();
      FileResource resource =new FileResource();
      
      for(String line:resource.lines()){
        int periodIndex = line.indexOf(".");
          if(periodIndex !=-1){
            String possibleName = line.substring(0,periodIndex);
            update(possibleName);
            }
        }
    }
  public int findMax(){
     int maxChar=charactersFreqs.get(0);
     int maxIndex= 0;
     for(int i=0; i<charactersFreqs.size(); i++){
        if(charactersFreqs.get(i)>maxChar){
         maxChar=charactersFreqs.get(i);
         maxIndex = i;
       }
     }
     return maxIndex;
     }
     
  public void Tester(){
    findAllCharacters();
    int max= findMax();
    //for(int i=0;i<characters.size();i++){
      //System.out.println("Xaraktiras # "+(i+1)+characters.get(i)+" me syxnotita : "+charactersFreqs.get(i));
    
  // }
   for(int i=0;i<charactersFreqs.size();i++){
    if(charactersFreqs.get(i)>40){
     System.out.println("Megaluteri syxnotita "+charactersFreqs.get(i)+" me onoma : "+characters.get(i));
   }
  }
   System.out.println("Character with most speaking parts: " + characters.get(max)+" "+charactersFreqs.get(max));
   charactersWithNumParts(10,15);
  }
  
  public void charactersWithNumParts(int num1,int num2){
      for(int i =0; i<charactersFreqs.size(); i++){
          if(charactersFreqs.get(i)>=num1 && charactersFreqs.get(i)<=num2){
            
            System.out.println("Character with speaking parts between "+num1+" and "+num2+" is "+characters.get(i));
            
            }
        }
  }
     }

