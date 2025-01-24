package cnovaez.dev.pre_ventav2

import android.content.ClipData.Item
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Tabla() {
    val lista = remember { (categoriasPorcentajes).toMutableStateList() }

    Box(Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
            items(items = lista) { item ->
                when (item) {
                    is ItemPorcentaje -> {
                        PorcentajeItem(item, lista, Modifier.animateItem())
                    }

                    is ItemDetalle -> {
                        DetalleItem(item, lista, Modifier.animateItem())
                    }
                }
            }
        }
    }
}

@Composable
fun PorcentajeItem(item: ItemPorcentaje, lista: SnapshotStateList<Items>, modifier: Modifier) {
    val color = if (item.tipoFila == TiposFilaPorcentajes.CATEGORIA_PORCENTAJE) {
        Color.Green
    } else {
        Color.Blue
    }

    val paddingStart = if(item.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE) {
        12.dp
    } else {
        0.dp
    }

    Card(
        border = BorderStroke(2.dp, color),
        modifier = modifier
            .padding(start = paddingStart)
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
fun DetalleItem(item: ItemDetalle, lista: SnapshotStateList<Items>, modifier: Modifier) {
    val color = if (item.tipoFila == TiposFilaDetalles.CATEGORIA_DETALLE) {
        Color.Green
    } else {
        Color.Blue
    }
    val paddingStart = if(item.tipoFila == TiposFilaDetalles.PRODUCTO_DETALLE) {
        12.dp
    } else {
        0.dp
    }


    Card(
        border = BorderStroke(2.dp, color),
        modifier = modifier
            .padding(start = paddingStart)
            .padding(2.dp)
            .fillMaxWidth()
            .padding(2.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { desplegarProductos(item, lista) },
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.nombre,
                modifier = Modifier.padding(2.dp),
                style = MaterialTheme.typography.h6
            )
            if (item.tipoFila != TiposFilaDetalles.CATEGORIA_DETALLE) {
                Text(
                    text = "Categoria: " + item.categoria,
                    modifier = Modifier.padding(2.dp)
                )
            }

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

fun mostrarDetalles(item: ItemPorcentaje, lista: SnapshotStateList<Items>) {
    if (!item.estaExpandido) {
        val posicionItem =
            lista.indexOfFirst { it is ItemPorcentaje && it.categoria == item.categoria && it.nombre == item.nombre }

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

        detalleAMostrar?.let {
            lista[posicionItem] = detalleAMostrar
        }
    }
}

fun desplegarProductos(item: ItemDetalle, lista: SnapshotStateList<Items>) {
    val index = lista.indexOfFirst {  it is ItemDetalle && it.categoria == item.categoria && it.nombre == item.nombre}
    if (item.tipoFila == TiposFilaDetalles.CATEGORIA_DETALLE) {
        if (item.estaExpandido) {
            val actualizado = (lista[index] as ItemDetalle).copy(estaExpandido = false)
            lista[index] = actualizado
            lista.removeIf {
                (it is ItemPorcentaje && it.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE && it.categoria == item.categoria) ||
                (it is ItemDetalle && it.tipoFila == TiposFilaDetalles.PRODUCTO_DETALLE && it.categoria == item.categoria)
            }
        } else {
            if(item.seMostraronProductos) {
                val itemPorcentaje = itemsTabla.firstOrNull {
                    it is ItemPorcentaje &&
                            it.tipoFila == TiposFilaPorcentajes.CATEGORIA_PORCENTAJE &&
                            it.categoria == item.categoria &&
                            it.nombre == item.nombre
                }
                itemPorcentaje?.let {
                    lista[index] = it
                }
            } else {
                val actualizado = (lista[index] as ItemDetalle).copy(estaExpandido = true, seMostraronProductos = true)
                lista[index] = actualizado
                val itemsAAgregar =
                    itemsTabla.filter {
                        (it is ItemPorcentaje) &&
                                it.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE &&
                                it.categoria == item.categoria
                    }.toMutableList()


                itemsAAgregar.forEachIndexed { i, element ->
                    lista.add(index + 1 + i, element)
                }
            }
        }
    } else {
        val itemPorcentajeProducto =
            itemsTabla.firstOrNull { it is ItemPorcentaje &&
                    it.tipoFila == TiposFilaPorcentajes.PRODUCTO_PORCENTAJE &&
                    it.categoria == item.categoria &&
                    it.nombre == item.nombre
            }

        itemPorcentajeProducto?.let {
            lista[index] = itemPorcentajeProducto
        }
    }
}