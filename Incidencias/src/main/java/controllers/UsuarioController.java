package controllers;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import clasesDAO.UsuarioDAO;
import misClases.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@RequestMapping("altaUsuario")
    public ModelAndView altaUsuario(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuarioForm", usuario);
        return new ModelAndView("altaUsuario");
    }
	
	@RequestMapping("guardarUsuario")
    public ModelAndView guardarUsuario(@ModelAttribute Usuario usuarioForm) {
    	// Si el id es 0 entonces se crea, de lo contrario se actualiza
        if(usuarioForm.getId() == null ){ 
            usuarioDAO.persistir(usuarioForm);
        } else {
            usuarioDAO.actualizar(usuarioForm);
        }
        //return new ModelAndView("redirect:listaUsuarios");
        return new ModelAndView("forward:/");
    }
	
	@RequestMapping(value = {"backendUsuario"})
	public ModelAndView backendUsuario() {
        return new ModelAndView("backendUsuario");
    }
	
	@RequestMapping(value ="/controlarEmail")
	@ResponseBody
	public String controlarEmail(@RequestParam String email, @RequestParam Long id){
	    	JSONObject result = new JSONObject();
	    	List<Usuario> userList = usuarioDAO.recuperarTodos();
	    	boolean res = false;
	    	if(id != null){
	    		Usuario user = usuarioDAO.recuperar(id);
		    	for(Usuario u : userList){
		    		if ((u.getEmail().equals(email)) && (!(u.getEmail().equals(user.getEmail())))){
		    			res = true;
		    			break;
		    		}
		    	}
	    	} else {
		    	for(Usuario u : userList){
		    		if (u.getEmail().equals(email)){
		    			res = true;
		    			break;
		    		}
		    	}
	    	}
	    	if(res){
	    		result.put("resultado", "encontro");
	    	} else{
	    		result.put("resutlado", "no encontro");
	    	}
	    	return result.toString();
	}
	
	@RequestMapping(value ="/controlarDNI")
	@ResponseBody
	public String controlarDNI(@RequestParam String dni, @RequestParam Long id){
	    	JSONObject result = new JSONObject();
	    	List<Usuario> userList = usuarioDAO.recuperarTodos();
	    	boolean res = false;
	    	if(id != null){
	    		Usuario user = usuarioDAO.recuperar(id);
		    	for(Usuario u : userList){
		    		if ((u.getDni().equals(dni)) && (!(u.getDni().equals(user.getDni())))){
		    			res = true;
		    			break;
		    		}
		    	}
	    	} else {
		    	for(Usuario u : userList){
		    		if (u.getDni().equals(dni)){
		    			res = true;
		    			break;
		    		}
		    	}
	    	}
	    	if(res){
	    		result.put("resultado", "encontro");
	    	} else{
	    		result.put("resutlado", "no encontro");
	    	}
	    	return result.toString();
	}

}
