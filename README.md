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
// Binary Search in Java

import java.util.*;

class BinarySearch {
    public static void binarySearch(int arr[], int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                System.out.println("Element is found at index: " + mid);
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Element is not found!");
        }
    }
    public static void main(String args[]) {
        int arr[] = {
            10,
            20,
            30,
            40,
            50
        };
        int key = 30;
        int last = arr.length - 1;
        binarySearch(arr, 0, last, key);
    }
}
```

#### Output

```java
Lexemes                                               Tokens
// Binary Search in Java                             SINGLE_LINE_COMMENT
import                                                KEYWORD (import)
java                                                  IDENTIFIER
.                                                     FULL_STOP
util                                                  IDENTIFIER
.                                                     FULL_STOP
*                                                     ARITHEMATIC_MULT
;                                                     SEMICOLON
class                                                 KEYWORD (class)
BinarySearch                                          IDENTIFIER
{                                                     LEFT_BRACES
public                                                KEYWORD (public)
static                                                KEYWORD (static)
void                                                  KEYWORD (void)
binarySearch                                          IDENTIFIER
(                                                     LEFT_PAREN
int                                                   KEYWORD (int)
arr                                                   IDENTIFIER
[                                                     LEFT_BRACKET
]                                                     RIGHT_BRACKET
,                                                     COMMA
int                                                   KEYWORD (int)
first                                                 IDENTIFIER
,                                                     COMMA
int                                                   KEYWORD (int)
last                                                  IDENTIFIER
,                                                     COMMA
int                                                   KEYWORD (int)
key                                                   IDENTIFIER
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
int                                                   KEYWORD (int)
mid                                                   IDENTIFIER
=                                                     ASSIGNMENT_OP
(                                                     LEFT_PAREN
first                                                 IDENTIFIER
+                                                     ARITHEMATIC_PLUS
last                                                  IDENTIFIER
)                                                     RIGHT_PAREN
/                                                     ARITHEMATIC_DIVISION
2                                                     INT_LITERAL
;                                                     SEMICOLON
while                                                 KEYWORD (while)
(                                                     LEFT_PAREN
first                                                 IDENTIFIER
<=                                                    RELATIONAL_LE
last                                                  IDENTIFIER
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
if                                                    KEYWORD (if)
(                                                     LEFT_PAREN
arr                                                   IDENTIFIER
[                                                     LEFT_BRACKET
mid                                                   IDENTIFIER
]                                                     RIGHT_BRACKET
<                                                     RELATIONAL_LT
key                                                   IDENTIFIER
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
first                                                 IDENTIFIER
=                                                     ASSIGNMENT_OP
mid                                                   IDENTIFIER
+                                                     ARITHEMATIC_PLUS
1                                                     INT_LITERAL
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
else                                                  KEYWORD (else)
if                                                    KEYWORD (if)
(                                                     LEFT_PAREN
arr                                                   IDENTIFIER
[                                                     LEFT_BRACKET
mid                                                   IDENTIFIER
]                                                     RIGHT_BRACKET
==                                                    RELATIONAL_EQUAL
key                                                   IDENTIFIER
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
System                                                IDENTIFIER
.                                                     FULL_STOP
out                                                   IDENTIFIER
.                                                     FULL_STOP
println                                               IDENTIFIER
(                                                     LEFT_PAREN
"Element is found at index: "                         STRING_LITERAL
+                                                     ARITHEMATIC_PLUS
mid                                                   IDENTIFIER
)                                                     RIGHT_PAREN
;                                                     SEMICOLON
break                                                 KEYWORD (break)
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
else                                                  KEYWORD (else)
{                                                     LEFT_BRACES
last                                                  IDENTIFIER
=                                                     ASSIGNMENT_OP
mid                                                   IDENTIFIER
-                                                     ARITHEMATIC_MINUS
1                                                     INT_LITERAL
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
mid                                                   IDENTIFIER
=                                                     ASSIGNMENT_OP
(                                                     LEFT_PAREN
first                                                 IDENTIFIER
+                                                     ARITHEMATIC_PLUS
last                                                  IDENTIFIER
)                                                     RIGHT_PAREN
/                                                     ARITHEMATIC_DIVISION
2                                                     INT_LITERAL
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
if                                                    KEYWORD (if)
(                                                     LEFT_PAREN
first                                                 IDENTIFIER
>                                                     RELATIONAL_GT
last                                                  IDENTIFIER
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
System                                                IDENTIFIER
.                                                     FULL_STOP
out                                                   IDENTIFIER
.                                                     FULL_STOP
println                                               IDENTIFIER
(                                                     LEFT_PAREN
"Element is not found!"                               STRING_LITERAL
)                                                     RIGHT_PAREN
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
}                                                     RIGHT_BRACES
public                                                KEYWORD (public)
static                                                KEYWORD (static)
void                                                  KEYWORD (void)
main                                                  IDENTIFIER
(                                                     LEFT_PAREN
String                                                IDENTIFIER
args                                                  IDENTIFIER
[                                                     LEFT_BRACKET
]                                                     RIGHT_BRACKET
)                                                     RIGHT_PAREN
{                                                     LEFT_BRACES
int                                                   KEYWORD (int)
arr                                                   IDENTIFIER
[                                                     LEFT_BRACKET
]                                                     RIGHT_BRACKET
=                                                     ASSIGNMENT_OP
{                                                     LEFT_BRACES
10                                                    INT_LITERAL
,                                                     COMMA
20                                                    INT_LITERAL
,                                                     COMMA
30                                                    INT_LITERAL
,                                                     COMMA
40                                                    INT_LITERAL
,                                                     COMMA
50                                                    INT_LITERAL
}                                                     RIGHT_BRACES
;                                                     SEMICOLON
int                                                   KEYWORD (int)
key                                                   IDENTIFIER
=                                                     ASSIGNMENT_OP
30                                                    INT_LITERAL
;                                                     SEMICOLON
int                                                   KEYWORD (int)
last                                                  IDENTIFIER
=                                                     ASSIGNMENT_OP
arr                                                   IDENTIFIER
.                                                     FULL_STOP
length                                                IDENTIFIER
-                                                     ARITHEMATIC_MINUS
1                                                     INT_LITERAL
;                                                     SEMICOLON
binarySearch                                          IDENTIFIER
(                                                     LEFT_PAREN
arr                                                   IDENTIFIER
,                                                     COMMA
0                                                     INT_LITERAL
,                                                     COMMA
last                                                  IDENTIFIER
,                                                     COMMA
key                                                   IDENTIFIER
)                                                     RIGHT_PAREN
;                                                     SEMICOLON
}                                                     RIGHT_BRACES
}                                                     RIGHT_BRACES
```
    
