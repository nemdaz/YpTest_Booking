package po;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.BaseAppium;
import io.appium.java_client.AppiumBy;

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
	
	public ReservaHabitacionPage() {
		
	}
	
	public void iniciamosReserva(String btnAction) {
		System.out.println("Iniciamos proceso de reserva");
		
		List<WebElement> botones = adriver.findElements(AppiumBy.className("android.widget.Button"));
		for (WebElement btn : botones) {
			System.out.print("\nBotones: " + btn.getText());
			if(btn.getText().contains(btnAction) || btnAction.contains(btn.getText())) {
				System.out.print(" ... Click");
				btn.click();
				break;
			}
		}
	}
	
	public void ingresamosDatosReserva() {
		System.out.println("Ingresamos los datos de reserva");
		//Nombre
		WebElement nombreEle = adriver.findElement(AppiumBy.id("com.booking:id/bstage1_contact_firstname_value"));
		WebElement nombreIpt = nombreEle.findElement(AppiumBy.id("com.booking:id/bui_input_container_background"));
		//nombreIpt.sendKeys(this.cliNombres); // No funciona, input seguros por codigo del APK
	}

}
