package cnovaez.dev.pre_ventav2

data class TareaItem(
    val title: String,
    val description: String,
    val cardColor: Int,
    val onItemClick: () -> Unit
)