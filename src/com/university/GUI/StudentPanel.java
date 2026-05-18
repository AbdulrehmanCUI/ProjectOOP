package com.university.GUI;

import com.university.Person.SessionManager;
import com.university.Person.Student;
import com.university.data.DataStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentPanel extends JPanel {

    /*
     * FORM FIELDS
     */
    private JTextField idField;
    private JTextField nameField;
    private JTextField departmentField;

    /*
     * TABLE
     */
    private JTable table;
    private DefaultTableModel model;

    /*
     * BUTTONS
     */
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;

    public StudentPanel() {

        setLayout(new BorderLayout(10,10));

        /*
         * ===== FORM PANEL =====
         */
        JPanel formPanel = new JPanel(
                new GridLayout(3,2,10,10)
        );

        formPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Student Information"
                )
        );

        idField = new JTextField();

        nameField = new JTextField();

        departmentField = new JTextField();

        formPanel.add(new JLabel("Student ID"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Student Name"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department"));
        formPanel.add(departmentField);

        /*
         * ===== BUTTON PANEL =====
         */
        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add");

        updateButton = new JButton("Update");

        deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);

        buttonPanel.add(updateButton);

        buttonPanel.add(deleteButton);

        /*
         * ===== TABLE =====
         */
        model = new DefaultTableModel(

                new String[]{
                        "ID",
                        "Name",
                        "Department"
                },

                0
        );

        table = new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        /*
         * ===== ADD COMPONENTS =====
         */
        add(formPanel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);

        add(buttonPanel, BorderLayout.SOUTH);

        /*
         * ===== LOAD EXISTING DATA =====
         */
        loadStudents();

        /*
         * ===== BUTTON ACTIONS =====
         */
        addButton.addActionListener(e -> addStudent());

        updateButton.addActionListener(e -> updateStudent());

        deleteButton.addActionListener(e -> deleteStudent());

        /*
         * ===== ROLE-BASED ACCESS =====
         */

        /*
         * STUDENT CAN ONLY VIEW
         */
        if(SessionManager.isStudent()) {

            addButton.setEnabled(false);

            updateButton.setEnabled(false);

            deleteButton.setEnabled(false);
        }

        /*
         * TEACHER CAN ADD/UPDATE ONLY
         */
        if(SessionManager.isTeacher()) {

            deleteButton.setEnabled(false);
        }
    }


    /*
     * ===== ADD STUDENT =====
     */
    private void addStudent() {

        if(!validateForm()) {
            return;
        }

        int id =
                Integer.parseInt(idField.getText());

        String name =
                nameField.getText();

        String department =
                departmentField.getText();

        Student student =
                new Student(id, name, department);

        DataStore.getInstance()
                .addStudent(student);

        model.addRow(new Object[]{

                student.getId(),

                student.getName(),

                student.getDepartment()
        });

        clearFields();
    }

    /*
     * ===== UPDATE STUDENT =====
     */
    private void updateStudent() {

        int row = table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a student first"
            );

            return;
        }

        model.setValueAt(
                nameField.getText(),
                row,
                1
        );

        model.setValueAt(
                departmentField.getText(),
                row,
                2
        );

        JOptionPane.showMessageDialog(
                this,
                "Student updated"
        );
    }

    /*
     * ===== DELETE STUDENT =====
     */
    private void deleteStudent() {

        int row = table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a student first"
            );

            return;
        }

        model.removeRow(row);

        JOptionPane.showMessageDialog(
                this,
                "Student deleted"
        );
    }

    /*
     * ===== VALIDATION =====
     */
    private boolean validateForm() {

        if(idField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student ID required"
            );

            return false;
        }

        if(nameField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student name required"
            );

            return false;
        }

        return true;
    }

    /*
     * ===== CLEAR FIELDS =====
     */
    private void clearFields() {

        idField.setText("");

        nameField.setText("");

        departmentField.setText("");
    }

    /*
     * ===== LOAD DATA =====
     */
    private void loadStudents() {

        for(Student student :
                DataStore.getInstance()
                        .getStudents()) {

            model.addRow(new Object[]{

                    student.getId(),

                    student.getName(),

                    student.getDepartment()
            });
        }
    }
}