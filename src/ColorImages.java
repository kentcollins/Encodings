import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/***
 * Open and mutate image files in Java.
 */
public class ColorImages {

    public static void main(String[] args) {
        // Opening a file for editing using the file chooser
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        BufferedImage image = null;
        try {
            image = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println("There was an error opening the selected file or no file was selected.");
            e.printStackTrace();
        }

        // Print image information in case the format does not match expected
        System.out.println(image);

        // Modify pixel array using bitwise operators
        int[] pixels = new int[image.getWidth()*image.getHeight()];
        for (int x = 0; x<image.getWidth(); x++) {
            for (int y = 0; y<image.getHeight(); y++) {
                int color = image.getRGB(x, y);
                color &= 0xFFFF00FF;
                image.setRGB(x, y, color);
            }
        }


        // Opening a file for saving using the file chooser
        fc.showSaveDialog(null);
        f = fc.getSelectedFile();
        try {
            ImageIO.write(image, "png", f);
        } catch (IOException e) {
            System.out.println("There was an error opening the selected file or no file was selected.");
            throw new RuntimeException(e);
        }

    }

}
