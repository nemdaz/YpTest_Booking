Feature: Realizar reserva de habitación en Booking.com.
  La reserva se reaiza para la ciudad Cusco.

  Scenario: Buscamos hotel y reservamos habitacion con pago con targeta en la APP.
    Given Iniciamos la aplicación en la patalla de búsqueda.
    When ingresamos el pais o region - "Cusco" - donde hospedarnos.
    And para el rango de fechas "14/02/2023" y "28/02/2023" 
    And que disponga de 1 habitacion para 2 adultos
    And que permita niños:
    	| Edad de niños |
    	| 5							|
    And hacemos click en el boton "Buscar"
    Then se muestra la lista de hoteles que cumplen nuestros criterios
    And comprobamos que existan al menos 2 hoteles.
