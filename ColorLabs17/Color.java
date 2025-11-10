
/**
 * Andrew Luo
 * 11-10-2025
 * Color
 * Various ways of manipulating the colors of a picture.
 */
import java.awt.*;
import java.util.*;
import java.util.List;
public class Color
{
    int red,green,blue;
    public void adjustRed(double factor)
    {
    for (Pixel spot : pixels1)
        {
            red = spot.getRed();
            red = (int) (red * factor);
            spot.setRed(red);
        }
    }
    public void adjustBlue(double factor) 
    {
    for (Pixel spot : pixels1)
        {
            blue = spot.getBlue();
            blue = (int) (blue * factor);
            spot.setBlue(blue);
        }
    }
    public void adjustGreen(double factor)
    {
    for (Pixel spot : pixels1)
        {
            green = spot.getGreen();
            green = (int) (green * factor);
            spot.setGreen(green);
        }
    }
    public void negate()
    {
    for (Pixel spot : pixels1)
        {
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            red = 255 - red;
            blue = 255 - red;
            green = 255 - red;
            spot.setRed(red);
            spot.setBlue(blue);
            spot.setGreen(green);
        }
    }
    public static void main (String[] args)
    {
        Picture pic1 = new Picture("images\\beach.jpg");
        Picture pic2 = new Picture("images\\beach.jpg");
        Picture pic3 = new Picture("images\\beach.jpg");
        Picture pic4 = new Picture("images\\beach.jpg");
        Pixel[] pixels1 = pic1.getPixels();
        Pixel[] pixels2 = pic2.getPixels();
        Pixel[] pixels3 = pic3.getPixels();
        Pixel[] pixels4 = pic4.getPixels();
        pic1.explore();
    }
}
