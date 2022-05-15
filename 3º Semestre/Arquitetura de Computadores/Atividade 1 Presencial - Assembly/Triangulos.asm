.data
msg_num1: .asciiz "Digite o tamanho do primeiro lado:"
msg_num2: .asciiz "Digite o tamanho do primeiro lado:"
msg_num3: .asciiz "Digite o tamanho do primeiro lado:"
msg_Equ: .asciiz "Equilatero: Todos os lados iguais"
msg_Esc: .asciiz "Escaleno: Todos os lados diferentes"
msg_Iso: .asciiz "Isoceles: dois lados iguais"

.text
li $v0, 4
la $a0, msg_num1
syscall
li $v0, 5
syscall
move $t1, $v0

li $v0, 4
la $a0, msg_num2
syscall
li $v0, 5
syscall
move $t2, $v0

li $v0, 4
la $a0, msg_num3
syscall
li $v0, 5
syscall
move $t3, $v0

beq $t1,$t2,Equal
beq $t2,$t3,EqualB
bne $t1,$t2,Dif
bne $t2,$t3,DifB



Dif:
beq $t2,$t3,DifA


DifA:
li $v0, 4
la $a0, msg_Esc
syscall
li $v0,10
syscall

DifB:
bne $t1,$t2,DifC

DifC:
li $v0, 4
la $a0, msg_Esc
syscall
li $v0,10
syscall

Equal:
beq $t2,$t3,EqualA

EqualA:
li $v0, 4
la $a0, msg_Equ
syscall
li $v0,10
syscall

EqualB:
beq $t1,$t2,EqualC

EqualC:
li $v0, 4
la $a0, msg_Equ
syscall
li $v0,10
syscall

beq $t1,$t2,IsoA
beq $t2,$t3,IsoB

IsoA:
li $v0, 4
la $a0, msg_Iso
syscall
li $v0,10
syscall

IsoB:
li $v0, 4
la $a0, msg_Iso
syscall
li $v0,10
syscall
