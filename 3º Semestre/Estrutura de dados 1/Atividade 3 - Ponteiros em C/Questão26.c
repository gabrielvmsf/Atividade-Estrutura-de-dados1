#include <stdio.h>
#include <math.h>

int raizes(float A,float B,float C,float *X1,float *X2){
	float delta = (B*B)-4*A*C;
	int i,Xpos,Xneg;
	printf("Delta = %.2f\n",delta);
	if(delta>0){
		*X1 = (-B+sqrt(delta))/(2*A);
		*X2 = (-B-sqrt(delta))/(2*A);
		return 2;
	} else if(delta==0){
		*X1 = (-B+sqrt(delta))/(2*A);
		return 1;
	} else {
		return 0;
	}
	
}

int main(){
	float A, B, C, X1, X2;
	
	printf("Digite o valor de A,B e C respectivamente:\n");
	scanf("%f",&A);
	scanf("%f",&B);
	scanf("%f",&C);
	int K = raizes(A,B,C,&X1,&X2);
	if(K==2){
		printf("Possui duas raizes, sendo X1: %f      e x2: %f",X1,X2);
	} else if (K==1){
		printf("Possui uma raiz, sendo X1: %f      e x2: %f",X1,X2);
	} else {
		printf("não possui raizes");
	}
	return 0;
}
