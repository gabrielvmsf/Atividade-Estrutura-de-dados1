#include <stdio.h>

int main(){
	int num1;	
	int num2;
	
	scanf("%i",&num1);
	scanf("%i",&num2);
	
	int *pnum1 = &num1;	
	int *pnum2 = &num2;
	
	troca(pnum1,pnum2);
	
	printf("Maior valor: %i \nMenor valor: %i",num1,num2);
}

void troca(int *pnum1,int *pnum2){
	int x;
	if(*pnum1<*pnum2){
		x = *pnum1;
		*pnum1 = *pnum2;
		*pnum2 = x;
	} else {
		printf("\n--O maior valor ja e pnum1!!--\n\n");
	}
}
