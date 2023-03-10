# Java-Lexer

Simple Lexer/Scanner for Java programming language.

## Usage

* Go to the directory and use the following commands.

  ```bash
    javac Lexer.java
    java Lexer
  ```

* "source.txt" contains the source code to be scanned.  


## Sample

#### Input

```java
// Linear Search in Java
public class LinearSearch {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String a[]) {
        int[] a1 = {
            10,
            20,
            30,
            50,
            70,
            90
        };
        int key = 50;
        System.out.println(key + " is found at index: " + linearSearch(a1, key));
    }
}
```

#### Output

```java
// Linear Search in Java                             SINGLE_LINE_COMMENT
public                                                KEYWORD (public)
class                                                 KEYWORD (class)
LinearSearch                                          IDENTIFIER
{                                                     LEFT_BRACES
public                                                KEYWORD (public)
static                                                KEYWORD (static)
int                                                   KEYWORD (int)
linearSearch                                          IDENTIFIER
(                                                     LEFT_PAREN
int                                                   KEYWORD (int)
[                                                     LEFT_BRACKET
]                                                     RIGHT_BRACKET
arr                                                   IDENTIFIER
,                                                     COMMA
int                                                   KEYWORD (int)
key                                                   IDENTIFIER
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
for                                                   KEYWORD (for)
(                                                     LEFT_PAREN
int                                                   KEYWORD (int)
i                                                     IDENTIFIER
=                                                     ASSIGNMENT_OP
0                                                     INT_LITERAL
;                                                     SEMICOLON
i                                                     IDENTIFIER
<                                                     RELATIONAL_LT
arr                                                   IDENTIFIER
.                                                     FULL_STOP
length                                                IDENTIFIER
;                                                     SEMICOLON
i                                                     IDENTIFIER
++                                                    INC_OP
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
if                                                    KEYWORD (if)
(                                                     LEFT_PAREN
arr                                                   IDENTIFIER
[                                                     LEFT_BRACKET
i                                                     IDENTIFIER
]                                                     RIGHT_BRACKET
==                                                    RELATIONAL_EQUAL
key                                                   IDENTIFIER
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
return                                                KEYWORD (return)
i                                                     IDENTIFIER
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
}                                                     RIGHT_BRACES
return                                                KEYWORD (return)
-                                                     ARITHEMATIC_MINUS
1                                                     INT_LITERAL
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
public                                                KEYWORD (public)
static                                                KEYWORD (static)
void                                                  KEYWORD (void)
main                                                  IDENTIFIER
(                                                     LEFT_PAREN
String                                                IDENTIFIER
a                                                     IDENTIFIER
[                                                     LEFT_BRACKET
]                                                     RIGHT_BRACKET
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
int                                                   KEYWORD (int)
[                                                     LEFT_BRACKET
]                                                     RIGHT_BRACKET
a1                                                    IDENTIFIER
=                                                     ASSIGNMENT_OP
{                                                     LEFT_BRACES
10                                                    INT_LITERAL
,                                                     COMMA
20                                                    INT_LITERAL
,                                                     COMMA
30                                                    INT_LITERAL
,                                                     COMMA
50                                                    INT_LITERAL
,                                                     COMMA
70                                                    INT_LITERAL
,                                                     COMMA
90                                                    INT_LITERAL
}                                                     RIGHT_BRACES
;                                                     SEMICOLON
int                                                   KEYWORD (int)
key                                                   IDENTIFIER
=                                                     ASSIGNMENT_OP
50                                                    INT_LITERAL
;                                                     SEMICOLON
System                                                IDENTIFIER
.                                                     FULL_STOP
out                                                   IDENTIFIER
.                                                     FULL_STOP
println                                               IDENTIFIER
(                                                     LEFT_PAREN
key                                                   IDENTIFIER
+                                                     ARITHEMATIC_PLUS
" is found at index: "                                STRING_LITERAL
+                                                     ARITHEMATIC_PLUS
linearSearch                                          IDENTIFIER
(                                                     LEFT_PAREN
a1                                                    IDENTIFIER
,                                                     COMMA
key                                                   IDENTIFIER
)                                                     RIGHT_PAREN
)                                                     RIGHT_PAREN
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
}                                                     RIGHT_BRACES
```
    
