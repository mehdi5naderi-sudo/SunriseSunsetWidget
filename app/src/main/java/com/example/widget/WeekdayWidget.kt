package com.example.widget

import android.content.Context
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.dp
import androidx.glance.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeekdayWidget : GlanceAppWidget() {
    override suspend fun provideContent(context: Context, id: GlanceAppWidget.GlanceId) {
        val today = SimpleDateFormat("EEEE", Locale.US).format(Date())
        provideContent {
            Column(
                modifier = androidx.glance.Modifier
                    .fillMaxSize()
                    .background(androidx.glance.Color(0xFF4CAF50))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = today,
                    style = TextStyle(
                        color = androidx.glance.Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

class WeekdayWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = WeekdayWidget()
}
