package po;

import base.BaseAppium;

public class ReservaHabitacionPage extends BaseAppium {

	public String cliNombres;
	public String cliApellidos;
	public String cliCorreoE;
	public String cliPaisRegion;
	public String cliNumTelf;
	public String cliProposito;

	public ReservaHabitacionPage(String cliNombres, String cliApellidos, String cliCorreoE, String cliPaisRegion,
			String cliNumTelf, String cliProposito) {
		super();
		this.cliNombres = cliNombres;
		this.cliApellidos = cliApellidos;
		this.cliCorreoE = cliCorreoE;
		this.cliPaisRegion = cliPaisRegion;
		this.cliNumTelf = cliNumTelf;
		this.cliProposito = cliProposito;
	}

}
