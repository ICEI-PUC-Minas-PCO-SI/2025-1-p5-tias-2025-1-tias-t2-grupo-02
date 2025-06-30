# Plano de Testes de Usabilidade - Jeitinho da Vovó e do Vovô

O objetivo principal deste plano de testes de usabilidade é **avaliar a qualidade da interface com o usuário da aplicação "Jeitinho da Vovó e do Vovô"**, garantindo que as principais funcionalidades sejam intuitivas, eficientes e atendam às necessidades dos **Colaboradores** e **Administradores** da Casa de Repouso. Nosso foco é obter feedback sobre a **facilidade de uso**, **curva de aprendizado** e **satisfação geral** com o sistema, especialmente em dispositivos móveis.

---

## Objetivos e Cenários de Teste

Com base nos requisitos funcionais e nas histórias de usuário levantadas, elaboramos os seguintes cenários para demonstrar as principais interações com o sistema:

| Nº do Cenário | Descrição do Cenário | Funcionalidades Avaliadas |
|---|---|---|
| **1** | Você é um **Colaborador** recém-contratado. Acesse o sistema utilizando suas credenciais e **cadastre um novo paciente**, incluindo seus dados pessoais, contato de familiar, alergias e um medicamento de uso contínuo. | Autenticação de usuário (RF-006), Cadastro de Pacientes (RF-001), Cadastro de Dados Médicos (RF-003) |
| **2** | Você é um **Colaborador** que precisa **consultar rapidamente as informações de um paciente** existente. Encontre o paciente "Maria Silva" e verifique quais medicamentos ela está utilizando e se há alguma restrição alimentar. | Busca Rápida por Pacientes (RF-005), Consulta de informações de paciente (RF-004), Restrições Alimentares dos Pacientes (RD-002) |
| **3** | Você é um **Colaborador** e precisa **atualizar a dosagem de um medicamento** para um paciente específico. Acesse a ficha do paciente "João Pereira" e altere a dosagem do medicamento "Insulina" de 10 UI para 12 UI, e adicione uma nova observação sobre sua condição de saúde atual. | Edição de dados de paciente (RF-002), Cadastro de Dados Médicos (RF-003), Gestão de Prontuários e Confidencialidade (RD-003) |
| **4** | Você é um **Administrador** e precisa **cadastrar um novo colaborador** na Casa de Repouso, concedendo a ele as permissões adequadas para operar o sistema. | Cadastrar e Gerir colaboradores (FN-03) |
| **5** | Você é um **Colaborador** e recebeu um novo lote de medicamentos "Dipirona" para o paciente "Ana Costa". **Adicione esses medicamentos ao estoque**, referenciando-os ao paciente e indicando a periodização prescrita, observando a baixa automática. | Adicionar medicamentos ao estoque (RF-007), Baixa automática de estoque (RF-008), Registro de Medicamentos Controlados (RD-001) |

---

## Critérios de Seleção dos Participantes

Serão convidados **seis (6) participantes**, divididos em dois grupos, que se encaixem nos perfis de usuários identificados na documentação:

* **Grupo 1: Colaboradores da Casa de Repouso (4 participantes)**: Idealmente, funcionários que atualmente lidam com o registro e consulta de informações de pacientes. Este grupo é crucial para avaliar a **Interface Intuitiva (RNF-004)** e o **Tempo de Resposta (RNF-001)** em suas rotinas diárias.
* **Grupo 2: Administradores da Casa de Repouso (2 participantes)**: Diretores ou supervisores que serão responsáveis pela gestão de usuários no sistema.

Objetivando respeitar as diretrizes da **Lei Geral de Proteção de Dados (LGPD)**, as informações pessoais dos usuários que participarem do teste não serão coletadas.

---

## Procedimentos e Dados a Serem Coletados

Os testes serão conduzidos de forma **presencial** na Casa de Repouso, com cada participante utilizando um dispositivo móvel (smartphone ou tablet) fornecido pela equipe de teste, otimizado para o ambiente da instituição. O método será de **observação direta** e **medição** das interações.

Para cada voluntário e cenário de teste, serão coletados e apresentados os seguintes dados/métricas:

* **Taxa de Sucesso:** Indica se o usuário conseguiu ou não executar a tarefa proposta (Sim/Não).
* **Tempo para Conclusão da Tarefa:** Tempo, em segundos, desde o início até a conclusão da tarefa. Este dado será comparado com o tempo de execução por um especialista (desenvolvedor) para cada cenário, buscando otimização do **Tempo de Resposta (RNF-001)**.
* **Número de Cliques/Interações:** Quantidade de cliques ou toques necessários para completar cada tarefa.
* **Número de Erros:** Quantidade de erros (tentativas incorretas, navegação perdida, etc.) cometidos durante a execução da tarefa.
* **Satisfação Subjetiva:** O usuário avaliará o sistema com relação à execução da tarefa proposta, utilizando a seguinte escala: **Péssimo, Ruim, Regular, Bom, Ótimo**. Esta métrica contribui para avaliar a **Interface Intuitiva (RNF-004)**.
* **Comentários Qualitativos:** Serão coletados feedbacks verbais dos usuários sobre a experiência, pontos de dificuldade, sugestões de melhoria e facilidades percebidas.

---

## Ordem de Execução das Tarefas e Etapas da Sessão de Teste

Cada sessão de teste terá a seguinte estrutura:

1.  **Boas-vindas e Introdução (5 minutos):** Apresentação do objetivo do teste (avaliar o sistema, não o usuário), garantia de anonimato dos dados e esclarecimento de dúvidas.
2.  **Cenários de Teste (10-15 minutos por cenário):** O condutor de teste apresentará um cenário por vez e instruirá o participante a realizá-lo no sistema. Será observada a interação, registrado o tempo, cliques e erros. Não haverá intervenção do condutor a menos que o participante solicite ou não consiga prosseguir após um tempo considerável.
3.  **Questionário de Satisfação e Feedback (5-10 minutos):** Após a execução de cada cenário (ou ao final de todos), o participante responderá sobre sua satisfação e dará comentários qualitativos.
4.  **Encerramento (5 minutos):** Agradecimento pela participação.

A ordem de execução dos cenários será padronizada para todos os participantes.

---

## Recursos Demandados

* **Equipe de Teste:** Membros da equipe de desenvolvimento do projeto (para condução dos testes e registro de dados).
* **Dispositivos:** Smartphones/tablets ou computadores com a aplicação instalada e acesso à internet.
* **Ambiente:** Sala tranquila e com boa iluminação na Casa de Repouso.
* **Ferramentas de Apoio:** Cronômetro, formulários de registro de dados (digitais ou físicos), gravador de tela (opcional, com consentimento prévio para análise posterior da interação).
