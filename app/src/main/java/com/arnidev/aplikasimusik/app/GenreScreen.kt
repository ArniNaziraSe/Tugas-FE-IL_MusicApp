package com.arnidev.aplikasimusik.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arnidev.aplikasimusik.app.component.GenreItem
import com.arnidev.aplikasimusik.data.DummyData
import com.arnidev.aplikasimusik.model.Genre
import com.arnidev.aplikasimusik.ui.theme.AplikasiMusikTheme

@Composable
fun GenreScreen(
    modifier: Modifier = Modifier,
    genres: List<Genre> = DummyData.songGenre
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Adaptive(140.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(genres, key = { it.id }) {
            GenreItem(genre = it)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun GenreScreenPreview() {
    AplikasiMusikTheme {
        GenreScreen(genres = DummyData.songGenre)
    }
}