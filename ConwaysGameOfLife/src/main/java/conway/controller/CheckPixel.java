package conway.controller;

import conway.model.Pixel;
import conway.view.Screen;

import java.awt.image.BufferedImage;

public class CheckPixel {
    private static Pixel[][] pixels = new Pixel[500][500];

    public static void checkPixels(Screen screen) {
        BufferedImage tempImage = screen.getMyImage();
        byte cellsAlive;
        for (int x = 0; x < tempImage.getHeight(); x++) {
            for (int y = 0; y < tempImage.getWidth(); y++) {
                cellsAlive = 0;
                for (int xMod = -1; xMod < 2; xMod++) {
                    for (int yMod = -1; yMod < 2; yMod++) {
                        if (!(xMod == 0 && yMod == 0)) {
                            if (x == 0 && xMod == -1) {
                                xMod = 0;
                            }
                            if (y == 0 && yMod == -1) {
                                yMod = 0;
                            }
                            if ((y == 499 && yMod == 1) || (x == 499 && xMod == 1)) {
                                break;
                            }

                            cellsAlive += checkAroundPixel(x, y, xMod, yMod, tempImage);
                        }
                    }
                }
                pixels[x][y].setAmountOfNeighbors(cellsAlive);
            }
        }
        Screen.setMyImage(flipPixels(tempImage));
    }

    public static BufferedImage flipPixels(BufferedImage tempImage) {
        int neighbors;
        boolean alive;
        for (int pixelRow = 0; pixelRow < 499; pixelRow++) {
            for (int pixelCol = 0; pixelCol < 499; pixelCol++) {
                neighbors = pixels[pixelRow][pixelCol].getAmountOfNeighbors();
                alive = pixels[pixelRow][pixelCol].isAlive();
                if (neighbors == 3 && !alive) {
                    tempImage.setRGB(pixelRow, pixelCol, Pixel.WHITE);
                } else if ((neighbors == 3 || neighbors == 2) && alive){
                    tempImage.setRGB(pixelRow, pixelCol, Pixel.WHITE);
                } else {
                    tempImage.setRGB(pixelRow, pixelCol, Pixel.BLACK);
                }
            }
        }
        return tempImage;
    }

    public void makePixels(BufferedImage image) {
        for (int row = 0; row < 500; row++) {
            for (int column = 0; column < 500; column++) {
                pixels[row][column] = new Pixel();
                if (image.getRGB(row, column) == Pixel.WHITE){
                    pixels[row][column].setAlive(true);
                }
            }
        }
    }

    private static byte checkAroundPixel(int x, int y, int xMod, int yMod, BufferedImage image) {
        x += xMod;
        y += yMod;
        if (image.getRGB(x, y) == Pixel.WHITE) {
            return  1;
        } else {
            return  0;
        }
    }
}
