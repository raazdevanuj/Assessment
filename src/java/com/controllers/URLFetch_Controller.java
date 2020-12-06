package com.controllers;

import com.beans.users;
import com.daos.users_queryDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class URLFetch_Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String url = request.getParameter("URL");
        // System.out.println(url);

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet(url);
        String content = null;
        try {
            Document doc = Jsoup.connect(url).get();
                content= doc.title();
                content+=doc.html();
//                content+=doc.body();
//            HttpResponse httpresponse = httpclient.execute(httpget);
//            HttpEntity entity = httpresponse.getEntity();
//            content = EntityUtils.toString(entity);

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(content==null){
        out.println("<script>alert('Invalid URL');</script>");
        out.println("<script>window.location='URL_fetch.jsp'</script>");
        }else
        {            
         request.setAttribute("url",url);    
        request.setAttribute("server_string", content);
        request.getRequestDispatcher("URL_fetch.jsp").forward(request, response);
       
        
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
