/**************************************************************************
 * @author Jason Altschuler
 *
 * @tags edge detection, image analysis, computer vision, AI, machine learning
 *
 * PURPOSE: Edge detector
 *
 * ALGORITHM: RobertsCross edge detector algorithm
 *
 * For full documentation, see the README
 ************************************************************************/

package se233.project.model;

import se233.project.controller.grayscale.Grayscale;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class RobertsCrossEdgeDetector extends GaussianEdgeDetector {

    /*********************************************************************
     * Convolution kernels
     *********************************************************************/
    private final static double[][] X_kernel = {{1, 0},
            {0, -1}};

    private final static double[][] Y_kernel = {{0, -1},
            {1, 0}};

    /*********************************************************************
     * Implemented abstract methods
     *********************************************************************/

    /**
     * All work is done in constructor.
     *
     * @param filePath path to image
     */
    public RobertsCrossEdgeDetector(String filePath, boolean defaultThreshold, int threshold) {
        // read image and get pixels
        BufferedImage originalImage;
        try {
            originalImage = ImageIO.read(new File(filePath));
            findEdges(Grayscale.imgToGrayPixels(originalImage), false, defaultThreshold, threshold);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * All work is done in constructor.
     * <P> Uses L2 norm by default.
     *
     * @param image
     */
    public RobertsCrossEdgeDetector(int[][] image, boolean defaultThreshold, int threshold) {
        findEdges(image, false, defaultThreshold, threshold);
    }


    /*********************************************************************
     * Constructor
     **********************************************************************/

    /**
     * All work is done in constructor.
     * <P> Gives option to use L1 or L2 norm.
     */
    public RobertsCrossEdgeDetector(int[][] image, boolean L1norm, boolean defaultThreshold, int threshold) {
        findEdges(image, L1norm, defaultThreshold, threshold);
    }

    /**
     * @Override {{1, 0}, {0, -1}}
     */
    public double[][] getXkernel() {
        return RobertsCrossEdgeDetector.X_kernel;
    }

    /**
     * @Override {{0, -1}, {1, 0}}
     */
    public double[][] getYkernel() {
        return RobertsCrossEdgeDetector.Y_kernel;
    }


    /*********************************************************************
     * Unit testing
     * @throws IOException
     *********************************************************************/

    /**
     * Example run.
     * <P> Displays detected edges next to orignal image.
     * @param args
     * @throws IOException
     */
//   public static void main(String[] args) throws IOException {
//      // read image and get pixels
//      String img = args[0];
//      BufferedImage originalImage = ImageIO.read(new File(img));
//      int[][] pixels = Grayscale.imgToGrayPixels(originalImage);
//
//      // run SobelEdgeDetector
//      final long startTime = System.currentTimeMillis();
//      RobertsCrossEdgeDetector sed = new RobertsCrossEdgeDetector(pixels);
//      final long endTime = System.currentTimeMillis();
//
//      // print timing information
//      final double elapsed = (double) (endTime - startTime) / 1000;
//      System.out.println("Roberts Edge Detector took " + elapsed + " seconds.");
//      System.out.println("Threshold = " + sed.threshold);
//
//      // display edges
//      boolean[][] edges = sed.getEdges();
//      BufferedImage edges_image = Threshold.applyThresholdReversed(edges);
//      BufferedImage[] toShow = {originalImage, edges_image};
//      String title = "Roberts Edge Detector by Jason Altschuler";
//      ImageViewer.showImages(toShow, title);
//   }

}
