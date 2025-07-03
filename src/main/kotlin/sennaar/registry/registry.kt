package club.doki7.sennaar.registry

import club.doki7.sennaar.Identifier
import club.doki7.sennaar.interned

sealed interface Entity {
    val name: Identifier

    val metadata: MutableMap<String, String>?
    var doc: List<String>?
    var group: String?
}

data class Typedef(
    override val name: Identifier,
    override val metadata: MutableMap<String, String>? = null,
    override var doc: List<String>? = null,
    override var group: String? = null,
    val target: Identifier
) : Entity
