import java.util.*;
public class DirectorsFilter implements Filter {
  private List<String> myDirectors;
  
  public DirectorsFilter(List<String> directors){
    myDirectors=directors;
    }
  
  public boolean satisfies(String id){
     for(String d : myDirectors){
      if(MovieDatabase.getDirector(id).contains(d)){
         return true;
       }
    }
    return false;
  }
}    

