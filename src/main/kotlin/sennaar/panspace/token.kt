package club.doki7.sennaar.panspace

enum class TokenKind {
    // Keywords
    AUTO, BREAK, CASE, CHAR, CONST, CONTINUE, DEFAULT, DO, DOUBLE, ELSE, ENUM, EXTERN,
    FLOAT, FOR, GOTO, IF, INT, LONG, REGISTER, RETURN, SHORT, SIGNED, SIZEOF, STATIC,
    STRUCT, SWITCH, TYPEDEF, UNION, UNSIGNED, VOID, VOLATILE, WHILE,

    // C11/C23 Keywords
    ALIGNAS, ALIGNOF, ATOMIC, BOOL, CONSTEXPR, FALSE, GENERIC, NULLPTR,
    STATIC_ASSERT, THREAD_LOCAL, TRUE, TYPEOF, TYPEOF_UNQUAL,

    // Identifier
    IDENT,

    // Constants and Literals
    INTEGER,
    FLOATING,
    CHARACTER,
    STRING,

    // Punctuators
    LBRACKET,   // [
    RBRACKET,   // ]
    LPAREN,     // (
    RPAREN,     // )
    LBRACE,     // {
    RBRACE,     // }
    DOT,        // .
    ARROW,      // ->
    DPLUS,      // ++
    DMINUS,     // --
    AMP,        // &
    ASTER,      // *
    PLUS,       // +
    MINUS,      // -
    TILDE,      // ~
    BANG,       // !
    SLASH,      // /
    PERCENT,    // %
    DLT,        // <<
    DGT,        // >>
    LT,         // <
    GT,         // >
    LEQ,        // <=
    GEQ,        // >=
    DEQ,        // ==
    NEQ,        // !=
    CARET,      // ^
    PIPE,       // |
    DAMP,       // &&
    DPIPE,      // ||
    QUEST,      // ?
    COLON,      // :
    SEMI,       // ;
    TRIDOT,     // ...
    EQ,         // =
    ASTEREQ,    // *=
    SLASHEQ,    // /=
    PERCENTEQ,  // %=
    PLUSEQ,     // +=
    MINUSEQ,    // -=
    DLTEQ,      // <<=
    DGTEQ,      // >>=
    AMPEQ,      // &=
    CARETEQ,    // ^=
    PIPEEQ,     // |=
    COMMA,      // ,

    EOI
}

data class Token(
    val kind: TokenKind,
    val value: String,
    val line: Int,
    val col: Int,
    var syntaxTrivia: List<String>? = null
)
