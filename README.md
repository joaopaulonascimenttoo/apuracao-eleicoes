# Apura Brasil — Apuração ao Vivo

Portal independente de utilidade pública e acompanhamento das eleições brasileiras, com visual profissional de portal de notícias e foco em dispositivos móveis e desktop.

---

## 🇧🇷 Identidade e Diretrizes do Projeto

- **Cores:** Fundo branco (`#FFFFFF`), azul-marinho (`#0A192F`, `#0F2042`) e detalhes em verde esmeralda (`#059669`, `#10B981`).
- **Fontes Oficiais:** Direcionamento direto para a apuração oficial do Tribunal Superior Eleitoral: [`https://resultados.tse.jus.br/`](https://resultados.tse.jus.br/).
- **Aviso Legal:** O projeto é 100% independente e não representa, não possui vínculo e não tem afiliação com o Tribunal Superior Eleitoral (TSE) ou órgãos públicos.
- **Privacidade & Integridade:** Não coleta dados pessoais dos visitantes e não inventa dados ou resultados de candidatos.
- **Espaço Publicitário:** Seção "Oferecimento" com clara identificação de anúncio.

---

## 📱 1. Execução do Aplicativo Android (Nativo)

O aplicativo nativo foi construído em **Kotlin + Jetpack Compose** com Material Design 3 e design adaptável para celulares e tablets:

- **Compilar e Executar no AI Studio:**
  O emulador interativo no painel lateral atualiza e recarrega o app automaticamente.
- **Compilar via Terminal:**
  ```bash
  gradle assembleDebug
  ```
  O APK gerado ficará disponível em `app/build/outputs/apk/debug/app-debug.apk`.
- **Rodar Testes Unitários e Robolectric:**
  ```bash
  gradle :app:testDebugUnitTest
  ```

---

## 🌐 2. Como Publicar o Site Responsivo Gratuitamente

Na pasta `/web/index.html` encontra-se o site responsivo completo em arquivo único (HTML5/CSS3/JavaScript puro), sem dependências pagas e pronto para publicação imediata em qualquer serviço gratuito:

### Opção A: GitHub Pages (100% Gratuito)
1. Crie um repositório no [GitHub](https://github.com/).
2. Envie o conteúdo do projeto ou apenas o arquivo `web/index.html` renomeado para `index.html` na raiz do branch `main` ou `gh-pages`.
3. Vá em **Settings > Pages > Build and deployment**, selecione a branch `main` e a pasta `/root`.
4. Em menos de 1 minuto seu site estará no ar em `https://seu-usuario.github.io/seu-repositorio/`.

### Opção B: Vercel (100% Gratuito)
1. Acesse [vercel.com](https://vercel.com/) e faça login gratuito com sua conta GitHub.
2. Clique em **Add New Project** e selecione este repositório (ou faça upload da pasta `web`).
3. O deploy será instantâneo com certificado SSL HTTPS gratuito.

### Opção C: Netlify (100% Gratuito)
1. Acesse [netlify.com](https://netlify.com/).
2. Na aba **Sites**, arraste e solte a pasta `web/`.
3. O site é publicado em segundos com domínio gratuito `.netlify.app`.

---

## 📌 Principais Recursos

1. **Acompanhe a apuração:** Botão de alta visibilidade direcionando para os resultados oficiais sem intermediários.
2. **Visualizador no App:** Permite navegar diretamente no portal do TSE dentro do próprio aplicativo via WebView otimizado.
3. **Compartilhar pelo WhatsApp:** Botão com mensagem pronta de utilidade pública para combater a desinformação.
4. **Oferecimento (Publicidade):** Bloco reservado para patrocinador institucional com logomarca, descrição e link de destino.
5. **Guia Completo da Votação:**
   - Horários unificados pelo fuso de Brasília (08h às 17h).
   - Documentos oficiais aceitos com foto (e-Título, RG, CNH, Passaporte).
   - Como justificar a ausência (no dia pelo e-Título ou em até 60 dias).
   - Consulta de local de votação e seção eleitoral.
   - Regras da cabine de votação (colinha de papel permitida; proibido celular).
   - Auditoria das urnas e combate a boatos (Fato ou Boato e SOS Voto 1491).
