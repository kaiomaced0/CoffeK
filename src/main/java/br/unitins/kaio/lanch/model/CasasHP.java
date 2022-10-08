package br.unitins.kaio.lanch.model;

import br.unitins.kaio.lanch.model.CasasHP;

public enum CasasHP {

	GRIFINORIA(0, "Masculino"), 
	CORVINAL(1, "Feminino"), 
	SONSERINA(2, "Outro"),
	LUFA_LUFA(3, "Lufa-lufa");

	private int id;
	private String label;
	
	CasasHP(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
		
	}
	
	public static CasasHP valueOf(Integer id) {
		if (id == null)
			return null;
		for (CasasHP casasHP : CasasHP.values()) 
			if (casasHP.getId() == id) 
				return casasHP;
		return null;
	}

}
