package com.university.GUI;

import com.university.AcademicUnit.Course;
import com.university.Person.SessionManager;
import com.university.data.DataStore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CoursePanel extends JPanel {

    private JTextField courseIdField;
    private JTextField courseNameField;
    private JTextField instructorField;
    private JTextField scheduleField;
   // Table
    private JTable table;
    private DefaultTableModel model;

   // Button
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;

    public CoursePanel() {

        setLayout(new BorderLayout(10,10));
// Form Pannel
        JPanel formPanel = new JPanel(
                new GridLayout(4,2,10,10)
        );

        formPanel.setBorder(BorderFactory.createTitledBorder(
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

        // Button pannel
        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add");

        updateButton = new JButton("Update");

        deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);

        buttonPanel.add(updateButton);

        buttonPanel.add(deleteButton);
      //   Table
        model = new DefaultTableModel(

                new String[]{"Course ID", "Course Name", "Instructor", "Schedule"
                },

                0);

        table = new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);


        add(formPanel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);

        add(buttonPanel, BorderLayout.SOUTH);

        // Load saved data
        loadCourses();

        // Button actions
        addButton.addActionListener(
                e -> addCourse()
        );

        updateButton.addActionListener(
                e -> updateCourse()
        );

        deleteButton.addActionListener(
                e -> deleteCourse()
        );

        // Role based access
        if(SessionManager.isStudent()) {

            addButton.setEnabled(false);

            updateButton.setEnabled(false);

            deleteButton.setEnabled(false);
        }

        // Teacher cannot delete
        if(SessionManager.isTeacher()) {

            deleteButton.setEnabled(false);
        }
    }

    // Add course
    private void addCourse() {

        if(!validateForm()) {
            return;
        }

        int courseId = Integer.parseInt(courseIdField.getText()
                );

        String courseName = courseNameField.getText();

        String instructor = instructorField.getText();

        String schedule = scheduleField.getText();


        Course course = new Course(courseId, courseName, instructor, schedule
        );

        // Add to database
        DataStore.getInstance()
                .addCourse(course);

       // Table
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

    // Update course
    private void updateCourse() {

        int row = table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a course first"
            );

            return;
        }

        model.setValueAt(courseNameField.getText(),

                row,

                1
        );

        model.setValueAt(instructorField.getText(),

                row,

                2
        );

        model.setValueAt(scheduleField.getText(),

                row,

                3
        );

        JOptionPane.showMessageDialog(
                this,
                "Course updated"
        );
    }

  // Delete course
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

  // Validation
    private boolean validateForm() {

        if(courseIdField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Course ID required"
            );

            return false;
        }

        if(courseNameField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Course name required"
            );

            return false;
        }

        return true;
    }

    // Clear fields
    private void clearFields() {

        courseIdField.setText("");

        courseNameField.setText("");

        instructorField.setText("");

        scheduleField.setText("");
    }

    // Load saved courses
    private void loadCourses() {

        for(Course course : DataStore.getInstance().getCourses()) {

            model.addRow(new Object[]{

                    course.getCourseId(),

                    course.getCourseName(),

                    course.getInstructor(),

                    course.getSchedule()
            });
        }
    }
}