package com.university.GUI;

import javax.swing.*;
import java.awt.*;
import com.university.data.PersistenceManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DashboardFrame extends JFrame {



    private final ScheduledExecutorService autoSaveExecutor = Executors.newSingleThreadScheduledExecutor();
    private void startAutoSave() {

        autoSaveExecutor.scheduleAtFixedRate(() -> {

            PersistenceManager.save(DataStore.getInstance());

        }, 5, 5, TimeUnit.MINUTES);
    }
    public DashboardFrame() {

        setTitle("Smart Campus Management System");
        setSize(1400, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(24, 44, 97));
        topPanel.setPreferredSize(new Dimension(100, 80));

        JLabel title = new JLabel(
                "Smart University Campus Management System"
        );

        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        topPanel.add(title, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);

        JButton saveBtn = new JButton("Save Now");
        JButton logoutBtn = new JButton("Logout");

        rightPanel.add(saveBtn);
        rightPanel.add(logoutBtn);

        topPanel.add(rightPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Campus Map", new CampusMapPanel());
        tabs.addTab("Students", new StudentPanel());
        tabs.addTab("Courses", new CoursePanel());
        tabs.addTab("Facilities", new FacilityPanel());
        tabs.addTab("Timetable & Reports", new TimetableReportPanel());

        add(tabs, BorderLayout.CENTER);

        logoutBtn.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                PersistenceManager.save(DataStore.getInstance());

                autoSaveExecutor.shutdown();
            }
        });

    }
}
