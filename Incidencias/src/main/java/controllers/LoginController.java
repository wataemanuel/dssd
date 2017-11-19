package controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import misClases.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import clasesDAO.UsuarioDAO;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(Map<String, Object> model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Object usr = session.getAttribute("usuario");
		if (usr == null) {
			Usuario usuario = new Usuario();
			model.put("usuarioForm", usuario);
			return "login";
		} else {
			return "backendUsuario";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute("usuarioForm") Usuario usuarioForm,
		BindingResult result, Map<String, Object> model, HttpServletRequest request) {
		if (result.hasErrors())
			return new ModelAndView("forward:/index.jsp");
		else {
			HttpSession session = request.getSession(true);
			//Object attribute = session.getAttribute("user");
			if (usuarioDAO.existeUsuario(usuarioForm.getEmail(), usuarioForm.getPassword())) {
				Usuario u = usuarioDAO.recuperarUsuario(usuarioForm.getEmail(), usuarioForm.getPassword());
				session.setAttribute("usuario", u);
				session.setAttribute("id", u.getId());
				session.setAttribute("permiso", false);
				return new ModelAndView("redirect:backendUsuario");
			}
			else {
				return new ModelAndView("login", "mensaje", "hola");
			}
		}
	}

	@RequestMapping("logout")
	public ModelAndView logout(Map<String, Object> model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return new ModelAndView("forward:/index.jsp");
	}
	
	@RequestMapping("home")
	public ModelAndView home(Map<String, Object> model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return new ModelAndView("redirect:backendUsuario");
		}
		else {
			return new ModelAndView("forward:/index.jsp");
		}
	}

}