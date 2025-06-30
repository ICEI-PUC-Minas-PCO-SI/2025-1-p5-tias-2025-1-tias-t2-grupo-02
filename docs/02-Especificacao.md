# Especificação do Projeto

Nesta seção, são apresentados os requisitos necessários para o desenvolvimento do sistema de gestão de pacientes e controle de medicamentos. A especificação foi elaborada com base na análise das necessidades dos usuários e nas particularidades do ambiente da instituição, visando garantir que a solução seja funcional, eficiente e segura.

Foram utilizadas técnicas como levantamento de requisitos através de entrevistas, análise de processos e construção de histórias de usuários. Além disso, foi aplicado um método de priorização por níveis (Alta, Média e Baixa), levando em conta a criticidade de cada funcionalidade para o funcionamento do sistema e o impacto direto na experiência do usuário e na operação da instituição.

---

## Personas

Para o sistema de gestão de pacientes da Casa de Repouso "Jeitinho da Vovó e do Vovô", identificamos as seguintes personas:

### 1. Maria Eduarda, a Enfermeira Dedicada

* **Dados demográficos:** 35 anos, enfermeira-chefe da Casa de Repouso, possui ensino superior em enfermagem e experiência de 10 anos em cuidados com idosos.
* **Personalidade:** Organizada, proativa, atenta aos detalhes e muito zelosa com o bem-estar dos pacientes. Valoriza a praticidade e a agilidade no dia a dia.
* **Objetivos:**
    * Ter acesso rápido e seguro a todas as informações de saúde dos pacientes, especialmente medicações e alergias.
    * Garantir que a administração de medicamentos seja feita de forma correta e no horário certo.
    * Reduzir o tempo gasto com burocracia e arquivos físicos para focar mais no cuidado direto aos idosos.
    * Manter um histórico detalhado da evolução clínica de cada paciente.
* **Frustrações:**
    * A demora em encontrar informações nos arquivos físicos.
    * O risco de erros na administração de medicamentos devido à falta de acesso rápido a dados atualizados.
    * A dificuldade em gerenciar o grande volume de informações de forma eficiente.
    * O sistema atual ser complexo e não otimizado para uso móvel.
* **Comportamento:** Utiliza o celular e o tablet para diversas tarefas pessoais e busca soluções digitais que simplifiquem seu trabalho. Gosta de aplicativos intuitivos e fáceis de usar.

### 2. João Silva, o Auxiliar de Enfermagem Prático

* **Dados demográficos:** 28 anos, auxiliar de enfermagem, recém-chegado à instituição, com curso técnico em enfermagem.
* **Personalidade:** Atencioso, prestativo e sempre disposto a aprender. Busca otimizar seu tempo e realizar suas tarefas com eficiência.
* **Objetivos:**
    * Registrar de forma simples e rápida as atividades diárias de cuidado com os pacientes (medicações, aferição de sinais vitais, alimentação).
    * Consultar informações básicas dos pacientes, como nome, quarto e histórico de atendimentos.
    * Ter uma ferramenta que facilite a comunicação com a equipe de enfermagem.
* **Frustrações:**
    * A necessidade de preencher formulários em papel.
    * A dificuldade em acessar o sistema atual da instituição.
    * Perder tempo procurando informações sobre os pacientes.
    * Falta de um método padronizado para registrar dados.
* **Comportamento:** Usuário frequente de smartphones para comunicação e acesso a informações, familiarizado com aplicativos de mensagem e redes sociais.

### 3. Aira, a Diretora Administrativa Visionária

* **Dados demográficos:** 45 anos, Diretora Administrativa da Casa de Repouso "Jeitinho da Vovó e do Vovô", possui graduação em administração e experiência em gestão de instituições de saúde.
* **Personalidade:** Estratégica, focada em resultados, preocupada com a qualidade dos serviços e a eficiência operacional. Busca soluções que otimizem os processos e reduzam custos.
* **Objetivos:**
    * Garantir a segurança e integridade dos dados dos pacientes.
    * Ter uma visão geral da gestão de pacientes e medicamentos.
    * Reduzir custos operacionais, incluindo a manutenção de sistemas antigos e o uso excessivo de papel.
    * Melhorar a reputação da instituição através da modernização e eficiência.
    * Facilitar a auditoria e conformidade com as normas de saúde.
* **Frustrações:**
    * A ineficiência e o alto custo do sistema atual (Gerifácil).
    * O risco de perda de informações importantes devido aos registros físicos.
    * A dificuldade em ter relatórios e dados para tomadas de decisão.
    * A falta de mobilidade para a equipe.
* **Comportamento:** Toma decisões baseadas em dados e busca tecnologias que tragam retorno sobre o investimento. Utiliza o computador e o smartphone para gerenciar a instituição.

---

## Histórias de Usuários

Com base na análise das personas, foram identificadas as seguintes histórias de usuários, agrupadas por contexto para facilitar consultas recorrentes:

### Gestão de Pacientes

| EU COMO... `PERSONA` | QUERO/PRECISO ... `FUNCIONALIDADE` | PARA ... `MOTIVO/VALOR` |
| :------------------- | :--------------------------------- | :---------------------- |
| Maria Eduarda        | Cadastrar novos pacientes no sistema | Ter todos os dados centralizados e acessíveis |
| João Silva           | Consultar o perfil de um paciente específico (nome, quarto, idade) | Saber quem é o residente e sua localização |
| Maria Eduarda        | Visualizar o histórico completo de saúde de um paciente (laudos, diagnósticos, evolução) | Acompanhar sua condição e tomar decisões informadas |
| João Silva           | Registrar o estado de saúde diário de um paciente (sinais vitais, observações) | Manter o histórico atualizado para a equipe |
| Maria Eduarda        | Editar as informações de um paciente (endereço, telefone, contato de emergência) | Manter os dados sempre atualizados |
| Aira                 | Ter uma visão geral da quantidade de pacientes ativos na casa | Gerenciar a capacidade da instituição |

### Controle de Medicamentos

| EU COMO... `PERSONA` | QUERO/PRECISO ... `FUNCIONALIDADE` | PARA ... `MOTIVO/VALOR` |
| :------------------- | :--------------------------------- | :---------------------- |
| Maria Eduarda        | Cadastrar os medicamentos prescritos para cada paciente | Garantir a administração correta |
| João Silva           | Visualizar a lista de medicamentos a serem administrados a um paciente em um determinado horário | Não esquecer de nenhuma medicação |
| Maria Eduarda        | Registrar a administração de cada medicamento (dose, horário, responsável) | Ter um controle preciso e evitar erros |
| Maria Eduarda        | Receber alertas sobre horários de medicação | Evitar atrasos ou esquecimentos |
| Aira                 | Acessar relatórios sobre o consumo de medicamentos por paciente e por período | Otimizar o estoque e controlar os gastos |

### Acessibilidade e Segurança

| EU COMO... `PERSONA` | QUERO/PRECISO ... `FUNCIONALIDADE` | PARA ... `MOTIVO/VALOR` |
| :------------------- | :--------------------------------- | :---------------------- |
| Maria Eduarda        | Acessar o sistema de qualquer dispositivo móvel (celular, tablet) | Ter as informações à mão em qualquer lugar da instituição |
| João Silva           | Que a interface do sistema seja intuitiva e fácil de usar | Agilizar meu trabalho e reduzir a curva de aprendizado |
| Aira                 | Que o sistema tenha diferentes níveis de acesso para os usuários (administrador, enfermeiro, auxiliar) | Garantir a segurança e confidencialidade dos dados |
| Aira                 | Que todas as informações dos pacientes sejam armazenadas de forma segura e protegida por criptografia | Cumprir com as normas de privacidade de dados |
| Qualquer Usuário     | Que o sistema seja rápido e responsivo | Não perder tempo esperando o carregamento das telas |

### Gestão de Documentos e Laudos

| EU COMO... `PERSONA` | QUERO/PRECISO ... `FUNCIONALIDADE` | PARA ... `MOTIVO/VALOR` |
| :------------------- | :--------------------------------- | :---------------------- |
| Maria Eduarda        | Anexar laudos médicos e exames aos perfis dos pacientes | Ter todos os documentos em um só lugar |
| João Silva           | Visualizar os laudos e exames de um paciente | Entender sua condição de saúde |
| Maria Eduarda        | Fazer upload de novas receitas e prescrições médicas | Manter o prontuário atualizado |
| Maria Eduarda        | Poder baixar os documentos anexados | Imprimir ou compartilhar quando necessário |

---

## Requisitos

As tabelas a seguir apresentam os requisitos funcionais e não funcionais que detalham o escopo do projeto.

### Requisitos funcionais

|ID    | Descrição do Requisito  | Prioridade |
|------|-----------------------------------------|----|
|RF-001| Cadastro de Pacientes | ALTA | 
|RF-002| Edição de dados de paciente | ALTA |
|RF-003| Cadastro de Dados Médicos | ALTA | 
|RF-004| Consulta de informações de paciente | ALTA | 
|RF-005| Busca Rápida por Pacientes | ALTA | 
|RF-006| Autenticação de usuário | MÉDIA | 
|RF-007| Adicionar medicamentos ao estoque | MÉDIA | 
|RF-008| Baixa automática de estoque | MÉDIA | 

### Requisitos não funcionais

|ID     | Descrição do Requisito  |Prioridade |
|-------|-------------------------|----|
|RNF-001| O site deve carregar rapidamente, com um tempo de resposta inferior a 2 segundos | MÉDIA | 
|RNF-002| Deve ser capaz de suportar aumento no número de usuários e dados sem degradação. |  MÉDIA | 
|RNF-003| Garantir que apenas usuários autorizados possam acessar informações especificas. | ALTA | 
|RNF-004| A interface deve ser fácil de usar, navegação clara e acessível para todos.  | MÉDIA | 
|RNF-005| O site deve estar disponível 99.9% do tempo, com planos de contingência de falhas.  | ALTA | 
|RNF-006| Implementar sistemas de backup regulares e procedimentos de recuperação de desastres | MÉDIA | 
|RNF-007| O código deve ser bem documentado, para facilitar manutenções  | MÉDIA | 

### Requisitos de domínio

|ID     | Descrição do Requisito  |Prioridade |
|-------|-------------------------|----|
|RD-001| OS medicamentos adquiridos devem ser registrados no sistema.  | MÉDIA | 
|RD-002| As restrições alimentares dos pacientes são informações críticas que afetam diretamente sua saúde e bem-estar, devendo ser rigorosamente observadas por toda a equipe do asilo.  | MÉDIA | 
|RD-003| A confidencialidade das informações médicas dos pacientes é um direito fundamental que deve ser respeitado pelo asilo, garantindo a privacidade e a segurança dos dados.  | ALTA | 

## Restrições


O projeto está restrito aos itens apresentados na tabela a seguir.

|ID| Restrição                                             |
|--|-------------------------------------------------------|
|001| O projeto deverá ser entregue até o final do semestre |
|002| O custo total do projeto não deve exceder o orçamento definido |
|003| O projeto deverá ser hospedado em algum ambiente virtual |
|004| O custo mensal da hospedagem da aplicação deve ser inferior a 200 reais |

## Diagrama de casos de uso

![Diagrama de Caso de Uso](docs/images/casodeuso.png)
