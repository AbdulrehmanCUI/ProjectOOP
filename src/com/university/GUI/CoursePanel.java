package com.university.GUI;

import com.university.AcademicUnit.Course;
import com.university.Person.SessionManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CoursePanel extends JPanel {

    /*
     * FORM FIELDS
     */
    private JTextField courseIdField;
    private JTextField courseNameField;
    private JTextField instructorField;
    private JTextField scheduleField;

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

    public CoursePanel() {

        setLayout(new BorderLayout(10,10));

        /*
         * ===== FORM PANEL =====
         */
        JPanel formPanel = new JPanel(
                new GridLayout(4,2,10,10)
        );

        formPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Course Information"
                )
        );

        courseIdField = new JTextField();

        courseNameField = new JTextField();

        instructorField = new JTextField();

        scheduleField = new JTextField();

        formPanel.add(new JLabel("Course ID"));
        formPanel.add(courseIdField);

        formPanel.add(new JLabel("Course Name"));
        formPanel.add(courseNameField);

        formPanel.add(new JLabel("Instructor"));
        formPanel.add(instructorField);

        formPanel.add(new JLabel("Schedule"));
        formPanel.add(scheduleField);

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
                        "Course ID",
                        "Course Name",
                        "Instructor",
                        "Schedule"
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
         * ===== LOAD SAVED DATA =====
         */
        loadCourses();

        /*
         * ===== BUTTON ACTIONS =====
         */
        addButton.addActionListener(
                e -> addCourse()
        );

        updateButton.addActionListener(
                e -> updateCourse()
        );

        deleteButton.addActionListener(
                e -> deleteCourse()
        );

        /*
         * ===== ROLE-BASED ACCESS =====
         */

        /*
         * STUDENTS CAN ONLY VIEW
         */
        if(SessionManager.isStudent()) {

            addButton.setEnabled(false);

            updateButton.setEnabled(false);

            deleteButton.setEnabled(false);
        }

        /*
         * TEACHERS CANNOT DELETE
         */
        if(SessionManager.isTeacher()) {

            deleteButton.setEnabled(false);
        }
    }

    /*
     * ===== ADD COURSE =====
     */
    private void addCourse() {

        if(!validateForm()) {
            return;
        }

        int courseId =
                Integer.parseInt(
                        courseIdField.getText()
                );

        String courseName =
                courseNameField.getText();

        String instructor =
                instructorField.getText();

        String schedule =
                scheduleField.getText();

        /*
         * CREATE COURSE OBJECT
         */
        Course course = new Course(courseId,

                courseName,

                instructor,

                schedule
        );

        /*
         * ADD TO DATASTORE
         */
        DataStore.getInstance()
                .addCourse(course);

        /*
         * ADD TO TABLE
         */
        model.addRow(new Object[]{

                course.getCourseId(),

                course.getCourseName(),

                course.getInstructor(),

                course.getSchedule()
        });

        clearFields();

        JOptionPane.showMessageDialog(
                this,
                "Course added successfully"
        );
    }

    /*
     * ===== UPDATE COURSE =====
     */
    private void updateCourse() {

        int row = table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a course first"
            );

            return;
        }

        model.setValueAt(

                courseNameField.getText(),

                row,

                1
        );

        model.setValueAt(

                instructorField.getText(),

                row,

                2
        );

        model.setValueAt(

                scheduleField.getText(),

                row,

                3
        );

        JOptionPane.showMessageDialog(
                this,
                "Course updated"
        );
    }

    /*
     * ===== DELETE COURSE =====
     */
    private void deleteCourse() {

        int row = table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a course first"
            );

            return;
        }

        model.removeRow(row);

        JOptionPane.showMessageDialog(
                this,
                "Course deleted"
        );
    }

    /*
     * ===== VALIDATION =====
     */
    private boolean validateForm() {

        if(courseIdField.getText()
                .trim()
                .isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Course ID required"
            );

            return false;
        }

        if(courseNameField.getText()
                .trim()
                .isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Course name required"
            );

            return false;
        }

        return true;
    }

    /*
     * ===== CLEAR FIELDS =====
     */
    private void clearFields() {

        courseIdField.setText("");

        courseNameField.setText("");

        instructorField.setText("");

        scheduleField.setText("");
    }

    /*
     * ===== LOAD SAVED COURSES =====
     */
    private void loadCourses() {

        for(Course course :
                DataStore.getInstance()
                        .getCourses()) {

            model.addRow(new Object[]{

                    course.getCourseId(),

                    course.getCourseName(),

                    course.getInstructor(),

                    course.getSchedule()
            });
        }
    }
}