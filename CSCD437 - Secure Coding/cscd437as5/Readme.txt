Muangkong Yang
CSCD437 - Secure Coding
Assignment 5 - RegularExpressions

Sites used
https://www.geeksforgeeks.org/pattern-compilestring-method-in-java-with-examples/
	> used to get a start with Pattern and Matcher to determine if expressions are correct
	
https://www.tutorialspoint.com/Java-program-to-find-if-the-given-number-is-a-leap-year
	> used to find how to determine a leap year for Date method
	
https://www.mkyong.com/regular-expressions/regular-expression-case-sensitive-example-java/
	> used to find out how to make url case insensitive
a) https://www.kerryr.net/pioneers/ascii3.htm
	> list of all punctuation marks, excluding the numbers

a. SSN
	 * Group 1: 3 numbers
	 * Group 2: 2 numbers
	 * Group 3: 4 numbers
	 * each group separated by either - or whitespace or nothing
ex/
Valid: 123-45-6789
Invalid: 123 3 51245

b. Phone#
	 * Group 1: May consist of () for the first 3 numbers 
	 * Group 2: then 3
	 * Group 3: then 4
	 * - and 1 whitespace are optional between the 3 groups
ex/
Valid: (509) 438-1568
Invalid: 50912345678

c. Email
	 * Group 1: start with 1 or more letters/numbers with optional -, _- . no spaces
	 * Group 2: must have @ symbol after group 1
	 * Group 3: 1 or more letters/numbers with optional -, _
	 * Group 4: followed by 1 or more 2-3 length word with period '.' in front
ex/
Valid: first.last@email.com
Invalid: name@email

d. Name
	 * Group 1: last name with first letter capitalized followed by 1 or more lowercase letters and ending with ','
	 * Group 2: Repeat group 1 with first name
	 * Group 3: 1 or more middle names followed of 1 or 2 capital letters followed by period '.' and space between them
ex/
Valid: Last, First, O. I. EP. HE. LL. OO.
Invalid: last, first MI.

e. Date
	 * Group 1: Any 1 or 2 numbers for month (e.g. 1, 01, 2, 02...)
	 * Group 2: Any 1 or 2 numbers for day   (e.g. 1, 01, 20, 30...)
	 * Group 3: Must be 4 numbers for year that is less than 3000
	 * groups must be separated by only 1 of / or - (e.g. mm/dd/yyyy or mm-dd-yyyy)
	 * Date must be real and not fictionous.
ex/
Valid: 2-29-2000
Invalid: 1/30/3000

f. House Address
	 * Group 1: Must start with 1 or more numbers
	 * Group 2: Optional direction N, NW, NE, W... (capitalized)
	 * Group 3: Starts with either a captial letter or number
	 * Group 4: follows up with letters or space
	 * Group 5: some street suffixes
ex/
Valid: 537 NW Hamilton St
Invalid: 28135 e central rd

g. City, State Zip
	 * Group 1: 1 capital letter following with 1 or more lowercase letters and ending with comma and space
	 * Group 2: 2 capital letters for state
	 * Group 3: 5 numbers for zip OR 5 numbers for zip and 4 numbers for extra with - between
	 * state must be valid
ex/
Valid: Cheney, WA 99008-4651
Invalid: Pullman, wa 13241

h. Miltary Time
	 * Group 1: 2 numbers representing hour
	 * Group 2: ':' in between
	 * Group 3: 2 numbers representing seconds
	 * check if hour is valid - 2 digits and from 00 - 23
	 * check if minutes is valid - 2 digits and from 00 - 59
ex/
Valid: 23:59
Invalid: 14:60

i. US Currency
	 * Group 1: '$' at beginning
	 * Group 2: number must not have any leading zeroes (e.g. cannot be $021.00)
	 * Group 3: optional 3 digit number with comma in front indicating next thousand's place
	 * Group 4: if not group 2 or 3, assuming below 1 dollar, 1 or 2 0s must be present (e.g. $0.00, $00.00)
	 * Group 5: '.'
	 * Group 6: 2 numbers representing cents
ex/
Valid: $1,234.99
Invalid: $010.00

j. URL
	 * Group 1: indicate case insensitivity
	 * Group 2: optional "http(s)://"
	 * Group 3: optional "www"
	 * Group 4: website name with 1 or more letters or numbers, _ or -
	 * Group 5: '.' and then 1 or more 2-3 letter word (e.g. .com)
	 * Group 6: 2 numbers representing cents
ex/
Valid: HTTPS://CANVAS.EWU.EDU
Invalid: 123.32.158.com

k. Password

> Must have 1 Uppercase character, 1 Lowercase character, length of 10 or more, 1 Punctuation mark, 
no more than consecutive 3 lowercase characters !(n > 3), so having 3 is maximum.
	 * Group 1: positive lookahead a digits
	 * Group 2: negative lookahead for no more than 3 consecutive lowercase letters !(n > 3) (n<=3)
	 * 			(e.g. abcd)
	 * Group 3: postive lookahead for a lowercase letter
	 * Group 4: positive lookahead for an uppercase letter
	 * Group 5: positive lookahead for a special character
	 * Group 6: must be at least 10 length

*Refer to a) link above for list of punctuation marks

ex/ 
Valid: Log2of100EquALS?
Invalid: AttackOrDefend?

l. ION
	 * Group 1: can have 0 or more (2 or more uppercase or lower case letters)
	 * 		 	this makes the count always 2 characters + 3 characters(from ion) odd
	 * Group 2: case insensitive ion

ex/
Valid: portion
Invalid: cation

***No shortcomings