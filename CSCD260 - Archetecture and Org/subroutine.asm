# Muangkong Yang
# CSCD260 - Subroutine

#main()
#{ 
#	print ( sbtract(5, 6) );
#}

#int sbtract(int a, int b)
#{ 
#	return( a-b );
#}

.data
numA: .word 5
numB: .word 6
A: .asciiz "a="
B: .asciiz "b="
str: .asciiz "a - b = "

.text
main:					#start of main
	jal print			#call print
	# Done
	li $v0, 10			#end of main
	syscall

print:
	addi $sp, $sp, -4	##stack -4
	sw $ra, 0($sp)		#store return address
	
	lw $s0, numA		#s0 = 5
	lw $s1, numB		#s1 = 6
						
	addi $sp, $sp, -8	##stack -8
	sw $s0, 4($sp)		##### 4($sp) = 5
	sw $s1, 0($sp)		##### $0($sp) = 6
	
	jal sbtract			#call sbtract
	addi $sp, $sp, 8	##stack +8
	lw $ra, 0($sp)		#load return address
	addi $sp, $sp, 4	##stack +4
	
	move $t0, $v0		#move $v0 to $t0
						#print Integer in t0
	li $v0, 4
	la $a0, str
	syscall
	li $v0, 1
	addi $a0, $t0, 0
	syscall
						#return to main
	jr $ra
	
	
sbtract:
	lw $t1, 4($sp)		#a = 5
	lw $t2, 0($sp)		#b = 6
	
	addi $sp, $sp, -4	#stack -4
	sw $t1, 0($sp)		#store on stack
						##### a = 4($sp) = 5
	addi $sp, $sp, -4	#stack -4
	sw $t2, 0($sp)		#store on stack
						##### b = 0($sp) = 6
						
						#print a and b
	li $v0, 4
	la $a0, A
	syscall
	li $v0, 1
	addi $a0, $t1, 0
	syscall
	addi $v0, $0, 11
	addi $a0, $0, 0xD
	syscall
	li $v0, 4
	la $a0, B
	syscall
	li $v0, 1
	addi $a0, $t2, 0
	syscall
	addi $v0, $0, 11
	addi $a0, $0, 0xD
	syscall
	
						#subtract
	sub $v0, $t1, $t2	#store a - b in v0, MIPS Convention
						#val returning back
						
	addi $sp, $sp, 8	#stack +8
	jr $ra				#return to print