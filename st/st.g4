// Grammer for Structured Text.

grammar st;

tokens {
	PROGRAM,
	END_PROGRAM
}

prog:	PROGRAM END_PROGRAM ;

// prog:	(expr NEWLINE)* ;
// expr:	expr ('*'|'/')
// expr
// 	|	expr ('+'|'-')
// expr
// 	|	INT
// 	|	'(' expr ')'
// 	;
// NEWLINE	: [\r\n]+ ;
// INT		: [0-9]+ ;

/*
 * What is 'channels'?
 */
