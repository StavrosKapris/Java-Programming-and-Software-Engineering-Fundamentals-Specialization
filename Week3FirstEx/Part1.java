
   import edu.duke.*;
   import org.apache.commons.csv.*;
public class Part1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        System.out.println(countryInfo(parser,"Germany"));
        listExportersTwoProducts(parser , "cotton" , "flowers");
        //listExportersTwoProducts(parser , "gold" , "diamonds");
         System.out.println(numberOfExporters(parser , "cocoa"));
         bigExporters(parser ,"$999,999,999,999");
     }
      
     public String countryInfo(CSVParser parser,String countryOfInterest){
          //FileResource fr = new FileResource();
       //  parser = fr.getCSVParser();
           String x = "";
        for (CSVRecord record : parser) {
            String country = record.get("Country");
            if(country.contains(countryOfInterest)){
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                x=country + ":" + exports + ":" + value ;
            }
           
         }
         return x;
        }
           
     public void listExportersTwoProducts(CSVParser parser , String exportItem1 , String exportItem2){
           FileResource fr = new FileResource();
             parser = fr.getCSVParser();
           for (CSVRecord record : parser){
                 String exports = record.get("Exports");
                 if( exports.contains(exportItem1)&& exports.contains(exportItem2)){
                        String countries = record.get("Country");
                        System.out.println(countries);
                   }
            }
      }
    public int numberOfExporters(CSVParser parser, String exportItem){
          FileResource fr = new FileResource();
          parser = fr.getCSVParser();
          int i=0;
          for (CSVRecord record : parser){
               String exportitem = record.get("Exports");
               if( exportitem.contains(exportItem)){
                       i++;
                 }
           }
             return i;
     }
     public void  bigExporters(CSVParser parser, String amount){
      FileResource fr = new FileResource();
      parser = fr.getCSVParser();
      for(CSVRecord record:parser){
        String poso = record.get("Value (dollars)");
            if (poso.length() > amount.length()) {
                System.out.print(record.get("Country")+" ");
                System.out.println(poso);
        }
      }
    }
}