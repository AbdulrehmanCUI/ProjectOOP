package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {

        setLayout(new BorderLayout());
        setBackground(new Color(241, 245, 249));

        JLabel heading = new JLabel(
                "UNIVERSITY DASHBOARD",
                SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 34));

        add(heading, BorderLayout.NORTH);

        JPanel cards = new JPanel(new GridLayout(2, 2, 30, 30));
        cards.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        cards.add(createCard("Students", "1250"));
        cards.add(createCard("Courses", "45"));
        cards.add(createCard("Facilities", "18"));
        cards.add(createCard("Transport Routes", "12"));

        add(cards, BorderLayout.CENTER);
    }

    private JPanel createCard(String title, String value) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 42));

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(valueLabel, BorderLayout.CENTER);

        return panel;
    }
}
