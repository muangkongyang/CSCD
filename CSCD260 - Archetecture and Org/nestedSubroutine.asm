# Muangkong Yang
# CSCD260 - Nested Subroutine

#int array[] = {3,5,21,7,3,4,5,8};
#int n_elem = 8;
#main()
#{
#	int i;int o_elem;
#	for(i=o_elem=0; i<n_elem; i++)
#	{
#		func( array[i] );
#	}
#}
#func(int num)
#{
#	if( num & 1 ) print_array( num );
#}
#print_array(int Num)
#{
#	syscall to print Num
#}

.data
arr: .word 3, 5, 21, 7, 3, 4, 5, 8
n_elem: .word 8

.text
main:
	la $a0, arr					#a0 = &arr[0]
	la $a1, n_elem				#&a1
	lw $a1, 0($a1)				#a1 = 8
	addi $s0, $s0, 0			#i = 0
	addi $s1, $s1, 0			#o_elem = 0
	for:
		bge $s0, $a1, endFor
		addi $sp, $sp, -4		##stack -4
		lw $t0, 0($a0)			#store array[0] on stack
		sw $t0, 0($sp)
		
		jal func
		
		addi $sp, $sp, 4		##stack +4
		addi $a0, $a0, 4		#next array offset
		addi $s0, $s0, 1		#i++
		b for
	endFor:
	
	##END
	addi $v0, $0, 10
	syscall
	
func:
	addi $sp, $sp, -4			##stack -4
	sw $ra, 0($sp)				#store func return address
	addi $sp, $sp, -4			##stack -4
	lw $t0, 8($sp)				#get value passed in
	sw $t0, 0($sp)				#store array[i] value to make it local
	lw $t1, 0($sp)				#load local value
	andi $t2, $t1, 1			#t2 = num & 1
	beq $t2, 0, funcReturn		#if(num & 1) print the odd num
								#else return
	jal print_array
	
	funcReturn:
	addi $sp, $sp, 4			##stack +4
	lw $ra, 0($sp)				#load return address
	addi $sp, $sp, 4			##stack +4
	jr $ra						#return from func

print_array:
	addi $sp, $sp, -4			##stack -4
	sw $ra, 0($sp)				#store print_array return address
	addi $sp, $sp, -4			##stack -4
	lw $t0, 8($sp)				#load num
								#print it out
	li $v0, 1
	addi $a0, $t0, 0
	syscall
	addi $v0, $0, 11
	addi $a0, $0, 0xD
	syscall
	
	addi $sp, $sp, 4			##stack +4
	lw $ra, 0($sp)				#load return address
	addi $sp, $sp, 4			##stack +4
	jr $ra						#return from print_array
	