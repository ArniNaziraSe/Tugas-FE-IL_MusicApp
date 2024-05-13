package com.arnidev.aplikasimusik.app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnidev.aplikasimusik.R
import com.arnidev.aplikasimusik.model.Kpop
import com.arnidev.aplikasimusik.ui.theme.AplikasiMusikTheme

@Composable
fun KpopItem(
    kpop: Kpop,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(kpop.id)
        }
    ) {
        Image(
            painter = painterResource(id = kpop.photo),
            contentDescription = kpop.name,
            modifier = Modifier
                .border(3.dp, Color.Magenta, CircleShape)
                .clip(CircleShape)
                .size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = kpop.name,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = kpop.artis,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
    }
}

@Preview
@Composable
private fun KpopItemPreview() {
    AplikasiMusikTheme {
        KpopItem(
            kpop = Kpop(
                1,
                "Sheesh",
                "Baby Mosnter",
                R.drawable.sheesh,
                "Album: BabyMons7er\n" +
                        "Dirilis: 2024\n" +
                        "Genre: K-Pop"
            ),
            onItemClicked = { kpopsId ->
                println("Kpop Id : $kpopsId")
            }
        )
    }
}