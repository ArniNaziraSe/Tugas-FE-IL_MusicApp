package com.arnidev.aplikasimusik.app

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arnidev.aplikasimusik.data.DummyData
import com.arnidev.aplikasimusik.model.Indo

@Composable
fun DetailIndoScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    indosId: Int?
) {
    val newIndosList = DummyData.songIndo.filter { indo ->
        indo.id == indosId
    }

    Column(
        modifier = modifier
    ) {
        DetailIndoContent(newIndosList = newIndosList)
    }
}

@Composable
fun DetailIndoContent(
    newIndosList: List<Indo>,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(100.dp))
    Surface(
        shape = MaterialTheme.shapes.extraLarge,
        color = MaterialTheme.colorScheme.outlineVariant,
        modifier = modifier.size(600.dp).padding(start = 25.dp, end = 25.dp, bottom = 25.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(50.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = newIndosList[0].photo)
                    .build(),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color.Gray),
                contentDescription = "Poster Single Indo"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = newIndosList[0].name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
                Text(
                    text = newIndosList[0].artis,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Text(
                    text = "(${newIndosList[0].desk})",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailIndoContentPreview() {
    DetailIndoContent(newIndosList = DummyData.songIndo)
}