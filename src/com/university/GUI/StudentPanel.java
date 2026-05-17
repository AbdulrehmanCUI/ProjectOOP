package com.university.GUI;

import com.university.CampusRepository;
import com.university.Person.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentPanel extends JPanel {

    private CampusRepository<Student> repo = new CampusRepository<>();

    private JTable table;
    private DefaultTableModel model;

    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField deptField = new JTextField();

    public StudentPanel() {

        setLayout(new BorderLayout(20, 20));
        setBackground(new Color(248, 250, 252));

        JLabel heading = new JLabel("Student Management", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 30));

        add(heading, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Department"}, 0
        );

        table = new JTable(model);
        table.setRowHeight(28);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(4, 2, 15, 15));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        form.add(new JLabel("Student ID"));
        form.add(idField);

        form.add(new JLabel("Student Name"));
        form.add(nameField);

        form.add(new JLabel("Department"));
        form.add(deptField);

        JButton addBtn = new JButton("Add Student");
        JButton updateBtn = new JButton("Update Student");
        JButton deleteBtn = new JButton("Delete Student");

        form.add(addBtn);
        form.add(updateBtn);
        form.add(deleteBtn);

        add(form, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addStudent());
        updateBtn.addActionListener(e -> updateStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
    }

    private void addStudent() {

        try {

            Student s = new Student(
                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    deptField.getText()
            );

            repo.add(s);
            refreshTable();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Input");
        }
    }

    private void updateStudent() {

        Student s = new Student(
                Integer.parseInt(idField.getText()),
                nameField.getText(),
                deptField.getText()
        );

        repo.update(s);
        refreshTable();
    }

    private void deleteStudent() {

        repo.delete(Integer.parseInt(idField.getText()));
        refreshTable();
    }

    private void refreshTable() {

        model.setRowCount(0);

        for (Student s : repo.getAll()) {

            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getDepartment()
            });
        }
    }

    private void clearFields() {

        idField.setText("");
        nameField.setText("");
        deptField.setText("");
    }
}
