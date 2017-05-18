package com.makingdevs.practice2

import spock.lang.*

class ConvertionServiceSpec extends Specification {

  @Unroll("La temperatura en #farenheit ªF es #celsius ªC")
  def "La conversión es correcta de ªF a ªC"(){
    given:
      ConvertionService service = new ConvertionService()
      def country = _country
      def city = _city
    and:
      def weatherServiceStub = Mock(WeatherWebService)
      service.setWeatherService(weatherServiceStub)
      def cacheServiceMock = Mock(CacheService)
      service.cacheService = cacheServiceMock
    when:
      def result = service.retrieveWeatherInCelsiusFromCountryAndCity(country, city)
    then:
      celsius == result
      1 * weatherServiceStub.retrieveWeatherInFarenheitFromCountryAndCity(_country, _city) >> farenheit
      1 * cacheServiceMock.isAvailable(_,_) >> false
      1 * cacheServiceMock.storeConversion(_,_,_,_)
    where:
      _country | _city    |farenheit || celsius
      "France" | "París"  | 52F      || 11.111111f
      "Spain"  | "Madrid" | 70F      || 21.111111f
  }

  def "El servicio del clima no está disponible"(){
    given:
      ConvertionService service = new ConvertionService()
      def country = "Any"
      def city = "Any"
    and:
      def weatherServiceStub = Mock(WeatherWebService)
      weatherServiceStub.retrieveWeatherInFarenheitFromCountryAndCity(_,_) >> { throw new RuntimeException("Timeout") }
      service.setWeatherService(weatherServiceStub)
    when:
      service.retrieveWeatherInCelsiusFromCountryAndCity(country, city)
    then:
      RuntimeException e = thrown()
      e.message == "El servicio no está disponible"
  }

  def """Usar el servicio de caché para recuperar
        valores ya obtenidos, pues algunas veces se cae
        el servicio."""(){
    given:
      ConvertionService service = new ConvertionService()
      def country = "Mexico"
      def city = "DF"
    and:
      def weatherServiceMock = Mock(WeatherWebService)
      service.weatherService = weatherServiceMock
      def cacheServiceMock = Mock(CacheService)
      service.cacheService = cacheServiceMock
    when:
      3.times {
        service.retrieveWeatherInCelsiusFromCountryAndCity(country, city)
      }
    then:
      3 * cacheServiceMock.isAvailable(_,_) >>> [false, true, true]
      //1 * cacheServiceMock.isAvailable(_,_) >> false
      1 * weatherServiceMock.retrieveWeatherInFarenheitFromCountryAndCity(_,_)
      1 * cacheServiceMock.storeConversion(_,_,_,_)
      //1 * cacheServiceMock.isAvailable(_,_) >> true
      2 * cacheServiceMock.retrieveConversion(_,_)
  }
}

