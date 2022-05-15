#include <stdio.h>

int main(){
	int A, *B, **C, ***D;
	
	scanf("%i",A);
	
	*B = (A*2);
	**C = (A*3);
	***D = (A*4);
	
	printf("Dobro: %i\nTriplo: %i\nQuadruplo: %i",*B,**C,***D);
	return 0;
}
