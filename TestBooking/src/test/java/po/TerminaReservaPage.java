package po;

import base.BaseAppium;

public class TerminaReservaPage extends BaseAppium {
	public String cardNumber;
	public String cardPropietario;
	public String cardExpira;
	public Double montoPagar;

	public TerminaReservaPage(String cardNumber, String cardPropietario, String cardExpira, Double montoPagar) {
		super();
		this.cardNumber = cardNumber;
		this.cardPropietario = cardPropietario;
		this.cardExpira = cardExpira;
		this.montoPagar = montoPagar;
	}

}
