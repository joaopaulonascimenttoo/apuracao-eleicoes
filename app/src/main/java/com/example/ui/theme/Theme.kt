package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
  primary = NavyDark,
  onPrimary = PureWhite,
  primaryContainer = NavyPrimary,
  onPrimaryContainer = PureWhite,
  secondary = GreenEmerald,
  onSecondary = PureWhite,
  secondaryContainer = GreenContainer,
  onSecondaryContainer = GreenAccent,
  tertiary = NavyLight,
  onTertiary = PureWhite,
  background = OffWhite,
  onBackground = TextPrimary,
  surface = PureWhite,
  onSurface = TextPrimary,
  surfaceVariant = SlateSubtle,
  onSurfaceVariant = TextSecondary,
  outline = SlateBorder,
)

private val DarkColorScheme = darkColorScheme(
  primary = GreenLight,
  onPrimary = NavyDark,
  primaryContainer = NavySurface,
  onPrimaryContainer = PureWhite,
  secondary = GreenLight,
  onSecondary = NavyDark,
  secondaryContainer = NavyPrimary,
  onSecondaryContainer = GreenLight,
  tertiary = NavyLight,
  onTertiary = PureWhite,
  background = NavyDark,
  onBackground = PureWhite,
  surface = NavySurface,
  onSurface = PureWhite,
  surfaceVariant = NavyPrimary,
  onSurfaceVariant = SlateBorder,
  outline = NavyLight,
)

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // We prefer the intentional custom news palette (navy/green/white) rather than wallpaper dynamic color
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}
