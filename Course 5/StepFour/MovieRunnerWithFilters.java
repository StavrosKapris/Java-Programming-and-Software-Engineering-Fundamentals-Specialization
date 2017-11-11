
import java.util.*;
public class MovieRunnerWithFilters {
    
    public void printAverageRatings(){
       ThirdRatings tr=new ThirdRatings("data/ratings.csv");
       
       int ratersNum= tr.getRaterSize();
       
       System.out.println("Number of raters : "+ratersNum);
       
       MovieDatabase.initialize("data/ratedmoviesfull.csv");
       
      //System.out.println("Number of movies :" + MovieDatabase.size());
       
      ArrayList<Rating> averageRatings= tr.getAverageRatings(35);
      
      Collections.sort(averageRatings);
      for(Rating r: averageRatings) {
	    	System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
       }
       System.out.println(averageRatings.size());
       }
       
    public void printAverageRatingsByYear (){
      ThirdRatings tr=new ThirdRatings("data/ratings.csv");
      
      ArrayList<Rating> averageRatingByYear= 
      tr.getAverageRatingsByFilter(20,new YearsAfterFilter(2000)); 
      Collections.sort(averageRatingByYear);
       System.out.println("found " + averageRatingByYear.size() + " movies");
      //for(Rating r: averageRatingByYear) {
	    	//System.out.println(r.getValue() + " "+ MovieDatabase.getYear(r.getItem())+" "+ MovieDatabase.getTitle(r.getItem()));
       //}
    }
    
    public void printAverageRatingsByGenre (){
      ThirdRatings tr=new ThirdRatings("data/ratings.csv");
      
      ArrayList<Rating> averageRatingByGenre= 
      tr.getAverageRatingsByFilter(20,new GenreFilter("Comedy")); 
      Collections.sort(averageRatingByGenre);
       System.out.println("found " + averageRatingByGenre.size() + " movies");
      //for(Rating r: averageRatingByGenre) {
	    //	System.out.println(r.getValue() + " "+ MovieDatabase.getGenres(r.getItem())+" "+ MovieDatabase.getTitle(r.getItem()));
       //}
    }
    
    public void printAverageRatingsByMinutes (){
      ThirdRatings tr=new ThirdRatings("data/ratings.csv");
      
      ArrayList<Rating> averageRatingByMinutes= 
      tr.getAverageRatingsByFilter(5,new MinutesFilter(105,135)); 
      Collections.sort(averageRatingByMinutes);
       System.out.println("found " + averageRatingByMinutes.size() + " movies");
      //for(Rating r: averageRatingByMinutes) {
	    	//System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
     // } 
    }
    
     public void printAverageRatingsByDirectors(){
      ThirdRatings tr=new ThirdRatings("data/ratings.csv");
      List<String> directorsList = Arrays.asList("Clint Eastwood","Joel Coen","Martin Scorsese","Roman Polanski","Nora Ephron","Ridley Scott","Sydney Pollack");
      ArrayList<Rating> averageRatingByDirectors= 
      tr.getAverageRatingsByFilter(4,new DirectorsFilter(directorsList)); 
      Collections.sort(averageRatingByDirectors);
       System.out.println("found " + averageRatingByDirectors.size() + " movies");
      //for(Rating r: averageRatingByDirectors) {
	    	//System.out.println(r.getValue() + " Time: " + MovieDatabase.getDirector(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
     // } 
    }
    
    public void printAverageRatingsByYearAfterAndGenre (){
      ThirdRatings tr=new ThirdRatings("data/ratings.csv");
      AllFilters al = new AllFilters();
      al.addFilter(new YearsAfterFilter(1990));
      al.addFilter(new GenreFilter("Drama"));
      ArrayList<Rating> list= tr.getAverageRatingsByFilter(8,al);
      Collections.sort(list);
      System.out.println("found " + list.size() + " movies");
     // for(Rating r: list) {
	   // 	System.out.println(r.getValue()+" "+ MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem())+
	    //	" "+MovieDatabase.getGenres(r.getItem()));
     //} 
    }
    
     public void printAverageRatingsByDirectorsAndMinutes (){
      ThirdRatings tr=new ThirdRatings("data/ratings.csv");
       List<String> directorsList = Arrays.asList("Clint Eastwood","Joel Coen","Tim Burton","Ron Howard","Nora Ephron","Sydney Pollack");
      AllFilters al = new AllFilters();
      al.addFilter(new DirectorsFilter(directorsList));
      al.addFilter(new MinutesFilter(90,180));
      ArrayList<Rating> list= tr.getAverageRatingsByFilter(3,al);
      Collections.sort(list);
      System.out.println("found " + list.size() + " movies");
      for(Rating r: list) {
	   	System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem())+
       " " +MovieDatabase.getDirector(r.getItem()));
      } 
    }
    
}
