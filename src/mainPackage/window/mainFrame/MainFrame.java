package mainPackage.window.mainFrame;

import javax.swing.*;

public class MainFrame extends JFrame {
    public DrawingComponent drawingComponent;

    public MainFrame(String title) {
        super(title);
        setLocation(0,0);
        setSize(1320,1042);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawingComponent = new DrawingComponent();
        add(drawingComponent);

        setVisible(true);
    }
    public DrawingComponent getDrawingComponent(){
        return drawingComponent;
    }
}
