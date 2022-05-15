#include <stdio.h>

void media(float *nota1,float *nota2,float *mediaS,float *mediaP){
	*mediaS = (*nota1+*nota2)/2;
	*mediaP = (*nota1+(*nota2)*2)/3;
}

int main(){
	float i,nota1,nota2,mediaS,mediaP;
	
	scanf("%f",&nota1);
	scanf("%f",&nota2);
	
	media(&nota1,&nota2,&mediaS,&mediaP);
	
	printf("Media simples: %.2f \nMedia ponderada: %.2f",mediaS,mediaP);
	return 0;
}
