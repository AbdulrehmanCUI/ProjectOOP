    package com.university.GUI;

    import com.university.CampusRepository;
    import com.university.Person.Student;

    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;

    public class StudentPanel extends JPanel{

        private CampusRepository<Student> repo = new CampusRepository<>();

        private JTable table;
        private DefaultTableModel model;

        private JTextField idField = new JTextField();
        private JTextField nameField = new JTextField();
        private JTextField deptField = new JTextField();

        public StudentPanel() {

            setLayout(new BorderLayout());

            // TABLE
            model = new DefaultTableModel(new String[]{"ID", "Name", "Department"}, 0);
            table = new JTable(model);

            add(new JScrollPane(table), BorderLayout.CENTER);

            // FORM
            JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));

            form.add(new JLabel("ID"));
            form.add(idField);

            form.add(new JLabel("Name"));
            form.add(nameField);

            form.add(new JLabel("Department"));
            form.add(deptField);

            JButton addBtn = new JButton("Add");
            JButton updateBtn = new JButton("Update");
            JButton deleteBtn = new JButton("Delete");

            form.add(addBtn);
            form.add(updateBtn);
            form.add(deleteBtn);

            add(form, BorderLayout.SOUTH);

            // LOAD DATA
            refreshTable();

            // ADD
            addBtn.addActionListener(e -> {
                repo.add(new Student(Integer.parseInt(idField.getText()), nameField.getText(), deptField.getText()));
                refreshTable();
            });

            // UPDATE
            updateBtn.addActionListener(e -> {
                repo.update(new Student(Integer.parseInt(idField.getText()), nameField.getText(), deptField.getText()));
                refreshTable();
            });

            // DELETE
            deleteBtn.addActionListener(e -> {
                repo.delete(Integer.parseInt(idField.getText()));
                refreshTable();
            });
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
    }