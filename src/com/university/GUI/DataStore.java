//package com.university.GUI;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import java.io.*;
//import java.nio.file.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class DataStore {
//
//    // ── Data directory (next to the JAR / project root) ──────────────────────
//    private static final String DATA_DIR = "data";
//    private static final String STUDENTS_FILE  = DATA_DIR + "/students.json";
//    private static final String COURSES_FILE   = DATA_DIR + "/courses.json";
//    private static final String TIMETABLE_FILE = DATA_DIR + "/timetable.json";
//
//    // ── In-memory lists ───────────────────────────────────────────────────────
//    private static List<String[]> students  = new ArrayList<>();
//    private static List<String[]> courses   = new ArrayList<>();
//    private static List<String[]> timetable = new ArrayList<>();
//
//    // ══════════════════════════════════════════════════════════════════════════
//    //  BOOT
//    // ══════════════════════════════════════════════════════════════════════════
//
//    static {
//        ensureDir();
//        loadAll();
//    }
//
//    private static void ensureDir() {
//        new File(DATA_DIR).mkdirs();
//    }
//
//    public static void loadAll() {
//        students  = loadJson(STUDENTS_FILE,  3);   // id, name, dept
//        courses   = loadJson(COURSES_FILE,   4);   // code, title, teacher, time
//        timetable = loadJson(TIMETABLE_FILE, 5);   // code, title, teacher, room, time
//    }
//
//    // ══════════════════════════════════════════════════════════════════════════
//    //  STUDENTS
//    // ══════════════════════════════════════════════════════════════════════════
//
//    public static List<String[]> getStudents() { return students; }
//
//    @SuppressWarnings("unchecked")
//    public static void addStudent(String id, String name, String dept) {
//        students.add(new String[]{id, name, dept});
//        saveJson(STUDENTS_FILE, students);
//    }
//
//    public static void updateStudent(int index, String id, String name, String dept) {
//        if (index >= 0 && index < students.size()) {
//            students.set(index, new String[]{id, name, dept});
//            saveJson(STUDENTS_FILE, students);
//        }
//    }
//
//    public static void deleteStudent(int index) {
//        if (index >= 0 && index < students.size()) {
//            students.remove(index);
//            saveJson(STUDENTS_FILE, students);
//        }
//    }
//
//    // ══════════════════════════════════════════════════════════════════════════
//    //  COURSES
//    // ══════════════════════════════════════════════════════════════════════════
//
//    public static List<String[]> getCourses() { return courses; }
//
//    public static void addCourse(String code, String title, String teacher, String time) {
//        courses.add(new String[]{code, title, teacher, time});
//        saveJson(COURSES_FILE, courses);
//    }
//
//    public static void updateCourse(int index, String code, String title, String teacher, String time) {
//        if (index >= 0 && index < courses.size()) {
//            courses.set(index, new String[]{code, title, teacher, time});
//            saveJson(COURSES_FILE, courses);
//        }
//    }
//
//    public static void deleteCourse(int index) {
//        if (index >= 0 && index < courses.size()) {
//            courses.remove(index);
//            saveJson(COURSES_FILE, courses);
//        }
//    }
//
//    // ══════════════════════════════════════════════════════════════════════════
//    //  TIMETABLE
//    // ══════════════════════════════════════════════════════════════════════════
//
//    public static List<String[]> getTimetable() { return timetable; }
//
//    public static void addTimetable(String code, String title, String teacher, String room, String time) {
//        timetable.add(new String[]{code, title, teacher, room, time});
//        saveJson(TIMETABLE_FILE, timetable);
//    }
//
//    public static void updateTimetable(int index, String code, String title, String teacher, String room, String time) {
//        if (index >= 0 && index < timetable.size()) {
//            timetable.set(index, new String[]{code, title, teacher, room, time});
//            saveJson(TIMETABLE_FILE, timetable);
//        }
//    }
//
//    public static void deleteTimetable(int index) {
//        if (index >= 0 && index < timetable.size()) {
//            timetable.remove(index);
//            saveJson(TIMETABLE_FILE, timetable);
//        }
//    }
//
//    // ══════════════════════════════════════════════════════════════════════════
//    //  JSON I/O  (using javax.json via hand-rolled reader for zero-dep build)
//    // ══════════════════════════════════════════════════════════════════════════
//
//    /** Save list-of-string-arrays as a JSON array of arrays. */
//    @SuppressWarnings("unchecked")
//    private static void saveJson(String path, List<String[]> data) {
//        StringBuilder sb = new StringBuilder("[\n");
//        for (int i = 0; i < data.size(); i++) {
//            sb.append("  [");
//            String[] row = data.get(i);
//            for (int j = 0; j < row.length; j++) {
//                sb.append("\"").append(escape(row[j])).append("\"");
//                if (j < row.length - 1) sb.append(", ");
//            }
//            sb.append("]");
//            if (i < data.size() - 1) sb.append(",");
//            sb.append("\n");
//        }
//        sb.append("]");
//        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
//            pw.print(sb);
//        } catch (IOException e) {
//            System.err.println("DataStore save error: " + e.getMessage());
//        }
//    }
//
//    /** Load JSON array-of-arrays. Falls back to empty list on any error. */
//    private static List<String[]> loadJson(String path, int expectedCols) {
//        List<String[]> result = new ArrayList<>();
//        File f = new File(path);
//        if (!f.exists()) return result;
//        try {
//            String raw = new String(Files.readAllBytes(f.toPath())).trim();
//            if (raw.isEmpty() || raw.equals("[]")) return result;
//            // minimal hand-rolled parser
//            raw = raw.substring(1, raw.length() - 1).trim(); // strip outer []
//            // split rows by ], [
//            String[] rows = raw.split("\\],\\s*\\[");
//            for (String row : rows) {
//                row = row.replaceAll("^\\[|\\]$", "").trim();
//                String[] cells = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//                String[] arr = new String[cells.length];
//                for (int i = 0; i < cells.length; i++) {
//                    arr[i] = cells[i].trim().replaceAll("^\"|\"$", "").replace("\\\"", "\"").replace("\\n", "\n");
//                }
//                result.add(arr);
//            }
//        } catch (Exception e) {
//            System.err.println("DataStore load error (" + path + "): " + e.getMessage());
//        }
//        return result;
//    }
//
//    private static String escape(String s) {
//        if (s == null) return "";
//        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
//    }
//}
