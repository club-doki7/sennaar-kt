package club.doki7.sennaar.panspace

fun interface MacroExpander {
    fun expand(macroName: String, args: String): String
}

data class TokenizerOptions(
    val knownTypes: Set<String> = emptySet(),
    val triviaMacros: Set<String> = emptySet(),
    val triviaCallAlikeMacros: Set<String> = emptySet(),
    val macros: Map<String, String> = emptyMap(),
    val callAlikeMacros: Map<String, MacroExpander> = emptyMap()
)

class Tokenizer(
    val source: List<String>,
    val line: Int,
    val col: Int,
    val tokenizerOptions: TokenizerOptions,
    val patchedSources: MutableMap<Int, String> = mutableMapOf()
)
