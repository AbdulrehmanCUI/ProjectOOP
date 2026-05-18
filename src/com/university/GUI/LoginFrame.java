package com.university.GUI;

import com.university.Person.SessionManager;
import com.university.Person.UserRole;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JComboBox<String> roleBox;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {

        setTitle("University Management System - Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        roleBox = new JComboBox<>(new String[]{
                "ADMIN",
                "TEACHER",
                "STUDENT"
        });

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> login());

        panel.add(new JLabel("Username"));
        panel.add(usernameField);

        panel.add(new JLabel("Password"));
        panel.add(passwordField);

        panel.add(new JLabel("Role"));
        panel.add(roleBox);

        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
    }

    private void login() {

        String role = roleBox.getSelectedItem().toString();

        SessionManager.login(UserRole.valueOf(role));

        DashboardFrame dashboard = new DashboardFrame();
        dashboard.setVisible(true);

        dispose();
    }
}
