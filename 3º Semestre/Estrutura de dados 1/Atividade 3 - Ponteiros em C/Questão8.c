#include <stdio.h>

int main(){
	float A[10];
	int *pA,i;
	
	for(i=0;i<10;i++){
		pA = &A[i];
		printf("Endereço do vetor na posição %i: %i\n",(i+1),pA);
	}
}
