package com.university.GUI;

import javax.swing.*;
import java.awt.*;

public class CampusMapPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        setBackground(Color.WHITE);

        g.setFont(new Font("Arial", Font.BOLD, 18));

        // LIBRARY
        g.setColor(Color.GREEN);
        g.fillRect(100, 100, 150, 100);
        g.setColor(Color.BLACK);
        g.drawString("Library", 145, 155);

        // CAFETERIA
        g.setColor(Color.YELLOW);
        g.fillRect(350, 100, 150, 100);
        g.setColor(Color.BLACK);
        g.drawString("Cafeteria", 385, 155);

        // HOSTEL
        g.setColor(Color.CYAN);
        g.fillRect(600, 100, 150, 100);
        g.setColor(Color.BLACK);
        g.drawString("Hostel", 650, 155);

        // TRANSPORT
        g.setColor(Color.RED);
        g.fillRect(220, 320, 180, 100);
        g.setColor(Color.WHITE);
        g.drawString("Transport Service", 240, 375);

        // HEALTH CENTER
        g.setColor(Color.PINK);
        g.fillRect(500, 320, 180, 100);
        g.setColor(Color.BLACK);
        g.drawString("Health Center", 530, 375);
    }
}
