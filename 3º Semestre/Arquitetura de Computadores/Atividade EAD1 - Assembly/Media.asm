.data

msg_num1: .asciiz "Digite a primeira nota:"
msg_num2: .asciiz "Digite a segunda nota:"
msg_num3: .asciiz "Digite a terceira nota:"
msg_num4: .asciiz "Digite a quarta nota:"
resultado1: .asciiz "\nO aluno foi aprovado"
resultado2: .asciiz "\nO aluno foi reprovado"
resultado3: .asciiz "\nO aluno está de recuperação"
zero: .float 0.0
num1: .float 10
num2: .float 6
num3: .float 3
num: .float 4

.text

lwc1 $f7 , num
lwc1 $f9 , num1
lwc1 $f10 , num2
lwc1 $f11 , num3

li $v0, 4
la $a0, msg_num1
syscall
li $v0,6
syscall
lwc1 $f8, zero

add.s $f1, $f8, $f0

li $v0, 4
la $a0, msg_num2
syscall
li $v0,6
syscall


add.s $f2, $f1, $f0

li $v0, 4
la $a0, msg_num3
syscall
li $v0,6
syscall


add.s $f3, $f2, $f0

li $v0, 4
la $a0, msg_num4
syscall
li $v0,6
syscall

add.s $f4, $f3, $f0
div.s $f5, $f4, $f7
add.s $f12, $f8, $f5
li $v0, 2
syscall

c.lt.s $f5,$f9

bc1t aprovado


aprovado: 

c.lt.s $f5,$f10
bc1t recuperação

li $v0, 4
la $a0, resultado1
syscall
li $v0,10
syscall


recuperação:
c.lt.s  $f5,$f11
bc1t reprovado

li $v0, 4
la $a0, resultado3
syscall
li $v0,10
syscall

reprovado:
li $v0, 4
la $a0, resultado2
syscall
li $v0,10
syscall


