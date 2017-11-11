
import java.util.*;
public class MovieRunnerSimilarRatings {
    
    public void printAverageRatings(){
      FourthRatings fr=new FourthRatings();
        RaterDatabase.initialize("ratings.csv");
       System.out.println("read data for " + RaterDatabase.size() + " raters");
      MovieDatabase.initialize("data/ratedmoviesfull.csv");
       
      System.out.println("Number of movies :" + MovieDatabase.size());
       
      ArrayList<Rating> averageRatings= fr.getAverageRatings(35);
      
      Collections.sort(averageRatings);
      for(Rating r: averageRatings) {
	    	System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
       }
       System.out.println(averageRatings.size());
       }
       
    public void printAverageRatingsByYearAfterAndGenre (){
      FourthRatings fr=new FourthRatings();
      AllFilters al = new AllFilters();
      al.addFilter(new YearsAfterFilter(1990));
      al.addFilter(new GenreFilter("Drama"));
      ArrayList<Rating> list= fr.getAverageRatingsByFilter(8,al);
      Collections.sort(list);
      System.out.println("found " + list.size() + " movies");
      // for(Rating r: list) {
	   // 	System.out.println(r.getValue()+" "+ MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem())+
	    //	" "+MovieDatabase.getGenres(r.getItem()));
      //} 
    }
    
    public void printSimilarRatings(){
       FourthRatings fr=new FourthRatings();
       RaterDatabase.initialize("ratings.csv");
       MovieDatabase.initialize("data/ratedmoviesfull.csv");
       ArrayList<Rating> list = fr.getSimilarRatings("71",20,5);
       //System.out.println(list);
      System.out.println(MovieDatabase.getTitle(list.get(0).getItem()));
        //for(Rating r: list) {
	    //	System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
       //}
       }
       
    public void printSimilarRatingsByGenre (){
       FourthRatings fr=new FourthRatings();
       RaterDatabase.initialize("ratings.csv");
       MovieDatabase.initialize("data/ratedmoviesfull.csv");
       ArrayList<Rating> list = fr.getSimilarRatingsByFilter("964",20,5,new GenreFilter("Mystery"));
       //System.out.println(list);
      System.out.println(MovieDatabase.getTitle(list.get(0).getItem()));
        //for(Rating r: list) {
	    //	System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
       //}
       }
     
    public void printSimilarRatingsByDirector  (){
       FourthRatings fr=new FourthRatings();
       RaterDatabase.initialize("ratings.csv");
       MovieDatabase.initialize("data/ratedmoviesfull.csv");
       List<String> directorsList = Arrays.asList("Clint Eastwood","J.J. Abrams","Alfred Hitchcock","Sydney Pollack","David Cronenberg","Oliver Stone","Mike Leigh");
       ArrayList<Rating> list = fr.getSimilarRatingsByFilter("120",10,2,new DirectorsFilter(directorsList));
       //System.out.println(list);
      System.out.println(MovieDatabase.getTitle(list.get(0).getItem()));
        //for(Rating r: list) {
	    //	System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
       //}
       }
       
    public void printSimilarRatingsByGenreAndMinutes(){
       FourthRatings fr=new FourthRatings();
       RaterDatabase.initialize("ratings.csv");
       MovieDatabase.initialize("data/ratedmoviesfull.csv");
       AllFilters al = new AllFilters();
       al.addFilter(new MinutesFilter(80,160));
       al.addFilter(new GenreFilter("Drama"));
        ArrayList<Rating> list = fr.getSimilarRatingsByFilter("168",10,3,al);
       System.out.println(MovieDatabase.getTitle(list.get(0).getItem()));
    }
    
    public void printSimilarRatingsByYearAfterAndMinutes (){
       FourthRatings fr=new FourthRatings();
       RaterDatabase.initialize("ratings.csv");
       MovieDatabase.initialize("data/ratedmoviesfull.csv");
       AllFilters al = new AllFilters();
       al.addFilter(new MinutesFilter(70,200));
       al.addFilter(new YearsAfterFilter(1975));
        ArrayList<Rating> list = fr.getSimilarRatingsByFilter("314",10,5,al);
       System.out.println(MovieDatabase.getTitle(list.get(0).getItem()));
    //for(Rating r: list){
       //System.out.println(MovieDatabase.getTitle(r.getItem())+" with sim rating : "+ r.getValue());
   // }
    }
    }

    


