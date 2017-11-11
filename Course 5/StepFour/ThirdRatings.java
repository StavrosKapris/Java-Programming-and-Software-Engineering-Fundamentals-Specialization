import java.util.*;
 import edu.duke.*;
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
       ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
       for(String id : movies){
         double movieAverageRating = getAverageByID(id,minimalRaters);
         if(movieAverageRating!=0.0){
            Rating r = new Rating(id,movieAverageRating);
            ratings.add(r);
            }
        }    
       return ratings;
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria){
       ArrayList<Rating> ratingsByFilter = new ArrayList<Rating>();
       ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
       for(String id : movies){
         double movieAverageRating = getAverageByID(id,minimalRaters);
         if(movieAverageRating!=0.0){
            Rating r = new Rating(id,movieAverageRating);
            ratingsByFilter.add(r);
            }
        }    
       return ratingsByFilter;
    
    }
    

}
