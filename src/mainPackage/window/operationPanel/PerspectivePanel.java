package mainPackage.window.operationPanel;

import mainPackage.Main;
import mainPackage.figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PerspectivePanel extends JPanel {
    JLabel jLabelL = new JLabel("L =");
    JLabel jLabelRo = new JLabel("ro =");

    JTextArea jTextAreaOfL = new JTextArea();
    JTextArea jTextAreaOfRo = new JTextArea();

    JButton buttonOblique = new JButton("Set");

    public PerspectivePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints dbc = new GridBagConstraints();

        jLabelL.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(0, 0, dbc, jLabelL);

        jTextAreaOfL.setText("0.5");
        AddComponent(0, 1, dbc, jTextAreaOfL);

        jLabelRo.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(1, 0, dbc, jLabelRo);

        jTextAreaOfRo.setText("40");
        AddComponent(1, 1, dbc, jTextAreaOfRo);

        dbc.ipady = 10;
        dbc.gridy = 8;
        dbc.gridx = 0;
        dbc.weightx = 1;
        dbc.gridwidth = 2;
        add(buttonOblique, dbc);
        ActionListenerPerspective actionListenerPerspective = new ActionListenerPerspective();
        buttonOblique.addActionListener(actionListenerPerspective);
    }

    private void AddComponent(int y, int x, GridBagConstraints dbc, JComponent jComponent) {
        dbc.ipadx = 40;
        dbc.gridy = y;
        dbc.gridx = x;
        dbc.weightx = 0.5;
        dbc.weighty = 1;
        add(jComponent, dbc);
    }

    class ActionListenerPerspective implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Figure figure : Main.getModel().getFigures()) {
                figure.oblique(Double.parseDouble(jTextAreaOfL.getText()),
                        Double.parseDouble(jTextAreaOfRo.getText()));
            }
            Main.getMainFrame().getDrawingComponent().repaint();
        }
    }
}
