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
			apiumBase.startOuter();
		});
		
		Given("Iniciamos la aplicación en la patalla de búsqueda.", () -> {
			UtilDelay.coolDelay(3000);
		});
		
		When("ingresamos el pais o region - {string} - donde hospedarnos.", (String destino) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(destino);
			buscarHotelPage.ingresaDestino();
		});
		
		And("que disponga de {int} habitacion para {int} adultos", (Integer cantHabitacion, Integer cantAdultos) -> {
			// Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java8.PendingException();
		});
		
		And("que permita niños:", (DataTable tNinos) -> {
			//assertEquals(tNinos.column(0), asList("5"));
			// Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java8.PendingException();
		});
		
		And("hacemos click en el boton \"{string}\"", (String btnBuscar) -> {
			// Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java8.PendingException();
		});
		
		Then("se muestra la lista de hoteles que cumplen nuestros criterios", () -> {
			// Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java8.PendingException();
		});
		
		And("comprobamos que existan al menos {int} hoteles.", (Integer minHoteles) -> {
			// Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java8.PendingException();
		});
		
		After(()->{
			UtilDelay.coolDelay(10000);
			apiumBase.shutDown();
		});
	}
}
