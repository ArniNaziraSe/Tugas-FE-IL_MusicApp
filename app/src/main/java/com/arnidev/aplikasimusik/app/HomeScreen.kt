package com.arnidev.aplikasimusik.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arnidev.aplikasimusik.app.component.IndoItem
import com.arnidev.aplikasimusik.app.component.KpopItem
import com.arnidev.aplikasimusik.data.DummyData
import com.arnidev.aplikasimusik.model.Indo
import com.arnidev.aplikasimusik.model.Kpop
import com.arnidev.aplikasimusik.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    kpops: List<Kpop> = DummyData.songKpop,
    indos: List<Indo> = DummyData.songIndo,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(kpops, key = {it.id}) {
                    KpopItem(kpop = it) { kpopsId ->
                        navController.navigate(Screen.Detail1.route + "/$kpopsId")
                    }
                }
            }
        }
        items(indos, key = {it.id}){
            IndoItem(indo = it) { indosId ->
                navController.navigate(Screen.Detail2.route + "/$indosId")
            }
        }
    }
}