package com.uz.ustudy.ui.courses.adapter

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.exoplayer.ExoPlayer
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentCourseIntroductionVideoBinding

class CourseIntroductionVideo : Fragment(R.layout.fragment_course_introduction_video) {

    private var _binding:FragmentCourseIntroductionVideoBinding? = null
    private val binding get() = _binding!!

    private lateinit var player: ExoPlayer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCourseIntroductionVideoBinding.bind(view)

        initializePlayer()

    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(requireContext()).build()
        binding.mediaPlayer.player = player

        val mediaItem = MediaItem.Builder()
            .setUri(Uri.parse("https://youtu.be/7Vxbogma5mA?si=Tiswg_y9_NGIhGxV"))
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()


        player.addMediaItem(mediaItem)
        player.playWhenReady = true
        player.prepare()
        player.play()
    }

    private fun releasePlayer() {
        player.release()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        releasePlayer()
        _binding = null
    }
}