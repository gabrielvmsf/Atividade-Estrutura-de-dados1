#include <stdio.h>

int main(){
	float A[5];
	int *pA,i;
	
	for(i=0;i<5;i++){
		scanf("%i",&A[i]);
	}
	
	for(i=0;i<5;i++){
		pA = &A[i];
		
		if(*pA%2==0){
			printf("O endereço par do vetor na posicao %i e: %i\n",(i+1),pA);
		}
		
	}
}
