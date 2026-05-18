package com.university.GUI;

import com.university.Person.Student;
import com.university.data.DataStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class StudentPanel extends JPanel {

    private JTextField idField;
    private JTextField nameField;
    private JTextField departmentField;

    private JTable table;
    private DefaultTableModel model;

    public StudentPanel() {

        setLayout(new BorderLayout(10,10));

        JPanel formPanel = new JPanel(new GridLayout(4,2,10,10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));

        idField = new JTextField();
        nameField = new JTextField();
        departmentField = new JTextField();

        formPanel.add(new JLabel("Student ID"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Name"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department"));
        formPanel.add(departmentField);

        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Department"},
                0
        );

        table = new JTable(model);

        TableRowSorter<DefaultTableModel> sorter =
                new TableRowSorter<>(model);

        table.setRowSorter(sorter);

        addButton.addActionListener(e -> addStudent());
        updateButton.addActionListener(e -> updateStudent());
        deleteButton.addActionListener(e -> deleteStudent());

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loadStudents();
    }

    private void addStudent() {

        if(!validateForm()) {
            return;
        }

        Student student = new Student(
                Integer.parseInt(idField.getText()),
                nameField.getText(),
                departmentField.getText()
        );

        DataStore.getInstance().getStudents().add(student);

        model.addRow(new Object[]{
                student.getId(),
                student.getName(),
                student.getDepartment()
        });

        clearFields();
    }

    private void updateStudent() {

        int row = table.getSelectedRow();

        if(row == -1) {
            return;
        }

        model.setValueAt(nameField.getText(), row, 1);
        model.setValueAt(departmentField.getText(), row, 2);
    }

    private void deleteStudent() {

        int row = table.getSelectedRow();

        if(row != -1) {
            model.removeRow(row);
        }
    }

    private boolean validateForm() {

        if(idField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Student ID required");
            return false;
        }

        if(nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Student name required");
            return false;
        }

        return true;
    }

    private void clearFields() {

        idField.setText("");
        nameField.setText("");
        departmentField.setText("");
    }

    private void loadStudents() {

        for(Student student : DataStore.getInstance().getStudents()) {

            model.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    student.getDepartment()
            });
        }
    }
}
