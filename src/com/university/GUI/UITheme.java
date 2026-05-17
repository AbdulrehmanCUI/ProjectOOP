package com.university.GUI;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * Central UI theme constants and factory helpers.
 * Every panel imports this so colours / fonts stay consistent.
 */
public class UITheme {

    // ── Palette ───────────────────────────────────────────────────────────────
    public static final Color PRIMARY       = new Color(26, 54, 120);
    public static final Color PRIMARY_DARK  = new Color(15, 35, 85);
    public static final Color PRIMARY_LIGHT = new Color(63, 97, 175);
    public static final Color ACCENT        = new Color(0, 168, 150);
    public static final Color ACCENT_HOVER  = new Color(0, 195, 175);
    public static final Color DANGER        = new Color(220, 53, 69);
    public static final Color DANGER_HOVER  = new Color(185, 28, 48);
    public static final Color SUCCESS       = new Color(40, 167, 69);
    public static final Color WARNING       = new Color(255, 193, 7);

    public static final Color BG_APP        = new Color(240, 243, 249);
    public static final Color BG_CARD       = Color.WHITE;
    public static final Color BG_SIDEBAR    = new Color(22, 42, 100);

    public static final Color TEXT_PRIMARY   = new Color(30, 40, 60);
    public static final Color TEXT_SECONDARY = new Color(100, 115, 140);
    public static final Color TEXT_LIGHT     = new Color(200, 210, 230);
    public static final Color BORDER_COLOR   = new Color(220, 226, 240);

    // ── Fonts ─────────────────────────────────────────────────────────────────
    public static final Font FONT_TITLE    = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font FONT_SUBTITLE = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font FONT_BODY     = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_SMALL    = new Font("Segoe UI", Font.PLAIN, 11);
    public static final Font FONT_MONO     = new Font("Consolas", Font.PLAIN, 13);

    // ── Field height ──────────────────────────────────────────────────────────
    public static final int FIELD_H = 36;

    // ══════════════════════════════════════════════════════════════════════════
    //  FACTORY HELPERS
    // ══════════════════════════════════════════════════════════════════════════

    /** Rounded card panel with shadow-like border. */
    public static JPanel card(LayoutManager layout) {
        JPanel p = new JPanel(layout);
        p.setBackground(BG_CARD);
        p.setBorder(new CompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(16, 16, 16, 16)
        ));
        return p;
    }

    /** Section heading label. */
    public static JLabel heading(String text) {
        JLabel l = new JLabel(text);
        l.setFont(FONT_TITLE);
        l.setForeground(TEXT_PRIMARY);
        return l;
    }

    /** Smaller sub-section label. */
    public static JLabel subHeading(String text) {
        JLabel l = new JLabel(text);
        l.setFont(FONT_SUBTITLE);
        l.setForeground(TEXT_PRIMARY);
        return l;
    }

    /** Styled text field. */
    public static JTextField field() {
        JTextField f = new JTextField();
        styleField(f);
        return f;
    }

    public static void styleField(JComponent f) {
        f.setFont(FONT_BODY);
        f.setForeground(TEXT_PRIMARY);
        f.setBackground(new Color(248, 249, 252));
        f.setBorder(new CompoundBorder(
                new LineBorder(BORDER_COLOR, 1, true),
                new EmptyBorder(4, 10, 4, 10)
        ));
        f.setPreferredSize(new Dimension(200, FIELD_H));
    }

    /** Primary action button. */
    public static JButton primaryButton(String text) {
        return styledButton(text, ACCENT, Color.WHITE, ACCENT_HOVER);
    }

    /** Danger (delete) button. */
    public static JButton dangerButton(String text) {
        return styledButton(text, DANGER, Color.WHITE, DANGER_HOVER);
    }

    /** Neutral / secondary button. */
    public static JButton secondaryButton(String text) {
        return styledButton(text, new Color(108, 117, 140), Color.WHITE, new Color(85, 93, 115));
    }

    private static JButton styledButton(String text, Color bg, Color fg, Color hover) {
        JButton b = new JButton(text);
        b.setBackground(bg);
        b.setForeground(fg);
        b.setFont(new Font("Segoe UI", Font.BOLD, 12));
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setPreferredSize(new Dimension(100, 34));
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { b.setBackground(hover); }
            public void mouseExited(java.awt.event.MouseEvent e)  { b.setBackground(bg); }
        });
        return b;
    }

    /** Styled table (no default grid colour, alternating rows handled via renderer). */
    public static void styleTable(JTable t) {
        t.setFont(FONT_BODY);
        t.setRowHeight(34);
        t.setGridColor(BORDER_COLOR);
        t.setShowVerticalLines(false);
        t.setFillsViewportHeight(true);
        t.setSelectionBackground(new Color(63, 97, 175, 60));
        t.setSelectionForeground(TEXT_PRIMARY);
        t.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        t.getTableHeader().setBackground(PRIMARY);
        t.getTableHeader().setForeground(Color.WHITE);
        t.getTableHeader().setReorderingAllowed(false);
        t.getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        t.setDefaultRenderer(Object.class, new StripedRenderer());
    }

    /** Styled scroll pane. */
    public static JScrollPane scrollPane(Component c) {
        JScrollPane sp = new JScrollPane(c);
        sp.setBorder(new LineBorder(BORDER_COLOR, 1));
        sp.getViewport().setBackground(BG_CARD);
        return sp;
    }

    /** Titled section border. */
    public static Border sectionBorder(String title) {
        TitledBorder tb = BorderFactory.createTitledBorder(
                new LineBorder(BORDER_COLOR, 1, true), "  " + title + "  ");
        tb.setTitleFont(new Font("Segoe UI", Font.BOLD, 12));
        tb.setTitleColor(PRIMARY);
        return new CompoundBorder(tb, new EmptyBorder(8, 8, 8, 8));
    }

    /** Show a styled info/error dialog. */
    public static void info(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Info",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void error(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    public static boolean confirm(Component parent, String msg) {
        return JOptionPane.showConfirmDialog(parent, msg, "Confirm",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    // ── Alternating-row table renderer ────────────────────────────────────────
    public static class StripedRenderer extends javax.swing.table.DefaultTableCellRenderer {
        private static final Color ODD  = Color.WHITE;
        private static final Color EVEN = new Color(246, 248, 253);

        @Override
        public Component getTableCellRendererComponent(
                JTable t, Object val, boolean sel, boolean foc, int row, int col) {
            super.getTableCellRendererComponent(t, val, sel, foc, row, col);
            setBorder(new EmptyBorder(0, 8, 0, 8));
            if (!sel) setBackground(row % 2 == 0 ? ODD : EVEN);
            return this;
        }
    }
}
