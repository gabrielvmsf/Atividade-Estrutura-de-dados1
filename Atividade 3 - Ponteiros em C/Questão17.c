#include <stdio.h>


void frac(float num, int *inteiro, float *fraci){
	*inteiro = (int) num;
	*fraci = num - *inteiro;
}

int main(){
	float num;
	int inteiro;
	float fraci;
	
	num = 5.45;
	
	frac(num,&inteiro,&fraci);
	
	printf("%i e %.5f\n",inteiro,fraci);
	
}


