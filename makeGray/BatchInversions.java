
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class BatchInversions {
    public ImageResource makeInversion (ImageResource inImage){
     ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
     for(Pixel pixel : outImage.pixels()){
         
         Pixel inPixel = inImage.getPixel(pixel.getX() , pixel.getY());
         pixel.setRed(255-inPixel.getRed());
         
         pixel.setGreen(255-inPixel.getGreen());
         pixel.setBlue(255-inPixel.getBlue());
         
         
          

}
return outImage;
}
public void selectAndCover(){
    DirectoryResource dr = new DirectoryResource();
    ImageResource ir = new ImageResource();
    for (File f : dr.selectedFiles()) {
        ImageResource inImage = new ImageResource(f);
        ImageResource gray = makeInversion(inImage);
        gray.draw();}
}}