package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class CoursePanel extends JPanel {

    public CoursePanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel("COURSE MODULE", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));

        add(label, BorderLayout.CENTER);
    }
}