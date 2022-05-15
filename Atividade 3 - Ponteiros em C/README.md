# Atividade3 

Universidade Federal de Uberlândia - UFU
Faculdade de Computação - FACOM
Lista de exercı́cios de programação em linguagem C

Exercı́cios: Ponteiros
1. Escreva um programa que declare um inteiro, um real e um char, e ponteiros para inteiro, real, e char. Associe as variáveis aos ponteiros (use &). Modifique os valores de
cada variável usando os ponteiros. Imprima os valores das variáveis antes e após a
modificação.

2. Escreva um programa que contenha duas variáveis inteiras. Compare seus endereços e
exiba o maior endereço.

3. Escreva um programa que contenha duas variáveis inteiras. Leia essas variáveis do
teclado. Em seguida, compare seus endereços e exiba o conteúdo do maior endereço.

4. Faça um programa que leia 2 valores inteiros e chame uma função que receba estas
2 variáveis e troque o seu conteúdo, ou seja, esta função é chamada passando duas
variáveis A e B por exemplo e, após a execução da função, A conterá o valor de B e B
terá o valor de A.

5. Faça um programa que leia dois valores inteiros e chame uma função que receba estes
2 valores de entrada e retorne o maior valor na primeira variável e o menor valor na
segunda variável. Escreva o conteúdo das 2 variáveis na tela.

6. Elaborar um programa que leia dois valores inteiros (A e B). Em seguida faça uma função
que retorne a soma do dobro dos dois números lidos. A função deverá armazenar o dobro
de A na própria variável A e o dobro de B na própria variável B.

7. Crie um programa que contenha uma função que permita passar por parâmetro dois
números inteiros A e B. A função deverá calcular a soma entre estes dois números e
armazenar o resultado na variável A. Esta função não deverá possuir retorno, mas deverá
modificar o valor do primeiro parãmetro. Imprima os valores de A e B na função principal.

8. Crie um programa que contenha um array de float contendo 10 elementos. Imprima o
endereço de cada posição desse array.

9. Crie um programa que contenha uma matriz de float contendo 3 linhas e 3 colunas.
Imprima o endereço de cada posição dessa matriz.

10. Crie um programa que contenha um array de inteiros contendo 5 elementos. Utilizando
apenas aritmética de ponteiros, leia esse array do teclado e imprima o dobro de cada
valor lido.

11. Crie um programa que contenha um array contendo 5 elementos inteiros. Leia esse array
do teclado e imprima o endereço das posições contendo valores pares.

12. Faça um programa que leia três valores inteiros e chame uma função que receba estes 3
valores de entrada e retorne eles ordenados, ou seja, o menor valor na primeira variável,
o segundo menor valor na variável do meio, e o maior valor na última variável. A função
deve retornar o valor 1 se os três valores forem iguais e 0 se existirem valores diferentes.
Exibir os valores ordenados na tela.


13. Elabore uma função que receba duas strings como parâmetros e verifique se a segunda
string ocorre dentro da primeira. Use aritmética de ponteiros para acessar os caracteres
das strings.

14. Crie uma função que receba dois parâmetros: um array e um valor do mesmo tipo do
array. A função deverá preencher os elementos de array com esse valor. Não utilize
ı́ndices para percorrer o array, apenas aritmética de ponteiros.

15. Crie uma função que receba como parâmetro um array e o imprima. Não utilize ı́ndices
para percorrer o array, apenas aritmética de ponteiros.

16. Considere a seguinte declaração: int A, *B, **C, ***D; Escreva um programa que leia a
variável a e calcule e exiba o dobro, o triplo e o quádruplo desse valor utilizando apenas
os ponteiros B, C e D. O ponteiro B deve ser usada para calcular o dobro, C o triplo e D
o quádruplo.

17. Escreva uma função que dado um número real passado como parâmetro, retorne a parte
inteira e a parte fracionária deste número. Escreva um programa que chama esta função.
Protótipo:
void frac(float num, int* inteiro, float* frac);

18. Implemente uma função que calcule a área da superfı́cie e o volume de uma esfera de
raio R. Essa função deve obedecer ao protótipo:
void calc_esfera(float R, float *area, float *volume)
A área da superfı́cie e o volume são dados, respectivamente, por:
A = 4 ∗ p ∗ R2
V = 4/3 ∗ p ∗ R3

19. Escreva uma função que aceita como parâmetro um array de inteiros com N valores, e
determina o maior elemento do array e o número de vezes que este elemento ocorreu
no array. Por exemplo, para um array com os seguintes elementos: 5, 2, 15, 3, 7, 15,
8, 6, 15, a função deve retorna para o programa que a chamou o valor 15 e o número 3
(indicando que o número 15 ocorreu 3 vezes). A função deve ser do tipo void.

20. Implemente uma função que receba como parâmetro um array de números reais de
tamanho N e retorne quantos números negativos há nesse array. Essa função deve
obedecer ao protótipo:
int negativos(float *vet, int N);

21. Escreva um programa que declare um array de inteiros e um ponteiro para inteiros. Associe o ponteiro ao array. Agora, some mais um (+1) a cada posição do array usando o
ponteiro (use *).

22. Crie uma função para somar dois arrays. Esta função deve receber dois arrays e retornar
a soma em um terceiro array. Caso o tamanho do primeiro e segundo array seja diferente
então a função retornará ZERO (0). Caso a função seja concluı́da com sucesso a mesma
deve retornar o valor UM (1). Utilize aritmética de ponteiros para manipulação do array.

23. Escreva uma função que retorna o maior valor de um array de tamanho N. Escreva um
programa que leia N valores inteiros, imprima o array com k elementos por linha, e o
maior elemento. O valor de k também deve ser fornecido pelo usuário.

24. Escreva uma função que receba um array de inteiros V e os endereços de duas variáveis
inteiras, min e max, e armazene nessas variáveis o valor mı́nimo e máximo do array.
Escreva também uma função main que use essa função.
25. Faça um programa que possua uma função para
• ler 2 notas e retorná-las por parâmetro (chamar uma função dedicada a ler 2 notas
válidas e que devolver os 2 números lidos);
• calcular a média simples e a média ponderada e retorná-las por parâmetro, onde a
segunda nota tem peso 2 media ponderada = (n1 + n2 ∗ 2)/3;
26. Implemente uma função que calcule as raı́zes de uma equação do segundo grau do tipo
Ax2 + Bx + C = 0. Lembrando que:
√
−B ± ∆
X=
2A
Onde
∆ = B 2 − 4AC
A variável A tem que ser diferente de zero.
• Se ∆ < 0 não existe real.
• Se ∆ = 0 existe uma raiz real.
• Se ∆ ≥ 0 existem duas raı́zes reais.
Essa função deve obedecer ao seguinte protótipo:
int raizes(float A,float B,float C,float * X1,float * X2);
Essa função deve ter como valor de retorno o número de raı́zes reais e distintas da
equação. Se existirem raı́zes reais, seus valores devem ser armazenados nas variáveis
apontadas por X1 e X2.

