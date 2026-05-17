package com.university.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FacilityPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public FacilityPanel() {

        setLayout(new BorderLayout(20, 20));

        JLabel heading = new JLabel("Campus Facilities", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 30));

        add(heading, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"Facility", "Location", "Status"},
                0
        );

        table = new JTable(model);
        table.setRowHeight(28);

        add(new JScrollPane(table), BorderLayout.CENTER);

        addFacility("Library", "Block A", "Active");
        addFacility("Cafeteria", "Block B", "Busy");
        addFacility("Hostel", "Block C", "Available");
        addFacility("Transport", "Main Gate", "Running");
    }

    private void addFacility(String name,
                             String location,
                             String status) {

        model.addRow(new Object[]{
                name,
                location,
                status
        });
    }
}
