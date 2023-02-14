package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import po.BuscarHotelPage;
import utils.UtilDate;
import utils.UtilDelay;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import base.BaseAppium;

public class ReservaStepsDefinition implements En {

	public ReservaStepsDefinition() {
		
		BaseAppium apiumBase = new BaseAppium();
		
		Before(()->{
			//apiumBase.startService();
		});
		
		Given("Iniciamos la aplicación en la patalla de búsqueda.", () -> {
			apiumBase.startDriver();
			UtilDelay.coolDelay(2000);
		});
		
		When("ingresamos el pais o region - {string} - donde hospedarnos.", (String destino) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(destino);
			buscarHotelPage.ingresaDestino();
			UtilDelay.coolDelay(2);
			buscarHotelPage.seleccionaOpcionesDestino(2);
		});
		
		And("para el rango de fechas {string} y {string}", (String checkin, String checkout) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(checkin, checkout);
			buscarHotelPage.seleccionaFechas();
		});
		
		And("que disponga de {int} habitacion para {int} adultos", (Integer cantHabitacion, Integer cantAdultos) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(cantHabitacion, cantAdultos);
			buscarHotelPage.seleccionaCantidades();
		});
		
		And("que permita niño de edad:", (DataTable tNinos) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(tNinos.asList(Integer.class));
			buscarHotelPage.seleccionaCantidadNinos();
		});
		
		And("hacemos click en el boton {string}", (String btnBuscar) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage();
			buscarHotelPage.buscamosHoteles();
		});
		
		Then("se muestra la lista de hoteles con al menos {int} resultados cumplen los criterios.", (Integer minCant) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage();
			List<String> resultado = buscarHotelPage.resultadoHoteles();
		});
		
		
		After(()->{
			UtilDelay.coolDelay(50 * 1000);
			apiumBase.shutDown();
		});
	}
}
