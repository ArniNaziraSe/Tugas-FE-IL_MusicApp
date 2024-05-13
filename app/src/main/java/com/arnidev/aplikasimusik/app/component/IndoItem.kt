package com.arnidev.aplikasimusik.app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnidev.aplikasimusik.R
import com.arnidev.aplikasimusik.model.Indo
import com.arnidev.aplikasimusik.ui.theme.AplikasiMusikTheme

@Composable
fun IndoItem(
    indo: Indo,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.border(1.dp, Color.LightGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            Row(
                modifier = modifier
            ){
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = indo.photo),
                    contentDescription = indo.name,
                    modifier = Modifier
                        .border(2.dp, Color.Magenta, CircleShape)
                        .clip(CircleShape)
                        .size(50.dp)
                        .clickable {
                            onItemClicked(indo.id)
                        }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = indo.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.width(350.dp)
                    )
                    Text(
                        text = indo.artis,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .width(350.dp),
                        maxLines = 1
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = indo.photo),
            contentDescription = indo.name,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .size(400.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IndoItemPreview() {
    AplikasiMusikTheme {
        IndoItem(
            indo = Indo(
                1,
                "Kupu-kupu",
                "Tiara Andini",
                R.drawable.kupu,
                "Dirilis: 2024\n" +
                        "Album: Kupu - Kupu\n" +
                        "Genre: Indonesian Pop"
            ),
            onItemClicked = { indosId ->
                println("Indo Id : $indosId")
            }
        )
    }
}