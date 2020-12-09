package mainPackage.window.optionsFrame;

import mainPackage.window.mainFrame.MainFrame;

import javax.swing.*;

public class OptionFrame extends JFrame {
    public OptionFrame(MainFrame mainFrame) {
        setTitle("Menu Option");
        setSize(620,1042);
        setLocation(1305,0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        OptionPanel optionPanel = new OptionPanel();
        add(optionPanel);

        /*addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    for (Figure figure : Main.getModel().getFigures()) {
                        figure.scale(1,1.5, 1);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    for (Figure figure :
                            Main.getModel().getFigures()) {
                        figure.transit(1,1.5, 1);
                    }
                }

                mainFrame.repaint();
            }
        });*/
        setVisible(true);
    }
}
