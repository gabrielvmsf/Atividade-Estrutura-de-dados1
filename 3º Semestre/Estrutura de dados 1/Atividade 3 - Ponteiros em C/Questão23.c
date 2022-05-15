#include <stdio.h>
int calculoMaior(int *vet,int A){
	A = vet + A;
	int maior = *vet;
		
	while(vet<A){
		
		if(*vet>maior){
			
			maior = *vet;
		}
		vet++;
		
	}
	
	return maior;
}


int main(){
	int vet[5];
	
	int i;
	
	for(i=0;i<5;i++){
		scanf("%i",&vet[i]);	
	}
	
	int t = 5;
	int maior = calculoMaior(vet,t);
	
	printf("Maior: %i\n",maior);
	
	for(i=0;i<5;i++){
		printf("Vetor[%i]: %i\n",(i+1),vet[i]);
	}
	return 0;
}
