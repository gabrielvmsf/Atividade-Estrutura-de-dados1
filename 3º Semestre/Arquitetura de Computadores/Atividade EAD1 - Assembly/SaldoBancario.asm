.data

msg_num2: .asciiz "\nOperação 1:depósito de um valor\nOperação 2: saque de um valor\nOperação 3: Visualizaçao da quantia\nOperação 4: Encerrar operação (finalizar programa).\n"
zero: .float 0.0
msg_dep: .asciiz "\nDigite a quantidade a ser depositada:\n"
msg_saq: .asciiz "\nDigite a quantidade a ser sacada:\n"
msg_qtd: .asciiz "\nA quantia é:\n"

.text


lwc1 $f8, zero
lwc1 $f6, zero

while:

li $v0, 4
la $a0, msg_num2
syscall
li $v0, 5
syscall
move $t1,$v0

beq $t1,1,deposito
beq $t1,2,saque
beq $t1,3,quantia
beq $t1,4,saida

j while

deposito:
li $v0, 4
la $a0, msg_dep
syscall
li $v0, 6
syscall

add.s $f6, $f0, $f6
add.s $f12, $f8, $f6
li $v0, 2
syscall

j while

saque:
li $v0, 4
la $a0, msg_saq
syscall
li $v0, 6
syscall

sub.s $f6, $f6, $f0
add.s $f12, $f8, $f6
li $v0, 2
syscall


j while

quantia:
li $v0, 4
la $a0, msg_qtd
syscall

add.s $f12, $f8, $f6
li $v0, 2
syscall

j while

saida:
li $v0,10
syscall