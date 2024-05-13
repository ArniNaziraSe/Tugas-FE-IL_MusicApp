package com.arnidev.aplikasimusik.app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnidev.aplikasimusik.R
import com.arnidev.aplikasimusik.model.Me
import com.arnidev.aplikasimusik.ui.theme.AplikasiMusikTheme

@Composable
fun MeItem(
    me: Me,
    modifier: Modifier = Modifier
) {
    Text(
        text = "ABOUT ME",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp, bottom = 50.dp)
    )
    Surface(
        shape = MaterialTheme.shapes.extraLarge,
        color = MaterialTheme.colorScheme.outlineVariant,
        modifier = modifier
            .size(600.dp)
            .padding(start = 25.dp, end = 25.dp, bottom = 50.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 50.dp)
        ) {
            Image(
                painter = painterResource(id = me.photo),
                contentDescription = me.name,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = me.name,
                textAlign = TextAlign.Center,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = me.email,
                textAlign = TextAlign.Center,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = me.pt,
                textAlign = TextAlign.Center,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = me.jurusan,
                textAlign = TextAlign.Center,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun MeItemPreview() {
    AplikasiMusikTheme {
        MeItem(
            me = Me(
                R.drawable.an,
                "Arni Nazira",
                "arninzra@gmail.com",
                "Universitas Islam Balitar",
                "Teknik Informatika"
            )
        )
    }
}