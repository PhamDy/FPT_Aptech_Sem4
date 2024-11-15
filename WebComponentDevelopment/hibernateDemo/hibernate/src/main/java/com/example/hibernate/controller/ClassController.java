package com.example.hibernate.controller;

import com.example.hibernate.entity.Classroom;
import com.example.hibernate.service.ClassroomService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/list-class")
public class ClassController extends HttpServlet {
    private ClassroomService classroomService;

    @Override
    public void init() throws ServletException {
        super.init();
        classroomService = new ClassroomService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null) {
            throw new ServletException("action is null");
        }
        req.getRequestDispatcher("classroom/list.jsp").forward(req, resp);
    }


}