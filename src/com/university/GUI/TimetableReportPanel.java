package com.university.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TimetableReportPanel extends JPanel {

    public TimetableReportPanel() {

        setLayout(new BorderLayout(15, 15));

        JTabbedPane tabs = new JTabbedPane();

        JPanel timetablePanel = new JPanel(new BorderLayout());

        JTable scheduleTable = new JTable(
                new DefaultTableModel(
                        new String[]{
                                "Code",
                                "Title",
                                "Teacher",
                                "Room",
                                "Time"
                        },
                        0
                )
        );

        scheduleTable.setRowHeight(30);

        timetablePanel.add(
                new JScrollPane(scheduleTable),
                BorderLayout.CENTER
        );

        JPanel buttons = new JPanel();

        buttons.add(new JButton("Refresh"));
        buttons.add(new JButton("Check Conflicts"));

        timetablePanel.add(buttons, BorderLayout.SOUTH);

        tabs.addTab("Timetable", timetablePanel);

        JPanel reportsPanel = new JPanel();
        reportsPanel.add(new JLabel("Reports Section"));

        tabs.addTab("Reports", reportsPanel);

        add(tabs, BorderLayout.CENTER);
    }
}
