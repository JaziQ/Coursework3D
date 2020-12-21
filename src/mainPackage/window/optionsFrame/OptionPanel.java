package mainPackage.window.optionsFrame;

import mainPackage.window.operationPanel.*;

import javax.swing.*;
import java.awt.*;

public class OptionPanel extends JPanel {
    JPanel jPanelForDrawing;
    JPanel jPanelForScaling;
    JPanel jPanelForOblique;

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

        jPanelForOblique = createPanel();
        ObliquePanel obliquePanel = new ObliquePanel();
        jPanelForScaling.setLayout(new GridLayout(10,2,5,5));
        jPanelForOblique.add(obliquePanel);

        jPanelForOblique = createPanel();
        AxonometricPanel axonometricPanel = new AxonometricPanel();
        jPanelForScaling.setLayout(new GridLayout(10,2,5,5));
        jPanelForOblique.add(axonometricPanel);


        jPanelForOblique = createPanel();
        PerspectivePanel perspectivePanel = new PerspectivePanel();
        jPanelForScaling.setLayout(new GridLayout(10,2,5,5));
        jPanelForOblique.add(perspectivePanel);


        jPanelForOblique = createPanel();
        OrthographicPanel orthographicPanel = new OrthographicPanel();
        jPanelForScaling.setLayout(new GridLayout(10,2,5,5));
        jPanelForOblique.add(orthographicPanel);


        tabs.addTab("Paint", drawingPanel);
        tabs.addTab("Rotate", rotatePanel);
        tabs.addTab("Transit",transitPanel);
        tabs.addTab("Scale", scalePanel);
        tabs.addTab("Orthographic", orthographicPanel);
        tabs.addTab("Oblique", obliquePanel);
        tabs.addTab("Axonom", axonometricPanel);
        tabs.addTab("Perspective", perspectivePanel);
        add(tabs);
    }

    public JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200,200));
        return panel;
    }
}
