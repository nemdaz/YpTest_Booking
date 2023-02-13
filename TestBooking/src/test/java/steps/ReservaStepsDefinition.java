package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import po.BuscarHotelPage;
import utils.UtilDelay;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import base.BaseAppium;

public class ReservaStepsDefinition implements En {

	public ReservaStepsDefinition() {
		
		BaseAppium apiumBase = new BaseAppium();
		
		Before(()->{
			apiumBase.start();
		});
		
		Given("Iniciamos la aplicación en la patalla de búsqueda.", () -> {
			UtilDelay.coolDelay(3000);
		});
		
		When("ingresamos el pais o region (\"{string}\") donde hospedarnos.", (String destino) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(destino);
			buscarHotelPage.ingresaDestino();
		});
		
		And("que disponga de {int} habitacion para {int} adultos", (Integer cantHabitacion, Integer cantAdultos) -> {
			
		});
		
		And("que permita niños:", (DataTable tNinos) -> {
			//assertEquals(tNinos.column(0), asList("5"));
		});
		
		And("hacemos click en el boton \"{string}\"", (String btnBuscar) -> {
			//
		});
		
		Then("se muestra la lista de hoteles que cumplen nuestros criterios", () -> {
			
		});
		
		And("comprobamos que existan al menos {int} hoteles.", (Integer minHoteles) -> {
			
		});
		
		After(()->{
			UtilDelay.coolDelay(10000);
			apiumBase.shutDown();
		});
	}
}
