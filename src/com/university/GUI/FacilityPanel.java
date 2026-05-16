package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class FacilityPanel extends JPanel {

    public FacilityPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel("FACILITY MODULE", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));

        add(label, BorderLayout.CENTER);
    }
}