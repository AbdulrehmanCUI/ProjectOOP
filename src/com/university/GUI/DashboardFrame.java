package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public DashboardFrame() {

        setTitle("Smart University Campus Management System");
        setSize(1400, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // TOP HEADER
        add(createHeader(), BorderLayout.NORTH);

        // CARD LAYOUT
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(new DashboardPanel(), "dashboard");
        contentPanel.add(new StudentPanel(), "students");
        contentPanel.add(new CoursePanel(), "courses");
        contentPanel.add(new FacilityPanel(), "facilities");
        contentPanel.add(new ReportPanel(), "reports");
        contentPanel.add(new CampusMapPanel(), "campusmap");

        add(createSidebar(), BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createHeader() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(0, 70));
        panel.setBackground(new Color(15, 23, 42));

        JLabel title = new JLabel(
                "Smart University Campus Management System",
                SwingConstants.CENTER
        );

        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        panel.add(title, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createSidebar() {

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(240, 0));
        panel.setBackground(new Color(30, 41, 59));
        panel.setLayout(new GridLayout(10, 1, 10, 10));

        String[] items = {
                "Dashboard",
                "Students",
                "Courses",
                "Facilities",
                "Reports",
                "CampusMap"
        };

        for (String name : items) {

            JButton btn = new JButton(name);

            btn.setFocusPainted(false);
            btn.setBackground(new Color(51, 65, 85));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btn.addActionListener(e ->
                    cardLayout.show(contentPanel, name.toLowerCase())
            );

            panel.add(btn);
        }

        return panel;
    }
}
