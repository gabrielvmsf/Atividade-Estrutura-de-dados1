#include <stdio.h>
#include <string.h>

int main(){
	char texto1[] = "IFgoianocampusMorrinhos";
	char texto2[] = "Morrinhos";
	
	if(verificar(texto1,texto2)==0){
		printf("A segunda string nao esta na primeira");
	} else {
		printf("A segunda string esta na primeira");
	}
}

int verificar(char texto1[], char texto2[]){
	char *pont1;
	char *pont2;
	
	int i,j,k;
	
	for(i=0;i<=strlen(texto1);i++){
		for(j=0;j<=strlen(texto2);j++){
			pont1 = &texto1[i];
			pont2 = &texto2[j];
			
			if((*pont1)==(*pont2)){
				i++;
				k++;
			} else {
				k=0;
			}
			
			if(k==strlen(texto2)){
				return 1;
			}
		}
	}
	return 0;
}
