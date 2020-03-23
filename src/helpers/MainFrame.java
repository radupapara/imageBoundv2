package helpers;

import constants.GUIProjectConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {

    private JButton imageBound;

    public MainFrame() {
        super("Image Bound");

        setLayout(new FlowLayout());

        // set up a file picker component
        JFilePicker firstImgFile = new JFilePicker("Pick first img file", "Browse...");
        firstImgFile.setMode(JFilePicker.MODE_OPEN);
        firstImgFile.addFileTypeFilter(GUIProjectConstants.FILE_EXTENSION, "JPEG Images");

        JFilePicker secondImgFile = new JFilePicker("Pick second img file", "Browse...");
        secondImgFile.setMode(JFilePicker.MODE_OPEN);

        // access JFileChooser class directly
        JFileChooser firstFileChooser = firstImgFile.getFileChooser();
        firstFileChooser.setCurrentDirectory(new File("D:/"));

        JFileChooser secondFileChooser = firstImgFile.getFileChooser();
        secondFileChooser.setCurrentDirectory(new File("D:/"));

        // add the component to the frame
        add(firstImgFile);
        add(secondImgFile);

        imageBound = new JButton("Bound Images");

        add(imageBound);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 200);
        setLocationRelativeTo(null);    // center on screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == imageBound) {
            ImageBound img = new ImageBound();
            try {
                img.boundImage();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}