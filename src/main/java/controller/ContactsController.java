package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactsDAO;
import dto.ContactsDTO;

@WebServlet("*.contacts")
public class ContactsController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");

		String cmd = request.getRequestURI();
		System.out.println(cmd);

		ContactsDAO dao = ContactsDAO.getInstance();
		try {
			if(cmd.equals("/save.contacts")){

				String writer = request.getParameter("writer");
				String message = request.getParameter("message");
				dao.insert(new ContactsDTO(null,writer,message));
				response.sendRedirect("/index.jsp");
			}
			else if(cmd.equals("/Output.contacts")){
				java.util.List<ContactsDTO> list = dao.selectAll();
				request.setAttribute("list", list);
			
				
				request.getRequestDispatcher("/outputForm.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.html");
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
