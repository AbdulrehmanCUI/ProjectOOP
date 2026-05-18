package com.university.GUI;

import javax.swing.*;

public class EmergencyDialog {

    public static void showEmergency(String message) {

        JOptionPane.showMessageDialog(
                null,
                message,
                "Emergency Alert",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
