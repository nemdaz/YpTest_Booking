package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import po.BuscarHotelPage;
import po.EscogeHabitacionPage;
import po.ListaHotelesPage;
import po.ReservaHabitacionPage;
import po.TerminaReservaPage;
import utils.Utility;
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
			UtilDelay.coolDelay(1 * 1000);
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
			UtilDelay.coolDelay(2 * 1000);
			BuscarHotelPage buscarHotelPage = new BuscarHotelPage();
			buscarHotelPage.buscamosHoteles();
		});
		
		Then("se muestra la lista de hoteles con al menos {int} resultados cumplen los criterios.", (Integer minCant) -> {
			UtilDelay.coolDelay(2 * 1000);
			ListaHotelesPage listaHoteles = new ListaHotelesPage();
			List<String> resultado = listaHoteles.listaResultadoHoteles();
			assertTrue( minCant <= resultado.size());
		});
		
		// SCENARIO
		Given("Estamos en la lista de resulado, seleccionamos el resultado {int} de la lista.", (Integer position)->{
			UtilDelay.coolDelay(2 * 1000);
			ListaHotelesPage listaHoteles = new ListaHotelesPage(position);
			listaHoteles.seleccionaHotel();
		});
		
		When("nos muestra el detalle del hotel", ()->{
			UtilDelay.coolDelay(1 * 1000);
			ListaHotelesPage listaHoteles = new ListaHotelesPage();	
			boolean vistaOk = listaHoteles.muestraDetalleHotel();
			assertTrue(vistaOk);
		});
		
		And("seleccionamos alguno de los botones para ver las habitaciones, botones:", (DataTable posibleBotones)->{
			ListaHotelesPage listaHoteles = new ListaHotelesPage();
			listaHoteles.muestraHabitacionesHotel(posibleBotones.asList());
		});
		
		Then("se muestra las habitaciones disponibles y sus precios", ()->{
			UtilDelay.coolDelay(2 * 1000);
			EscogeHabitacionPage ehab = new EscogeHabitacionPage();
			boolean muestra = ehab.muestraHabitaciones();
			assertTrue(muestra);
		});
		
		And("podemos seleccionar la habitación {int} de la lista para Información", (Integer position)->{
			UtilDelay.coolDelay(2 * 1000);
			EscogeHabitacionPage ehab = new EscogeHabitacionPage(position);
			reservaObj.setCostoPrevio(ehab.seleccionaHabitacion());
		});
		
		And("en la Información de la habitación se muestra el mismo precio de lista", ()->{
			UtilDelay.coolDelay(5 * 1000);
			EscogeHabitacionPage ehab = new EscogeHabitacionPage();
			Double p = ehab.muestraInformacionHabitacion();
			assertEquals(reservaObj.getCostoPrevio(), p);
			reservaObj.setCostoPrevio(p);
		});
		
		And("la sección Reserva muestra el mismo precio que en la Información.", ()->{
			UtilDelay.coolDelay(1 * 1000);
			EscogeHabitacionPage ehab = new EscogeHabitacionPage();
			Double p = ehab.muestraInformacionReserva();
			assertEquals(reservaObj.getCostoPrevio(), p);
			reservaObj.setCostoPrevio(p);
		});
		
		// SCENARIO
		Given("Previamente se verifico el detalle de la habitación, presionamos boton {string}", (String btnTexto)->{
			UtilDelay.coolDelay(1 * 1000);
			ReservaHabitacionPage reservaPage = new ReservaHabitacionPage();
			reservaPage.iniciamosReserva(btnTexto);
		});
		
		When("Ingresamos nuestros datos en el formulario:", (DataTable datosReserva)->{
			UtilDelay.coolDelay(5 * 1000);
			List<String> datos = datosReserva.asList();
			ReservaHabitacionPage reservaPage = new ReservaHabitacionPage(
					datos.get(0),
					datos.get(1),
					datos.get(2),
					datos.get(3),
					datos.get(4),
					datos.get(5)
					);
			reservaPage.ingresamosDatosReserva();
			
		});
		
		And("Se habilita el boton {string}, continuamos", (String btnTexto)->{
			UtilDelay.coolDelay(1 * 1000);
			ReservaHabitacionPage reservaPage = new ReservaHabitacionPage();
			reservaPage.comprobamosDetalleReserva(btnTexto);
		});
		
		And("comprobamos el resumen de la reserva y presionamos el boton {string}", (String btnTexto)->{
			UtilDelay.coolDelay(1 * 1000);
			ReservaHabitacionPage reservaPage = new ReservaHabitacionPage();
			reservaPage.comprobamosResumenReserva(btnTexto);
		});
		
		Then("se nos pide ingresar los datos de tarjeta:", (DataTable datosTarjeta)->{
			UtilDelay.coolDelay(4 * 1000);
			List<String> datCard = datosTarjeta.asList(); 
			TerminaReservaPage reservaFinPage = new TerminaReservaPage(
					datCard.get(0),
					datCard.get(1),
					datCard.get(2),
					datCard.get(3)
					);
			reservaFinPage.ingresamosDatosTarjeta();
		});
		
		And("al reservar con {string} nos confirma la reserva", (String btnTexto)->{
			UtilDelay.coolDelay(1 * 1000);
			//Verificamos montos
			TerminaReservaPage reservaFinPage = new TerminaReservaPage();
			
			
		});
		
		
		After(()->{
			// Acciones finales para cada scenario
		});
		
		// END SERVICE OR DRIVER
		//UtilDelay.coolDelay(50 * 1000);
		//apiumBase.shutDown();
	}
}
