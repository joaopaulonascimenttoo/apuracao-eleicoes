package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.GreenEmerald
import com.example.ui.theme.NavyDark
import com.example.ui.theme.PureWhite
import com.example.ui.theme.SlateBorder
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun OfficialChannelsSection(
    onDialPhone: (String) -> Unit,
    onOpenUrl: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = PureWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, SlateBorder, RoundedCornerShape(16.dp))
            .testTag("official_channels_card")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(6.dp, 20.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(NavyDark)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Canais Oficiais de Atendimento",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = NavyDark
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // SOS Voto 1491
            ChannelRowItem(
                icon = Icons.Default.Campaign,
                iconBg = Color(0xFFFEF2F2),
                iconTint = Color(0xFFDC2626),
                title = "SOS Voto — Disque 1491",
                subtitle = "Central gratuita para denúncias de mentiras e desinformação eleitoral.",
                actionLabel = "Ligar 1491",
                onClick = { onDialPhone("1491") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Disque Eleitor 148
            ChannelRowItem(
                icon = Icons.Default.Phone,
                iconBg = Color(0xFFEFF6FF),
                iconTint = Color(0xFF2563EB),
                title = "Disque Eleitor — 148",
                subtitle = "Informações sobre situação eleitoral, quitação e título.",
                actionLabel = "Ligar 148",
                onClick = { onDialPhone("148") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Autoatendimento do TSE
            ChannelRowItem(
                icon = Icons.Default.SupportAgent,
                iconBg = Color(0xFFF0FDF4),
                iconTint = GreenEmerald,
                title = "Autoatendimento do TSE",
                subtitle = "Consulta online de situação cadastral e emissão de certidões.",
                actionLabel = "Acessar Portal",
                onClick = { onOpenUrl("https://www.tse.jus.br/servicos-eleitorais/autoatendimento-eleitoral#/") }
            )
        }
    }
}

@Composable
private fun ChannelRowItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconBg: Color,
    iconTint: Color,
    title: String,
    subtitle: String,
    actionLabel: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF8FAFC))
            .clickable(onClick = onClick)
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(iconBg),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = TextMuted,
                lineHeight = 15.sp
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = Icons.AutoMirrored.Filled.OpenInNew,
            contentDescription = actionLabel,
            tint = GreenEmerald,
            modifier = Modifier.size(16.dp)
        )
    }
}
