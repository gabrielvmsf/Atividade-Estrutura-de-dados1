#include <stdio.h>

int main(){
	int A;	
	int B;
	
	scanf("%i",&A);
	scanf("%i",&B);
	
	int *pA = &A;	
	int *pB = &B;
	
	soma(pA,pB);
	
	printf("Valor A: %i \nValor B: %i",A,B);
}

void soma(int *pA, int *pB){
	int soma = (*pA)+(*pA);
	*pA = soma;
	printf("\n--Soma efetuada e armazenada em A--\n\n");
}
