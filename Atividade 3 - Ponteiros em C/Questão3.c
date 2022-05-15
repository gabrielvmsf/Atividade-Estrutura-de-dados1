#include <stdio.h>

int main(){
	int num1;	
	int num2;
	
	scanf("%i",&num1);
	scanf("%i",&num2);
	
	int *pnum1 = &num1;	
	int *pnum2 = &num2;
	
	if(pnum1>pnum2){
		printf("Maior endereco e de pnum1, que possui o valor: %i",*pnum1);
	} else {
		printf("Maior endereco e de pnum2, que possui o valor: %i",*pnum2);
	}
}
