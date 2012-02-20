package rasterbator;

import java.awt.image.BufferedImage;

public class RasterJob {

    public String OriginalFilename;
    public String TargetFilename;

    // paper size in mm
//    public int PaperWidthDecimal = 210m;
//    public int PaperHeightDecimal = 297m;

    public int PaperWidthDecimal = 210;
    public int PaperHeightDecimal = 297;

    public int OutputWidth, OutputHeight;

    public BufferedImage OriginalImage = null;

//    public decimal RasterSize;
    public double RasterSize;
    public String RasterColor;

    public boolean UseRectangles = false;
    public boolean CroppingRectangle = false;

    public RasterJob ()
    {
    }

}