import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Irw {
    
    
    public void totalBirths () {
        FileResource fr = new FileResource();
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int girlsNameNum = 0;
        int boysNameNum = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boysNameNum++;
            }
            else {
                totalGirls += numBorn;
                girlsNameNum++;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        System.out.println("total girls names = " + girlsNameNum);
        System.out.println("total boys names = " + boysNameNum);
        System.out.println("total names in file = " + girlsNameNum+boysNameNum);
    }
    
    public int getRank(int year, String name, String gender){
       int rank = 0;
       int girlsNameNum = 0;
       int finalRank = 0;
       int  boysNameNum = 0;
       String fileName= "yob" + year +".csv";
        FileResource fr = new FileResource("C:/Users/punk/Downloads/us_babynames/us_babynames_by_year/" + fileName);
        for (CSVRecord rec : fr.getCSVParser(false)) {
             // this is to count the totalGirlsName
             if (rec.get(1).equals("F")) {
                girlsNameNum++;
             }
             else {                
                boysNameNum++;
            }
            
             if ((!(rec.get(0).equals(name)))||((rec.get(0).equals(name))&&(!(rec.get(1).equals(gender))))){
                 //System.out.println("mpike sto if!");
                rank++;
                }
            else{
                finalRank = rank+1;
                //System.out.println("Mpika sti thesi" +(finalRank));                
                }            
         }
                    
        if(gender.equals("M")){
            finalRank = finalRank - girlsNameNum;
            //System.out.println("To finalRank "+finalRank);
        }
                
      //System.out.println("Ta agoria einai "+boysNameNum);
     // System.out.println("ta koritsia einai "+girlsNameNum);      
        if(rank ==(boysNameNum+girlsNameNum)){
            finalRank = -1;            
        }    
    return finalRank;
}


public String getName(int year, int rank, String gender){
       String fileName= "yob" + year + ".csv";
      FileResource fr = new FileResource("C:/Users/punk/Downloads/us_babynames/us_babynames_by_year/" + fileName);
      int currentGirlPosition = 0;
      int currentBoyPosition = 0;
      int girlsNameNum = 0;
      int boysNameNum =0;
    String name = null;
    for (CSVRecord rec : fr.getCSVParser(false)) {
         if (rec.get(1).equals("F")) {
                girlsNameNum++;
             }
             else {                
                boysNameNum++;
            }
        
         if(rec.get(1).equals("F")){
            currentGirlPosition++;
            } 
            else {
                currentBoyPosition++;
            }
            
         if(rank ==currentGirlPosition && gender.equals("F")){
             name = rec.get(0);
            }
       
        if(rank ==currentBoyPosition && gender.equals("M")){
             name = rec.get(0);
            }
     }
    if(rank>boysNameNum && gender.equals("M")){
        name = "NAME NOT FOUND";
    }
       if(rank>girlsNameNum && gender.equals("F")){
         name = "NAME NOT FOUND";
        }
    return name;
  }
  
public void whatIsNameYear(String name , int year , int newYear , String gender){
     
      int rank = getRank(year,name,gender);
     
        String newName = getName(newYear, rank ,gender);
        
        System.out.println(name+"born in "+year+" would be "+newName+" if she was born in "+newYear);
}
           
           
public int yearOfHighestRank(String name , String gender){
    
    DirectoryResource dr = new DirectoryResource();
    int maxYear=0;
    int currentRank=0;
    int highestRank=999999999;
    int sumRank = 0;
    int filesCount = 0;
    
    for (File f: dr.selectedFiles()) {
        filesCount++;
         FileResource fr = new FileResource(f);
         String yearName = (f.getName()).substring(3,7);
                 
         int yearNameNum = Integer.parseInt(yearName);
          currentRank = getRank(yearNameNum, name,gender);
         
           if(currentRank<highestRank && currentRank>0){
               
             highestRank = currentRank;
             maxYear = yearNameNum;
             sumRank += currentRank;
            }
    
    
    }
      
    if (sumRank == (filesCount*(-1))){
        return -1;
    } else {
    return maxYear;
   }
    
    /* System.out.println(maxYear);
      if (highestRank == -1){
         return -1; 
        }
        else{
       return maxYear; 
    }*/

}
public double getAverageRank(String name,String gender){
    DirectoryResource dr = new DirectoryResource();
    int currentRank=0;
    double averageRank;
    double sumRank=0;
    double numOfFilesSelected = 0;
     for (File f: dr.selectedFiles()) {
         numOfFilesSelected++;
         FileResource fr = new FileResource(f);
         String yearName = (f.getName()).substring(3,7);
                 
         int yearNameNum = Integer.parseInt(yearName);
          currentRank = getRank(yearNameNum, name,gender);
          sumRank+=currentRank;    
        }
        
        averageRank = sumRank/numOfFilesSelected;
        if(sumRank<0){
         return -1;
        
        }
        else{
        return averageRank; 
    }
}
 
public int getTotalBirthsRankedHigher(int year ,String name,String gender){
       int totalBirths = 0;
       String fileName= "yob" + year + ".csv";
        FileResource fr = new FileResource("C:/Users/punk/Downloads/us_babynames/us_babynames_by_year/" + fileName);
       
       long rank = getRank(year, name, gender);
       for (int i = 1; i < rank; i++) {
           String higherName = getName(year, i, gender);
           //System.out.println(higherName);
           CSVParser parser = fr.getCSVParser(false);           
           for (CSVRecord rec : parser) {
               if ((rec.get(0).equals(higherName) && rec.get(1).equals(gender))) {
                   int num = Integer.parseInt(rec.get(2));
                   //System.out.println("num "+ num);
                   totalBirths = totalBirths + num;
                   
               }
           }
       }
       return totalBirths;
 
    

}

}
 
          
 


