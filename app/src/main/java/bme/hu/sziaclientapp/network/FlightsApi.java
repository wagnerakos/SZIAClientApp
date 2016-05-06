package bme.hu.sziaclientapp.network;

import java.util.List;

import bme.hu.sziaclientapp.model.Flight;
import retrofit2.Call;
import retrofit2.http.*;

public interface FlightsApi {
  
  /**
   * Get All Flights
   * 
   * @return Call<List<Flight>>
   */
  
  @GET("flights")
  Call<List<Flight>> flightsGet();
    

  
  /**
   * Get a specific flight by id
   * 
   * @param id Identifier of a flight.
   * @return Call<Flight>
   */
  
  @GET("flights/{id}")
  Call<Flight> flightsIdGet(
          @Path("id") Integer id
  );

  
}
