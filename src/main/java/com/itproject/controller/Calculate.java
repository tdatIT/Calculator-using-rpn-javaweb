package com.itproject.controller;

import com.google.gson.Gson;
import com.itproject.model.CalculatorInfix;
import com.itproject.model.CalculatorPostfix;
import com.itproject.model.CalculatorString;
import com.itproject.variable.RedirectPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = RedirectPage.CALCULATE_SERVLET)
public class Calculate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            String expr = req.getParameter("infix");
            String result = calculate(expr);

            String json = null;
            if (result != null) {
                json = new Gson().toJson(result);
            }
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.println(json);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher(RedirectPage.ERROR_404).forward(req, resp);
        }
    }

    private String calculate(String expr) {
        CalculatorString calStr = new CalculatorString(expr);
        CalculatorInfix calInf = new CalculatorInfix(calStr.calculateResult());
        CalculatorPostfix calPost = new CalculatorPostfix(calInf.calculateResult());

        String result = calPost.calculateResult();
        return result;
    }
}
