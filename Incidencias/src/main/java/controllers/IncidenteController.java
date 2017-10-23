package controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import misClases.Incidente;
import misClases.TipoIncidente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import clasesDAO.IncidenteDAO;
import clasesDAO.TipoIncidenteDAO;

@Controller
public class IncidenteController {
	
	@Autowired
	private IncidenteDAO incidenteDAO;
	
	@Autowired
	private TipoIncidenteDAO tipoIncidenteDAO;

	public IncidenteDAO getIncidenteDAO() {
		return incidenteDAO;
	}

	public void setIncidenteDAO(IncidenteDAO incidenteDAO) {
		this.incidenteDAO = incidenteDAO;
	}

	@RequestMapping("altaIncidente")
    public ModelAndView altaIncidente(Map<String, Object> model) {
		Incidente incidente = new Incidente();
		List<TipoIncidente> tipoIncidenteList = tipoIncidenteDAO.recuperarTodos();
		model.put("tipoIncidenteList", tipoIncidenteList);
		model.put("incidenteForm", incidente);
        return new ModelAndView("altaIncidente");
    }
	
	@RequestMapping("guardarIncidente")
    public ModelAndView guardarIncidente(@ModelAttribute Incidente incidenteForm) {
    	// Si el id es 0 entonces se crea, de lo contrario se actualiza
        if(incidenteForm.getId() == null ){ 
        	incidenteForm.setFechaExpediente(new Date());
        	incidenteForm.setResultado("En proceso");
        	incidenteDAO.persistir(incidenteForm);
        } else {
        	incidenteDAO.actualizar(incidenteForm);
        }
        //return new ModelAndView("redirect:listaUsuarios");
        return new ModelAndView("forward:/");
    }
	
}