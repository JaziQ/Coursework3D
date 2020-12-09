package mainPackage.window.mainFrame;

import mainPackage.Main;

import javax.swing.*;
import java.awt.*;


public class DrawingComponent extends JPanel {
    public DrawingComponent() {
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        if (Main.getModel() != null) {
            Main.getModel().drawModel((Graphics2D) graphics);
        }
    }
}
