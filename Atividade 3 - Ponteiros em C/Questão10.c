#include <stdio.h>

int main(){
	int A[5];
	int *pA,i;
	
	for(i=0;i<5;i++){
		scanf("%i",&A[i]);
	}
	for(i=0;i<5;i++){
		pA = &A[i];
		printf("dobro do valor do vetor na posição %i: %i\n",(i+1),((*pA)*2));
	}
}
