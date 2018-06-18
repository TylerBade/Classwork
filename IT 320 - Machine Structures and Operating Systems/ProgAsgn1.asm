# Tyler Bade

# I certify that this program is entirely my own creation
# (except for portions provided by the professor).
# I have not shared this code with any other person.

	.data
prompt:
	.asciiz "Enter a string: "
cont:
	.asciiz "\nYour string contains: "
thar:
	.asciiz "\nThere are "
norm:
	.asciiz " characters."
ucchar:
	.asciiz " upper case characters."
lcchar:
	.asciiz " lower case characters."
digits:
	.asciiz " digits."
space:
	.asciiz " spaces."
other:
	.asciiz " other characters."
buffer:
	.space 80
	
	.text
	
	li $v0, 4
	la $a0, prompt
	syscall
	
	li $v0, 8
	la $a0, buffer
	li $a1, 80
	syscall
	
	la $t0, buffer
	li $s0, 0
	li $s1, '\n'
myloop: lb $t1, 0($t0)
	beq $t1, $s1, loopDone
	addi $s0, $s0, 1
	addi $t0, $t0, 1
	j myloop
loopDone:
	sb $0, 0($t0)
	
	move $t7, $s0 #$t7 now stores length of the string
		
	li $v0, 4
	la $a0, cont
	syscall
	
	li $v0, 1
	move $a0, $s0
	syscall
	
	li $v0, 4
	la $a0, norm
	syscall
	
	la $t0, buffer
	li $s0, 0
	li $t2, 'A'
	li $t3, 'Z'
myloopU: lb $t1, 0($t0)
	beqz $t1, loopDoneU
	blt $t1, $t2, elseU
	bgt $t1, $t3, elseU
	addi $s0, $s0, 1
	addi $t0, $t0, 1
	j myloopU
elseU:
	addi $t0, $t0, 1
	j myloopU
loopDoneU:
	
	add $t6, $t6, $s0 #$t6 stores the number of uppercase right now
	
	li $v0, 4
	la $a0, thar
	syscall
	
	li $v0, 1
	move $a0, $s0
	syscall
	
	li $v0, 4
	la $a0, ucchar
	syscall
	
	la $t0, buffer
	li $s0, 0
	li $t2, 'a'
	li $t3, 'z'
myloopL: lb $t1, 0($t0)
	beqz $t1, loopDoneL
	blt $t1, $t2, elseL
	bgt $t1, $t3, elseL
	addi $s0, $s0, 1
	addi $t0, $t0, 1
	j myloopL
elseL:
	addi $t0, $t0, 1
	j myloopL
loopDoneL:
	
	add $t6, $t6, $s0 # adds number of lowercase to number of uppercase
	
	li $v0, 4
	la $a0, thar
	syscall
	
	li $v0, 1
	move $a0, $s0
	syscall
	
	li $v0, 4
	la $a0, lcchar
	syscall
	
	
	la $t0, buffer
	li $s0, 0
	li $t2, '0'
	li $t3, '9'
myloopD: lb $t1, 0($t0)
	beqz $t1, loopDoneD
	blt $t1, $t2, elseD
	bgt $t1, $t3, elseD
	addi $s0, $s0, 1
	addi $t0, $t0, 1
	j myloopD
elseD:
	addi $t0, $t0, 1
	j myloopD
loopDoneD:
	
	add $t6, $t6, $s0 # adds number of digits to number of upper and lower case letters
	
	li $v0, 4
	la $a0, thar
	syscall
	
	li $v0, 1
	move $a0, $s0
	syscall
	
	li $v0, 4
	la $a0, digits
	syscall
	
	la $t0, buffer
	li $s0, 0
	li $t2, ' '
myloopS: lb $t1, 0($t0)
	beqz $t1, loopDoneS
	beq $t1, $t2, equalS
	addi $t0, $t0, 1
	j myloopS
equalS:
	addi $s0, $s0, 1
	addi $t0, $t0, 1
	j myloopS
loopDoneS:
	
	add $t6, $t6, $s0 # adds number of spaces to number of upper and lower case letters and numbers
	
	li $v0, 4
	la $a0, thar
	syscall
	
	li $v0, 1
	move $a0, $s0
	syscall
	
	li $v0, 4
	la $a0, space
	syscall
	
	sub $t4, $t7, $t6 # Takes all counted characters, subtracts them from length of string
	
	li $v0, 4
	la $a0, thar
	syscall
	
	li $v0, 1
	move $a0, $t4
	syscall
	
	li $v0, 4
	la $a0, other
	syscall
	
	li $v0, 10
	syscall
