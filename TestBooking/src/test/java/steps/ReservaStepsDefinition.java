package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import po.BuscarHotelPage;
import po.ListaHotelesPage;
import utils.UtilDate;
import utils.UtilDelay;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import base.BaseAppium;
import dto.ReservaDTO;

public class ReservaStepsDefinition implements En {

	public ReservaStepsDefinition() {
		
		BaseAppium apiumBase = new BaseAppium();
		ReservaDTO reservaObj = new ReservaDTO();
		
		Before(()->{
			//apiumBase.startService();
		});
		
		// SCRENARIO
		Given("Iniciamos la aplicación en la patalla de búsqueda.", () -> {
			apiumBase.startDriver();
			UtilDelay.coolDelay(2000);
		});
		
		When("ingresamos el pais o region - {string} - donde hospedarnos.", (String destino) -> {
			reservaObj.setDestino(destino);
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(destino);
			buscarHotelPage.ingresaDestino();
			UtilDelay.coolDelay(2);
			buscarHotelPage.seleccionaOpcionesDestino(2);
		});
		
		And("para el rango de fechas {string} y {string}", (String checkin, String checkout) -> {
			reservaObj.setFechaIngreso(checkin);
			reservaObj.setFechaSalida(checkout);
			
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(checkin, checkout);
			buscarHotelPage.seleccionaFechas();
		});
		
		And("que disponga de {int} habitacion para {int} adultos", (Integer cantHabitacion, Integer cantAdultos) -> {
			reservaObj.setCantidadAdultos(cantAdultos);
			reservaObj.setCantidadHabitaciones(cantHabitacion);
			
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(cantHabitacion, cantAdultos);
			buscarHotelPage.seleccionaCantidades();
		});
		
		And("que permita niño de edad:", (DataTable tNinos) -> {
			reservaObj.setCantidadNinosEdad(tNinos.asList(Integer.class));
			
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage(tNinos.asList(Integer.class));
			buscarHotelPage.seleccionaCantidadNinos();
		});
		
		And("hacemos click en el boton {string}", (String btnBuscar) -> {
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage();
			buscarHotelPage.buscamosHoteles();
		});
		
		Then("se muestra la lista de hoteles con al menos {int} resultados cumplen los criterios.", (Integer minCant) -> {
			ListaHotelesPage buscarHotelPage = new ListaHotelesPage();
			List<String> resultado = buscarHotelPage.listaResultadoHoteles();
			assertTrue( minCant >= resultado.size());
		});
		
		// SCENARIO
		Given("Estamos en la lista de resulado, seleccionamos el resultado {int} de la lista.", (Integer position)->{
			
		});
		
		When("nos muestra el detalle del hotel", ()->{
					
		});
		
		And("seleccionamos alguno de los botones para ver las habitaciones, botones:", (DataTable posibleBotones)->{
			
		});
		
		Then("se muestra las habitaciones disponibles y sus precios", ()->{
			
		});
		
		And("podemos seleccionar la habitación 1 de la lista para Información", ()->{
			
		});
		
		And("en la Información de la habitación se muestra el mismo precio de lista", ()->{
			
		});
		
		And("la sección Reserva muestra el mismo precio que en la Información.", ()->{
			
		});
		
		
		After(()->{
			UtilDelay.coolDelay(50 * 1000);
			apiumBase.shutDown();
		});
	}
}
