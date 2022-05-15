#include <stdio.h>

void calc_esfera(float R, float *area, float *volume){
	*area = 4*3.14*(R*R);
	*volume = (4/3)*3.14*(R*R*R);
}

int main(){
	float R,area,volume;
	
	scanf("%f",&R);
	
	calc_esfera(R,&area,&volume);
	
	printf("Area:%f \nVolume:%f",area,volume);
}
