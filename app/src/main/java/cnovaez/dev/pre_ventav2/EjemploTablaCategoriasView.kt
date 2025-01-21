package cnovaez.dev.pre_ventav2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope

@Composable
fun Tabla() {
    val lista = remember { mutableStateOf(categoriasPorcentajes) }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = lista.value) { item ->
            when (item) {
                is ItemPorcentaje -> {
                    PorcentajeItem(item, lista)
                }

                is ItemDetalle -> {
                    DetalleItem(item, lista)
                }
            }
        }
    }
}

@Composable
fun PorcentajeItem(item: ItemPorcentaje, lista: MutableState<MutableList<Items>>) {
    val color = if (item.tipoFila == TiposFilaPorcentajes.CATEGORIA_PORCENTAJE) {
        Color.Green
    } else {
        Color.Blue
    }

    Card(
        border = BorderStroke(2.dp, color),
        modifier = Modifier
            .padding(2.dp)
            .wrapContentHeight()
            .padding(2.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    mostrarDetalles(item, lista)
                }
        ) {
            Text(
                text = item.nombre,
            )
            Text(
                text = item.porcentaje,
            )
        }

    }
}

@Composable
fun DetalleItem(item: ItemDetalle, lista: MutableState<MutableList<Items>>) {
    val color = if (item.tipoFila == TiposFilaDetalles.CATEGORIA_DETALLE) {
        Color.Cyan
    } else {
        Color.Magenta
    }

    Card(
        border = BorderStroke(2.dp, color),
        modifier = Modifier.padding(2.dp).fillMaxWidth().padding(2.dp).wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { desplegarProductos(item, lista) },
            verticalArrangement = Arrangement.Center
        ) {
            /* if (item.tipoFila == TiposFilaDetalles.CATEGORIA_DETALLE) {
                Text(
                    text = item.categoria,
                    modifier = Modifier.padding(2.dp)
                )
            }
            Text(
                text = item.nombre,
                modifier = Modifier.padding(2.dp)
            ) */
            Text(
                text = "Segmento: " + item.segmento,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Dia Visita: " + item.diaVisita,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Meta: " + item.meta,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Llegada: " + item.llegada,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "SM: " + item.sm,
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}

@Composable
@Preview
fun Preview() {
    Tabla()
}

fun mostrarDetalles(item: ItemPorcentaje, lista: MutableState<MutableList<Items>>) {
    if (!item.estaExpandido) {
        val posicionItem = lista.value.indexOfFirst { it is ItemPorcentaje && it.categoria == item.categoria && it.nombre ==  item.nombre }
        val elemento = lista.value[posicionItem] as? ItemPorcentaje
        val elementoActualizado = elemento?.copy(estaExpandido = true)
        if (elementoActualizado != null) {
            lista.value[posicionItem] = elementoActualizado
        }
        val listaPrincipio = lista.value.subList(0, posicionItem + 1).toMutableList()
        val listaFin = if (posicionItem + 1 == lista.value.size) mutableListOf()
        else lista.value.subList(
            posicionItem + 1,
            lista.value.size
        ).toMutableList()

        val detalleAMostrar = itemsTabla.firstOrNull {
            it is ItemDetalle &&
                    ((item.tipoFila == TiposFilaPorcentajes.CATEGORIA_PORCENTAJE &&
                            it.tipoFila == TiposFilaDetalles.CATEGORIA_DETALLE &&
                            item.categoria == it.categoria) ||
                            (item.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE &&
                                    it.tipoFila == TiposFilaDetalles.PRODUCTO_DETALLE &&
                                    item.categoria == it.categoria &&
                                    item.nombre == it.nombre))
        }

        lista.value = if (detalleAMostrar == null) {
            lista.value
        } else {
            (listaPrincipio + detalleAMostrar + listaFin).toMutableList()
        }


        //if (lista.value[posicionItem] is ItemPorcentaje) lista.value[posicionItem]

    } else {
        val posicionItem = lista.value.indexOfFirst { it is ItemPorcentaje && it.categoria == item.categoria && it.nombre ==  item.nombre }
        val elemento = lista.value[posicionItem] as? ItemPorcentaje
        val elementoActualizado = elemento?.copy(estaExpandido = false)
        if (elementoActualizado != null) {
            lista.value[posicionItem] = elementoActualizado
        }
        if (item.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE) {
            val posicion = lista.value.indexOfFirst { it is ItemPorcentaje && it.categoria == item.categoria && it.nombre == item.nombre }
        lista.value = lista.value.filterIndexed { index, _ ->  index != posicion + 1 }.toMutableList()
        } else {
            lista.value = lista.value.filter {
                !((it is ItemDetalle && it.categoria == item.categoria) ||
                        (it is ItemPorcentaje && it.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE &&
                                it.categoria == item.categoria))
            }.toMutableList()
        }
    }
}

fun desplegarProductos(item: ItemDetalle, lista: MutableState<MutableList<Items>>) {
    val index = lista.value.indexOfFirst {  it is ItemDetalle && it.categoria == item.categoria && it.nombre == item.nombre}
    if (item.tipoFila == TiposFilaDetalles.CATEGORIA_DETALLE) {
        if (item.estaExpandido) {
            val actualizado = (lista.value[index] as ItemDetalle).copy(estaExpandido = false)
            lista.value[index] = actualizado
            lista.value = lista.value.filter {
                !((it is ItemPorcentaje && it.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE && it.categoria == item.categoria) ||
                (it is ItemDetalle && it.tipoFila == TiposFilaDetalles.PRODUCTO_DETALLE && it.categoria == item.categoria))
            }.toMutableList()
        } else {
            val actualizado = (lista.value[index] as ItemDetalle).copy(estaExpandido = true)
            lista.value[index] = actualizado
            val itemsAAgregar =
                itemsTabla.filter {
                    (it is ItemPorcentaje) &&
                            it.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE &&
                            it.categoria == item.categoria
                }.toMutableList()

            val principioLista = lista.value.subList(0, index + 1).toMutableList()
            val finalLista =
                if (lista.value.size - 1 == index) mutableListOf() else lista.value.subList(
                    index + 1,
                    lista.value.size
                ).toMutableList()
            lista.value = (principioLista + itemsAAgregar + finalLista).toMutableList()
        }
    }
}