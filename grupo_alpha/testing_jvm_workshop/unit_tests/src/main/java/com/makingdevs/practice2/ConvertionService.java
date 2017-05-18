package com.makingdevs.practice2;

public class ConvertionService {

	private WeatherWebService weatherService;
  private CacheService cacheService;

	public float retrieveWeatherInCelsiusFromCountryAndCity(String country, String city){
    try{
      if(cacheService.isAvailable(country, city)){
        return cacheService.retrieveConversion(country, city);
      } else {
        float weather = weatherService.retrieveWeatherInFarenheitFromCountryAndCity(country, city);
        float result = (weather - 32f)*5f/9f;
        cacheService.storeConversion(country, city, weather, result);
        return result;
      }
    }
    catch(RuntimeException e){
      throw new RuntimeException("El servicio no está disponible");
    }
	}

  public void setWeatherService(WeatherWebService service){
    this.weatherService = service;
  }
  public void setCacheService(CacheService service){
    this.cacheService = service;
  }
}
