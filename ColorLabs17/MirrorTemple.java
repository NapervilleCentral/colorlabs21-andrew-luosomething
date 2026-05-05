
/**
 * Fixing a temple by mirroring part of it.
 * 5-5-2026
 * Andrew Luo
 */
import java.awt.*;
import java.util.*;
import java.util.List;
public class MirrorTemple
{
    public static void main (String[] args)
    {
        Picture p = new Picture("images\\temple.jpg");
        Picture c = new Picture("images\\640x480.jpg");
        
        mirrorTemple(p);
        p.explore();
        copytoCanvas(p,c);
        c.explore();
    }
    public static void mirrorTemple(Picture apic)
    {
        int width = apic.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int y = 20; y<138; y++)
        {
            for (int x = 0; x<mirrorPoint;x++)
            {
                leftPixel = apic.getPixel(x,y);
                rightPixel = apic.getPixel(width-1-x,y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    public static void copytoCanvas(Picture source, Picture target)
    {
        Pixel sourcepix = null;
        Pixel targetpix = null;
        for (int sx=0, tx=0; sx<source.getWidth();sx++,tx++)
        {
            for (int sy=0, ty=0; sy<source.getHeight();sy++,ty++)
            {
                sourcepix = source.getPixel(sx,sy);
                targetpix = target.getPixel(tx,ty);
                targetpix.setColor(sourcepix.getColor());
            }
        }
    }
}
