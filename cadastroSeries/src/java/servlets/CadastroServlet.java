package java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.dominio.Serie;


@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Serie> series;
       
    public CadastroServlet() {
        super();
        series = new ArrayList<Serie>();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String temporadas = request.getParameter("temporadas");
		
		Serie s = new Serie(titulo, genero, temporadas);
		series.add(s);

		request.getSession().setAttribute("listaSeries", series);

		String mensagem = "<html>" +
			"<body>" +
			"<h2>Serie cadastrada</h2>";
		for (Serie sr : series) {
			mensagem += sr.getTitulo() + "<br/>";
		}
		mensagem += "<br/>Clique <a href=\"http://localhost:8080/Contatos/interna/cadastro.html\">aqui</a> "+
			"para cadastrar uma nova serie" +
			"</body>" +
			"</html>";
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(mensagem);
	}

}