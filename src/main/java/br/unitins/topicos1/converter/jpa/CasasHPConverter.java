package br.unitins.topicos1.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.topicos1.lanch.model.CasasHP;

@Converter(autoApply = true)
public class CasasHPConverter implements AttributeConverter<CasasHP, Integer> {

	@Override
	public Integer convertToDatabaseColumn(CasasHP casasHP) {
		return casasHP.getId();
	}

	@Override
	public CasasHP convertToEntityAttribute(Integer id) {
		return CasasHP.valueOf(id);
	}

}
