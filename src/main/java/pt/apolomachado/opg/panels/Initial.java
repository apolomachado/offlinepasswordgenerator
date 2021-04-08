package pt.apolomachado.opg.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Initial extends JFrame {

    public Initial() {
        setTitle("Offline Password Generator");
        setSize(800, 600);
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Size: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(label, constraints);

        JTextField numberOfChars = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(numberOfChars, constraints);

        JCheckBox useLetters = new JCheckBox("Use letters");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(useLetters, constraints);

        JCheckBox useNumbers = new JCheckBox("Use numbers");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(useNumbers, constraints);

        JCheckBox useSymbols = new JCheckBox("Use symbols");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(useSymbols, constraints);

        JButton run = new JButton("Generate Password");
        ActionListener actionListener = e -> {
            String numberOfCharsValue = numberOfChars.getText();
            boolean useLettersValue = useLetters.isSelected();
            boolean useNumbersValue = useNumbers.isSelected();
            boolean useSymbolsValue = useSymbols.isSelected();
            SwingUtilities.invokeLater(() -> new Final(numberOfCharsValue, useLettersValue, useNumbersValue, useSymbolsValue).setVisible(true));
        };
        run.addActionListener(actionListener);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(run, constraints);

        add(panel);

        pack();
        setLocationRelativeTo(null);
    }
}
