package com.university.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FacilityPanel extends JPanel {

    public FacilityPanel() {

        setLayout(new BorderLayout(15, 15));

        JLabel heading = new JLabel(
                "Campus Facilities & Services"
        );

        heading.setFont(new Font("Arial", Font.BOLD, 28));

        add(heading, BorderLayout.NORTH);

        JTable table = new JTable(
                new DefaultTableModel(
                        new String[]{
                                "Type",
                                "ID",
                                "Name",
                                "Location",
                                "Status"
                        },
                        0
                )
        );

        table.setRowHeight(30);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottom = new JPanel();

        bottom.add(new JComboBox<>(
                new String[]{"active", "busy", "closed"}
        ));

        bottom.add(new JButton("Apply Status"));

        add(bottom, BorderLayout.SOUTH);
    }
}
