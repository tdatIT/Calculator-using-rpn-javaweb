package com.itproject.controller;

import com.itproject.variable.RedirectPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = RedirectPage.CALCULATE_SERVLET)
public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try{

        }catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher(RedirectPage.ERROR_404).forward(req,resp);
        }
    }
}
