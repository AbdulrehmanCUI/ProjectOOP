package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    // STATIC COUNTERS
    public static int totalStudents = 0;
    public static int totalCourses = 0;
    public static int totalFacilities = 18;
    public static int totalRoutes = 12;

    // LABELS
    private static JLabel studentValue;
    private static JLabel courseValue;
    private static JLabel facilityValue;
    private static JLabel routeValue;

    public DashboardPanel() {

        setLayout(new BorderLayout());

        setBackground(new Color(241, 245, 249));

        // TITLE
        JLabel heading = new JLabel(
                "UNIVERSITY DASHBOARD",
                SwingConstants.CENTER
        );

        heading.setFont(
                new Font("Arial", Font.BOLD, 34)
        );

        add(heading, BorderLayout.NORTH);

        // CARDS PANEL
        JPanel cards = new JPanel(
                new GridLayout(2, 2, 30, 30)
        );

        cards.setBorder(
                BorderFactory.createEmptyBorder(
                        50,
                        50,
                        50,
                        50
                )
        );

        // VALUE LABELS
        studentValue = new JLabel(
                String.valueOf(totalStudents),
                SwingConstants.CENTER
        );

        courseValue = new JLabel(
                String.valueOf(totalCourses),
                SwingConstants.CENTER
        );

        facilityValue = new JLabel(
                String.valueOf(totalFacilities),
                SwingConstants.CENTER
        );

        routeValue = new JLabel(
                String.valueOf(totalRoutes),
                SwingConstants.CENTER
        );

        cards.add(createCard(
                "Students",
                studentValue
        ));

        cards.add(createCard(
                "Courses",
                courseValue
        ));

        cards.add(createCard(
                "Facilities",
                facilityValue
        ));

        cards.add(createCard(
                "Transport Routes",
                routeValue
        ));

        add(cards, BorderLayout.CENTER);
    }

    // CREATE CARD
    private JPanel createCard(
            String title,
            JLabel valueLabel
    ) {

        JPanel panel = new JPanel(
                new BorderLayout()
        );

        panel.setBackground(Color.WHITE);

        panel.setBorder(
                BorderFactory.createLineBorder(
                        Color.LIGHT_GRAY
                )
        );

        JLabel titleLabel = new JLabel(
                title,
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        valueLabel.setFont(
                new Font("Arial", Font.BOLD, 42)
        );

        panel.add(titleLabel, BorderLayout.NORTH);

        panel.add(valueLabel, BorderLayout.CENTER);

        return panel;
    }

    // REFRESH DASHBOARD
    public static void refreshDashboard() {

        studentValue.setText(
                String.valueOf(totalStudents)
        );

        courseValue.setText(
                String.valueOf(totalCourses)
        );

        facilityValue.setText(
                String.valueOf(totalFacilities)
        );

        routeValue.setText(
                String.valueOf(totalRoutes)
        );
    }
}