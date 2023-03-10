
import java.io.*;
import java.util.*;

public class Lexer {

    static char lookahead;

    public static void main(String[] args) throws IOException {
        // Read the source code from source.txt

        FileReader input = new FileReader("source.txt");
        BufferedReader read = new BufferedReader(input);
        
        System.out.println("Lexemes                                               Tokens");
        tokenizer(read);
    }

    public static void tokenizer(BufferedReader read) throws IOException {

        // Storing reserved words of Java into an array
        String[] ReservedWords = {
            "abstract", "continue", "for", "new", "switch",
            "assert", "default", "if", "package", "synchronized",
            "boolean", "do", "goto", "private", "this",
            "break", "double", "implements", "protected", "throw",
            "byte", "else", "import", "public", "throws",
            "case", "enum", "instanceof", "return", "transient",
            "catch", "extends", "int", "short", "try",
            "char", "final", "interface", "static", "void",
            "class", "finally", "long", "strictfp", "volatile",
            "const", "float", "native", "super", "while",
            "null", "true", "false"};

        // Create an array named “lexeme” to store lexeme.
        char lexeme[] = new char[1000];

        int flag;
        int i = 0;
        int j = 0;
        int state = 0;

        lookahead = (char) read.read();

        while (lookahead != '\uffff') {

            switch (state) {

                case 0: 

                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        state = 0;
                        lookahead = (char) read.read();
                    } else if (Character.isLetter(lookahead) || lookahead == '_' || lookahead == '$') {
                        state = 1;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '+') {
                        state = 3;
                        lexeme[i++] = lookahead;
                    } else if (Character.isDigit(lookahead)) {
                        state = 7;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '-') {
                        state = 13;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '*') {
                        state = 17;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '%') {
                        state = 20;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '=') {
                        state = 23;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '>') {
                        state = 26;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '<') {
                        state = 30;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '!') {
                        state = 34;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '&') {
                        state = 37;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '|') {
                        state = 40;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '~') {
                        state = 43;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '^') {
                        state = 44;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '/') {
                        state = 45;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '(') {
                        state = 53;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == ')') {
                        state = 54;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '{') {
                        state = 55;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '}') {
                        state = 56;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == ':') {
                        state = 57;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '\'') { // Single Quotes
                        read.mark(900);
                        state = 58;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '"') {
                        read.mark(900);
                        state = 63;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == ',') {
                        state = 68;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '.') {
                        state = 69;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == ']') {
                        state = 72;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '?') {
                        state = 73;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '[') {
                        state = 74;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == ';') {
                        state = 75;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '\\') {
                        state = 76;
                        lexeme[i++] = lookahead;
                    } else {
                        state = 100;
                        lexeme[i++] = lookahead;
                    }
                    break;

                case 1: 
                    lookahead = (char) read.read();
                    if (Character.isLetter(lookahead) || Character.isDigit(lookahead) || lookahead == '_' || lookahead == '$') {
                        state = 1;
                        lexeme[i++] = lookahead;

                    } else {
                        state = 2;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        flag = checkReserveWord(ReservedWords, lexeme, i);   // Check if reserved word
                        print(lexeme, "IDENTIFIER", flag, i);
                        i = 0;
                    }
                    break;
                case 2:  
                    state = 0;
                    break;
                case 3:  
                    lookahead = (char) read.read();
                    if (lookahead == '+') {
                        state = 4;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "INC_OP", 0, i);
                        i = 0;
                    } else if (lookahead == '=') {
                        state = 5;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "PLUS_EQUAL", 0, i);
                        i = 0;
                    } else {
                        state = 6;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "ARITHEMATIC_PLUS", 0, i);
                        i = 0;
                    }
                    break;

                case 4:  
                    lookahead = (char) read.read();
                    state = 0;

                    break;
                case 5:  
                    lookahead = (char) read.read();
                    state = 0;

                    break;
                case 6:  
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }

                    break;
                case 7:   
                    lookahead = (char) read.read();
                    if (Character.isDigit(lookahead)) {
                        state = 7;
                        lexeme[i++] = lookahead;
                    } else if (lookahead == '.') {
                        state = 8;
                        lexeme[i++] = lookahead;
                    } else {
                        state = 12;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "INT_LITERAL", 0, i);
                        i = 0;
                    }
                    break;

                case 8:     
                    lookahead = (char) read.read();
                    if (Character.isDigit(lookahead)) {
                        state = 10;
                        lexeme[i++] = lookahead;
                    } else {
                        state = 9;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "DOUBLE_LITERAL", 0, i);
                        i = 0;
                    }
                    break;
                case 9:  
                    state = 0;
                    break;
                case 10:   
                    lookahead = (char) read.read();
                    if (Character.isDigit(lookahead)) {
                        state = 10;
                        lexeme[i++] = lookahead;
                    } else {
                        state = 11;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "DOUBLE_LITERAL", 0, i);
                        i = 0;
                    }
                    break;
                case 11:  
                    state = 0;
                    break;
                case 12:    
                    state = 0;
                    break;
                case 13:   
                    lookahead = (char) read.read();
                    if (lookahead == '-') {
                        state = 14;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "DEC_OP", 0, i);
                        i = 0;
                    } else if (lookahead == '=') {
                        state = 15;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "MINUS_EQUAL", 0, i);
                        i = 0;
                    } else {
                        state = 16;
                        lexeme[i] = '\0';
                        print(lexeme, "ARITHEMATIC_MINUS", 0, i);
                        i = 0;
                    }
                    break;
                case 14:   
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 15:   
                    lookahead = (char) read.read();
                    state = 0;
                    //read.unread(lookahead);
                    break;
                case 16:   
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 17:
                    lookahead = (char) read.read();
                    if (lookahead == '=') {
                        state = 18;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "MULTI_EQUAL", 0, i);
                        i = 0;
                    } else {
                        state = 19;
                        lexeme[i] = '\0';
                        print(lexeme, "ARITHEMATIC_MULT", 0, i);
                        i = 0;
                    }
                    break;
                case 18:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 19:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 20:
                    lookahead = (char) read.read();
                    if (lookahead == '=') {
                        state = 21;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "MODULO_EQUAL", 0, i);
                        i = 0;
                    } else {
                        state = 22;
                        lexeme[i] = '\0';
                        print(lexeme, "ARITHEMATIC_MODULO", 0, i);
                        i = 0;
                    }
                    break;
                case 21:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 22:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 23:
                    lookahead = (char) read.read();
                    if (lookahead == '=') {
                        state = 24;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "RELATIONAL_EQUAL", 0, i);
                        i = 0;
                    } else {
                        state = 25;
                        lexeme[i] = '\0';
                        print(lexeme, "ASSIGNMENT_OP", 0, i);
                        i = 0;
                    }
                    break;
                case 24:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 25:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 26:
                    lookahead = (char) read.read();
                    if (lookahead == '>') {
                        state = 27;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "RIGHT_SHIFT", 0, i);
                        i = 0;
                    } else if (lookahead == '=') {
                        state = 28;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "RELATIONAL_GE", 0, i);
                        i = 0;
                    } else {
                        state = 29;
                        lexeme[i] = '\0';
                        print(lexeme, "RELATIONAL_GT", 0, i);
                        i = 0;
                    }
                    break;
                case 27:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 28:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 29:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 30:
                    lookahead = (char) read.read();
                    if (lookahead == '<') {
                        state = 31;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "LEFT_SHIFT", 0, i);
                        i = 0;
                    } else if (lookahead == '=') {
                        state = 32;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "RELATIONAL_LE", 0, i);
                        i = 0;
                    } else {
                        state = 33;
                        lexeme[i] = '\0';
                        print(lexeme, "RELATIONAL_LT", 0, i);
                        i = 0;
                    }
                    break;
                case 31:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 32:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 33:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 34:
                    lookahead = (char) read.read();
                    if (lookahead == '=') {
                        state = 36;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "RELATIONAL_NOTEQUAL", 0, i);
                        i = 0;
                    } else {
                        state = 35;
                        lexeme[i] = '\0';
                        print(lexeme, "LOGICAL_NOT", 0, i);
                        i = 0;
                    }
                    break;
                case 35:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 36:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 37:
                    lookahead = (char) read.read();
                    if (lookahead == '&') {
                        state = 38;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "LOGICAL_AND", 0, i);
                        i = 0;
                    } else {
                        state = 39;
                        lexeme[i] = '\0';
                        print(lexeme, "BITWISE_AND", 0, i);
                        i = 0;
                    }
                    break;
                case 38:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 39:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 40:
                    lookahead = (char) read.read();
                    if (lookahead == '|') {
                        state = 42;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "LOGICAL_OR", 0, i);
                        i = 0;
                    } else {
                        state = 41;
                        lexeme[i] = '\0';
                        print(lexeme, "BITWISE_OR", 0, i);
                        i = 0;
                    }
                    break;
                case 41:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 42:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 43:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "BITWISE_COMPLEMENT", 0, i);
                    i = 0;
                    break;
                case 44:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "LOGICAL_XOR", 0, i);
                    i = 0;
                    break;
                case 45:
                    lookahead = (char) read.read();
                    if (lookahead == '/') {
                        state = 46;
                        lexeme[i++] = lookahead;

                    } else if (lookahead == '*') {
                        state = 48;
                        lexeme[i++] = lookahead;

                    } else if (lookahead == '=') {
                        state = 51;
                        lexeme[i++] = lookahead;
                        lexeme[i] = '\0';                         // Storing null character at the end
                        print(lexeme, "DIVISION_EQUAL", 0, i);
                        i = 0;
                    } else {
                        state = 52;
                        lexeme[i] = '\0';
                        print(lexeme, "ARITHEMATIC_DIVISION", 0, i);
                        i = 0;
                    }
                    break;
                case 46:
                    while (lookahead != '\n' && lookahead != '\r' && lookahead != '\uffff') {
                        lookahead = (char) read.read();
                        lexeme[i++] = lookahead;
                    }
                    lexeme[i - 1] = '\0';                         // Storing null character at the end
                    print(lexeme, "SINGLE_LINE_COMMENT", 0, i);
                    i = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    state = 0;
                    break;
                case 48:
                    lookahead = (char) read.read();
                    lexeme[i++] = lookahead;
                    while (lookahead != '*' && lookahead != '\uffff') {

                        lookahead = (char) read.read();
                        lexeme[i++] = lookahead;

                    }
                    if (lookahead == '*') {
                        state = 49;
                    }

                    break;
                case 49:
                    lookahead = (char) read.read();
                    lexeme[i++] = lookahead;
                    if (lookahead == '/') {
                        state = 50;
                    } else if (lookahead == '*') {
                        state = 49;
                    } else {
                        state = 48;
                    }
                    break;
                case 50:
                    lookahead = (char) read.read();
                    lexeme[i++] = lookahead;
                    lexeme[i - 1] = '\0';                         // Storing null character at the end
                    print(lexeme, "MULTILINE_COMMENT", 0, i);
                    i = 0;
                    state = 0;
                    break;
                case 51:
                    lookahead = (char) read.read();
                    state = 0;
                    break;
                case 52:
                    state = 0;
                    if (lookahead == '\r' || lookahead == '\t' || lookahead == ' '
                            || lookahead == '\n' || lookahead == '\r') {
                        lookahead = (char) read.read();
                    }
                    break;
                case 53:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "LEFT_PAREN", 0, i);
                    i = 0;
                    break;
                case 54:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "RIGHT_PAREN", 0, i);
                    i = 0;
                    break;
                case 55: 
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "LEFT_BRACES", 0, i);
                    i = 0;
                    break;
                case 56: 
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "RIGHT_BRACES", 0, i);
                    i = 0;
                    break;
                case 57: 
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "COLON", 0, i);
                    i = 0;
                    break;

                case 58: 
                    lookahead = (char) read.read();
                    if (lookahead == '\\') {
                        lexeme[i++] = lookahead;
                        lookahead = (char) read.read();
                        if (lookahead == 't' || lookahead == 'n' || lookahead == 'b' || lookahead == 'r' || lookahead == 'f' || lookahead == '\\' || lookahead == '\'') {
                            state = 58;
                            lexeme[i++] = lookahead;
                            lookahead = (char) read.read();
                            if (lookahead == '\'') {
                                lexeme[i++] = lookahead;
                                state = 0;
                                lexeme[i] = '\0';
                                print(lexeme, "CHAR_LITERAL", 0, i);
                                i = 0;
                                lookahead = (char) read.read();
                            } else {
                                state = 0;
                                read.reset();
                                lexeme[i] = '\0';
                                print(lexeme, "SINGLE_QUOTATION", 0, 1);
                                i = 0;
                                lookahead = (char) read.read();
                            }
                        } else {
                            state = 0;
                            read.reset();
                            lexeme[i] = '\0';
                            print(lexeme, "SINGLE_QUOTATION", 0, 1);
                            i = 0;
                            lookahead = (char) read.read();
                        }
                    } else {
                        lexeme[i++] = lookahead;
                        if (lookahead == '\'') {
                            for (int k = 0; k < 2; k++) {
                                print(lexeme, "SINGLE_QUOTATION", 0, 1);
                            }
                            state = 0;
                            i = 0;
                            lookahead = (char) read.read();
                        } else {
                            lookahead = (char) read.read();
                            if (lookahead == '\'') {
                                lexeme[i++] = lookahead;
                                state = 0;
                                lexeme[i] = '\0';
                                print(lexeme, "CHAR_LITERAL", 0, i);
                                i = 0;
                                lookahead = (char) read.read();
                            } else {
                                state = 0;
                                read.reset();
                                lexeme[i] = '\0';
                                print(lexeme, "SINGLE_QUOTATION", 0, 1);
                                i = 0;
                                lookahead = (char) read.read();
                            }
                        }
                    }
                    break;

                case 63: 
                    lookahead = (char) read.read();
                    if (lookahead == '\n' || lookahead == '\r' || lookahead == '\uffff') {
                        state = 0;
                        read.reset();
                        lexeme[i] = '\0';
                        print(lexeme, "DOUBLE_QUOTATION", 0, 1);
                        i = 0;
                        lookahead = (char) read.read();
                    } else if (lookahead == '"') {
                        if (lexeme[i - 1] == '\\') {
                            lexeme[i - 1] = '"';
                            state = 63;
                        } else {
                            lexeme[i++] = lookahead;
                            state = 0;
                            lexeme[i] = '\0';
                            print(lexeme, "STRING_LITERAL", 0, i);
                            i = 0;
                            lookahead = (char) read.read();
                        }
                    } else {
                        lexeme[i++] = lookahead;
                        state = 63;
                    }
                    break;
                case 68:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "COMMA", 0, i);
                    i = 0;
                    break;
                case 69: 
                    lookahead = (char) read.read();
                    if (Character.isDigit(lookahead)) {
                        state = 70;
                        lexeme[i++] = lookahead;
                    } else {
                        state = 71;
                        lexeme[i] = '\0';
                        print(lexeme, "FULL_STOP", 0, i);
                        i = 0;
                    }
                    break;
                case 70: 
                    lookahead = (char) read.read();
                    if (Character.isDigit(lookahead)) {
                        state = 70;
                        lexeme[i++] = lookahead;
                    } else {
                        state = 0;
                        lexeme[i] = '\0';
                        print(lexeme, "DOUBLE_LITERAL", 0, i);
                        i = 0;
                    }
                    break;
                case 71: 
                    state = 0;
                    break;
                case 72:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "RIGHT_BRACKET", 0, i);
                    i = 0;
                    break;
                case 73:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "QUESTION_MARK", 0, i);
                    i = 0;
                    break;
                case 74:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "LEFT_BRACKET", 0, i);
                    i = 0;
                    break;
                case 75:
                    lookahead = (char) read.read();
                    state = 0;
                    lexeme[i] = '\0';
                    print(lexeme, "SEMICOLON", 0, i);
                    i = 0;
                    break;
                case 100:
                    print(lexeme, "UNRECOGNIZED_TOKEN", 0, 1);
                    lookahead = (char) read.read();
                    state = 0;
                    i = 0;
                default:

            } // END SWITCH

        }

    }

    public static int checkReserveWord(String[] ReservedWords, char[] a, int index) {

        char[] b = new char[index];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }

        String check = String.valueOf(b);
        for (int i = 0; i < ReservedWords.length; i++) {
            if (ReservedWords[i].equals(check)) {
                return 1;
            }
        }
        return 0;
    }

    public static void print(char[] lexeme, String s, int flag, int index) {
        if (flag == 1) {
            print(lexeme, lexeme);

        } else {
            char[] b = new char[index];
            for (int i = 0; i < b.length; i++) {
                b[i] = lexeme[i];
            }
            String st = String.valueOf(b);
            System.out.printf("%-53s %s", st, s);
            System.out.println("");
        }

    }

    public static void print(char[] lexeme, char[] c) {

        char[] ca = new char[15];
        for (int i = 0; i < lexeme.length; i++) {
            if (lexeme[i] != '\0') {
                ca[i] = lexeme[i];
            } else {
                break;
            }
        }

        String st = String.valueOf(ca);
        String trim = st.trim();
        System.out.printf("%-53s KEYWORD (%s)", trim, trim);
        System.out.println();

    }
}
