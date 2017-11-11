import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class Part1 {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        
        CSVRecord smallestSoFar = null;
        
        for (CSVRecord currentRow : parser) {
            // use method to compare two records
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
        }
        
        return smallestSoFar;
    }
    
    
    public void testColdestInDay () {
        FileResource fr = new FileResource();
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") +
                   " at " + smallest.get("TimeEST"));
    }
    
    
    public CSVRecord getSmallestOfTwo (CSVRecord currentRow, CSVRecord smallestSoFar) {
        
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            //Check if currentRow’s temperature > largestSoFar’s
            if (currentTemp < smallestTemp) {
                //If so update largestSoFar to currentRow
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
    
    
   /* public String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord smallestSoFar = null;
        String coldestFileName ="file not set";
          for (File currFile : dr.selectedFiles()){
              
              FileResource fr = new FileResource(currFile);
              CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
              double coldestTempInFIle = Double.parseDouble (currentRow.get("TemperatureF"));
              smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
              double smallestSoFarDouble = Double.parseDouble(smallestSoFar.get("TemperatureF"));
              double currentTemp = Double.parseDouble (currentRow.get("TemperatureF"));
                   coldestFileName = currFile.getPath();
        
              System.out.println("currentTemp"+currentTemp);
              System.out.println("smallestSoFarDouble"+smallestSoFarDouble);
        
           if (currentTemp > smallestSoFarDouble) {
               smallestSoFarDouble = currentTemp;
               System.out.println("skata");
       
           }
        
        }
        return coldestFileName;
    }*/
    
 /*    
  public String fileWithColdestTemperature() {
        CSVRecord coldestSoFar = null;
        String coldestFileName = null;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f:dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (coldestSoFar == null) coldestSoFar = currentRow;
            else {
                double currentTem = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTem = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currentTem != -9999 && currentTem < coldestTem) {
                    coldestSoFar = current;
                    coldestFileName = f.getPath();
                }
            }
        }
        return coldestFileName;
}
    */
 /*   public void testFileWithColdestTemperature() {
         
        String coldestFileName = fileWithColdestTemperature();
        System.out.print("Coldest day was in file ");
        System.out.println(coldestFileName);
        FileResource fr = new FileResource(coldestFileName);
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.print("The coldest temperature on that day was ");
        System.out.println(coldest.get("TemperatureF"));
       System.out.println("All the temperatures on the coldest day were");
       for (CSVRecord record:fr.getCSVParser()) {
            System.out.print(record.get("DateUTC")+" "+ record.get("TemperatureF")+" "+record.get("TimeEST"));
         }
        
    }*/
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        
        for (CSVRecord currentRow : parser){
            smallestSoFar = getSmallestOfTwo2(currentRow, smallestSoFar);
            if (smallestSoFar.get("Humidity") != "N/A"){
                double smallestSoFarDouble = Double.parseDouble(smallestSoFar.get("Humidity"));
            }
        
        }
        
        return smallestSoFar;
    }
    
    public void testLowestHumidityInFile(){
    
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    CSVRecord csv = lowestHumidityInFile(parser);
    System.out.println("The lowest humidity in file is "+ csv.get("Humidity")+ " at"+ csv.get("DateUTC"));
    }
           
    public CSVRecord getSmallestOfTwo2 (CSVRecord currentRow, CSVRecord smallestSoFar) {
        
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("Humidity"));
            //Check if currentRow’s temperature > largestSoFar’s
            if (currentTemp < smallestTemp) {
                //If so update largestSoFar to currentRow
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord smallestSoFar = null;
     
        DirectoryResource dr = new DirectoryResource();
        for (File currFile : dr.selectedFiles()){
            FileResource currentFile = new FileResource(currFile);
            CSVRecord lowestHumidityInCurrentFile = lowestHumidityInFile(currentFile.getCSVParser());
            smallestSoFar =  getSmallestOfTwo2(lowestHumidityInCurrentFile, smallestSoFar);
            double smallestSoFarDouble = Double.parseDouble(smallestSoFar.get("Humidity"));
            double currentHum = Double.parseDouble (lowestHumidityInCurrentFile.get("Humidity"));
        
            if ( currentHum < smallestSoFarDouble) {
               smallestSoFarDouble = currentHum;
               
           }
             }       
            return smallestSoFar;        
    }
    
    
    public void testLowestHumidityInManyFiles(){
       CSVRecord csv = lowestHumidityInManyFiles();
       System.out.println("The lowest humidity was "+ csv.get("Humidity")+ " at"+ csv.get("DateUTC"));
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        //FileResource file = new FileResource();
        double currentTemp = 0.0;
        int i = 0;
        double total = 0;
        
        for (CSVRecord currentRow : parser) {               
               currentTemp  = Double.parseDouble(currentRow.get("TemperatureF"));                
                total +=currentTemp;
                i++;         
        }
           return (total)/i;
    }
     
    public void  testAverageTemperatureInFile() {
        
        FileResource fr = new FileResource();
        double average = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is "+ average);
        
    }
    
    
    public double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value){
         double total = 0.0;
         int i=0;
        for (CSVRecord currentRow : parser) {
            double currentHum = Double.parseDouble(currentRow.get("Humidity"));
            if( currentHum >= value){
                double currentTemp =  Double.parseDouble(currentRow.get("TemperatureF"));
                total = total + currentTemp;
                 i++;
            
            }
            
         }
         return total/i;
    }
    
    public void  testAverageTemperatureWithHighHumidityInFile(){
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       double average = averageTemperatureWithHighHumidityInFile(parser,80);
       if( average !=0){
           System.out.println("The Average Temperature With High Humidity In File "+average);
    
        }
        else{
           System.out.println("No temperatures with that humidity");
            
            
         }
    
    }
    
    
    
    
    
    
    
}