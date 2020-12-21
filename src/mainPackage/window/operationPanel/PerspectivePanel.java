package mainPackage.window.operationPanel;

import mainPackage.Main;
import mainPackage.window.interfaces.Projections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PerspectivePanel extends JPanel implements Projections {
    JLabel jLabelD = new JLabel("D =");
    JLabel jLabelRo = new JLabel("ro =");
    JLabel jLabelFi = new JLabel("fi =");
    JLabel jLabelTeta = new JLabel("teta =");

    JTextArea jTextAreaOfD = new JTextArea();
    JTextArea jTextAreaOfRo = new JTextArea();
    JTextArea jTextAreaOfFi = new JTextArea();
    JTextArea jTextAreaOfTeta = new JTextArea();

    JButton buttonOblique = new JButton("Set");

    public PerspectivePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints dbc = new GridBagConstraints();

        jLabelD.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(0, 0, dbc, jLabelD);

        jTextAreaOfD.setText("200");
        AddComponent(0, 1, dbc, jTextAreaOfD);

        jLabelRo.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(1, 0, dbc, jLabelRo);

        jTextAreaOfRo.setText("100");
        AddComponent(1, 1, dbc, jTextAreaOfRo);

        jLabelFi.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(2, 0, dbc, jLabelFi);

        jTextAreaOfFi.setText("0");
        AddComponent(2, 1, dbc, jTextAreaOfFi);

        jLabelTeta.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(3, 0, dbc, jLabelTeta);

        jTextAreaOfTeta.setText("0");
        AddComponent(3, 1, dbc, jTextAreaOfTeta);

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
            Main.getModel().setProjection(PERSPECTIVE);
            Main.getModel().setPerspective(Double.parseDouble(jTextAreaOfD.getText()),
                    Double.parseDouble(jTextAreaOfRo.getText()),
                    Double.parseDouble(jTextAreaOfFi.getText()),
                    Double.parseDouble(jTextAreaOfTeta.getText()));
            Main.getMainFrame().getDrawingComponent().repaint();
        }
    }
}
