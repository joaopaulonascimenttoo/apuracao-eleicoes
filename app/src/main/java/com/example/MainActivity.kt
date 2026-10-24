package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.model.GuideRepository
import com.example.model.SponsorConfig
import com.example.ui.components.DisclaimerFooter
import com.example.ui.components.HeroSection
import com.example.ui.components.InAppOfficialWebView
import com.example.ui.components.OfficialChannelsSection
import com.example.ui.components.PortalHeader
import com.example.ui.components.SponsorSection
import com.example.ui.components.VotingGuideSection
import com.example.ui.components.WhatsAppShareCard
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.OffWhite
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ApuraBrasilApp()
            }
        }
    }
}

private const val OFFICIAL_TSE_RESULTS_URL = "https://resultados.tse.jus.br/"

@Composable
fun ApuraBrasilApp() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    var isViewingInAppBrowser by remember { mutableStateOf(false) }
    var sponsorConfig by remember { mutableStateOf(SponsorConfig()) }

    fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Não foi possível abrir o link externo.", Toast.LENGTH_SHORT).show()
        }
    }

    fun dialPhone(number: String) {
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Não foi possível abrir o discador.", Toast.LENGTH_SHORT).show()
        }
    }

    fun shareViaWhatsApp() {
        val shareMessage = buildString {
            appendLine("🗳️ *APURA BRASIL — Apuração ao Vivo das Eleições*")
            appendLine()
            appendLine("Consulte os resultados oficiais e a contagem de votos diretamente na fonte da Justiça Eleitoral:")
            appendLine("👉 $OFFICIAL_TSE_RESULTS_URL")
            appendLine()
            appendLine("📌 Horários de votação, documentos aceitos e regras na cabine sem complicação.")
            appendLine("*Informação segura, sem fake news e com respeito à democracia.*")
        }

        try {
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareMessage)
                // Try WhatsApp specifically if installed
                `package` = "com.whatsapp"
            }
            context.startActivity(sendIntent)
        } catch (e: Exception) {
            // Fallback to generic Android share sheet
            val genericIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareMessage)
            }
            val chooser = Intent.createChooser(genericIntent, "Compartilhar Apuração ao Vivo via...")
            chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(chooser)
        }
    }

    if (isViewingInAppBrowser) {
        InAppOfficialWebView(
            url = OFFICIAL_TSE_RESULTS_URL,
            onClose = { isViewingInAppBrowser = false },
            onOpenExternal = { openUrl(OFFICIAL_TSE_RESULTS_URL) }
        )
    } else {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                PortalHeader(
                    onShareClick = { shareViaWhatsApp() }
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .testTag("main_screen_scaffold")
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(OffWhite)
                    .padding(innerPadding),
                contentAlignment = Alignment.TopCenter
            ) {
                // Adaptive container: centered with max width 640.dp for tablets/foldables/DeX
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .widthIn(max = 640.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    val scrollState = rememberScrollState()

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                            .padding(horizontal = 16.dp, vertical = 18.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // 1. Hero Section ("Acompanhe a apuração", "Consulte os resultados nas fontes oficiais")
                        HeroSection(
                            onOpenOfficialExternal = { openUrl(OFFICIAL_TSE_RESULTS_URL) },
                            onOpenInAppBrowser = { isViewingInAppBrowser = true }
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // 2. WhatsApp Share Button & Card
                        WhatsAppShareCard(
                            onShareWhatsApp = { shareViaWhatsApp() }
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // 3. "Oferecimento" Sponsor Section with clearly identified advertising badge
                        SponsorSection(
                            sponsor = sponsorConfig,
                            onOpenSponsorLink = { url -> openUrl(url) },
                            onUpdateSponsor = { updated ->
                                sponsorConfig = updated
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar("Patrocinador atualizado com sucesso!")
                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        // 4. Useful Voting Information Guide
                        VotingGuideSection(
                            topics = GuideRepository.topics,
                            onOpenExternalLink = { url -> openUrl(url) }
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        // 5. Official Channels & Helpline (SOS Voto 1491, Disque 148, Autoatendimento)
                        OfficialChannelsSection(
                            onDialPhone = { phone -> dialPhone(phone) },
                            onOpenUrl = { url -> openUrl(url) }
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        // 6. Disclaimer Footer declaring independence & no connection to TSE
                        DisclaimerFooter()
                    }
                }
            }
        }
    }
}
