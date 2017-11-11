
public class MagnitudeFilter implements Filter {
    private double maxMagn ;
    private double minMagn  ;
    private String name = "Magnitude";
    public MagnitudeFilter(double min,double max){
      maxMagn=max;
      minMagn=min;
    
    }
   
    public boolean satisfies (QuakeEntry qe){
        
      return qe.getMagnitude()>=minMagn &&qe.getMagnitude() <= maxMagn;
        
     }
     
    public String getName(){
        return name;
        
        }
 } 























   
