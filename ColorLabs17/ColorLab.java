
/**
 * Andrew Luo
 * 11-10-2025
 * Color
 * Various ways of manipulating the colors of a picture.
 */
import java.awt.*;
import java.util.*;
import java.util.List;
public class ColorLab
{
    public static void main (String[] args)
    {
        int red,green,blue;
        Picture pic1 = new Picture("images\\beach.jpg");
        Picture pic2 = new Picture("images\\beach.jpg");
        Picture pic3 = new Picture("images\\beach.jpg");
        Picture pic4 = new Picture("images\\beach.jpg");
        Pixel[] pixels1 = pic1.getPixels();
        Pixel[] pixels2 = pic2.getPixels();
        Pixel[] pixels3 = pic3.getPixels();
        Pixel[] pixels4 = pic4.getPixels();
        pic1.explore();
        /**
        adjustRed
        for (Pixel spot : pixels1)
        {
            red = spot.getRed();
            red = (int) (red * 0.5);
            spot.setRed(red);
        }
        adjustGreen
        for (Pixel spot : pixels1)
        {
            blue = spot.getBlue();
            blue = (int) (blue * 0.4);
            spot.setBlue(blue);
        }
        adjustBlue
        for (Pixel spot : pixels1)
        {
            green = spot.getGreen();
            green = (int) (green * 0.75);
            spot.setGreen(green);
        }
        negate
        for (Pixel spot : pixels1)
        {
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            red = 255 - red;
            blue = 255 - blue;
            green = 255 - green;
            spot.setRed(red);
            spot.setBlue(blue);
            spot.setGreen(green);
        }
        grayscale
        for (Pixel spot : pixels1)
        {
        red = spot.getRed();
        blue = spot.getBlue();
        green = spot.getGreen();
        red = (red + blue + green) / 3;
        blue = red;
        green = red;
        spot.setRed(red);
        spot.setBlue(blue);
        spot.setGreen(green);
        }
        lighten
        for (Pixel spot : pixels1)
        {
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            red += 20;
            blue += 20;
            green += 20;
            if (red > 255)
            red = 255;
            if (blue > 255)
            blue = 255;
            if (green > 255)
            green = 255;
            spot.setRed(red);
            spot.setBlue(blue);
            spot.setGreen(green);
        }
        darken
        for (Pixel spot : pixels1)
        {
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            red -= 20;
            blue -= 20;
            green -= 20;
            if (red < 0)
            red = 0;
            if (blue < 0)
            blue = 0;
            if (green < 0)
            green = 0;
            spot.setRed(red);
            spot.setBlue(blue);
            spot.setGreen(green);
        }
        changeColors
        for (Pixel spot : pixels1)
        {
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            red += 60;
            blue += -20;
            green += 12;
            if (red > 255)
            red = 255;
            if (blue > 255)
            blue = 255;
            if (green > 255)
            green = 255;
            if (red < 0)
            red = 0;
            if (blue < 0)
            blue = 0;
            if (green < 0)
            green = 0;
            spot.setRed(red);
            spot.setBlue(blue);
            spot.setGreen(green);
        }
        */
        for (Pixel spot : pixels2)
        {
            red = spot.getRed();//230,210.160
            blue = spot.getBlue();
            green = spot.getGreen();
            if (red > 190 && blue > 170 && blue < 250 && green > 120 && green < 200)
            
        }
        pic1.explore();
        pic2.explore();
        pic3.explore();
        pic4.explore();
    }
}
