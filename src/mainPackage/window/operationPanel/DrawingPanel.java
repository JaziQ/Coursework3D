package mainPackage.window.operationPanel;

import mainPackage.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrawingPanel extends JPanel {
    JButton buttonPaint;
    JTextArea textAreaOfA = new JTextArea();
    JTextArea textAreaOfB = new JTextArea();
    JTextArea textAreaOfC = new JTextArea();
    JTextArea textAreaOfDY = new JTextArea();
    JTextArea textAreaOfDZ = new JTextArea();
    JTextArea textAreaOfH = new JTextArea();
    JTextArea textAreaOfR = new JTextArea();
    JTextArea textAreaOfAprox = new JTextArea();

    JLabel jLabelA = new JLabel("A =");
    JLabel jLabelB = new JLabel("B =");
    JLabel jLabelC = new JLabel("C =");
    JLabel jLabeldY = new JLabel("dY =");
    JLabel jLabeldZ = new JLabel("dZ =");
    JLabel jLabelR = new JLabel("R =");
    JLabel jLabelH = new JLabel("H =");
    JLabel jLabelApp = new JLabel("Approximation =");


    public DrawingPanel() {
        setPreferredSize(new Dimension(600, 400));
        setLayout(new GridBagLayout());
        GridBagConstraints dbc = new GridBagConstraints();


        jLabelA.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(0,0,dbc, jLabelA);

        textAreaOfA.setText("150");
        AddComponent(0,1,dbc,textAreaOfA);


        jLabelB.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(1,0,dbc,jLabelB);

        textAreaOfB.setText("150");
        AddComponent(1,1,dbc,textAreaOfB);


        jLabelC.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(2,0,dbc,jLabelC);


        textAreaOfC.setText("250");
        AddComponent(2,1,dbc,textAreaOfC);

        jLabeldY.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(3,0,dbc,jLabeldY);

        textAreaOfDY.setText("125");
        AddComponent(3,1,dbc,textAreaOfDY);


        jLabeldZ.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(4,0,dbc,jLabeldZ);


        textAreaOfDZ.setText("75");
        AddComponent(4,1,dbc, textAreaOfDZ);


        jLabelR.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(5,0,dbc,jLabelR);

        textAreaOfR.setText("50");
        AddComponent(5,1,dbc,textAreaOfR);

        jLabelH.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(6,0, dbc,jLabelH);

        textAreaOfH.setText("50");
        AddComponent(6,1,dbc, textAreaOfH);

        jLabelApp.setHorizontalAlignment(JTextField.RIGHT);
        AddComponent(7,0,dbc,jLabelApp);

        textAreaOfAprox.setText("8");
        AddComponent(7,1,dbc, textAreaOfAprox);


        buttonPaint = new JButton("Paint");
        dbc.ipady = 10;      //make this component tall
        dbc.gridy = 8;
        dbc.gridx = 0;
        dbc.weightx = 1;
        dbc.gridwidth = 2;
        add(buttonPaint, dbc);
        ActionListener actionListener = new ActionListener();
        buttonPaint.addActionListener(actionListener);
    }

    private void AddComponent(int y, int x, GridBagConstraints dbc, JComponent jComponent) {
        dbc.ipadx = 40;
        dbc.gridy = y;
        dbc.gridx = x;
        dbc.weightx = 0.5;
        dbc.weighty = 1;
        add(jComponent, dbc);
    }

    class ActionListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.setModel(Integer.parseInt(textAreaOfA.getText()), Integer.parseInt(textAreaOfB.getText()),
                    Integer.parseInt(textAreaOfC.getText()), Integer.parseInt(textAreaOfDY.getText()),
                    Integer.parseInt(textAreaOfDZ.getText()),Integer.parseInt(textAreaOfH.getText()),
                    Integer.parseInt(textAreaOfR.getText()), Integer.parseInt(textAreaOfAprox.getText()));
            Main.getMainFrame().getDrawingComponent().repaint();
        }
    }
}
