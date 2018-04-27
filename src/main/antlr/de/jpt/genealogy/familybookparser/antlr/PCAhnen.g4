grammar PCAhnen;
@header {
	package de.jpt.genealogy.familybookparser.antlr;
}
 
options { 
  output=AST; 
}

record     : husband  
             wife NEWLINE 
             children+ NEWLINE NEWLINE ;

husband    : ID SPACE name profession? REFERENCE? NEWLINE 
             (birth NEWLINE)?
             (death NEWLINE)? ;

wife       : INDENT marriage source? NEWLINE
             INDENT name NEWLINE
             (INDENT birth NEWLINE)? 
             (INDENT death NEWLINE)? ; 

children   : (child)* NEWLINE ;
child      : INDENT NO name birth source NEWLINE 
             (marriage NEWLINE)* ;

marriage   : MARRIAGE_PREFIX (SPACE DATE)? (SPACE place)? ;


name       : UPPERSTRING SPACE STRING ;
profession : STRING ;
birth      : BIRTH_PREFIX SPACE DATE SPACE place? source?;
death      : DEATH_PREFIX SPACE DATE SPACE place? source?;
source     : SOURCE_PREFIX STRING ;
place      : (LEBENSORT_PREFIX)? STRING ;

fragment LOWERCASE  : [a-zöäüß] ;
fragment UPPERCASE  : [A-ZÖÄÜ] ;
fragment DIGIT      : [0-9] ;
fragment DOT        : '.' ;

NO                  : DIGIT DOT SPACE;
INDENT              : '    ' ;
NEWLINE             : ('\r'? '\n' | '\r')+ ;
BIRTH_PREFIX        : '*' ;
DEATH_PREFIX        : '†' ;
SOURCE_PREFIX       : 'Qu: ' ;
MARRIAGE_PREFIX     : (DIGIT DOT)?('oo'|'00'|'OO') ;
LEBENSORT_PREFIX    : ('Lebensort:'|'Lebensorte:') SPACE ;

ID                  : '<' DIGIT+ '>' ;
REFERENCE           : '<' DIGIT+ DOT DIGIT'>' ;
DATE                : ( 'um' DOT | 'ca' DOT | ) (DIGIT DIGIT DOT DIGIT DIGIT DOT)? DIGIT DIGIT DIGIT DIGIT;

SPACE               : ' ' ;
UPPERSTRING         : UPPERCASE+ ;
STRING              : (LOWERCASE | UPPERCASE)+ ;
