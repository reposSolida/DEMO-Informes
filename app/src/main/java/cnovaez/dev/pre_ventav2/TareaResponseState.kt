package cnovaez.dev.pre_ventav2

enum class TareaResponseState {
    Answered, NotAnswered;

    override fun toString(): String {
        return when (this) {
            Answered -> "A"
            NotAnswered -> "N"
        }
    }
}