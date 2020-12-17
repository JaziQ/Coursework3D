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

        setVisible(true);
    }
}
