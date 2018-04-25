// Define a grammar called Hello
grammar PCAhnen;
r  : '<'ID'>' ;         // start of record
ID : [0-9]+ ;             // id is a number
//WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
