#include <stdio.h>

int main(){
	float A[3][3];
	int *pA,i,j;
	
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
		pA = &A[i][j];
		printf("Endere�o da matriz na posi��o %i %i: %i\n",(i+1),(j+1),pA);
		}
	}
}
