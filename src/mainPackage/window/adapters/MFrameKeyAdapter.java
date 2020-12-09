package mainPackage.window.adapters;

import mainPackage.window.mainFrame.DrawingComponent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MFrameKeyAdapter extends KeyAdapter {
    private final DrawingComponent drawingComponent;

    public MFrameKeyAdapter(DrawingComponent d) {
        super();
        drawingComponent = d;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //Main.getModel().reset();
        }
        drawingComponent.repaint();
    }
}
