package com.arnidev.aplikasimusik.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnidev.aplikasimusik.app.component.MeItem
import com.arnidev.aplikasimusik.data.DummyData
import com.arnidev.aplikasimusik.model.Me
import com.arnidev.aplikasimusik.ui.theme.AplikasiMusikTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    mes: List<Me> = DummyData.aboutMe
) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(mes, key = {it.photo}){
            MeItem(me = it)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AboutScreenPreview() {
    AplikasiMusikTheme {
        AboutScreen(mes = DummyData.aboutMe)
    }
}