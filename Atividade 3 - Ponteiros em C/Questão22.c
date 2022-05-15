#include <stdio.h>

int soma(int *vetA,int *vetB,int *vetC,int A, int B){
	int i;
	
	if(A != B){
		return 0;
	} 
	int C = vetA + A;
	
	
	while(vetA<C){
		*vetC = (*vetA)+(*vetB);
		
		vetA++;
		vetB++;
		vetC++;
	}
	
}

int main(){
	int vetA[5] = {1,2,3,4,5};
	int vetB[5] = {6,7,8,9,10};
	int vetC[5],i;
	
	if(soma(vetA,vetB,vetC,sizeof(vetA),sizeof(vetB)) == 0){
		printf("tamanhos diferentes!");
	}
	
	for(i=0;i<5;i++){
		printf("VetorC[%i]: %i\n",(i+1),vetC[i]);
	}
	return 0;
}
