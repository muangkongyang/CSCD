# Muangkong Yang
# CSCD260 - Bubble Sort

.data
array: .word -2, -2, 3, 3, 5, 0, 0, 0, 1, 1, 0, 0, 0, 99, -1, -1, -1, 2, 2, 2
n_element: .word 20

.text
main:
la $a2, n_element
lw $a2, 0($a2) # a2 <= n_element
addi $t1, $0, 0 # sorted = 0
addi $t9, $0, 0 # t9 : counter
la $a1, array # a1 = &array[0]
addi $t0, $0, 0 # for t0=0 to
addi $a2, $a2, -1 # because we do [i+1]
#
#
#print array before sort
pb:
lw $t7, 0($a1)
add $a0, $t7, 0
addi $v0, $0, 1
syscall
addi $a0, $0, 0x20 # ascii 0x20 = ' '
addi $v0, $0, 11
syscall
addi $a1, $a1, 4
addi $t9, $t9, 1
beq $t9, 20, newLine
b pb
newLine:
add $a0, $t8, 0
addi $v0, $0, 1
syscall
addi $a0, $0, 0x0D # ascii 0x0D = CR
addi $v0, $0, 11
syscall
#
#
# resets when array is still not sorted
# IMPORTANT STEP!!
notsorted:
addi $t1, $t1, 1	# sorted == 1
addi $t9, $t9, -19	# counter = 0, from 19
addi $a1, $a1, -76	# &array[0] from end of array

top:
lw $t7,0($a1) # t7 = array[i]
lw $t8,4($a1) # t8 = array[i+1]

# print the data comparison
#add $a0, $t7, 0
#addi $v0, $0, 1
#syscall
#addi $a0, $0, 0x20 # ascii 0x20 = ' '
#addi $v0, $0, 11
#syscall
#add $a0, $t8, 0
#addi $v0, $0, 1
#syscall
#addi $a0, $0, 0x0D # ascii 0x0D = CR
#addi $v0, $0, 11
#syscall

#determineSwap
bleu $t7, $t8, noswap # jump if t7 is less than t8
lw $t5, 0($a1) # t7 value
lw $t6, 4($a1) # t8 value
sw $t6, 0($a1) # swap
sw $t5, 4($a1) # swap 
beq $t1, 0, noupdate
addi $t1, $t1, -1

noupdate:
noswap:
addi $a1, $a1, 4 # next array offset
addi $t9, $t9, 1 # counter++
beq $t9, $a2, quit
b top

quit:
beq $t1, 0, notsorted # do it again until sorted

#reset for end print
addi $t9, $t9, -19
addi $a1, $a1, -76
#
#
#print array after sort
pa:
lw $t7, 0($a1)
add $a0, $t7, 0
addi $v0, $0, 1
syscall
addi $a0, $0, 0x20 # ascii 0x20 = ' '
addi $v0, $0, 11
syscall
addi $a1, $a1, 4
addi $t9, $t9, 1
beq $t9, 20, done
b pa
#
#
done:
addi $v0, $0, 10
syscall
########################################
#Bubble Sort Algorithmn
#array[]
#while(sorted == 0)
#sorted == 1
#for(i=0; i < MAX-1; i++)
#{
#	if(array[i] > array[i+1])
#	{
#		t = array[i]
#		array[i] = array[i+1]
#		array[i+1] = t
#		sorted = 0
#	}
#}
