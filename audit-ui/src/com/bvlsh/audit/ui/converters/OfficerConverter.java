package com.bvlsh.audit.ui.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bvlsh.audit.ui.models.OfficerDTO;
import com.bvlsh.audit.ui.services.UtilService;




@SuppressWarnings("rawtypes")
@FacesConverter("officerConverter")
public class OfficerConverter implements Converter {

	UtilService service = new UtilService();
	
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && !"".equals(value.trim())) {
            try {
            	 int id = Integer.valueOf(value);
                 return service.findOfficerById(id);
            }catch(NumberFormatException ne)
            {
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value != null) {
            return String.valueOf(((OfficerDTO)value).getId());
        }
        return null;

    }
}