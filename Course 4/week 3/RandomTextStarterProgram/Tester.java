import java.util.*;
import edu.duke.*;
public class Tester {
    
   public void testGetFollows (){
    
      MarkovOne markov = new MarkovOne();
      String myText = "this is a test yes this is a test.";
       markov.setTraining(myText);
       ArrayList<String> markovOneList= markov.getFollows("t");
      System.out.println("The result of calling getFollows(\"t\") : " + markovOneList + ", and its size is : " + markovOneList.size());
    }
    
   public void testGetFollowsWithFile (){
     FileResource fr = new FileResource("data/confucius.txt");
     String text = fr.asString();
     text = text.replace('\n', ' ');
     MarkovOne markov = new MarkovOne();
     markov.setTraining(text);
      ArrayList<String> markovOneList= markov.getFollows("");
      System.out.println(markovOneList.size());
    }
}      