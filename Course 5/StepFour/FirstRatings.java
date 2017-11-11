import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {
    
    public ArrayList<Movie> loadMovies(String filename){
      ArrayList<Movie> list = new ArrayList<Movie>();
      FileResource fr = new FileResource(filename);
      CSVParser parser = fr.getCSVParser();
      
      for (CSVRecord rec : parser) {
        Movie currMovie = new Movie(rec.get("id"),rec.get("title"),rec.get("year"), rec.get("genre"),rec.get("director"),
        rec.get("country"), rec.get("poster"),Integer.parseInt(rec.get("minutes")));
        list.add(currMovie);
        }
      return list;
    }
   
   public void  testLoadMovies (){
       int comedyCount=0;
       int minuteCount=0;
       HashMap<String,Integer> directorsMap = new HashMap <String,Integer>();
      ArrayList <Movie> movieList = loadMovies("data/ratedmoviesfull.csv");
      for (int i=0; i<movieList.size(); i++){
        if (movieList.get(i).getGenres().contains("Comedy")){
          comedyCount++;
        }
        
        if (movieList.get(i).getMinutes()>150){
          minuteCount++;
        }
        
        if(!directorsMap.containsKey(movieList.get(i).getDirector())){
          directorsMap.put(movieList.get(i).getDirector(),1);
        }
        else{
           directorsMap.put(movieList.get(i).getDirector(),directorsMap.get(movieList.get(i).getDirector())+1);  
        }
        
        //System.out.println(movieList.get(i));
       }
       
       int maxValue=0;
      for(Integer v :directorsMap.values()){
         if(v>maxValue){
            maxValue=v;
            }
        }
        
      for (Map.Entry<String, Integer> entry : directorsMap.entrySet()) {
         String key = entry.getKey();
         Integer value = entry.getValue();
        
          if (value == maxValue){
            System.out.println("Max movies are : "+maxValue+" Director with max movies :" + key);
         }   
      }

      System.out.println("Comedy Found in : "+comedyCount+" movies"); 
      System.out.println("Movies with length in minutes greater than 150 : "+minuteCount);
      System.out.println("Found : "+ movieList.size()+" movies");
      System.out.println(directorsMap);
     }
     
   
  public ArrayList<Rater> loadRaters(String filename){
		ArrayList<Rater> raters = new ArrayList<Rater>();
		FileResource fResource = new FileResource(filename);
		CSVParser parser = fResource.getCSVParser();
		for (CSVRecord record : parser) {
			String id = record.get("rater_id");
			if (raters.size() != 0 && raters.get(raters.size() - 1).getID().equals(id))
			{
				raters.get(raters.size() - 1).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
			}
			else
			{
				Rater r = new EfficientRater(id);
				r.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
				raters.add(r);
			}
		}
		return raters;
   }
    
  public void testLoadRaters(){
     
     ArrayList <Rater> ratersList = loadRaters("data/ratings.csv");
     ArrayList <Integer> numRatingsList = new ArrayList<>();
     ArrayList<String> itemsRatedPerRater = new ArrayList<>();
     int ratingCount=0;
     String movieId = "1798709";
     for(int i=0; i<ratersList.size(); i++){
        //System.out.println("The raters id is " + ratersList.get(i).getID());
        //System.out.println("and has " + ratersList.get(i).numRatings() +"ratings");
        numRatingsList.add(ratersList.get(i).numRatings());
        }
        Collections.sort(numRatingsList);
        int maxRating = numRatingsList.get(numRatingsList.size()-1);
        System.out.println("the max ratings is "+ maxRating);
        
       for(int i=0; i<ratersList.size(); i++){
           if( ratersList.get(i).numRatings()== maxRating){
            System.out.println("the rater with the most ratings is " + ratersList.get(i).getID());
            }    
                
       }
        Set<String> set =new HashSet<String>();
       for(Rater r :ratersList){
         itemsRatedPerRater=r.getItemsRated();
          for(int i =0; i<itemsRatedPerRater.size(); i++){
              set.add(itemsRatedPerRater.get(i));
            }
         if(r.hasRating(movieId)){
            ratingCount++;
            }
        }
       System.out.println("the movie with id " +movieId+" has " + ratingCount+" ratings");
       System.out.println("monadikes tainies : "+set.size());
       }
    
   
    }