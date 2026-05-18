package com.university.Person;

public class UserRole {

    /*
     * ROLE CONSTANTS
     */
    public static final String ADMIN =
            "ADMIN";

    public static final String TEACHER =
            "TEACHER";

    public static final String STUDENT =
            "STUDENT";

    /*
     * VALIDATE ROLE
     */
    public static String valueOf(
            String role) {

        if(role == null) {

            return STUDENT;
        }

        role = role.trim()
                .toUpperCase();

        switch(role) {

            case "ADMIN":
                return ADMIN;

            case "TEACHER":
                return TEACHER;

            case "STUDENT":
                return STUDENT;

            default:
                return STUDENT;
        }
    }
}