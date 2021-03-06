
public class DistanceFilter implements Filter {
   private Location location; 
   private double maxDistance;     
   private String name = "Distance";
   
   public DistanceFilter(Location loc, double dist) { 
   	   location = loc;
       maxDistance = dist;   
   	}
   	
   	
   	public boolean satisfies(QuakeEntry qe){
   	
   	    return qe.getLocation().distanceTo(location) < maxDistance;
   	}
   	public String getName(){
   	  return name;
   	
   	}
   	
}
