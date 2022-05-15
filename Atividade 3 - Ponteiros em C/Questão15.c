#include <stdio.h>

int main(){
	int array[3] = {1,2,3};
	
	preencher(array);
}

void preencher(int array[3]){
	int *p, *i;
	p=&array[0];
	i=&array[3];

	while(p<i){
		printf("\nValor: %i\n\n",*p);
		p++;
	}
	
}


