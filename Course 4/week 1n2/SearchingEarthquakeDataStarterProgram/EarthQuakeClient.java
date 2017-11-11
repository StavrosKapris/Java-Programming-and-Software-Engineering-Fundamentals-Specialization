import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry currQuake:quakeData){
           if(currQuake.getMagnitude()>magMin){
            answer.add(currQuake);
            }
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
       double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry currQuake:quakeData){
            if(currQuake.getLocation().distanceTo(from)<distMax){
              answer.add(currQuake);
            
            }
        }

        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "http://www.dukelearntoprogram.com/course4/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        
        ArrayList<QuakeEntry> listOfBigs= filterByMagnitude(list,5.0);
        for(QuakeEntry quake:listOfBigs){
           System.out.println(quake);
        }
         System.out.println("Big quakes : # " +listOfBigs.size());
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "http://www.dukelearntoprogram.com/course4/data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        
        System.out.println("read data for "+list.size()+" quakes");
        
        // This location is Durham, NC
        Location city = new Location(35.988, -78.907);
        
         ArrayList<QuakeEntry> distanceList =filterByDistanceFrom(list,1000,city);
         for(QuakeEntry quake :distanceList){
            System.out.println("Distance from city : "+quake.getLocation().distanceTo(city)+" info : "+quake.getInfo());
            }
        // This location is Bridgeport, CA
        // Location city =  new Location(38.17, -118.82);
        System.out.println("Found " + distanceList.size() + " quakes that match that criteria");
        // TODO
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,double minDepth,
    double maxDepth) {
              ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry currQuake:quakeData){
          if(currQuake.getDepth()>minDepth && currQuake.getDepth()<maxDepth){
            answer.add(currQuake);
            }
             }
        return answer;
    }
    
    public void quakesOfDepth (){
         EarthQuakeParser parser = new EarthQuakeParser();
         String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        double minDepth=-12000.0;
        double maxDepth= -10000.0;
        ArrayList<QuakeEntry> depthList = filterByDepth(list,minDepth,maxDepth);
        System.out.println("Quakes found with depth between " + minDepth + " and " + maxDepth);
        for(QuakeEntry quake:depthList){
           System.out.println(quake);
        }
        System.out.println("Found "+ depthList.size() + " quakes that match that criteria");
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,String where,
    String phrase){
       ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
       if(where.equals("start")){
         for(QuakeEntry currQuake:quakeData){
           if(currQuake.getInfo().startsWith(phrase)){
             answer.add(currQuake);
            }
        }
      }
    
      if(where.equals("any")){
         for(QuakeEntry currQuake:quakeData){
           if(currQuake.getInfo().contains(phrase)){
             answer.add(currQuake);
            }
        }
      }
      
      if(where.equals("end")){
         for(QuakeEntry currQuake:quakeData){
           if(currQuake.getInfo().endsWith(phrase)){
             answer.add(currQuake);
            }
        }
      }
      
      return answer;
    } 
    
    public void quakesByPhrase(){
    
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        
        String where= "any";
     	String phrase = "Can";
        ArrayList<QuakeEntry> phraseList=filterByPhrase(list,where,phrase);
        for(QuakeEntry quake:phraseList){
           System.out.println(quake);
        }
        System.out.println("Found " + phraseList.size() + " quakes that match " + phrase + " at " + where);
    }
    
    
    
}
