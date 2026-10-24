package com.example.model

data class GuideTopic(
    val id: String,
    val title: String,
    val summary: String,
    val iconName: String,
    val keyPoints: List<String>,
    val officialNote: String,
    val officialLink: String? = null,
    val officialLinkLabel: String? = null
)

object GuideRepository {
    val topics = listOf(
        GuideTopic(
            id = "horarios",
            title = "Horário de Votação Unificado",
            summary = "A votação ocorre das 08h às 17h pelo horário oficial de Brasília em todo o Brasil.",
            iconName = "schedule",
            keyPoints = listOf(
                "Início às 08h00 e encerramento às 17h00 (horário de Brasília).",
                "Estados com fuso horário diferente devem seguir o horário de Brasília (ex: Acre vota das 06h às 15h no horário local).",
                "Eleitores que já estiverem na fila às 17h recebem senha e têm direito assegurado ao voto."
            ),
            officialNote = "Definição oficial do TSE para padronizar o início da apuração em nível nacional."
        ),
        GuideTopic(
            id = "documentos",
            title = "Documentos Permitidos para Votar",
            summary = "Apresente um documento oficial com foto. O título em papel não é obrigatório.",
            iconName = "badge",
            keyPoints = listOf(
                "e-Título (aplicativo digital) com foto cadastrada e biometria regular.",
                "Carteira de Identidade (RG) física ou digital oficial.",
                "Carteira Nacional de Habilitação (CNH) física ou digital.",
                "Passaporte brasileiro válido.",
                "Carteira de Trabalho física ou carteira profissional de órgão de classe (OAB, CRM, CREA, etc.).",
                "Atenção: O título de eleitor impresso sem foto serve apenas para consultar a seção, exigindo documento com foto adicional."
            ),
            officialNote = "Certidões de nascimento ou casamento NÃO são aceitas como documento de identificação."
        ),
        GuideTopic(
            id = "justificativa",
            title = "Como Justificar a Ausência",
            summary = "Se estiver fora do seu domicílio eleitoral, justifique no dia ou em até 60 dias.",
            iconName = "edit_note",
            keyPoints = listOf(
                "No dia da eleição: Diretamente pelo aplicativo e-Título (das 08h às 17h via geolocalização).",
                "No dia da eleição presencial: Em qualquer mesa receptora de justificativa ou seção eleitoral.",
                "Após a eleição: Em até 60 dias após cada turno pelo Sistema Justifica (justifica.tse.jus.br) ou cartório eleitoral com comprovante.",
                "Eleitores no exterior têm 30 dias após o retorno ao Brasil para regularizar a situação."
            ),
            officialNote = "A justificativa é individual para cada turno em que o eleitor não compareceu."
        ),
        GuideTopic(
            id = "local_votacao",
            title = "Consulta de Local e Seção Eleitoral",
            summary = "Verifique sua zona e seção eleitoral com antecedência antes de sair de casa.",
            iconName = "location_on",
            keyPoints = listOf(
                "Pelo aplicativo gratuito e-Título disponível para Android e iOS.",
                "Pelo portal oficial do TSE na seção 'Serviços Eleitorais -> Local de Votação'.",
                "Pelo WhatsApp oficial do TSE com atendimento automatizado.",
                "Pelo atendimento telefônico do seu Tribunal Regional Eleitoral (TRE)."
            ),
            officialNote = "Confira com antecedência, pois algumas seções e zonas sofrem alterações antes do pleito.",
            officialLink = "https://www.tse.jus.br/servicos-eleitorais/autoatendimento-eleitoral#/atendimento-eleitor",
            officialLinkLabel = "Consultar Local no Portal do TSE"
        ),
        GuideTopic(
            id = "cabine",
            title = "Regras na Cabine: O que Pode e Não Pode",
            summary = "É permitida a 'colinha' de papel. Celulares e câmeras são terminantemente proibidos.",
            iconName = "how_to_vote",
            keyPoints = listOf(
                "PODE: Levar colinha de papel com o número e o nome dos seus candidatos.",
                "PODE: Manifestação individual e silenciosa da preferência (uso de broches, adesivos e bandeira pessoal).",
                "NÃO PODE: Entrar na cabine com celular, câmera fotográfica, filmadora ou qualquer aparelho de transmissão.",
                "O celular deve ser desligado e entregue aos mesários antes de se dirigir à urna eletrônica.",
                "NÃO PODE: Aglomeração de pessoas com roupas padronizadas caracterizando boca de urna."
            ),
            officialNote = "O sigilo do voto é protegido pela Constituição Federal e pelo Código Eleitoral."
        ),
        GuideTopic(
            id = "seguranca_urnas",
            title = "Auditoria e Transparência das Urnas",
            summary = "Entenda como funciona o Boletim de Urna (BU) e a fiscalização dos votos.",
            iconName = "verified_user",
            keyPoints = listOf(
                "Zeresima: Relatório impresso antes das 08h comprovando zero votos registrados na urna.",
                "Boletim de Urna (BU): Impresso imediatamente às 17h e fixado na porta de cada seção para conferência pública.",
                "Aplicativo Boletim na Mão: Qualquer cidadão pode escanear o QR Code do BU impresso na seção para conferir o total de votos.",
                "Urna 100% desconectada: Não possui placa Wi-Fi, Bluetooth nem conexão com a internet."
            ),
            officialNote = "Fiscalização realizada por partidos políticos, OAB, Ministério Público e observadores independentes."
        ),
        GuideTopic(
            id = "fato_boato",
            title = "Checagem de Fatos e Combate a Boatos",
            summary = "Não repasse mensagens duvidosas. Consulte os canais oficiais de checagem.",
            iconName = "fact_check",
            keyPoints = listOf(
                "Página oficial 'Fato ou Boato' da Justiça Eleitoral desmente desinformações frequentes.",
                "SOS Voto (Disque 1491): Canal gratuito da Justiça Eleitoral para denúncias de fake news e desinformação eleitoral.",
                "Tira-dúvidas oficial no WhatsApp: Verificação rápida de notícias eleitorais diretamente pelo mensageiro.",
                "Nunca compartilhe áudios ou vídeos sem confirmação de veículos de imprensa confiáveis."
            ),
            officialNote = "Compartilhar notícias falsas sobre o processo eleitoral pode configurar crime eleitoral.",
            officialLink = "https://www.tse.jus.br/fato-ou-boato",
            officialLinkLabel = "Acessar 'Fato ou Boato' do TSE"
        )
    )
}
