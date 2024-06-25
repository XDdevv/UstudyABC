package com.uz.ustudy.ui.analytics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartFontWeightType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentAnalyticsBinding

class AnalyticsFragment : Fragment(R.layout.fragment_analytics) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentAnalyticsBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnalyticsBinding.bind(view)

        val aaChartModel: AAChartModel = AAChartModel()
            .chartType(AAChartType.Spline)
            .title("Reading Book Analytics")
            .titleStyle(
                AAStyle.Companion.style(
                    "#ffffff", 24f,
                    AAChartFontWeightType.Bold
                )
            )

            .legendEnabled(true)
            .backgroundColor("#363130")
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Tokyo")
                        .data(
                            arrayOf(
                                7.0,
                                6.9,
                                9.5,
                                14.5,
                                18.2,
                                21.5,
                            )
                        ),
                    AASeriesElement()
                        .name("NewYork")
                        .data(
                            arrayOf(
                                0.2,
                                0.8,
                                5.7,
                                11.3,
                                17.0,
                                22.0,
                            )
                        )
                )
            )
        binding.chartBooks.aa_drawChartWithChartModel(aaChartModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}