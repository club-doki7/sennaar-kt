package club.doki7.sennaar.cpl

import club.doki7.sennaar.Identifier

sealed interface CExpr

data class CIntLiteralExpr(val value: Long, val suffix: String? = null) : CExpr
data class CFloatLiteralExpr(val value: Double, val suffix: String? = null) : CExpr
data class CCharLiteralExpr(val value: Char) : CExpr
data class CStringLiteralExpr(val value: String) : CExpr
data class CIdentifierExpr(val identifier: Identifier) : CExpr

data class CIndexExpr(val base: CExpr, val index: CExpr) : CExpr
data class CCallExpr(val callee: CExpr, val args: List<CExpr>) : CExpr
data class CMemberExpr(val obj: CExpr, val member: Identifier) : CExpr
data class CPtrMemberExpr(val obj: CExpr, val member: Identifier) : CExpr
data class CPostfixIncExpr(val expr: CExpr) : CExpr
data class CPostfixDecExpr(val expr: CExpr) : CExpr

data class CUnaryExpr(val op: CUnaryOp, val expr: CExpr) : CExpr

enum class CUnaryOp {
    PLUS,
    MINUS,
    NOT,
    BIT_NOT,
    DEREF,
    ADDR_OF,
    SIZEOF
}

data class CCastExpr(val typeName: Identifier, val expr: CExpr) : CExpr

data class CBinaryExpr(val op: CBinaryOp, val lhs: CExpr, val rhs: CExpr) : CExpr

enum class CBinaryOp(val precedence: Int) {
    // Multiplicative
    MUL(3000), DIV(3000), MOD(3000),
    // Additive
    ADD(4000), SUB(4000),
    // Shift
    SHL(5000), SHR(5000),
    // Relational
    LT(6000), GT(6000), LE(6000), GE(6000),
    // Equality
    EQ(7000), NE(7000),
    // Bitwise
    BIT_AND(8000), BIT_XOR(9000), BIT_OR(10000),
    // Logical
    AND(11000), OR(12000),
    // Assignment
    ASSIGN(14000), MUL_ASSIGN(14000), DIV_ASSIGN(14000), MOD_ASSIGN(14000), ADD_ASSIGN(14000), SUB_ASSIGN(14000),
    SHL_ASSIGN(14000), SHR_ASSIGN(14000), AND_ASSIGN(14000), XOR_ASSIGN(14000), OR_ASSIGN(14000),
    // Comma
    COMMA(15000)
}

data class CConditionalExpr(val cond: CExpr, val then: CExpr, val otherwise: CExpr) : CExpr
