package br.unitins.kaio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.kaio.lanch.model.ModeloEmpresa;
import br.unitins.kaio.lanch.repository.ModeloEmpresaRepository;

@Named
@FacesConverter(forClass = ModeloEmpresa.class)
public class ModeloEmpresaConverter implements Converter<ModeloEmpresa>{

	@Override
	public ModeloEmpresa getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		ModeloEmpresaRepository modeloEmpresa = new ModeloEmpresaRepository();
		return modeloEmpresa.buscarPeloId(Integer.valueOf(value));
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, ModeloEmpresa modeloEmpresa) {
		if (modeloEmpresa == null || modeloEmpresa.getId() == null)
			return null;
		
		return modeloEmpresa.getId().toString();
	}
	
	
	
}

	