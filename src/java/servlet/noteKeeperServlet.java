package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.note;

public class noteKeeperServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = "";
        String contents = "";
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
// to read files
         BufferedReader br = new BufferedReader(new FileReader(new File(path)));
         note note = new note(br.readLine(),br.readLine());
         request.setAttribute("note", note);
         br.close();
         String edit = request.getParameter("edit");
        if (edit != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }
        else{
              getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        }
      
   }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String path;
        path = getServletContext().getRealPath("/WEB-INF/note.txt");
       
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
   
        String changedTitle = request.getParameter("title");
    
        String changedContents = request.getParameter("contents");
         note note = new note(changedTitle,changedContents);
       
         if (changedTitle != null || changedContents != null) {
            request.setAttribute("note",note);
            pw.println(changedTitle);
            pw.println(changedContents);
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
   
        }
     pw.close();
   
    }
      
}
