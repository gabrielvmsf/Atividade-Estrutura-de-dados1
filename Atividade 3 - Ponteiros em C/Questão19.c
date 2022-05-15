#include <stdio.h>

void maior(int *vet,int *N,int *Maior){
	int i;
	*Maior = *vet;
	int k = vet;
	
	for(i=0;i<7;i++){
	
		if(*vet>=*Maior){
			*Maior = *vet;
		}
		vet++;
	}
	vet = k;
	
	int M = *Maior, j = 0;
	for(i=0;i<7;i++){
		if(*vet==M){
			j++;
		}
		vet++;
	}
	*N = j;
}

int main(){
	int N=0,Maior;
	int vet[7] = {8,9,9,4,2,9,5};
	
	maior(vet,&N,&Maior);
	
	printf("Maior Num:%i\nqtd repetições: %i ",Maior,N);
	return 0;
}
