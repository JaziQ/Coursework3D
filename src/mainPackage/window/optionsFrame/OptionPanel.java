package mainPackage.window.optionsFrame;

import mainPackage.window.operationPanel.DrawingPanel;
import mainPackage.window.operationPanel.RotatePanel;
import mainPackage.window.operationPanel.ScalePanel;
import mainPackage.window.operationPanel.TransitPanel;

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
        RotatePanel rotatePanel = new RotatePanel();
        jPanelForScaling.setLayout(new GridLayout(10,2,10,10));
        jPanelForScaling.add(rotatePanel);

        jPanelForScaling = createPanel();
        TransitPanel transitPanel = new TransitPanel();
        jPanelForScaling.setLayout(new GridLayout(10,2,10,10));
        jPanelForScaling.add(transitPanel);

        jPanelForScaling = createPanel();
        ScalePanel scalePanel = new ScalePanel();
        jPanelForScaling.setLayout(new GridLayout(10,2,10,10));
        jPanelForScaling.add(scalePanel);

        tabs.addTab("Paint", drawingPanel);
        tabs.addTab("Rotate", rotatePanel);
        tabs.addTab("Transit",transitPanel);
        tabs.addTab("Scale", scalePanel);
        add(tabs);
    }

    public JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200,200));
        return panel;
    }
}
