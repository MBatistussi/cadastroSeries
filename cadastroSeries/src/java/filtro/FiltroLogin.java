package java.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.dominio.Usuario;


@WebFilter("/interna/*")
public class FiltroLogin implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		Usuario u = (Usuario) req.getSession().getAttribute("usuario");
		if (u == null) {								
			res.sendRedirect("/Series/login.html");	
		} else {
			chain.doFilter(req, res);					
		}
	}

	@Override
	public void destroy() {
	}
}