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
        
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        inFile_title += br.readLine();
        inFile_contents += br.readLine();
        
        Note note = new Note(inFile_title, inFile_contents);
        request.setAttribute("note", note);
        
        String getEdit = request.getParameter("edit");
        if (getEdit != null) {
            // this will display the requested JSP as a view
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
            // this will display the requested JSP as a view
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
        
        br.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
