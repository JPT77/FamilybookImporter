// Define a grammar called Hello
grammar PCAhnen;
@header {
package de.jpt.genealogy.familybookparser.antlr;
}
r  : '<'ID'>' ;         // start of record
ID : [0-9]+ ;             // id is a number
//WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
