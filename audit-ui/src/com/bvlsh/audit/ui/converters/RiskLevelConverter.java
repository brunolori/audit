package com.bvlsh.audit.ui.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bvlsh.audit.ui.models.RiskLevelDTO;
import com.bvlsh.audit.ui.services.UtilService;

@SuppressWarnings("rawtypes")
@FacesConverter("riskLevelConverter")
public class RiskLevelConverter implements Converter {

	UtilService service = new UtilService();
	
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && !"".equals(value.trim())) {
            try {
                return service.findRiskLevelByCode(value);
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
            return ((RiskLevelDTO)value).getCode();
        }
        return null;

    }
}