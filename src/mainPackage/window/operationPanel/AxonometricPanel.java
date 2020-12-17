package mainPackage.window.operationPanel;

import mainPackage.Main;
import mainPackage.figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AxonometricPanel extends JPanel {
    JLabel jLabelD = new JLabel("psi =");
    JLabel jLabelRo = new JLabel("ro =");
    JLabel jLabelFi = new JLabel("fi =");
    JLabel jLabelTeta = new JLabel("teta =");


    JTextArea jTextAreaOfPsi = new JTextArea();
    JTextArea jTextAreaOfFi = new JTextArea();
    JTextArea jTextAreaOfRo = new JTextArea();
    JTextArea jTextAreaOfTeta = new JTextArea();

    JButton buttonOblique = new JButton("Set");

    public AxonometricPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints dbc = new GridBagConstraints();

        jLabelD.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(0, 0, dbc, jLabelD);

        jTextAreaOfPsi.setText("45");
        AddComponent(0, 1, dbc, jTextAreaOfPsi);

        jLabelFi.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(1, 0, dbc, jLabelFi);

        jTextAreaOfFi.setText("45");
        AddComponent(1, 1, dbc, jTextAreaOfFi);

        dbc.ipady = 10;
        dbc.gridy = 8;
        dbc.gridx = 0;
        dbc.weightx = 1;
        dbc.gridwidth = 2;
        add(buttonOblique, dbc);
        ActionListenerAxonometric actionListenerAxonometric = new ActionListenerAxonometric();
        buttonOblique.addActionListener(actionListenerAxonometric);
    }

    private void AddComponent(int y, int x, GridBagConstraints dbc, JComponent jComponent) {
        dbc.ipadx = 40;
        dbc.gridy = y;
        dbc.gridx = x;
        dbc.weightx = 0.5;
        dbc.weighty = 1;
        add(jComponent, dbc);
    }

    class ActionListenerAxonometric implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Figure figure : Main.getModel().getFigures()) {
                figure.axonometric(Double.parseDouble(jTextAreaOfPsi.getText()),
                        Double.parseDouble(jTextAreaOfFi.getText()));
            }
            Main.getMainFrame().getDrawingComponent().repaint();
        }
    }
}
