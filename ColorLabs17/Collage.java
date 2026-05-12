import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Collage of 9 images derived from 1 image edited. Final project for APCS.
 * 
 * 1 - original image
 * 2 - image recursively gets copied to top left 2/3rd section
 * 3 - saturated image such that most intense component amplified, less intense
 * components reduced
 * 4 - edge detection: more intense edges yellow, less intense edges green
 * 5 - rotating colors. red to blue, blue to green, green to red
 * 6 - all pixels in image become 1 of 8 colors, depending on red, green, and blue values
 * 7 - mirroring bottom half of image to top half of image
 * 8 - mirroring horizontally alternate stripes of the image
 * 9 - image becomes white/light grey based on brightness of original pixels
 * 
 * saved to finalcollage.png in images folder
 * 
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
        Picture p7 = new Picture("images\\UScap.png");
        Picture p8 = new Picture("images\\UScap.png");
        Picture p9 = new Picture("images\\UScap.png");
        Picture c = new Picture("images\\Canvas.png");
        
        copytoCanvas(p1,c,0,0);
        recur(p2,p2.getWidth(),p2.getHeight());
        copytoCanvas(p2,c,1,0);
        saturate(p3);
        copytoCanvas(p3,c,2,0);
        edgeDetect(p4);
        copytoCanvas(p4,c,0,1);
        rotateColor(p5);
        copytoCanvas(p5,c,1,1);
        partition(p6);
        copytoCanvas(p6,c,2,1);
        mirrorVert(p7);
        copytoCanvas(p7,c,0,2);
        stripeMirrorHor(p8);
        copytoCanvas(p8,c,1,2);
        white(p9);
        copytoCanvas(p9,c,2,2);
        c.explore();
        
        c.write("images\\finalcollage.png");
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
    public static void mirrorVert(Picture p)
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
    public static void saturate(Picture p)
    {
        int a,b,c;
        char col;
        Pixel pix;
        for (int y=0; y<p.getHeight(); y++)
        {
            for (int x=0; x<p.getWidth(); x++)
            {
                pix = p.getPixel(x,y);
                a = pix.getRed();
                col = 'r';
                if (a < pix.getGreen())
                {
                    col = 'g';
                    a = pix.getGreen();
                }
                if (a<pix.getBlue())
                {
                    col = 'b';
                    a = pix.getBlue();
                }
                a+=120;
                if (a>255) a = 255;
                if (col == 'r')
                {
                    pix.setRed(a);
                    b = pix.getGreen();
                    c = pix.getBlue();
                    b-=60; c-=60;
                    if (b<0) b=0; if (c<0) c=0;
                    pix.setGreen(b);
                    pix.setBlue(c);
                }
                if (col == 'g')
                {
                    pix.setGreen(a);
                    b = pix.getRed();
                    c = pix.getBlue();
                    b-=60; c-=60;
                    if (b<0) b=0; if (c<0) c=0;
                    pix.setRed(b);
                    pix.setBlue(c);
                }
                if (col == 'b')
                {
                    pix.setBlue(a);
                    b = pix.getGreen();
                    c = pix.getRed();
                    b-=60; c-=60;
                    if (b<0) b=0; if (c<0) c=0;
                    pix.setGreen(b);
                    pix.setRed(c);
                }
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
                if (a>100) pix.setColor(Color.yellow);
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
    public static void rotateColor(Picture p)
    {
        int rn,gn,bn;
        Pixel pix;
        for (int y=0; y<p.getHeight(); y++)
        {
            for (int x=0; x<p.getWidth(); x++)
            {
                pix = p.getPixel(x,y);
                bn = pix.getRed();
                rn = pix.getGreen();
                gn = pix.getBlue();
                pix.setColor(new Color(rn,gn,bn));
            }
        }
    }
    public static void partition(Picture p)
    {
        int a;
        Pixel pix;
        for (int y=0; y<p.getHeight(); y++)
        {
            for (int x=0; x<p.getWidth(); x++)
            {
                a = 0;
                pix = p.getPixel(x,y);
                if (pix.getRed() >= 128) a+=4;
                if (pix.getGreen() >= 128) a+=2;
                if (pix.getBlue() >= 128) a+=1;
                switch(a)
                {
                    case 0:
                        pix.setColor(Color.black);
                        break;
                    case 1:
                        pix.setColor(Color.blue);
                        break;
                    case 2:
                        pix.setColor(Color.green);
                        break;
                    case 3:
                        pix.setColor(Color.cyan);
                        break;
                    case 4:
                        pix.setColor(Color.red);
                        break;
                    case 5:
                        pix.setColor(Color.magenta);
                        break;
                    case 6:
                        pix.setColor(Color.yellow);
                        break;
                    case 7:
                        pix.setColor(Color.white);
                        break;
                }
            }
        }
    }
    public static void stripeMirrorHor(Picture p)
    {
        int mirror = p.getWidth()/2;
        Pixel lpix, rpix;
        Color temp;
        for (int y=0; y<p.getHeight(); y++)
        {
            if ((y/40)%2==0)
            {
                for (int x=0; x<mirror; x++)
                {
                    lpix = p.getPixel(x,y);
                    rpix = p.getPixel(p.getWidth()-1-x,y);
                    temp = rpix.getColor();
                    rpix.setColor(lpix.getColor());
                    lpix.setColor(temp);
                }
            }
        }
    }
    public static void white(Picture p)
    {
        Pixel pix;
        int a;
        for (int y=0; y<p.getHeight(); y++)
        {
            for (int x=0; x<p.getWidth(); x++)
            {
                pix = p.getPixel(x,y);
                a = pix.getRed()+pix.getBlue()+pix.getGreen();
                a/=12;
                a=255-a;
                pix.setColor(new Color(a,a,a));
            }
        }
    }
}
