grammar PCAhnen2;
@header {
	package de.jpt.genealogy.familybookparser.antlr;
}

record     : ID SPACE line+ ;

line       : ANY+ NEWLINE ;

NEWLINE    : ('\r'? '\n' | '\r')+ ;
ID         : '<' DIGIT+ '>' ;
SPACE      : ' ' ;

//fragment 
ANY      : '[a-z0-9A-Z_-.()öäüÖÄÜß:*†<>]' ;
fragment DIGIT    : [0-9] ;
