package po;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import base.BaseAppium;
import io.appium.java_client.AppiumBy;
import utils.UtilDelay;

public class ListaHotelesPage extends BaseAppium{
	public int seleccionaPos;
	public int cantNoHoteles;

	public ListaHotelesPage(int seleccionaPos) {
		super();
		this.seleccionaPos = (seleccionaPos > 0)? seleccionaPos -1 : 0;
	}
	
	public ListaHotelesPage() {
		super();
	}
	
	public List<String> listaResultadoHoteles() {
		WebElement containerResultados = adriver.findElement(AppiumBy.id("com.booking:id/results_list_facet")); //FrameLayout
		List<WebElement> listaHoteles = containerResultados.findElements(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup"));
		//listaHoteles.remove(0); // Quita texto de cantidad de hoteles
		List<String> resultadoHoteles = new ArrayList<>();
		
		String nameHotelXpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView";
		
		this.cantNoHoteles = 0;
		for (WebElement containerHotel : listaHoteles) {
			try {
			WebElement hotelText = containerHotel.findElement(AppiumBy.xpath(nameHotelXpath));
			resultadoHoteles.add(hotelText.getText());
			} catch (NoSuchElementException ex) {
				System.out.println("Grupo que no es hotel, no se agrega a la lista ...");
				this.cantNoHoteles ++;
			}
		}
		
		for (String string : resultadoHoteles) {
			System.out.printf("Hotel en lista: %s\n", string);
		}
		
		return resultadoHoteles;
	}
	
	public void seleccionaHotel() {
		WebElement containerResultados = adriver.findElement(AppiumBy.id("com.booking:id/results_list_facet")); //FrameLayout
		List<WebElement> listaHoteles = containerResultados.findElements(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup"));
				
		WebElement hotel = listaHoteles.get(this.seleccionaPos + this.cantNoHoteles);
		hotel.click();
		
	}

	public boolean muestraDetalleHotel() {
		try {
			List<WebElement> vistaDetalle = adriver.findElements(AppiumBy.id("com.booking:id/listLayout"));
			if(vistaDetalle.size() > 0) return true;
		} catch (Exception ex) {
			return false;
		}
		return false;
	}
	
	public void muestraHabitacionesHotel(List<String> nombreBotonesParaMostrar) {
		WebElement boton = adriver.findElement(AppiumBy.id("com.booking:id/select_room_cta"));
		
		for (String txtBtn : nombreBotonesParaMostrar) {
			if(boton.getText().contains(txtBtn) || txtBtn.contains(boton.getText())) {
				boton.click();
				break;
			}
		}
	}

}
