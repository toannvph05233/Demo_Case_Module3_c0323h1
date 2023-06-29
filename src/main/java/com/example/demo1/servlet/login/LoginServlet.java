package com.example.demo1.servlet.login;

import com.example.demo1.dao.LoginDAO;
import com.example.demo1.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    LoginDAO loginDAO = new LoginDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = loginDAO.getLogin(username,password);
        if (account != null){
            // get session by request.
            HttpSession session = req.getSession();
            // add account save in session.
            session.setAttribute("account", account);

            if (account.getRole().equals("user")){
                resp.sendRedirect("/home");
            }else{
                resp.sendRedirect("/admin");
            }
        }
    }
}
