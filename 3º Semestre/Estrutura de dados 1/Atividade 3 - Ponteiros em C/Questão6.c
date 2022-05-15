#include <stdio.h>

int main(){
	int A;	
	int B;
	
	scanf("%i",&A);
	scanf("%i",&B);
	
	int *pA = &A;	
	int *pB = &B;
	
	int soma = dobro(pA,pB);
	
	printf("Soma: %i \nValor A: %i \nValor B: %i",soma,A,B);
}

int dobro(int *pA,int *pB){
	int soma;
	
	*pA = (*pA) * 2;
	*pB = (*pB) * 2;
	
	soma = (*pA) + (*pB);
	
	return soma;
}
