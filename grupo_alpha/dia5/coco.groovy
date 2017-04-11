natural = 0
suma = 0;
while(natural < 1000){
	if(natural % 3 == 0 || natural % 5 == 0 ){
		suma+=natural;
	}
	natural++;
}
println(suma);
