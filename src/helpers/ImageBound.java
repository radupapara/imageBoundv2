package helpers;

import constants.GUIProjectConstants;
import helpers.JFilePicker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageBound {
    private JFilePicker filePicker;

    public void boundImage() throws IOException {
        BufferedImage img1 = ImageIO.read(new File(filePicker.getSelectedFilePath()));
        BufferedImage img2 = ImageIO.read(new File(filePicker.getSelectedFilePath()));
        BufferedImage joinedImg = joinBufferedImage(img1, img2);
        ImageIO.write(joinedImg, GUIProjectConstants.FILE_EXTENSION, new File(GUIProjectConstants.OUTPUT_FILE_PATH));
    }

    public static BufferedImage joinBufferedImage(BufferedImage img1,
                                                  BufferedImage img2) {
        int offset = 2;
        int width = img1.getWidth() + img2.getWidth() + offset;
        int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
        BufferedImage newImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
        g2.drawImage(img1, null, 0, 0);
        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        g2.dispose();
        return newImage;
    }
}
