#include <stdio.h>

int main(){
	int array[5] = {1,2,3,4,5};
	int *p = &array;
	int *k = &array[5];
	
	while(p<k){
		*p = *p + 1;
		p++;
	}
	
	int i;
	
	for(i=0;i<5;i++){
		printf("posicao %i: %i\n",(i+1),array[i]);
	}
}
