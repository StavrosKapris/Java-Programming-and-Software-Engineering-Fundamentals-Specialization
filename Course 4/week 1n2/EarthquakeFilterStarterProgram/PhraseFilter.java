
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    String where;
    String phrase;
    private String name= "Phrase";
    public PhraseFilter(String i ,String j){
      where=i;
      phrase = j;
    }
    
    public boolean satisfies (QuakeEntry qe){
      if(where.equals("start")) {
			return qe.getInfo().startsWith(phrase);
		}
		else if (where.equals("any")) {
			return qe.getInfo().contains(phrase);
		}
		else if (where.equals("end")) {
			return qe.getInfo().endsWith(phrase);
		}
      return false;
    }
    public String getName(){
     return name;
    }
}
