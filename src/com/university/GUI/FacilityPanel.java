package com.university.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.TableRowSorter;

public class FacilityPanel extends JPanel {

    public FacilityPanel() {

        setLayout(new BorderLayout(15,15));

        JLabel heading = new JLabel("Campus Facilities & Services");

        heading.setFont(new Font("Arial", Font.BOLD, 28));

        add(
                heading,
                BorderLayout.NORTH);



        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Type", "ID", "Name", "Location", "Status"},

                        0);

        model.addRow(new Object[]{"Library", "L01", "Central Library", "Block A", "Active"
        });

        model.addRow(new Object[]{"Cafeteria", "C01", "Main Cafe", "Block B", "Busy"
        });

        model.addRow(new Object[]{"Hostel", "H01", "Boys Hostel", "Block C", "Closed"
        });


        JTable table = new JTable(model);

        table.setRowHeight(30);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

        table.setRowSorter(sorter);

        table.getTableHeader().setReorderingAllowed(false);

        add(
                new JScrollPane(table),

                BorderLayout.CENTER
        );

        JPanel bottom = new JPanel();

        JComboBox<String> statusBox = new JComboBox<>(
                new String[]{"active", "busy", "closed"});

        JButton applyButton = new JButton("Apply Status");

        bottom.add(statusBox);

        bottom.add(applyButton);

        add(bottom, BorderLayout.SOUTH);
    }
}