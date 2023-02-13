package po;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import base.BaseAppium;
import io.appium.java_client.AppiumBy;

public class BuscarHotelPage extends BaseAppium {
	public String destino;
	public Date fecIngreso;
	public Date fecSalida;
	public int cantHabitacion;
	public List<Integer> ninosEdad;

	public BuscarHotelPage(String destino, Date fecIngreso, Date fecSalida, int cantHabitacion,
			List<Integer> ninosEdad) {
		super();
		this.destino = destino;
		this.fecIngreso = fecIngreso;
		this.fecSalida = fecSalida;
		this.cantHabitacion = cantHabitacion;
		this.ninosEdad = ninosEdad;
	}
	
	public BuscarHotelPage(String destino) {
		super();
		this.destino = destino;
	}
	
	public void ingresaDestino() {
		WebElement desLbl = adriver.findElement(AppiumBy.id("com.booking:id/facet_search_box_basic_field_label"));
		desLbl.click();
		WebElement desTxt = adriver.findElement(AppiumBy.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
		desTxt.sendKeys(this.destino);
	}

}
