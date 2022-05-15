#include <stdio.h>

int negativos(float *vet, int N){
	int i;
	for(i=0;i<5;i++){
		if(*vet<0){
			N++;
		}
		vet++;
	}
	return N;
}

int main(){
	int N=0;
	float vet[5] = {5.4,3.1,-4,-5,-0.7};
	
	N = negativos(vet,N);
	
	printf("qtd negativos: %i ",N);
	return 0;
}
