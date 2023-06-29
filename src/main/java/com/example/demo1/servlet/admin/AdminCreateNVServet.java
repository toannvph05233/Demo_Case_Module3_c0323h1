package com.example.demo1.servlet.admin;

import com.example.demo1.dao.NhanVienDAO;
import com.example.demo1.model.NhanVien;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/createNV")
public class AdminCreateNVServet extends HttpServlet {
    NhanVienDAO nhanVienDAO = new NhanVienDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        nhanVienDAO.save(new NhanVien(0,name, img));
        resp.sendRedirect("/admin");

    }
}
