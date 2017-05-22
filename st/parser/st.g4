// Grammer for Structured Text.
// refer: http://www.plcacademy.com/structured-text-tutorial/

grammar st;

//tokens {
//	PROGRAM,
//	END_PROGRAM
//}

prog :	'PROGRAM' prog_name 'END_PROGRAM' ;

prog_name :	ID ;

// statement :
// expression :
// operator :
// operand :

ID :	[a-zA-Z] [a-zA-Z0-9_]* ;
WD :	[ \r\t\n]+ -> skip ;

BLOCK_COMMENT1 :
	'/*' .*? '*/' -> skip	// '-> channel(HIDDEN)' is also ok
	;
BLOCK_COMMENT2 :
	'(*' .*? '*)' -> skip	// '-> channel(HIDDEN)' is also ok
	;

LINE_COMMENT :
	'//' ~[\r\n]* -> skip	// '-> channel(HIDDEN)' is also ok
	;

/*
 * What is 'tokens'? When it is used?
 */
