


public class MinutesFilter implements Filter {
    private int myMaxMin;
    private int myMinMin;
    public MinutesFilter(int minMin ,int maxMin){
      myMinMin = minMin;
      myMaxMin= maxMin;
    }
    
    public boolean satisfies(String id){
     return myMinMin<=MovieDatabase.getMinutes(id)&&MovieDatabase.getMinutes(id)<=myMaxMin;
    }
    
}
