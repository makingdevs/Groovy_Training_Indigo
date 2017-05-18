package com.makingdevs.practice2

interface CacheService {
  boolean isAvailable(String country, String city)
  void storeConversion(String country, String city, float farenheit, float celsius)
  float retrieveConversion(String country, String city)
}
