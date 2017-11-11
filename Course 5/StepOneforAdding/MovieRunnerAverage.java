import java.util.*;
public class MovieRunnerAverage {
    
    
    public void printAverageRatings(){
        SecondRatings sr=new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
       int moviesNum= sr.getMovieSize();
       int ratersNum= sr.getRaterSize();
       
       System.out.println("Number of movies : "+moviesNum+" and number of raters : "+ratersNum);
       
      ArrayList<Rating> averageRatings= sr.getAverageRatings(50);
      Collections.sort(averageRatings);
      //System.out.println(sr.getAverageByID("1524930",3));
       
      for(Rating r : averageRatings){
         System.out.println("vrethikan : "+averageRatings.size()+" tainies");
         System.out.println(sr.getTitle(r.getItem())+" "+"Meso rating : "+r.getValue());
        }
    }
    
    public void getAverageRatingOneMovie(){
        SecondRatings sr=new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
      String movieTitle = "The Godfather";
      String movieID = sr.getID(movieTitle);
      int minimalRaters = 3;
	  ArrayList<Rating> ratings = sr.getAverageRatings(minimalRaters);
      for(Rating r: ratings) {
			if(r.getItem().equals(movieID)){
				System.out.println("meso rating gia tin tainia "+ movieTitle +" : " + r.getValue());
		}
      }
    }
    
    }
    

