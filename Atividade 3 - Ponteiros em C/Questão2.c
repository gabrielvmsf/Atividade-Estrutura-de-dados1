#include <stdio.h>

int main(){
	int num1;	
	int num2;
	
	int *pnum1 = &num1;	
	int *pnum2 = &num2;
	
	if(pnum1>pnum2){
		printf("Maior endereco e de pnum1: %i",pnum1);
	} else {
		printf("Maior endereco e de pnum2: %i",pnum2);
	}

}
