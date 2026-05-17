package com.university.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CoursePanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    private JTextField codeField = new JTextField();
    private JTextField titleField = new JTextField();
    private JTextField teacherField = new JTextField();
    private JTextField scheduleField = new JTextField();

    public CoursePanel() {

        setLayout(new BorderLayout(20, 20));

        JLabel heading = new JLabel("Course Management", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 30));

        add(heading, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"Course Code", "Title", "Teacher", "Schedule"},
                0
        );

        table = new JTable(model);
        table.setRowHeight(28);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(5, 2, 15, 15));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        form.add(new JLabel("Course Code"));
        form.add(codeField);

        form.add(new JLabel("Course Title"));
        form.add(titleField);

        form.add(new JLabel("Teacher"));
        form.add(teacherField);

        form.add(new JLabel("Schedule"));
        form.add(scheduleField);

        JButton addBtn = new JButton("Add Course");
        JButton removeBtn = new JButton("Remove Course");

        form.add(addBtn);
        form.add(removeBtn);

        add(form, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addCourse());
        removeBtn.addActionListener(e -> removeCourse());
    }

    private void addCourse() {

        model.addRow(new Object[]{
                codeField.getText(),
                titleField.getText(),
                teacherField.getText(),
                scheduleField.getText()
        });

        clearFields();
    }

    private void removeCourse() {

        int row = table.getSelectedRow();

        if (row >= 0) {
            model.removeRow(row);
        }
    }

    private void clearFields() {

        codeField.setText("");
        titleField.setText("");
        teacherField.setText("");
        scheduleField.setText("");
    }
}
