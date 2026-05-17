package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {

        setTitle("University Login");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel heading = new JLabel(
                "Campus Login System",
                SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 28));

        add(heading, BorderLayout.NORTH);

        panel.add(new JLabel("Username"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        panel.add(loginBtn);

        add(panel, BorderLayout.CENTER);

        loginBtn.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("admin123")) {

            JOptionPane.showMessageDialog(this,
                    "Admin Login Successful");

            new DashboardFrame();
            dispose();
        }

        else if (username.equals("teacher") &&
                password.equals("teacher123")) {

            JOptionPane.showMessageDialog(this,
                    "Teacher Login Successful");

            new DashboardFrame();
            dispose();
        }

        else if (username.equals("student") &&
                password.equals("student123")) {

            JOptionPane.showMessageDialog(this,
                    "Student Login Successful");

            new DashboardFrame();
            dispose();
        }

        else {
            JOptionPane.showMessageDialog(this,
                    "Invalid Credentials");
        }
    }
}
