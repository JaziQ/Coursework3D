package mainPackage.window.optionsFrame;

import mainPackage.window.operationPanel.DrawingPanel;


import javax.swing.*;
import java.awt.*;

public class OptionPanel extends JPanel {
    JPanel jPanelForDrawing;
    JPanel jPanelForScaling;

    public OptionPanel() {
        JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
        setBackground(Color.WHITE);
        Font font = new Font("Lobster Regular", Font.PLAIN, 20);
        tabs.setFont(font);

        jPanelForDrawing = createPanel();
        DrawingPanel drawingPanel = new DrawingPanel();
        jPanelForDrawing.setLayout(new GridLayout(10,2,10,10));
        jPanelForDrawing.add(drawingPanel);

        jPanelForScaling = createPanel();

        jPanelForScaling.setLayout(new GridLayout(10,2,10,10));
        //jPanelForScaling.add();

        tabs.addTab("Paint", drawingPanel);
        //tabs.addTab("FuckU", panel5);
        add(tabs);
    }

    public JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200,200));
        return panel;
    }
}
