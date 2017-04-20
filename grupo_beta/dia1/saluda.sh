#!/usr/bin/env groovy

s = "touch file.txt".execute().text

println s

for(int i = 0; i< 100; i++){
  System.out.println(i);
}
