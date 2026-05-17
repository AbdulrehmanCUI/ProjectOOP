package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {

    public ReportPanel() {

        setLayout(new BorderLayout());

        JLabel heading = new JLabel(
                "University Reports",
                SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 30));

        add(heading, BorderLayout.NORTH);

        JTextArea area = new JTextArea();
        area.setFont(new Font("Monospaced", Font.PLAIN, 18));

        area.setText(
                "===== UNIVERSITY REPORT =====\n\n" +
                        "Total Students : 1250\n" +
                        "Total Courses  : 45\n" +
                        "Total Faculty  : 85\n" +
                        "Library Usage  : HIGH\n" +
                        "Transport      : ACTIVE\n" +
                        "Security Status: STABLE\n\n" +
                        "Performance Summary:\n" +
                        "The university system is functioning normally."
        );

        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
