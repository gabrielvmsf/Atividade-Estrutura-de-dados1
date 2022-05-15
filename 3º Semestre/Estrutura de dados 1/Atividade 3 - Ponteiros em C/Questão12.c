#include <stdio.h>

int main(){
	int num1;	
	int num2;
	int num3;
	
	scanf("%i",&num1);
	scanf("%i",&num2);
	scanf("%i",&num3);

	int *pnum1 = &num1;	
	int *pnum2 = &num2;
	int *pnum3 = &num3;	
	
	ordem(pnum1,pnum2,pnum3);
	
	printf("Valor pnum1: %i \nValor pnum2: %i \nValor pnum3: %i ",num1,num2,num3);
}

int ordem(int *pnum1,int *pnum2,int *pnum3){
	
	int maior, menor, meio;
	
	if(*pnum1==*pnum2==*pnum3){
		printf("Todos os valores são iguais!\n");
		return 1;
	} else {
		if(*pnum1>*pnum2 && *pnum1 >*pnum3){
			maior = *pnum1;
		} else
		if((*pnum1<*pnum2 && *pnum1 >*pnum3)||(*pnum1>*pnum2 && *pnum1 <*pnum3)){
			meio = *pnum1;
		} else
		if(*pnum1<*pnum2 && *pnum1 <*pnum3){
			menor = *pnum1;
		}
		
		if(*pnum2>*pnum1 && *pnum2 >*pnum3){
			maior = *pnum2;
		} else
		if((*pnum2>*pnum1 && *pnum2 <*pnum3)||(*pnum2<*pnum1 && *pnum2 >*pnum3)){
			meio = *pnum2;
		} else
		if(*pnum2<*pnum1 && *pnum2 <*pnum3){
			menor = *pnum2;
		}
		
		if(*pnum3>*pnum1 && *pnum3 >*pnum2){
			maior = *pnum3;
		} else
		if((*pnum3>*pnum1 && *pnum3 <*pnum2)||(*pnum3<*pnum1 && *pnum3 >*pnum2)){
			meio = *pnum3;
		} else
		if(*pnum3<*pnum1 && *pnum3 <*pnum2){
			menor = *pnum3;
		}
		
		*pnum1 = menor;
		*pnum2 = meio;
		*pnum3 = maior;
		
		return 0;
	}
	
}


