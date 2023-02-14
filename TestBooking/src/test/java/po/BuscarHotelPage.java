package po;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseAppium;
import io.appium.java_client.AppiumBy;
import utils.UtilDate;
import utils.UtilDelay;
import utils.UtilDriver;

public class BuscarHotelPage extends BaseAppium {
	public String destino;
	public String fecIngreso;
	public String fecSalida;
	public int cantHabitacion;
	public int cantAdultos;
	public List<Integer> ninosEdad;

	public BuscarHotelPage(String destino, String fecIngreso, String fecSalida, int cantHabitacion, int cantAdultos,
			List<Integer> ninosEdad) {
		super();
		this.destino = destino;
		this.fecIngreso = fecIngreso;
		this.fecSalida = fecSalida;
		this.cantHabitacion = cantHabitacion;
		this.cantAdultos = cantAdultos;
		this.ninosEdad = ninosEdad;
	}

	public BuscarHotelPage(String destino) {
		super();
		this.destino = destino;
	}

	public BuscarHotelPage(String fecIngreso, String fecSalida) {
		super();
		this.fecIngreso = fecIngreso;
		this.fecSalida = fecSalida;
	}

	public BuscarHotelPage(int cantHabitacion, int cantAdultos) {
		super();
		this.cantHabitacion = cantHabitacion;
		this.cantAdultos = cantAdultos;
	}

	public void ingresaDestino() {
		// Wait
		UtilDriver.waitUntilVisible("com.booking:id/facet_search_box_cta", 3);

		// Action
		WebElement desLbl = adriver
				.findElement(AppiumBy.id("com.booking:id/facet_search_box_accommodation_destination"));
		desLbl.click();
		WebElement desTxt = adriver
				.findElement(AppiumBy.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
		desTxt.sendKeys(this.destino);
	}

	public void seleccionaOpcionesDestino(int index) {
		// Action
		WebElement optDestinosContainer = adriver
				.findElement(AppiumBy.id("com.booking:id/facet_disambiguation_content"));
		List<WebElement> optDestinos = optDestinosContainer.findElements(AppiumBy.xpath("//android.view.ViewGroup"));
		optDestinos.get(index).click();
	}

	public void seleccionaFechas() {
		String iF = "dd/MM/yyyy";
		String sF = "dd MMMM yyyy";
		String checkin = UtilDate.changeFormat(this.fecIngreso, iF, sF);
		String checkout = UtilDate.changeFormat(this.fecSalida, iF, sF);
		// Action
		UtilDriver.waitUntilVisible("com.booking:id/calendar_month_list", 5);
		
		WebElement calendarioContainer = adriver.findElement(AppiumBy.id("com.booking:id/calendar_month_list"));
		WebElement fechaMesI = calendarioContainer
				.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"" + checkin + "\"]"));
		fechaMesI.click();
		WebElement fechaMesF = calendarioContainer
				.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"" + checkout + "\"]"));
		fechaMesF.click();

		UtilDelay.coolDelay(2000);
		WebElement btnConfirmaFechas = adriver.findElement(AppiumBy.id("com.booking:id/facet_date_picker_confirm"));
		btnConfirmaFechas.click();
	}

	public void seleccionaCantidades() {
		// Action
		WebElement desLbl = adriver.findElement(AppiumBy.id("com.booking:id/facet_search_box_accommodation_occupancy"));
		desLbl.click();

		// Action: Habitacion
		WebElement containerHab = adriver.findElement(AppiumBy.id("com.booking:id/group_config_rooms_count"));
		WebElement cantHab = containerHab.findElement(AppiumBy.id("com.booking:id/bui_input_stepper_value"));
		WebElement cantHabAdd = containerHab.findElement(AppiumBy.id("com.booking:id/bui_input_stepper_remove_button"));
		WebElement cantHabRem = containerHab.findElement(AppiumBy.id("com.booking:id/bui_input_stepper_add_button"));

		System.out.println("Cantidad: " + cantHab.getText());

		int _cantHabitacion = Integer.parseInt(cantHab.getText());

		int intentoClickH = 1;
		while (_cantHabitacion != this.cantHabitacion && intentoClickH < 20) {
			if (_cantHabitacion < this.cantHabitacion) {
				cantHabAdd.click();
			}
			if (_cantHabitacion > this.cantHabitacion) {
				cantHabRem.click();
			}
			intentoClickH++;
		}
		// Action: Adultos
		WebElement containerAdult = adriver.findElement(AppiumBy.id("com.booking:id/group_config_adults_count"));
		WebElement cantAdu = containerAdult.findElement(AppiumBy.id("com.booking:id/bui_input_stepper_value"));
		WebElement cantAduAdd = containerAdult.findElement(AppiumBy.id("com.booking:id/bui_input_stepper_remove_button"));
		WebElement cantAduRem = containerAdult.findElement(AppiumBy.id("com.booking:id/bui_input_stepper_add_button"));

		System.out.println("Cantidad: " + cantAdu.getText());

		int _cantAdultos = Integer.parseInt(cantAdu.getText());

		int intentoClickA = 1;
		while (_cantAdultos != this.cantAdultos && intentoClickA < 20) {
			if (_cantAdultos < this.cantAdultos) {
				cantAduAdd.click();
			}
			if (_cantAdultos > this.cantAdultos) {
				cantAduRem.click();
			}
			intentoClickA++;
		}

	}

}
