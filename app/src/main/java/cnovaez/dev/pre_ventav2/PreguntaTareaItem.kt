package cnovaez.dev.pre_ventav2

data class PreguntaTareaItem(
    val title: String,
    val state: TareaResponseState,
    val onItemClick: () -> Unit
)