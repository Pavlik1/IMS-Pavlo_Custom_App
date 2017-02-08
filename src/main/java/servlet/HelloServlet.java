package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.net.www.http.HttpClient;

import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;  
import java.net.URL;  

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.net.www.http.HttpClient;

import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;  
import java.net.URL;  


@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello heroku get".getBytes());
        out.flush();
        out.close();
    }

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  String url = "http://pavlo-developer-edition.eu2.force.com/sitepostrequest";  
		  URL obj = new URL(url);  
		  HttpURLConnection con = (HttpURLConnection) obj.openConnection();  
		  
		        // Setting basic post request  
		  con.setRequestMethod("POST");  
		  con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
		  
		  String postJsonData = "here";
		  //= "+req.getParameterMap() + ">>> " + req.getReader().readLine() + "end";
		  
		  String inputLine;

		  try {
			  while ((inputLine = req.getReader().readLine()) != null) {
				   postJsonData += inputLine;
			  }
		  }
		  catch (IOException e) {
			  System.err.println("Error: " + e);
		 }
		 
		  // Send post request  
		  con.setDoOutput(true);  
		  DataOutputStream wr = new DataOutputStream(con.getOutputStream());  
		  wr.writeBytes(postJsonData);  
		  wr.flush();  
		  wr.close();  
		  
		  int responseCode = con.getResponseCode();  
		  System.out.println("\nSending 'POST' request to URL : " + url);  
		  System.out.println("Post Data : " + postJsonData);  
		  System.out.println("Response Code : " + responseCode);  
		  
		  BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));  
		  String output;  
		  StringBuffer response = new StringBuffer();  
		  
		  while ((output = in.readLine()) != null) {  
		   response.append(output);  
		  }  
		  in.close();  
		    
		  //printing result from response  
		  System.out.println(response.toString());  
		  
		  res.getWriter().write("Execute");
	}
	
}
