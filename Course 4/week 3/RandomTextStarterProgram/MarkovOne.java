import java.util.*;
import java.util.Random;
public class MarkovOne {
    private String myText;
	private Random myRandom;
	
	public MarkovOne() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
    public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-1);
		String key = myText.substring(index, index+1);
		sb.append(key);
		for(int k=0; k < numChars-1; k++){
			ArrayList<String> follows = getFollows(key);
			if(follows.size() == 0){
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key = key.substring(1) + next;
        }
		return sb.toString();
    }
    
    public ArrayList<String> getFollows (String key){
       int keyLength=key.length();
       ArrayList<String> answer = new ArrayList<String>();
       for(int i=0; i<myText.length()-keyLength;i++){
          if (key.equals(myText.substring(i, i+keyLength))){                		
            answer.add(myText.substring(i+keyLength, i+keyLength+1));
		  }
        }
       return answer;
      }
}
