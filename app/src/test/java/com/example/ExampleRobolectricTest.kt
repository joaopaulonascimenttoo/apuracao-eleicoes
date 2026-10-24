package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.model.GuideRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read app name string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Apura Brasil", appName)
  }

  @Test
  fun `verify guide topics load with valid data`() {
    val topics = GuideRepository.topics
    assertTrue(topics.isNotEmpty())
    val horariosTopic = topics.find { it.id == "horarios" }
    assertNotNull(horariosTopic)
    assertTrue(horariosTopic?.keyPoints?.isNotEmpty() == true)
  }
}
