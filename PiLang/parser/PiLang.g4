// antlr4 -package parser -o antlr-generated  -no-listener parser/PiLang.g4
grammar PiLang;

prog: varDecls funcDecl*
	;

funcDecl: 'function' IDENTIFIER '(' params ')' '{' varDecls stmt* '}'
    ;

params:   /* no parameter */
    | IDENTIFIER (',' IDENTIFIER)*
    ;

varDecls: ('var' IDENTIFIER ';')*
    ;

stmt: '{' stmt* '}'							# compoundStmt
	| IDENTIFIER '=' expr ';'				# assignStmt
	| 'if' '(' expr ')' stmt 'else' stmt	# ifStmt
	| 'while' '(' expr ')' stmt				# whileStmt
	| 'return' expr ';'						# returnStmt
	| 'print' expr ';'						# printStmt
	;

expr: orExpr
      ;
      
orExpr: orExpr OROP andExpr
	| andExpr
	;

andExpr: andExpr ANDOP addExpr
	| addExpr
	;

addExpr: addExpr ADDOP mulExpr
    | addExpr SUBOP mulExpr
	| mulExpr
	;

mulExpr: mulExpr MULOP unaryExpr
	| unaryExpr
	;

unaryExpr: VALUE					# literalExpr
	| IDENTIFIER					# varExpr
	| '(' expr ')'				# parenExpr
	| SUBOP expr					# subExpr
	| NOTOP expr					# notExpr
	| IDENTIFIER '(' args ')' 	# callExpr
	;

args: /* no arguments */
	| expr ( ',' expr )*
	;

ADDOP: '+';
MULOP: '*'|'/';
ANDOP: '&';
OROP: 	'|';
SUBOP: '-';
NOTOP:	'~';

IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*|'main';
VALUE: [1-9][0-9]*|'0';
WS: [ \t\r\n] -> skip;
