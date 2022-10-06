package com.itproject.controller;

import com.itproject.variable.RedirectPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = RedirectPage.HOME_SERVLET)
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try{
            req.getRequestDispatcher(RedirectPage.HOME_PAGE).forward(req,resp);
        }catch(Exception e){
            req.getRequestDispatcher(RedirectPage.ERROR_404).forward(req,resp);
        }
    }
}
