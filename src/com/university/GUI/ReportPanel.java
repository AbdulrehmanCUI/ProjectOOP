package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {

    public ReportPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel("REPORTS MODULE", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));

        add(label, BorderLayout.CENTER);
    }
}