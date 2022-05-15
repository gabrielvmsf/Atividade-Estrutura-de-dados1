#include <stdio.h>

void inteiros(int *pont, int *min, int *max){
	int i,k = pont;
	
	for(i=0;i<5;i++){
		scanf("%i",& *pont);
		pont++;
	}
	
	pont = k;
	*max = *pont;
	*min = *pont;
	
	for(i=0;i<5;i++){

		if(*pont>*max){
			*max = *pont;
		}
		if(*pont<*min){
			*min = *pont;
		}
		pont++;
	}

}

int main(){
	int vet[5];
	int min, max;
	inteiros(vet,&min,&max);
	
	printf("O valor max e %i\n",max);
	printf("O valor min e %i\n",min);
	return 0;
	
}
