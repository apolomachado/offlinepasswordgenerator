package pt.apolomachado.opg.panels;

import pt.apolomachado.opg.utils.PasswordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Final extends JFrame {

    public Final(String sizeValue, boolean useLetters, boolean useNumbers, boolean useSymbols) {
        setTitle("Offline Password Generator");
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        if(isValidValue(sizeValue)) {
            JLabel label = new JLabel("Generated Password: ");
            constraints.gridx = 0;
            constraints.gridy = 0;
            panel.add(label, constraints);

            JTextArea password = new JTextArea(PasswordGenerator.generatePassword(Integer.parseInt(sizeValue), useLetters, useNumbers, useSymbols));
            constraints.gridx = 1;
            constraints.gridy = 0;
            panel.add(password, constraints);

            JButton run = new JButton("Generate Again");
            ActionListener actionListener = e -> password.setText(PasswordGenerator.generatePassword(Integer.parseInt(sizeValue), useLetters, useNumbers, useSymbols));
            run.addActionListener(actionListener);

            constraints.gridx = 0;
            constraints.gridy = 4;
            panel.add(run, constraints);
        } else {
            JLabel label = new JLabel("In 'Size' section, use only numbers please.");
            constraints.gridx = 0;
            constraints.gridy = 0;
            panel.add(label, constraints);
        }

        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    protected boolean isValidValue(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) { return false; }
    }
}
