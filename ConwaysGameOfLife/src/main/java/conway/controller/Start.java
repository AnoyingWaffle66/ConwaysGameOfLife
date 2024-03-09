package conway.controller;

import conway.model.Pixel;
import conway.view.Screen;

import java.awt.*;

public class Start {
Screen myScreen;
    public void startHere(){
        myScreen = new Screen();
        myScreen.setVisible(true);
        myScreen.setBackground(Color.black);
        System.out.println(Pixel.WHITE);
        System.out.println();
        update();
    }
    public void update(){
        while (true){
            try {
            Thread.sleep(150);
            } catch (InterruptedException ie){
                // handle exception
            }
            myScreen.repaint();
        }
    }
}
