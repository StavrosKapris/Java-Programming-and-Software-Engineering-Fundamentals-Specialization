
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int N;
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public AbstractMarkovModel(int n) {
        myRandom = new Random();
        N = n;
     }
     
    public void setTraining(String s) {
        myText = s.trim();
    }
    
    public void setRandom(int seed){
      myRandom = new Random(seed);
    }
    
    protected ArrayList<String> getFollows (String key){
       int keyLength=key.length();
       ArrayList<String> answer = new ArrayList<String>();
       for(int i=0; i<myText.length()-keyLength;i++){
          if (key.equals(myText.substring(i, i+keyLength))){                		
            answer.add(myText.substring(i+keyLength, i+keyLength+1));
		  }
        }
       return answer;
      }
      
    abstract public String getRandomText(int numChars);
    
    
}
