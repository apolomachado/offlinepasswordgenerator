package pt.apolomachado.opg;

import pt.apolomachado.opg.panels.Initial;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Initial().setVisible(true));
    }
}
