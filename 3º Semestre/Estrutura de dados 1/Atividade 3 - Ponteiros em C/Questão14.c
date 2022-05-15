#include <stdio.h>

int main(){
	int array[5],valor=5;
	
	preencher(array,valor);
}

void preencher(int array[5],int valor){
	int *p, *i;
	p=&array[0];
	i=&array[5];

	while(p<i){
		*p = valor;
		printf("Endereço: %i",p);
		printf("\nValor: %i\n\n",*p);
		p++;
	}
	
}
