# Muangkong Yang
# CSCD260 - Recursion

#main()
#{ keyboard_input N;
#sum = rec_add( N );
#print sum;
#}
#rec_add( word n )
#{ if (n==0) return 0;
#return ( rec_add( n-1 ) + n );
#}

.data
keyboard_input: .asciiz "Enter number: "
sum: .space 4

.text
.globl main

main:
### do not change this sp print code below.
addi $v0, $0, 1
addi $a0, $sp, 0
syscall
addi $v0, $0, 11
addi $a0, $0, 0xD
syscall
### do not change this sp print code above.

###########################
## your code starts here ##
###########################

# Print keyboard_input string
li $v0, 4
la $a0, keyboard_input
syscall
# Read number
addi $v0, $0, 5
syscall

addi $t0, $v0, 0	#store input N in t0

# Print number
addi $v0, $0, 1
addi $a0, $t0, 0
syscall
addi $v0, $0, 11
addi $a0, $0, 0xD
syscall

addi $sp, $sp, -4	#stack -4
sw $t0, 0($sp)		#store N in stack

la $s0, sum			
addi $s0, $0, 0		#sum = 0

jal rec_add
addi $sp, $sp, 4

addi $v0, $0, 1
addi $a0, $s0, 0
syscall
addi $v0, $0, 11
addi $a0, $0, 0xD
syscall

#########################
## your code ends here ##
#########################

### do not change this sp print code below.
addi $v0, $0, 1
addi $a0, $sp, 0
syscall
addi $v0, $0, 11
addi $a0, $0, 0xD
syscall
### do not change this sp print code above.

## exit ##
addi $v0, $0, 10
syscall
## End main ##

###################################
## recursiv function starts here ##
###################################
rec_add:
	lw $t1, 0($sp)		#load N
	beq $t1, 0, return	#if(N==0) return;
						#else do rest
	addi $sp, $sp, -4	#stack -4
	sw $ra, 0($sp)		#store return address
	addi $sp, $sp, -4	#stack -4
	addi $t1, $t1, -1	#N = N - 1
	sw $t1, 0($sp)		#store N
	jal rec_add			#recursive call
	addi $sp, $sp, 4	#stack +4
	lw $ra, 0($sp)		#load return address
	addi $sp, $sp, 4	#stack +4
	lw $t1, 0($sp)
	add $s0, $s0, $t1	#sum = sum + N
	return:
	jr $ra				#return to previous function


#############################
## your function ends here ##
#############################

