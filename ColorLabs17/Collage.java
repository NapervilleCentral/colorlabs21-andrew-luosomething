import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Collage of 6 images derived from 1 image edited. Final project for APCS.
 * 5-5-2026
 * Andrew Luo
 */
public class Collage
{
    public static void main (String[] args)
    {
        Picture p1 = new Picture("images\\UScap.png");
        Picture p2 = new Picture("images\\UScap.png");
        Picture p3 = new Picture("images\\UScap.png");
        Picture p4 = new Picture("images\\UScap.png");
        Picture p5 = new Picture("images\\UScap.png");
        Picture p6 = new Picture("images\\UScap.png");
        Picture c = new Picture("images\\Canvas.png");
        
        copytoCanvas(p1,c,0,0);
        recur(p2,p2.getWidth(),p2.getHeight());
        copytoCanvas(p2,c,1,0);
        edgeDetect(p3);
        copytoCanvas(p3,c,0,1);
        mirrorHor(p5);
        copytoCanvas(p5,c,0,2);
        c.explore();
    }
    public static void copytoCanvas(Picture source, Picture target, int x,int y)
    {
        Pixel sourcepix = null;
        Pixel targetpix = null;
        for (int sx=0, tx=0; sx<source.getWidth();sx++,tx++)
        {
            for (int sy=0, ty=0; sy<source.getHeight();sy++,ty++)
            {
                sourcepix = source.getPixel(sx,sy);
                targetpix = target.getPixel(tx+source.getWidth()*x,ty+source.getHeight()*y);
                targetpix.setColor(sourcepix.getColor());
            }
        }
    }
    public static void recur(Picture p, int width, int height)
    {
        int newwidth=width*2/3;
        int newheight=height*2/3;
        Pixel oldpix, newpix;
        for (int x=0; x<newwidth; x++)
        {
            for (int y=0; y<newheight; y++)
            {
                oldpix = p.getPixel(x,y);
                newpix = p.getPixel(x*3/2, y*3/2);
                oldpix.setColor(newpix.getColor());
            }
        }
        if (newheight > 10) recur(p,newwidth,newheight);
    }
    public static void mirrorHor(Picture p)
    {
        int mirror = p.getHeight()/2;
        Pixel tpix, bpix;
        for (int x=0; x<p.getWidth(); x++)
        {
            for (int y = 0; y<mirror;y++)
            {
                tpix = p.getPixel(x,y);
                bpix = p.getPixel(x,p.getHeight()-1-y);
                tpix.setColor(bpix.getColor());
            }
        }
    }
    public static void edgeDetect(Picture p)
    {
        int a;
        Pixel pix, downpix;
        for (int y=0; y<p.getHeight()-1; y++)
        {
            for (int x=0; x<p.getWidth(); x++)
            {
                a=0;
                pix = p.getPixel(x,y);
                downpix = p.getPixel(x,y+1);
                a += Math.abs(pix.getRed()-downpix.getRed());
                a += Math.abs(pix.getGreen()-downpix.getGreen());
                a += Math.abs(pix.getBlue()-downpix.getBlue());
                if (a>100) pix.setColor(Color.blue);
                else if (a>50) pix.setColor(Color.green);
                else pix.setColor(Color.black);
            }
        }
        for (int x=0; x<p.getWidth(); x++)
        {
            pix = p.getPixel(x,p.getHeight()-1);
            pix.setColor(Color.black);
        }
    }
    
}
