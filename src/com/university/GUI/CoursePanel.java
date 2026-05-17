package com.university.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CoursePanel extends JPanel {

    public CoursePanel() {

        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(245, 247, 250));

        JPanel top = new JPanel(new GridLayout(3, 4, 15, 15));

        top.setBorder(BorderFactory.createTitledBorder("Course Details"));

        top.add(new JLabel("Course Code"));
        top.add(new JTextField());

        top.add(new JLabel("Title"));
        top.add(new JTextField());

        top.add(new JLabel("Teacher"));
        top.add(new JTextField());

        top.add(new JLabel("Time Slot"));
        top.add(new JTextField());

        add(top, BorderLayout.NORTH);

        JTable table = new JTable(
                new DefaultTableModel(
                        new String[]{
                                "Code",
                                "Title",
                                "Teacher",
                                "Time"
                        },
                        0
                )
        );

        table.setRowHeight(30);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottom = new JPanel();

        bottom.add(new JButton("Add"));
        bottom.add(new JButton("Update"));
        bottom.add(new JButton("Delete"));

        add(bottom, BorderLayout.SOUTH);
    }
}
