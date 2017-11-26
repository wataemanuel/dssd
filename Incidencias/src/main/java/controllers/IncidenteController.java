package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import misClases.ObjetoInd;
import misClases.Usuario;
import misClases.Incidente;
import misClases.TipoIncidente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import clasesDAO.EstadoDAO;
import clasesDAO.IncidenteDAO;
import clasesDAO.TipoIncidenteDAO;
import clasesDAO.UsuarioDAO;

@Controller
public class IncidenteController {
	
	@Autowired
	private IncidenteDAO incidenteDAO;
	
	@Autowired
	private TipoIncidenteDAO tipoIncidenteDAO;
	
	@Autowired
	private EstadoDAO estadoDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	private List<ObjetoInd> objetos;

	public IncidenteDAO getIncidenteDAO() {
		return incidenteDAO;
	}

	public void setIncidenteDAO(IncidenteDAO incidenteDAO) {
		this.incidenteDAO = incidenteDAO;
	}

	@RequestMapping("altaIncidente")
    public ModelAndView altaIncidente(Map<String, Object> model) {
		Incidente incidente = new Incidente();
    	objetos = new ArrayList<ObjetoInd>();
		List<TipoIncidente> tipoIncidenteList = tipoIncidenteDAO.recuperarTodos();
		model.put("tipoIncidenteList", tipoIncidenteList);
		model.put("incidenteForm", incidente);
        return new ModelAndView("altaIncidente");
    }
	
	@RequestMapping("guardarIncidente")
    public ModelAndView guardarIncidente(@ModelAttribute Incidente incidenteForm, HttpServletRequest request) {
    	// Si el id es 0 entonces se crea, de lo contrario se actualiza
        if(incidenteForm.getId() == null ){ 
        	incidenteForm.setFechaExpediente(new Date());
        	Usuario usr = (Usuario) request.getSession(true).getAttribute("usuario");
    		usr = usuarioDAO.recuperar(usr.getId());
    		incidenteForm.setUsuario(usr);
        	incidenteForm.setEstado(estadoDAO.recuperar(new Long(1)));
        	/*for(ObjetoInd o : objetos) {
        		System.out.println(o.getNombre());
        		System.out.println(o.getCantidad());
        		System.out.println(o.getDesripcion());
        	}*/
        	incidenteForm.setObjetos(objetos);
        	incidenteDAO.persistir(incidenteForm);
        } else {
        	incidenteDAO.actualizar(incidenteForm);
        }
        return new ModelAndView("redirect:backendUsuario");
    }
	
	@RequestMapping("listaIncidentes")
    public ModelAndView listaIncidentes(Map<String, Object> model, HttpServletRequest request) {
		Usuario usr = (Usuario) request.getSession(true).getAttribute("usuario");
		List<Incidente> incidenteList = usuarioDAO.recuperarIncidentes(usr.getId());
		model.put("incidenteList", incidenteList);
        return new ModelAndView("listaIncidentes");
    }
	
	@RequestMapping("agregarObjetos")
	public void agregarObjetos(@RequestParam String nom, @RequestParam int cant, @RequestParam String desc) {
		objetos.add(new ObjetoInd(nom, cant, desc));
	}

	@ModelAttribute("objetos")
	public List<ObjetoInd> getObjetos() {
		return objetos;
	}
	
}