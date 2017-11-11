import java.util.*;
public class ThirdRatings {
   
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this( "data/ratings.csv");
    }
    
    public ThirdRatings( String ratingsfile){
      FirstRatings fr = new FirstRatings();
      myRaters = fr.loadRaters(ratingsfile);
    }
    
    public int getMovieSize(){
      return myMovies.size();
    }
    
    public int getRaterSize(){
      return myRaters.size();
    }
    
    public double getAverageByID(String id, int minimalRaters){
        double sum = 0.0; 
        int ratersNum = 0;
        double finalAverage=0.0;
      for(Rater r : myRaters){
        if(r.hasRating(id)){
          ratersNum +=1;
        }
      }
      
      if(ratersNum>=minimalRaters){
        for(Rater r : myRaters){
          if(r.hasRating(id)){
            sum+=r.getRating(id);
          } 
        } 
        
        finalAverage =sum/ratersNum;
        return finalAverage;
        }
        else
        {
         return 0.0;
        }
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
       ArrayList<Rating> ratings = new ArrayList<Rating>();
       for(Movie m : myMovies){
         double movieAverageRating = getAverageByID(m.getID(),minimalRaters);
         if(movieAverageRating!=0.0){
            Rating r = new Rating(m.getID(),movieAverageRating);
            ratings.add(r);
            }
        }    
       return ratings;
    }
    
    public String getTitle(String id){
        
      for(Movie m : myMovies){
        if(m.getID().equals(id)){
           return "O titlos : "+m.getTitle();
        }
      }
        return "H ID : "+id+" den vrethike!!";
       }
       
    public String getID(String title){
      for(Movie m : myMovies){
        if(m.getTitle().equals(title)){
         return "ID tis tainias : "+m.getID();
         }  
         }
        return "NO SUCH TITLE!!!";
        }

}
