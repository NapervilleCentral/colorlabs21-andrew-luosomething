
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        
         //opens selfie picture 
         //relative path
         Picture pic1 = new Picture("images\\selfee.jpg");
         Picture pic2 = new Picture("images\\selfee.jpg");
         pic1.explore();
         Pixel[] pixels1 = pic1.getPixels();
         Pixel[] pixels2 = pic2.getPixels();
         //custom color palette
         Color dkblue = new Color(28,32,77);
         Color redish = new Color(220,0,0);
         Color ltblue = new Color(155,179,191);
         Color offwt = new Color(224,221,215);
         
         int red,green,blue,avg,min,max;
         
         for (Pixel ixl : pixels1)
         {
             red = ixl.getRed();
             green = ixl.getGreen();
             blue = ixl.getBlue();
             avg = (red + green + blue)/3;
             if (avg < 64)
             ixl.setColor(dkblue);
             else if (avg < 128)
             ixl.setColor(redish);
             else if (avg < 192)
             ixl.setColor(ltblue);
             else
             ixl.setColor(offwt);
         }
         
         //method 2
         min = 128;//initial values that will most likely be changed
         max = 128;
         for (Pixel ixl : pixels2)
         {
             red = ixl.getRed();
             green = ixl.getGreen();
             blue = ixl.getBlue();
             avg = (red + green + blue)/3;
             if (avg < min)
             min = avg;
             if (avg > max)
             max = avg;
         }
         int range, subrange;
         range = max-min;
         for (Pixel ixl : pixels2)
         {
             red = ixl.getRed();
             green = ixl.getGreen();
             blue = ixl.getBlue();
             avg = (red + green + blue)/3;
             if (avg < (min + range / 4))
             ixl.setColor(dkblue);
             else if (avg < (min + range / 2))
             ixl.setColor(redish);
             else if (avg < (min + (3*range) / 4))
             ixl.setColor(ltblue);
             else
             ixl.setColor(offwt);
         }
         
         pic2.explore();
    }//main       
}//class
