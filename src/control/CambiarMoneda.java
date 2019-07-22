package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CambiarMoneda
 */
@WebServlet("/CambiarMoneda")
public class CambiarMoneda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		if(request.getParameter("moneda")!=null){
			switch (request.getParameter("moneda")) {
			case "USD":
				session.setAttribute("moneda", request.getParameter("moneda"));
				session.setAttribute("nom_moneda", "$ Dolar EE.UU");
				break;	
			case "COP":
				session.setAttribute("moneda", request.getParameter("moneda"));
				session.setAttribute("nom_moneda", "$ Pesos Colombianos");
				break;	
			case "MXN":
				session.setAttribute("moneda", request.getParameter("moneda"));
				session.setAttribute("nom_moneda", "$ Pesos Mexicanos");
				break;						
			default:
				session.setAttribute("moneda", "PEN");
				session.setAttribute("nom_moneda", "$ soles Peruanos");
				break;			
			}
		}
		response.sendRedirect("inicio");
	}

}
