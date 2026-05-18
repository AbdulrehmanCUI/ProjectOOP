package com.university.Person;

public class SessionManager {

    private static String currentRole;

    public static void login(String role) {

        currentRole = role;
    }

    public static String getCurrentRole() {

        return currentRole;
    }

    public static boolean isAdmin() {

        return UserRole.ADMIN.equals(currentRole);
    }

    public static boolean isTeacher() {

        return UserRole.TEACHER.equals(currentRole);
    }

    public static boolean isStudent() {

        return UserRole.STUDENT.equals(currentRole);
    }
}