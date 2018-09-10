package java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.dominio.Usuario;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if (login.equals("admin") && senha.equals("senha")) {
			Usuario u = new Usuario(login, senha);
			request.getSession().setAttribute("usuario", u);
			
			response.sendRedirect("/Series/interna/cadastro.html");
		} else {
			String mensagem = "<html>" +
					"<body>" +
					"<h2>Erro</h2>" +
					"</body>" +
					"</html>";
				
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(mensagem);
		}
	}
}