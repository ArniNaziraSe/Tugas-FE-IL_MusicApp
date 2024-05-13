package com.arnidev.aplikasimusik.app

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arnidev.aplikasimusik.data.DummyData
import com.arnidev.aplikasimusik.model.Kpop

@Composable
fun DetailKpopScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    kpopsId: Int?
) {
    val newKpopsList = DummyData.songKpop.filter { kpop ->
        kpop.id == kpopsId
    }

    Column(
        modifier = modifier
    ) {
        DetailKpopContent(newKpopsList = newKpopsList)
    }
}

@Composable
fun DetailKpopContent(
    newKpopsList: List<Kpop>,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(100.dp))
    Surface(
        shape = MaterialTheme.shapes.extraLarge,
        color = MaterialTheme.colorScheme.outlineVariant,
        modifier = modifier.size(600.dp).padding(start = 25.dp, end = 25.dp, bottom = 25.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(start = 10.dp, end = 10.dp, bottom = 100.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = newKpopsList[0].photo)
                    .build(),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color.Gray),
                contentDescription = "Poster Single Kpop"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = newKpopsList[0].name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Magenta
                )
                Text(
                    text = newKpopsList[0].artis,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }
        Text(
            text = "${newKpopsList[0].desk}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top = 400.dp, start = 20.dp, end = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailKpopContentPreview() {
    DetailKpopContent(newKpopsList = DummyData.songKpop)
}