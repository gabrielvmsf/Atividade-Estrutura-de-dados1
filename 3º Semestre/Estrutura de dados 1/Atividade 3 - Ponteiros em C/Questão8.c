#include <stdio.h>

int main(){
	float A[10];
	int *pA,i;
	
	for(i=0;i<10;i++){
		pA = &A[i];
		printf("Endere�o do vetor na posi��o %i: %i\n",(i+1),pA);
	}
}
