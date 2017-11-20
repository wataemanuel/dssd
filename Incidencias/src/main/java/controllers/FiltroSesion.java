package controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class filtroSesion
 */
@WebFilter("/FiltroSesion")
public class FiltroSesion implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest) request).getServletPath();
	    if (excludeFromFilter(path)) {
		    chain.doFilter(request, response);
		} else {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession(true);
			Object usr = session.getAttribute("usuario");
			if (usr == null){
				request.getRequestDispatcher("/WEB-INF/pages/errorSesion.jsp").forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private boolean excludeFromFilter(String path) {
		if (path.equals("/") || path.equals("/index.jsp") || path.equals("/login") || path.equals("/altaUsuario") || path.equals("/logout") || path.startsWith("/resources")) return true;
		else return false;
	}
}
