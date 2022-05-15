.data

msg_num1: .asciiz "Digite o primeiro valor:"
msg_num2: .asciiz "Digite o segundo valor:"
msg_pedido: .asciiz "Digite 1 para somar\nDigite 2 para subtrair\nDigite 3 para multiplicar\nDigite 4 para dividir\nDigite 0 para finalizar\n"
msg_resultado: .asciiz "\nResultado:  "
msg_finalizar: .asciiz "\nPrograma finalizado"

.text
li $v0, 4
la $a0, msg_pedido
syscall
li $v0, 5
syscall
move $t1, $v0

li $v0, 4
la $a0, msg_num1
syscall
li $v0, 5
syscall
move $t2, $v0

li $v0, 4
la $a0, msg_num2
syscall
li $v0, 5
syscall
move $t3, $v0

beq $t1,1,soma
beq $t1,2,subtracao
beq $t1,3,multiplicacao
beq $t1,4,divisao

soma: 
add $t4,$t2,$t3
li $v0, 4
la $a0, msg_resultado
syscall
li $v0, 1
la $a0, ($t4)
syscall 
li $v0,10
syscall

subtracao:
sub $t4,$t2,$t3
li $v0, 4
la $a0, msg_resultado
syscall
li $v0, 1
la $a0, ($t4)
syscall 
li $v0,10
syscall


multiplicacao:
mul $t4,$t2,$t3
li $v0, 4
la $a0, msg_resultado
syscall
li $v0, 1
la $a0, ($t4)
syscall 
li $v0,10
syscall


divisao:
div $t4,$t2,$t3
li $v0, 4
la $a0, msg_resultado
syscall
li $v0, 1
la $a0, ($t4)
syscall 



beq $t1,0,finalizar

finalizar:
li $v0, 4
la $a0, msg_finalizar
syscall
li $v0,10
syscall
