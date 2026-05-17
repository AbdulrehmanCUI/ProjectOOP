package com.university.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CampusMapPanel extends JPanel {

    public CampusMapPanel() {

        setLayout(null);
        setBackground(new Color(220, 226, 234));

        add(createCard("Computer Science", 40, 60));
        add(createCard("Electrical Eng.", 250, 60));
        add(createCard("Programming Lab", 40, 180));
        add(createCard("Central Library", 250, 180));
        add(createCard("Main Cafeteria", 40, 300));
        add(createCard("Boys Hostel", 250, 300));
        add(createCard("Campus Shuttle", 460, 300));
        add(createCard("Medical Center", 460, 180));
    }

    private JButton createCard(String text, int x, int y) {

        JButton btn = new JButton(text);

        btn.setBounds(x, y, 170, 80);
        btn.setBackground(new Color(76, 175, 80));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(50, 120, 60), 2));

        btn.setToolTipText(text + " - Active");

        btn.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(92, 200, 95));
                btn.setBounds(btn.getX() - 5, btn.getY() - 5, 180, 90);
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(76, 175, 80));
                btn.setBounds(x, y, 170, 80);
            }
        });

        return btn;
    }
}
