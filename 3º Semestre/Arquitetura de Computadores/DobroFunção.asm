# Gabriel Vieira Melo ----------- 3º Periodo BCC

.data

resultado: .asciiz "Dobro:"

.text

li $t1, 2
jal dobro

li $v0, 4
la $a0, resultado
syscall
li $v0, 1
la $a0, ($t2)
syscall

li $v0,10
syscall

dobro: 
mul $t2,$t1,2
jr $ra
