package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.GreenLight
import com.example.ui.theme.NavyDark
import com.example.ui.theme.PureWhite

@Composable
fun DisclaimerFooter(
    modifier: Modifier = Modifier
) {
    Surface(
        color = NavyDark,
        contentColor = PureWhite,
        modifier = modifier
            .fillMaxWidth()
            .testTag("disclaimer_footer")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp)
                .navigationBarsPadding()
        ) {
            // Independence Badge
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF1E293B),
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Gavel,
                        contentDescription = null,
                        tint = GreenLight,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "PORTAL INDEPENDENTE & DE UTILIDADE PÚBLICA",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = PureWhite
                    )
                }
            }

            // Legal & Civic Disclaimer
            Text(
                text = "Este portal/aplicativo é uma iniciativa cidadã informativa, independente e voluntária. Não possui qualquer vínculo institucional, representação comercial, endosso ou ligação com o Tribunal Superior Eleitoral (TSE), Tribunais Regionais Eleitorais (TREs) ou qualquer outro órgão da administração pública.",
                fontSize = 12.sp,
                color = Color(0xFFCBD5E1),
                lineHeight = 17.sp,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Todos os resultados da apuração, totalização de votos e boletins de urna são gerados, processados e divulgados exclusivamente pela Justiça Eleitoral no endereço oficial resultados.tse.jus.br. Não solicitamos nem coletamos dados pessoais de nenhum eleitor.",
                fontSize = 11.sp,
                color = Color(0xFF94A3B8),
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(18.dp))

            HorizontalDivider(
                color = Color(0xFF334155),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Security,
                    contentDescription = null,
                    tint = GreenLight,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Apura Brasil • Eleições Transparentes & Combate à Desinformação",
                    fontSize = 11.sp,
                    color = Color(0xFF94A3B8)
                )
            }
        }
    }
}
