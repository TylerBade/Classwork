# Tyler Bade
# IT 320 Programming Assignment 2
# I certify that this program is entirely my own creation.
# I have not shared this code with any other person. 

	.data
	.align 2
prompt1:
	.asciiz "What is integer a? "
prompt2:
	.asciiz "What is integer b? "
ansC:
	.asciiz "\nC is "
ansD:
	.asciiz "\nD is "
ansE:
	.asciiz "\nE is "

	.text
	
	li $v0, 4
	la $a0, prompt1
	syscall
	
	li $v0, 5
	syscall
	la $s0, ($v0) #stores a in $s0
	
	li $v0, 4
	la $a0, prompt2
	syscall
	
	li $v0, 5
	syscall
	la $s1, ($v0) #Stores b in $s1
	
	# c = 13 * a - b
	jal funcC
	
	# if a >= 0: d = a - 6 * b + 110
	# else: d = b - 91
	jal funcD
	
	# if a != b: e = a
	# else: e = (a - 3) * (b + 2)
	jal funcE
	
	li $v0, 4
	la $a0, ansC
	syscall
	
	li $v0, 1
	la $a0, ($s5)
	syscall
	
	li $v0, 4
	la $a0, ansD
	syscall
	
	li $v0, 1
	la $a0, ($s6)
	syscall
	
	li $v0, 4
	la $a0, ansE
	syscall
	
	li $v0, 1
	la $a0, ($s7)
	syscall
	
	li $v0, 10
	syscall

funcC: # Value C stored in $s5
	li $t0, 13
	subu $sp, $sp, 16
	sw $t0, 0($sp) # value 13
	sw $s0, 4($sp) # value a
	sw $s1, 8($sp) # value b
	sw $ra, 12($sp)
	
	lw $s5, 0($sp)
	lw $t1, 4($sp)
	mul $s5, $s5, $t1
	lw $t1, 8($sp)
	sub $s5, $s5, $t1
	
	lw $ra, 12($sp)
	addu $sp, $sp, 16
	jr $ra
	
funcD: # final value stored in $s6
	bltz $s0, elsestate
	li $t0, 6
	li $t1, 110
	subu $sp, $sp, 20
	sw $t0, 0($sp) # value 6
	sw $s1, 4($sp) # value b
	sw $s0, 8($sp) # value a
	sw $t1, 12($sp) # value 110
	sw $ra, 16($sp)
	
	lw $s6, 0($sp)
	lw $t0, 4($sp)
	mul $s6, $s6, $t0
	lw $t0, 8($sp)
	sub $s6, $t0, $s6
	lw $t0, 12($sp)
	add $s6, $s6, $t0
	
	lw $ra, 16($sp)
	addu $sp, $sp, 20
	jr $ra
	
elsestate:
	li $t0, 91
	subu $sp, $sp, 12
	sw $s1, 0($sp) # value b
	sw $t0, 4($sp) # value 91
	sw $ra, 8($sp)
	
	lw $s6, 0($sp)
	lw $t0, 4($sp)
	sub $s6, $s6, $t0
	
	lw $ra, 8($sp)
	addu $sp, $sp, 12
	jr $ra

funcE:
	beq $s0, $s1, elsebranch
	la $s7, ($s0)
	jr $ra
	
elsebranch:
	li $t0, 3
	li $t1, 2
	subu $sp, $sp, 20
	sw $s0, 0($sp)
	sw $t0, 4($sp)
	sw $s1, 8($sp)
	sw $t1, 12($sp)
	sw $ra, 16($sp)
	
	lw $t0, 0($sp)
	lw $t1, 4($sp)
	sub $s7, $t0, $t1
	lw $t2, 8($sp)
	lw $t3, 12($sp)
	add $t0, $t2, $t3
	mul $s7, $s7, $t0
	
	lw $ra, 16($sp)
	addu $sp, $sp, 20
	jr $ra