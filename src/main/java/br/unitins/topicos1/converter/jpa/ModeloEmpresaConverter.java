package br.unitins.topicos1.converter.jpa;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.topicos1.lanch.model.ModeloEmpresa;
import br.unitins.topicos1.lanch.repository.ModeloEmpresaRepository;

@Named
@FacesConverter(forClass = ModeloEmpresa.class)
public class ModeloEmpresaConverter implements Converter<ModeloEmpresa>{

	@Override
	public ModeloEmpresa getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isBlank())
			return null;
		ModeloEmpresaRepository estado = new ModeloEmpresaRepository();
		return estado.buscarPeloId(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, ModeloEmpresa value) {
		if (value == null || value.getId() == null)
			return null;
		
		return value.getId().toString();
	}
	
	
	
}

	