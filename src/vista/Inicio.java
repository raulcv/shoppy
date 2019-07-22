package vista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession sesion = request.getSession();
		if(sesion.getAttribute("moneda")==null){
			sesion.setAttribute("moneda", "PEN");
			sesion.setAttribute("nom_moneda", "$ Soles Peruanos");
		}
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
}
