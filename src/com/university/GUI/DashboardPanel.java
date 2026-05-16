package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel("DASHBOARD", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));

        add(label, BorderLayout.CENTER);
    }
}