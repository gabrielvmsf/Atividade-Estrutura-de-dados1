.data

msg_num1: .asciiz "Digite o número desejado:"
msg_num2: .asciiz "O quadrado do número digitado é: "

.text

li $v0, 4
la $a0, msg_num1
syscall
li $v0, 5
syscall
move $t1,$v0


mul $t3,$t1,$t1

li $v0, 4
la $a0, msg_num2
syscall
li $v0, 1
la $a0, ($t3)
syscall