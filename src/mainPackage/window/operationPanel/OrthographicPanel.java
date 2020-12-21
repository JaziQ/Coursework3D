package mainPackage.window.operationPanel;

import mainPackage.Main;
import mainPackage.window.interfaces.Projections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OrthographicPanel extends JPanel implements Projections {
    JButton buttonHorizontal = new JButton("Horizontal");
    JButton buttonProfile = new JButton("Profile");
    JButton buttonFrontal = new JButton("Frontal");

    public OrthographicPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints dbc = new GridBagConstraints();

        setButton(dbc, buttonProfile, 0, 0);
        ActionListenerProfile actionListenerProfile = new ActionListenerProfile();
        buttonProfile.addActionListener(actionListenerProfile);

        setButton(dbc, buttonHorizontal, 1, 0);
        ActionListenerHorizontal actionListenerHorizontal = new ActionListenerHorizontal();
        buttonHorizontal.addActionListener(actionListenerHorizontal);

        setButton(dbc, buttonFrontal, 2, 0);
        ActionListenerFrontal actionListenerFrontal = new ActionListenerFrontal();
        buttonFrontal.addActionListener(actionListenerFrontal);
    }

    private void setButton(GridBagConstraints dbc, JButton jButton, int gridY, int gridX) {
        dbc.ipady = 15;
        dbc.ipadx = 200;
        dbc.gridy = gridY;
        dbc.gridx = gridX;
        dbc.weightx = 3;
        dbc.gridwidth = 2;
        add(jButton, dbc);
    }

    class ActionListenerHorizontal implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.getModel().setProjection(HORIZONTAL);
            Main.getMainFrame().getDrawingComponent().repaint();
        }
    }

    class ActionListenerFrontal implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.getModel().setProjection(FRONTAL);
            Main.getMainFrame().getDrawingComponent().repaint();
        }
    }

    class ActionListenerProfile implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.getModel().setProjection(PROFILE);
            Main.getMainFrame().getDrawingComponent().repaint();
        }
    }
}
