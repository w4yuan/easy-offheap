grammar EasyOffheap;

// 词法规则
PACKAGE     : 'package';
ORIGIN      : 'origin';
REPEATED    : 'repeated';
STRUCT      : 'struct';
LONG        : 'long';
STRING      : 'string';
BYTE        : 'byte';
BOOLEAN     : 'boolean';
FLOAT       : 'float';
DOUBLE      : 'double';
INT         : 'int';
CHAR        : 'char';
DEFAULT     : 'def';
EQUAL       : '=';
SEMI        : ';';
LCURLY      : '{';
RCURLY      : '}';
DOT         : '.';
ID          : LITERAL (LITERAL | INTLIT | '<' | '>')*;  // 标识符（ID）
// 字面量
LITERAL     : [a-zA-Z_];
// 整数字面量
INTLIT      : [0-9]+;

WS          : [ \t\r\n]+ -> skip;  // 忽略空白字符


// 语法规则
// 包名
idlFile     : package? structDef+;  // 文件中可以包含多个结构定义
package     : PACKAGE package_name SEMI;
package_name: ID (DOT ID)*;
structDef   : STRUCT ID LCURLY fieldDef* RCURLY;  // 结构体定义
fieldDef    : ORIGIN? REPEATED? fieldType ID EQUAL INTLIT defaultDef? SEMI;  // 字段定义
defaultDef  : DEFAULT defValue;
defValue    : (ID | INTLIT | DOT | '-')+;
fieldType   : LONG
            | STRING
            | BYTE
            | BOOLEAN
            | FLOAT
            | DOUBLE
            | INT
            | CHAR
            | ID;  // 支持的字段类型


