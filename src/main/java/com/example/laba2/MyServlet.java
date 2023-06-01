package com.example.laba2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class MyServlet extends HttpServlet {

    private List<Student> students = new ArrayList<Student>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray jsonArray = new JSONArray(students);
        PrintWriter out = response.getWriter();
        out.print(jsonArray.toString());
        out.flush();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonString = request.getParameter("jsonString");
        if (jsonString != null && !jsonString.isEmpty()) {
            // обрабатываем значение jsonString только если оно не null и не пустое
            writeJsonToFile(jsonString);
            JSONObject jsonObject = new JSONObject(jsonString);
            Student student = new Student(jsonObject.getString("firstName"), jsonObject.getString("lastName"), jsonObject.getString("email"),
                    jsonObject.getInt("age"), jsonObject.getString("phone"));
            students.add(student);
            PrintWriter out = response.getWriter();
            out.print(student.toString());
            out.flush();
        } else {
            // выводим сообщение об ошибке, если значение jsonString равно null или пусто
            PrintWriter out = response.getWriter();
            out.print("Error: jsonString is null or empty");
            out.flush();
        }
    }



    private void writeJsonToFile(String jsonString) {
        try {
            File file = new File("students.json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonString);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static class Student {
        private String firstName;
        private String lastName;
        private String email;
        private int age;
        private String phone;

        public Student(String firstName, String lastName, String email, int age, String phone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.age = age;
            this.phone = phone;
        }
    }
}


