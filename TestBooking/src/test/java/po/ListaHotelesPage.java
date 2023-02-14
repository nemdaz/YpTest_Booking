package po;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import base.BaseAppium;
import io.appium.java_client.AppiumBy;

public class ListaHotelesPage extends BaseAppium{
	public int seleccionaPos;

	public ListaHotelesPage(int seleccionaPos) {
		super();
		this.seleccionaPos = seleccionaPos;
	}
	
	public ListaHotelesPage() {
		super();
	}
	
	public List<String> listaResultadoHoteles() {
		WebElement containerResultados = adriver.findElement(AppiumBy.id("com.booking:id/results_list_facet")); //FrameLayout
		List<WebElement> listaHoteles = containerResultados.findElements(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup"));
		listaHoteles.remove(0); // Quita texto de cantidad de hoteles
		List<String> resultadoHoteles = new ArrayList<>();
		
		String nameHotelXpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView";
		
		for (WebElement containerHotel : listaHoteles) {
			WebElement hotelText = containerHotel.findElement(AppiumBy.xpath(nameHotelXpath));
			resultadoHoteles.add(hotelText.getText());
		}
		
		return resultadoHoteles;
	}


}
