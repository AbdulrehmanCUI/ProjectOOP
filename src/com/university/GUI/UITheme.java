package com.university.GUI;

import java.awt.*;

public class UITheme {

    /*
     * MAIN COLORS
     */
    public static final Color PRIMARY =
            new Color(30, 58, 95);

    public static final Color SECONDARY =
            new Color(59, 130, 246);

    public static final Color BACKGROUND =
            new Color(244, 247, 250);

    public static final Color CARD =
            Color.WHITE;

    public static final Color SUCCESS =
            new Color(34, 197, 94);

    public static final Color DANGER =
            new Color(220, 38, 38);

    public static final Color TEXT =
            new Color(33, 37, 41);

    /*
     * FONTS
     */
    public static final Font TITLE_FONT =
            new Font(
                    "SansSerif",
                    Font.BOLD,
                    24
            );

    public static final Font HEADER_FONT =
            new Font(
                    "SansSerif",
                    Font.BOLD,
                    18
            );

    public static final Font NORMAL_FONT =
            new Font(
                    "SansSerif",
                    Font.PLAIN,
                    14
            );

    /*
     * BUTTON STYLE
     */
    public static void styleButton(Button button) {

        button.setBackground(PRIMARY);

        button.setForeground(Color.WHITE);

        button.setFont(NORMAL_FONT);
    }
}