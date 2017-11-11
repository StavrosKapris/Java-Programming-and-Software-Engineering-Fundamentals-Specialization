
import java.util.*;
public class LargestQuakes {
    
   public void findLargestQuakes(){
       EarthQuakeParser parser = new EarthQuakeParser();
       String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
       ArrayList<QuakeEntry> largestsList = getLargest(list,50);
       for(int k=0; k < largestsList.size(); k++){
			QuakeEntry currQuake = largestsList.get(k);
			System.out.println(currQuake);
           }
      }
   
   public int  indexOfLargest(ArrayList<QuakeEntry> data){
       ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(data);
       int indexOfMax=0;
      double  largestMagnitude=0.0;
      for(int i=0; i<copy.size(); i++){
        QuakeEntry  currQuake=copy.get(i);
        double currMagnitude=currQuake.getMagnitude();
        if(currMagnitude>largestMagnitude){
            largestMagnitude=currMagnitude;
            indexOfMax=i;
            }
       }
           return  indexOfMax;  
    }
     
   public ArrayList<QuakeEntry> getLargest (ArrayList<QuakeEntry> quakeData,int howMany){
       ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
       ArrayList<QuakeEntry> answer= new ArrayList<QuakeEntry>();
       if(howMany > copy.size()) {
               howMany = copy.size();
            }
           int largestsIndex= 0;
       for(int i=0; i<howMany; i++){
			largestsIndex = indexOfLargest(copy);
			answer.add(copy.get(largestsIndex));
			copy.remove(largestsIndex);
          }
    return answer;
    }
    
    
}
