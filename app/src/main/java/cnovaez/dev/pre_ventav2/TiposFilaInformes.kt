package cnovaez.dev.pre_ventav2

enum class TiposFilaPorcentajes {
    CATEGORIA_PORCENTAJE, PRODUCTO_PORCENTAJE
}

enum class TiposFilaDetalles {
    CATEGORIA_DETALLE, PRODUCTO_DETALLE
}

interface  Items

data class ItemPorcentaje(
    val categoria: String,
    val nombre: String,
    val porcentaje: String,
    val tipoFila: TiposFilaPorcentajes,
    val estaExpandido: Boolean = false
): Items

data class ItemDetalle(
    val categoria: String,
    val nombre: String,
    val tipoFila: TiposFilaDetalles,
    val segmento: String,
    val diaVisita: String,
    val meta: String,
    val llegada: String,
    val sm: String,
    val estaExpandido: Boolean = false
): Items

val itemsTabla = mutableListOf(
    ItemPorcentaje(
        categoria = "Categoria 1",
        nombre = "Categoria 1",
        porcentaje = "14%",
        tipoFila = TiposFilaPorcentajes.CATEGORIA_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 1",
        nombre = "Categoria 1",
        tipoFila = TiposFilaDetalles.CATEGORIA_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "7",
        llegada = "1",
        sm = "14%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 1",
        nombre = "CDD CAB. SAUV.",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 1",
        nombre = "CDD CAB. SAUV.",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 1",
        nombre = "CDD CARM. O MERLOT",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 1",
        nombre = "CDD CARM. O MERLOT",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 1",
        nombre = "CDD RES. PRIVADA",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 1",
        nombre = "CDD RES. PRIVADA",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 1",
        nombre = "DIABLO BLACK",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 1",
        nombre = "DIABLO BLACK",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 1",
        nombre = "DIABLO DEEP",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 1",
        nombre = "DIABLO DEEP",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 1",
        nombre = "DIABLO RED",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 1",
        nombre = "DIABLO RED",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "1",
        sm = "100%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 1",
        nombre = "MARQUES DE CASA CONCHA",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 1",
        nombre = "MARQUES DE CASA CONCHA",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),

    ItemPorcentaje(
        categoria = "Categoria 2",
        nombre = "Categoria 2",
        porcentaje = "57%",
        tipoFila = TiposFilaPorcentajes.CATEGORIA_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 2",
        nombre = "Categoria 2",
        tipoFila = TiposFilaDetalles.CATEGORIA_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "7",
        llegada = "4",
        sm = "57%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 2",
        nombre = "CLOS DE PIRQUE T1000",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 2",
        nombre = "CLOS DE PIRQUE T1000",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 2",
        nombre = "CLOS DE PIRQUE T2000",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 2",
        nombre = "CLOS DE PIRQUE T2000",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "1",
        sm = "100%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 2",
        nombre = "EXP. SEL B1500 CAB.SAUV",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 2",
        nombre = "EXP. SEL B1500 CAB.SAUV",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "1",
        sm = "100%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 2",
        nombre = "EXP. SEL B1500 DULCE TINTO O FRUTAL",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 2",
        nombre = "EXP. SEL B1500 DULCE TINTO O FRUTAL",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "1",
        sm = "100%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 2",
        nombre = "EXP. SEL B1500 MERLOT",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 2",
        nombre = "EXP. SEL B1500 MERLOT",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 2",
        nombre = "EXPORTACIÓN T2000",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 2",
        nombre = "EXPORTACIÓN T2000",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Categoria 2",
        nombre = "SE SANTA EMILIANA B0700",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Categoria 2",
        nombre = "SE SANTA EMILIANA B0700",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "1",
        sm = "100%"
    ),

    ItemPorcentaje(
        categoria = "Cerveza Importada",
        nombre = "Cerveza Importada",
        porcentaje = "57%",
        tipoFila = TiposFilaPorcentajes.CATEGORIA_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Cerveza Importada",
        nombre = "Cerveza Importada",
        tipoFila = TiposFilaDetalles.CATEGORIA_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "3",
        llegada = "1",
        sm = "33%"
    ),
    ItemPorcentaje(
        categoria = "Cerveza Importada",
        nombre = "MILLER B0355",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Cerveza Importada",
        nombre = "MILLER B0355",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "1",
        sm = "100%"
    ),
    ItemPorcentaje(
        categoria = "Cerveza Importada",
        nombre = "MILLER B0650",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Cerveza Importada",
        nombre = "MILLER B0650",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),
    ItemPorcentaje(
        categoria = "Cerveza Importada",
        nombre = "MILLER LA473",
        porcentaje = "0%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Cerveza Importada",
        nombre = "MILLER LA473",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "0",
        sm = "0%"
    ),

    ItemPorcentaje(
        categoria = "Cerveza Nacional",
        nombre = "Cerveza Nacional",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.CATEGORIA_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Cerveza Nacional",
        nombre = "Cerveza Nacional",
        tipoFila = TiposFilaDetalles.CATEGORIA_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "2",
        llegada = "2",
        sm = "100%"
    ),
    ItemPorcentaje(
        categoria = "Cerveza Nacional",
        nombre = "KRPSS B0710 GOLDEN",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Cerveza Nacional",
        nombre = "KRPSS B0710 GOLDEN",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "1",
        sm = "100%"
    ),
    ItemPorcentaje(
        categoria = "Cerveza Nacional",
        nombre = "ODISSEA",
        porcentaje = "100%",
        tipoFila = TiposFilaPorcentajes.PRODUCTO_PORCENTAJE
    ),
    ItemDetalle(
        categoria = "Cerveza Nacional",
        nombre = "ODISSEA",
        tipoFila = TiposFilaDetalles.PRODUCTO_DETALLE,
        segmento = "MIN SEGMENTO E",
        diaVisita = "05.Viernes",
        meta = "1",
        llegada = "1",
        sm = "100%"
    ),
)

val categoriasPorcentajes = itemsTabla.filter { it is ItemPorcentaje && it.tipoFila == TiposFilaPorcentajes.CATEGORIA_PORCENTAJE }.toMutableList()