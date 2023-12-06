# Android Video Playback with androidx.media3:media3

## Spike Document

### Objective
Evaluate the feasibility and suitability of using the `androidx.media3:media3` library for video playback in an Android app using Kotlin and Jetpack Compose.

### Tasks

#### Library Integration
Add the `media3` library to the project by including the following dependencies:

```groovy
implementation ("androidx.media3:media3-exoplayer:1.2.0")
implementation ("androidx.media3:media3-ui:1.2.0")
implementation ("androidx.media3:media3-common:1.2.0")
```

#### Setup Media3 Player
Initialize and set up the Media3 player in the application, configuring the player settings and options:

```kotlin
val exoPlayer = remember { ExoPlayer.Builder(context).build() }

exoPlayer.apply {
    setMediaItem(MediaItem.fromUri(url))
    repeatMode = ExoPlayer.REPEAT_MODE_ALL
    playWhenReady = playWhenReady
    prepare()
    play()
}
```

#### Create Jetpack Compose UI
Design a Jetpack Compose UI to display the video player:

```kotlin
AndroidView(
    modifier = if (isFullScreen) Modifier else Modifier.fillMaxSize(),
    factory = {
        PlayerView(context).apply {
            player = exoPlayer
            useController = true
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }
)
```

#### Supported Formats
Supported video formats: H.264, VP8, VP9, H.265 (HEVC)
Supported audio formats: AAC, MP3, Vorbis, FLAC, AMR-NB, AMR-WB, Opus
Supported container formats: MP4, MPEG-2 TS, WebM, Matroska (MKV), 3GPP, ADTS (AAC)
Supported network protocols: HTTP/HTTPS live streaming, DASH, SmoothStreaming, HLS

#### Performance and Optimization
Evaluate the performance of the Media3 player, especially with large or high-quality videos.

### Conclusion
Summarize the findings from the spike, including insights into library usability, compatibility with Jetpack Compose, and any limitations or challenges encountered.

### Reference
- [Official Documentation](<official_documentation_link>)
- [Sample Github Project](<github_project_link>)
