package mainPackage.window.operationPanel;


import mainPackage.Main;
import mainPackage.figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScalePanel extends JPanel {
    JLabel jLabelX = new JLabel("X =");
    JLabel jLabelY = new JLabel("Y =");
    JLabel jLabelZ = new JLabel("Z =");

    JTextArea jTextAreaOfX = new JTextArea();
    JTextArea jTextAreaOfY = new JTextArea();
    JTextArea jTextAreaOfZ = new JTextArea();

    JButton buttonScale = new JButton("Scale");

    public ScalePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints dbc = new GridBagConstraints();

        jLabelX.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(0, 0, dbc, jLabelX);

        jTextAreaOfX.setText("1");
        AddComponent(0, 1, dbc, jTextAreaOfX);

        jLabelY.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(1, 0,dbc, jLabelY);

        jTextAreaOfY.setText("1");
        AddComponent(1,1,dbc,jTextAreaOfY);

        jLabelZ.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(2,0,dbc,jLabelZ);

        jTextAreaOfZ.setText("1");
        AddComponent(2,1,dbc,jTextAreaOfZ);


        dbc.ipady = 10;
        dbc.gridy = 8;
        dbc.gridx = 0;
        dbc.weightx = 1;
        dbc.gridwidth = 2;
        add(buttonScale, dbc);
        ActionListenerScale actionListenerScale = new ActionListenerScale();
        buttonScale.addActionListener(actionListenerScale);

    }

    private void AddComponent(int y, int x, GridBagConstraints dbc, JComponent jComponent) {
        dbc.ipadx = 40;
        dbc.gridy = y;
        dbc.gridx = x;
        dbc.weightx = 0.5;
        dbc.weighty = 1;
        add(jComponent, dbc);
    }

    class ActionListenerScale implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Figure figure : Main.getModel().getFigures()) {
                figure.scale(Double.parseDouble(jTextAreaOfX.getText()),
                        Double.parseDouble(jTextAreaOfY.getText()),
                        Double.parseDouble(jTextAreaOfZ.getText()));
            }
            Main.getMainFrame().getDrawingComponent().repaint();
        }
    }
}
