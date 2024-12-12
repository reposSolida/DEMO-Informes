package cnovaez.dev.pre_ventav2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.solidatec.pre_ventav2_vct.R

@Composable
fun InformesView(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.mipmap.modelo_fondo_3),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.6f),
            contentScale = ContentScale.Crop // Ajusta cómo se escala la imagen
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.big_horizontal_margin),
                    vertical = 48.dp
                )
        ) {
            item {

                Titulo("Efectividad de Surtido Mandatorio")
                TareaInfoCard()

                Titulo("Avance del Mes")
                CircularProgressBar("Ejemplo ", 65f)

                Titulo("Avance del Dia")
                LinearProgressBar("Ejemplo ", 65f)

                Titulo("Venta dia anterior")
                HorizontalGridExcelColumnsExample(
                    7,
                    listOf(
                        "Categoria VCT",
                        "Categoria 1",
                        "Categoria 1 Superior",
                        "Categoria 2",
                        "Cerveza",
                        "Spirits",
                        "Total",
                        "Venta DHA $",
                        "$225.753",
                        "$28.212",
                        "$503.735",
                        "$787.284",
                        "$117.858",
                        "$1.662.842",
                        "Venta Necesaria DHA",
                        "$761.223",
                        "$89.192",
                        "$580.875",
                        "$682.002",
                        "$88.429",
                        "$2.201.720",
                        "%",
                        "30 %",
                        "32 %",
                        "87 %",
                        "115 %",
                        "133 %",
                        "76 %",
                        "Meta Concr. (DHA)",
                        "4",
                        "1",
                        "6",
                        "4",
                        "5",
                        "6",
                        "Concreciones",
                        "6",
                        "1",
                        "8",
                        "11",
                        "5",
                        "12",
                        "% Cumpl.",
                        "150 %",
                        "100 %",
                        "133 %",
                        "275 %",
                        "250 %",
                        "200 %"
                    )
                )
            }

            items(
                items = listOfQuestions,
                itemContent = {
                    PreguntaTareaItem(
                        it.title,
                        it.state,
                        it.onItemClick
                    )
                },
            )
        }
    }
}

@Composable
private fun TareaInfoCard(
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .border(
                BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.big_horizontal_margin))
                .padding(vertical = dimensionResource(id = R.dimen.top_margin)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CampoSinSeleccion(
                "Cartera",
                "98",
                colorResource(R.color.Salmon)
            )

            CampoSinSeleccion(
                "Cobertura",
                "62",
                colorResource(R.color.Salmon)
            )

            CampoSinSeleccion(
                "Cartera prioritaria",
                "45",
                colorResource(R.color.Salmon)
            )

            CampoSinSeleccion(
                "Cobertura (Prioritario)",
                "34",
                colorResource(R.color.Salmon)
            )

            CampoSinSeleccion(
                "Cobertura Mes Anterior",
                "72",
                colorResource(R.color.pastel_blue_5)
            )

            CampoSinSeleccion(
                "Recompra",
                "58",
                colorResource(R.color.pastel_blue_5)
            )


            CampoSinSeleccion(
                "Posibles Concr. Arum.",
                "190",
                colorResource(R.color.MediumTurquoise)
            )

            CampoSinSeleccion(
                "Posibles Concre. Mes",
                "289",
                colorResource(R.color.MediumTurquoise)
            )

            CampoSinSeleccion(
                "Pedidos Facturados",
                "135",
                colorResource(R.color.CornflowerBlue)
             )

            CampoSinSeleccion(
                "Pedidos Facturados",
                "135",
                colorResource(R.color.CornflowerBlue)
            )

            CampoSinSeleccion(
                "% Cobr vc DM",
                "63 %",
                colorResource(R.color.DarkKhaki)
            )

            CampoSinSeleccion(
                "% Cob vs DMI Prioritario",
                "76 %",
                colorResource(R.color.Salmon)
            )

            CampoSinSeleccion(
                "% Recompra",
                "81 %",
                colorResource(R.color.GreenYellow)
            )

            CampoSinSeleccion(
                "% Posibles Concr.",
                "71 %",
                colorResource(R.color.Salmon)
            )

            CampoSinSeleccion(
                "% Concreciones Mes",
                "47",
                colorResource(R.color.Salmon)
            )
        }
    }
}

@Composable
private fun Titulo(title: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.big_top_margin)),
        text = title,
        fontSize = 32.sp,
    )
}

@Composable
private fun CampoSinSeleccion(
    title: String,
    content: String,
    rowColor: Color = Color.LightGray,
    spacer: Boolean = true
) {
    ConstraintLayout(
        constraintSet = ConstraintSet {
            val titleRef = createRefFor("title")
            val dividerRef = createRefFor("divider")
            val contentRef = createRefFor("content")

            constrain(titleRef) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(dividerRef.start)
                width = Dimension.fillToConstraints
            }

            constrain(dividerRef) {
                start.linkTo(titleRef.end)
                top.linkTo(parent.top, margin = 4.dp)
                bottom.linkTo(parent.bottom, margin = 4.dp)
                end.linkTo(contentRef.start)
                height = Dimension.fillToConstraints
            }

            constrain(contentRef) {
                start.linkTo(dividerRef.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = rowColor,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            modifier = Modifier
                .layoutId("title")
                .wrapContentHeight()
                .padding(horizontal = 4.dp, vertical = 2.dp),
            textAlign = TextAlign.Start,
            color = Color.Black
        )

        // Divider ajustado con bordes redondeados
        Box(
            modifier = Modifier
                .layoutId("divider")
                .width(2.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(50))
                .background(Color.Gray)
        )

        Text(
            text = content,
            fontSize = 16.sp,
            modifier = Modifier
                .layoutId("content")
                .wrapContentHeight()
                .padding(horizontal = 4.dp, vertical = 4.dp),
            textAlign = TextAlign.Start,
            color = Color.Black
        )
    }



    if (spacer) {
        Spacer(
            modifier = Modifier.padding(top = 4.dp),
        )
    }
}

@Composable
fun HorizontalGridExcelColumnsExample(
    rows: Int,
    items: List<String>
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val gridHeight = when {
        rows > 10 -> screenHeight
        rows > 5 -> screenHeight / 2
        else ->  screenHeight / 3
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(gridHeight)
            .border(
                BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(rows),
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(items) { index, item ->
                val columnIndex = index % rows
                GridCellWithColumnColor(item = item, columnIndex = columnIndex)
            }
        }
    }
}

@Composable
fun GridCellWithColumnColor(
    item: String,
    columnIndex: Int
) {
    val isGrayColumn = columnIndex % 2 == 0
    val backgroundColor = if (isGrayColumn) Color.LightGray else Color.White

    Box(
        modifier = Modifier
            .size(width = 140.dp, height = 40.dp) // Tamaño uniforme de la celda.
            .background(backgroundColor)
            .border(1.dp, Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .padding(2.dp),
            text = item,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun LinearProgressBar(
    title: String,
    progress: Float,
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .border(
                BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = dimensionResource(R.dimen.horizontal_margin)),
                text = "$title $progress%",
                fontSize = 24.sp
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .clip(RoundedCornerShape(10.dp)) // Bordes redondeados.
                    .background(Color.LightGray) // Fondo gris.
                    .padding(2.dp) // Espaciado interior para el efecto de borde.
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress / 100) // Ancho proporcional al progreso.
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(8.dp)) // Más redondeo interno.
                        .background(Color.Blue) // Color de la barra de progreso.
                )
            }
        }

    }
}


@Composable
fun CircularProgressBar(
    title: String,
    progress: Float,
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .border(
                BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.top_margin)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (title.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.horizontal_margin)),
                    text = "$title $progress%",
                    fontSize = 24.sp
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(150.dp) // Tamaño de la barra circular.
                    .background(Color.LightGray, CircleShape) // Fondo gris con forma circular.
            ) {
                CircularProgressIndicator(
                    progress = progress / 100, // Valor del progreso.
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Blue,
                    strokeWidth = 75.dp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InformesPreView() {
    InformesView()
}

private val listOfQuestions = listOf(
    PreguntaTareaItem("Esta es una pregunta", TareaResponseState.Answered, {}),
    PreguntaTareaItem("Esta es una pregunta de largo mediano, Esta es una pregunta de largo mediano", TareaResponseState.NotAnswered, {}),
    PreguntaTareaItem("Esta es una pregunta de un largo super largo y dificl de ver en solamente 3 lineas, Esta es una pregunta de largo mediano, Esta es una pregunta de largo mediano", TareaResponseState.Answered, {}),
    PreguntaTareaItem("Esta es una pregunta", TareaResponseState.Answered, {}),
    PreguntaTareaItem("Esta es una pregunta", TareaResponseState.Answered, {}),
    PreguntaTareaItem("Esta es una pregunta", TareaResponseState.Answered, {}),
    PreguntaTareaItem("Esta es una pregunta", TareaResponseState.Answered, {}),
    PreguntaTareaItem("Esta es una pregunta", TareaResponseState.Answered, {})
)