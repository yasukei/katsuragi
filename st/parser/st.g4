// Grammer for Structured Text.
// refer: http://www.plcacademy.com/structured-text-tutorial/

grammar st;

program :
	prog_section ;

prog_section :
	'PROGRAM' prog_name prog_body 'END_PROGRAM' ;

prog_name :
	ID ;

prog_body :
	(var_decl_section)* (statement ';')* ;

var_decl_section :
	'VAR' (var_decl)* 'END_VAR' ;

var_decl :
	var_name ':' var_type ';' ;

var_name :
	ID ;

var_type :
	ID ;

statement :
	assignment ;

assignment :
	var_name ':=' expression ;

expression :
	INT ;

// operator :
// operand :

ID :	[a-zA-Z] [a-zA-Z0-9_]* ;
WD :	[ \r\t\n]+ -> skip ;
INT :	'0' | [1-9][0-9]* ;

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
