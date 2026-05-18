package com.university.GUI;

import com.university.data.DataStore;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {

    public ReportPanel() {

        setLayout(new BorderLayout());

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);

        StringBuilder report = new StringBuilder();

        report.append("===== UNIVERSITY REPORT ===== ");

                report.append("Total Students: ")
                        .append(DataStore.getInstance()
                                .getStudents().size())
                        .append(" ");

                                report.append("Total Courses: ")
                                        .append(DataStore.getInstance()
                                                .getCourses().size())
                                        .append(" ");

                                                reportArea.setText(report.toString());

        add(new JScrollPane(reportArea), BorderLayout.CENTER);
    }
}
