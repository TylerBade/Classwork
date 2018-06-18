# Name: Tyler Bade
# I certify that this program is entirely my own creation
# (except for portions provided by the professor)
# I have not shared this code with any other person
# IT 320 PA 3
        .data
strt:   
        .word 28
        .word -60
        .word 99
        .word -82
        .word 23465
        .word -1342177280 
        .word 0  # Sentinel value to stop the program
    
prompt: .asciiz "The input key is "
tex1:   .asciiz "\nAfter processing the value "
tex2:   .asciiz " becomes "

        .text
main:   
        
        la   $a0, prompt
        li   $v0, 4          # system call code for print_str
        syscall              # Print the input prompt
    
        li   $v0, 5
        syscall
    
        la   $s0, strt       # address of start of array to $s0
        move $s2, $v0        # Key value is in $s2

loop:           
        # loads number from array in $t1
        lw $t1, 0($s0)
        # 0 = sentinel value
	beqz $t1, done
	
	# Checks the second bit from the left for if it's 0 or 1 (0100 --)
	andi $t2, $t1, 0x40000000
	# If the result of the andi statement = 0, goes to other branch.
	beqz $t2, elseloop
	
	# Creating mask for when bit 30 = 1
	# mask contains bits 0-4
	andi $t3, $s2, 0x0000001f
	# Shift the mask 2 bits to the left
	mul $t3, $t3, 4
	
	# Clears bits 2-6, stores new value in $t4
	andi $t4, $t1, 0xffffff83
	
	# combines mask in $t3 with number in $t4
	or $t5, $t4, $t3
	
	la $a0, tex1
	li $v0, 4
	syscall
	
	move $a0, $t1
	li $v0, 1
	syscall
	
	la $a0, tex2
	li $v0, 4
	syscall
	
	move $a0, $t5
	li $v0, 1
	syscall
	
	#increments array
	addu $s0, $s0, 4
        
        j   loop             # back to see if more work to do

elseloop:
	# Creates mask for when bit 30 = 0
	# mask contains bits 0-6
	andi $t3, $s2, 0x0000007f
	# Shifts the mask 8 bits to the left
	mul $t3, $t3, 256
	
	# Clears bit 8-14, stores in $t4
	andi $t4, $t1, 0xffff80ff
	
	# Combines mask in $t3 with number in $t4
	or $t5, $t4, $t3
	
	la $a0, tex1
	li $v0, 4
	syscall
	
	move $a0, $t1
	li $v0, 1
	syscall
	
	la $a0, tex2
	li $v0, 4
	syscall
	
	move $a0, $t5
	li $v0, 1
	syscall
	
	# Increments array
	addu $s0, $s0, 4
	
	j   loop
	
done:   
        li  $v0, 10
        syscall
