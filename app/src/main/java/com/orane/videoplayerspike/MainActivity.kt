package com.orane.videoplayerspike

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orane.videoplayerspike.ui.VideosMbo
import com.orane.videoplayerspike.ui.getAllVideos
import com.orane.videoplayerspike.ui.theme.VideoPlayerSpikeTheme
import com.orane.videoplayerspike.ui.theme.composeUi.VideoItem
import com.orane.videoplayerspike.ui.theme.composeUi.VideoPlayerScreen
import com.orane.videoplayerspike.ui.theme.hideSystemUI
import com.orane.videoplayerspike.ui.theme.showSystemUI

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideoPlayerSpikeTheme {
                var rememberedVideo by remember { mutableStateOf("") }
                var isLandscape by remember { mutableStateOf(false) }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val configuration = LocalConfiguration.current

                    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        isLandscape= true
                        window.hideSystemUI()
                    } else {
                        isLandscape= false
                        window.showSystemUI()
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        if (rememberedVideo.isNotEmpty()) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .height(0.dp)
                                    .weight(1f)

                            ) {
                                if (rememberedVideo.isNotEmpty()) {
                                    VideoPlayerScreen(rememberedVideo,isLandscape)
                                } else {
                                    Text(text = "No Video Selected")
                                }
                            }
                        }
                        if (!isLandscape || rememberedVideo=="") {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(0.dp)
                                    .weight(2f)
                            ) {
                                LazyColumn {
                                    items(getAllVideos().videos) { video ->
                                        VideoItem(video) {
                                            Log.e("TAG", "onCreate: " + video.sources)
                                            rememberedVideo = video.sources.orEmpty()

                                        }
                                    }
                                }
                            }
                        }


                    }


                }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun VideoItemPreview() {
    val video=  VideosMbo( "sample","sample","sample","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4","sample")
    VideoPlayerSpikeTheme {
        VideoItem(video){

        }
    }
}