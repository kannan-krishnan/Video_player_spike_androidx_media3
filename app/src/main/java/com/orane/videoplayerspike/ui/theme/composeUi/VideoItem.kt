package com.orane.videoplayerspike.ui.theme.composeUi

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.orane.videoplayerspike.ui.VideosMbo

@Composable
fun VideoItem(video: VideosMbo, onVideoClick: (video: VideosMbo) -> Unit) {
    var rememberedVideo by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onVideoClick(video) }
                .padding(24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ImageFromURL(video.thumb.orEmpty())
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = video.title.orEmpty(), color = Color.Magenta
                )
                val size = animateDpAsState(
                    if (rememberedVideo) 200.dp else 50.dp,
                    animationSpec = tween(durationMillis = 300), label = ""
                )
                Text(
                    modifier = Modifier.clickable { rememberedVideo = !rememberedVideo },
                    text = video.description.orEmpty(),
                    maxLines = if (rememberedVideo) Int.MAX_VALUE else 2,
//                    size=size
//                    animationSpec = tween(durationMillis = 300)
                )
            }
        }

    }
}