import java.util.*;
public class FourthRatings {
     public double getAverageByID(String id, int minimalRaters){
         ArrayList<Rater> myRaters = RaterDatabase.getRaters();
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
    
    private double dotProduct(Rater me, Rater r){
      double ratingsProduct = 0.0;
      // HashMap<String,Rating> myRatings = me.getMyRatings();
       ArrayList<String> myMovies = me.getItemsRated();
      for(String m : myMovies){
         if(r.hasRating(m)){
           double myMovieRating = me.getRating(m);
           double rMovieRating = r.getRating(m);
           myMovieRating -= 5;
           rMovieRating -= 5;
           ratingsProduct += myMovieRating * rMovieRating;
         }
        }
        return ratingsProduct;
    }
    
    private ArrayList <Rating> getSimilarities(String id){
      ArrayList<Rating> similarRatings = new ArrayList<Rating>();
      Rater me = RaterDatabase.getRater(id);
      for(Rater r : RaterDatabase.getRaters()){
        if(!r.equals(me)){
          double product =  dotProduct(me,r);
          if(product>0){
            similarRatings.add(new Rating(r.getID(), product));
            }
        }
        }
      Collections.sort(similarRatings, Collections.reverseOrder());
      return similarRatings;
    }
    
    public ArrayList <Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters){
      ArrayList<Rating> answer = new ArrayList<Rating>();
      ArrayList<Rating> similarRatings = getSimilarities(id);
      ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
      for(String m : movies){
        double weightedAverage = 0.0;
        int raters = 0;
        double sum = 0.0;
        for( int i=0; i< numSimilarRaters; i++){
          double weight = similarRatings.get(i).getValue();
          String raterID = similarRatings.get(i).getItem();
          Rater rater =  RaterDatabase.getRater(raterID);
          
          if(rater.hasRating(m)){
            raters++;
            sum += weight * rater.getRating(m);
            }
            
        }
        
        if(raters >= minimalRaters){
          weightedAverage = sum / raters;
          answer.add(new Rating(m,weightedAverage));
        }
        
        }
      Collections.sort(answer, Collections.reverseOrder());
      return answer;
    }
    
    public ArrayList<Rating>  getSimilarRatingsByFilter(String id ,int numSimilarRaters, 
    int minimalRaters,Filter filterCriteria){
        ArrayList<Rating> answer = new ArrayList<Rating>();
      ArrayList<Rating> similarRatings = getSimilarities(id);
      System.out.println(similarRatings);
      ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
      for(String m : movies){
        double weightedAverage = 0.0;
        int raters = 0;
        double sum = 0.0;
        for( int i=0; i< numSimilarRaters; i++){
          double weight = similarRatings.get(i).getValue();
          String raterID = similarRatings.get(i).getItem();
          Rater rater =  RaterDatabase.getRater(raterID);
          if(rater.hasRating(m)){
            raters++;
            sum += weight * rater.getRating(m);
            }
        }
        if(raters >= minimalRaters){
          weightedAverage = sum / raters;
          answer.add(new Rating(m,weightedAverage));
        }
        }
      Collections.sort(answer, Collections.reverseOrder());
      return answer;
    }
}
