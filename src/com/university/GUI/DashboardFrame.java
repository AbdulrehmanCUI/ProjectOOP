package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public DashboardFrame() {

        setTitle("Smart University Campus Management System");
        setSize(1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(new DashboardPanel(), "dashboard");
        contentPanel.add(new StudentPanel(), "students");
        contentPanel.add(new CoursePanel(), "courses");
        contentPanel.add(new FacilityPanel(), "facilities");
        contentPanel.add(new ReportPanel(), "reports");

        add(createSidebar(), BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createSidebar() {

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(220, 0));
        panel.setBackground(new Color(24, 28, 36));
        panel.setLayout(new GridLayout(10, 1, 10, 10));

        String[] items = {"Dashboard", "Students", "Courses", "Facilities", "Reports"};

        for (String name : items) {

            JButton btn = new JButton(name);

            btn.setFocusPainted(false);
            btn.setBackground(new Color(45, 52, 71));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.BOLD, 16));

            btn.addActionListener(e ->
                    cardLayout.show(contentPanel, name.toLowerCase())
            );

            panel.add(btn);
        }

        return panel;
    }
}