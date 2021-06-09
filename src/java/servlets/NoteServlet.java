package servlets;

import domain.Note;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 855474
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String inFile_title = "";
        String inFile_contents = "";
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // Reads the contents of a file
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        // stores the lines of the file
        inFile_title += br.readLine();
        inFile_contents += br.readLine();
        
        Note note = new Note(inFile_title, inFile_contents);
        request.setAttribute("note", note);
        
        String getEdit = request.getParameter("edit");
        if (getEdit != null) {
            // this will display the requested JSP as a view
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }else{
           // this will display the requested JSP as a view
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response); 
        }
        // close the stream
        br.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // Writes content to the file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 

        String title_area = request.getParameter("title_area");
        String content_area = request.getParameter("content_area");
        
        // if inputs are empty, populate with predetermined message
        if(title_area == null || title_area.equals("")){
            title_area = "Please insert title";
        }else if(content_area == null || content_area.equals("")){
            content_area = "Please insert content";
        }
        
        pw.println(title_area);
        pw.println(content_area);
        // close the stream
        pw.close();
        
        Note note = new Note(title_area, content_area);
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
