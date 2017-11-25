// antlr4 -package parser -o antlr-generated  -no-listener parser/TinyPiS.g4
grammar TinyPiS;

prog: varDecls stmt
	 ;
	
varDecls: ('var' IDENTIFIRE ';')*
	;
	
stmt: '{' stmt* '}'					  			# compoundStmt
	| IDENTIFIRE '=' expr ';'		  			# assignStmt
	| 'if' '(' expr ')' stmt 'else' stmt		# ifStmt
	| 'while' '(' expr ')' stmt					# whileStmt
	;

expr: addExpr
      ;

addExpr: addExpr ADDOP mulExpr
	| mulExpr
	;

mulExpr: mulExpr MULOP unaryExpr
	| unaryExpr
	;

unaryExpr: VALUE			# literalExpr
	| IDENTIFIRE			# varExpr
	| '(' expr ')'			# parenExpr
	;

ADDOP: '+'|'-';
MULOP: '*'|'/';

IDENTIFIRE: 'x'|'y'|'z'|'answer';
VALUE: [0-9]+;
WS: [ \t\r\n] -> skip;
