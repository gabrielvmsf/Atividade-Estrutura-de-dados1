#include <stdio.h>

int main(){
	int inteiro;
	float real;
	char caractere;
	
	int *pontInt = &inteiro;
	float *pontReal = &real;
	char *pontChar = &caractere;
	
	inteiro = 10;
	real = 5.2;
	caractere = 'a';
	
	printf("Antes: %i , %.1f , %c\n\n",inteiro,real,caractere);
	
	*pontInt = 50;
	*pontReal = 8.5;
	*pontChar = 'c';
	
	printf("Depois: %i , %.1f , %c\n\n",inteiro,real,caractere);
	
}
