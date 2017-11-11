import java.util.*;
public class RecommendationRunner implements Recommender {
  
  public ArrayList<String> getItemsToRate (){
    //MovieDatabase.initialize("data/ratedmoviesfull.csv");
    
    ArrayList<String> movies = MovieDatabase.filterBy(new YearsAfterFilter(2013));
    ArrayList<String> myMovies = new ArrayList<String>(); 
    for(int i=0; i<10; i++){
      myMovies.add(movies.get(i));
    }
    return myMovies;
  }
  
  public void printRecommendationsFor (String webRaterID){
    FourthRatings fr = new FourthRatings();
    //RaterDatabase.initialize("ratings.csv");
   // MovieDatabase.initialize("data/ratedmoviesfull.csv");
    //ArrayList<Rater> raters =  RaterDatabase.getRaters();
         //System.out.println(list);
    ArrayList<Rating> list = fr.getSimilarRatingsByFilter(webRaterID,0,0,new YearsAfterFilter(2013));

    for(int i = 0; i < 10; i++ ) {
	   	String movie= list.get(i).getItem();
	   	System.out.println(MovieDatabase.getTitle(movie));
	   	System.out.println(MovieDatabase.getPoster(movie));
      }
      
   }
   
  public void test(){
    ArrayList<String> myMovies=getItemsToRate();
    for(int i =0; i<myMovies.size(); i++){
      System.out.println(myMovies.get(i)); 
    }
    }
  
  public void testPrint(){
    RaterDatabase.initialize("ratings.csv");
    MovieDatabase.initialize("data/ratedmoviesfull.csv");
   ArrayList<Rater> raters =  RaterDatabase.getRaters();
    //System.out.println(raters.get(3).getID());
     printRecommendationsFor(raters.get(3).getID());
    
    }
}
