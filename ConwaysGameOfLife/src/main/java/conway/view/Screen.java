package conway.view;

import conway.controller.CheckPixel;
import conway.model.Pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Screen extends JFrame {
    private static BufferedImage myImage;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    CheckPixel myPixels = new CheckPixel();

    public Screen() {
        setTitle("Conway's Game of Life");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);

        myImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (int d = 0; d < 500; d++) {
            myImage.setRGB(250, d, Pixel.WHITE);
        }
        for (int d = 0; d < 500; d++){
            myImage.setRGB(248, d, Pixel.WHITE);
        }
        for (int i = 0; i < 500; i++) {
            myImage.setRGB(i, 250, Pixel.WHITE);
        }
        for (int i = 0; i < 500; i++) {
            myImage.setRGB(i, 248, Pixel.WHITE);
        }
        myPixels.makePixels(myImage);
    }

    @Override
    public void paint(Graphics g) {
        CheckPixel.checkPixels(this);
        super.paint(g);
        g.drawImage(myImage, 0, 0, this);
    }

    public BufferedImage getMyImage() {
        return myImage;
    }

    public static void setMyImage(BufferedImage image) {
        myImage = image;
    }
}
