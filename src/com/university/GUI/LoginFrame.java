package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {

        // =========================
        // FRAME SETTINGS
        // =========================

        setTitle("Smart Campus Management System");

        setSize(430, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // =========================
        // TOP PANEL
        // =========================

        JPanel topPanel = new JPanel();

        topPanel.setBackground(
                new Color(24, 44, 97)
        );

        topPanel.setPreferredSize(
                new Dimension(430, 70)
        );

        topPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        20
                )
        );

        JLabel title = new JLabel(
                "SMART CAMPUS MANAGEMENT SYSTEM"
        );

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font(
                        "Times New Roman",
                        Font.BOLD,
                        15
                )
        );

        topPanel.add(title);

        add(topPanel, BorderLayout.NORTH);

        // =========================
        // CENTER PANEL
        // =========================

        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(null);

        centerPanel.setBackground(
                new Color(245, 247, 250)
        );

        // =========================
        // LOGIN TITLE
        // =========================

        JLabel loginTitle = new JLabel(
                "LOGIN PORTAL"
        );

        loginTitle.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        17
                )
        );

        loginTitle.setForeground(
                new Color(24, 44, 97)
        );

        loginTitle.setBounds(
                130,
                15,
                200,
                22
        );

        centerPanel.add(loginTitle);

        // =========================
        // USERNAME LABEL
        // =========================

        JLabel usernameLabel = new JLabel(
                "Username"
        );

        usernameLabel.setFont(
                new Font(
                        "Times New Roman",
                        Font.PLAIN,
                        12
                )
        );

        usernameLabel.setBounds(
                70,
                60,
                100,
                20
        );

        centerPanel.add(usernameLabel);

        // =========================
        // USERNAME FIELD
        // =========================

        usernameField = new JTextField();

        usernameField.setBounds(
                70,
                82,
                260,
                28
        );

        usernameField.setFont(
                new Font(
                        "Times New Roman",
                        Font.PLAIN,
                        12
                )
        );

        centerPanel.add(usernameField);

        // =========================
        // PASSWORD LABEL
        // =========================

        JLabel passwordLabel = new JLabel(
                "Password"
        );

        passwordLabel.setFont(
                new Font(
                        "Times New Roman",
                        Font.PLAIN,
                        12
                )
        );

        passwordLabel.setBounds(
                70,
                120,
                100,
                20
        );

        centerPanel.add(passwordLabel);

        // =========================
        // PASSWORD FIELD
        // =========================

        passwordField = new JPasswordField();

        passwordField.setBounds(
                70,
                142,
                260,
                28
        );

        passwordField.setFont(
                new Font(
                        "Times New Roman",
                        Font.PLAIN,
                        12
                )
        );

        centerPanel.add(passwordField);

        // =========================
        // LOGIN BUTTON
        // =========================

        JButton loginBtn = new JButton(
                "LOGIN"
        );

        loginBtn.setBounds(
                70,
                190,
                260,
                34
        );

        loginBtn.setBackground(
                new Color(24, 44, 97)
        );

        loginBtn.setForeground(
                Color.WHITE
        );

        loginBtn.setFocusPainted(false);

        loginBtn.setBorderPainted(false);

        loginBtn.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        centerPanel.add(loginBtn);

        // =========================
        // BUTTON HOVER EFFECT
        // =========================

        loginBtn.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    public void mouseEntered(
                            java.awt.event.MouseEvent evt
                    ) {

                        loginBtn.setBackground(
                                new Color(40, 60, 130)
                        );
                    }

                    public void mouseExited(
                            java.awt.event.MouseEvent evt
                    ) {

                        loginBtn.setBackground(
                                new Color(24, 44, 97)
                        );
                    }
                }
        );

        // =========================
        // DEMO ACCOUNTS
        // =========================

        JLabel demoLabel = new JLabel(

                "<html>" +

                        "<div style='font-size:10px; line-height:1.4'>" +

                        "<b>Demo Accounts</b><br><br>" +

                        "<table style='width:260px'>" +

                        "<tr>" +

                        "<td valign='top'>" +

                        "<b>Admin</b><br>" +
                        "Username: admin<br>" +
                        "Password: admin123" +

                        "</td>" +

                        "<td valign='top'>" +

                        "<b>Student</b><br>" +
                        "Username: student<br>" +
                        "Password: stud123" +

                        "</td>" +

                        "</tr>" +

                        "</table>" +

                        "<br>" +

                        "<b>Teacher</b><br>" +
                        "Username: teacher<br>" +
                        "Password: teach123" +

                        "</div>" +

                        "</html>"
        );

        demoLabel.setBounds(
                75,
                240,
                280,
                150
        );

        demoLabel.setForeground(
                Color.DARK_GRAY
        );

        demoLabel.setFont(
                new Font(
                        "Times New Roman",
                        Font.PLAIN,
                        11
                )
        );

        centerPanel.add(demoLabel);

        add(centerPanel, BorderLayout.CENTER);

        // =========================
        // LOGIN ACTION
        // =========================

        loginBtn.addActionListener(
                e -> login()
        );

        setVisible(true);
    }

    // =========================
    // LOGIN METHOD
    // =========================

    private void login() {

        String username =
                usernameField.getText();

        String password =
                new String(
                        passwordField.getPassword()
                );

        // ADMIN LOGIN
        if (username.equals("admin")
                &&
                password.equals("admin123")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Admin Login Successful"
            );

            new DashboardFrame();

            dispose();
        }

        // TEACHER LOGIN
        else if (username.equals("teacher")
                &&
                password.equals("teach123")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Teacher Login Successful"
            );

            new DashboardFrame();

            dispose();
        }

        // STUDENT LOGIN
        else if (username.equals("student")
                &&
                password.equals("stud123")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student Login Successful"
            );

            new DashboardFrame();

            dispose();
        }

        // INVALID LOGIN
        else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password"
            );
        }
    }
}