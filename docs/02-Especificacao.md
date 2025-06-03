# Especificação do projeto

Nesta seção, são apresentados os requisitos necessários para o desenvolvimento do sistema de gestão de pacientes e controle de medicamentos. A especificação foi elaborada com base na análise das necessidades dos usuários e nas particularidades do ambiente da instituição, visando garantir que a solução seja funcional, eficiente e segura.

Foram utilizadas técnicas como levantamento de requisitos através de entrevistas, análise de processos e construção de histórias de usuários. Além disso, foi aplicado um método de priorização por níveis (Alta, Média e Baixa), levando em conta a criticidade de cada funcionalidade para o funcionamento do sistema e o impacto direto na experiência do usuário e na operação da instituição.

## Personas

Exemplo: _Pedro Paulo tem 26 anos, é arquiteto recém-formado e autônomo. Pensa em se desenvolver profissionalmente por meio de um mestrado fora do país, pois adora viajar, é solteiro e sempre quis fazer um intercâmbio. Está buscando uma agência que o ajude a encontrar universidades na Europa que aceitem alunos estrangeiros._

Enumere e detalhe as personas da sua solução. Para tanto, baseie-se tanto nos documentos disponibilizados na disciplina e/ou nos seguintes links:

> **Links úteis**:
> - [Rock content](https://rockcontent.com/blog/personas/)
> - [Hotmart](https://blog.hotmart.com/pt-br/como-criar-persona-negocio/)
> - [O que é persona?](https://resultadosdigitais.com.br/blog/persona-o-que-e/)
> - [Persona x público-alvo](https://flammo.com.br/blog/persona-e-publico-alvo-qual-a-diferenca/)
> - [Mapa de empatia](https://resultadosdigitais.com.br/blog/mapa-da-empatia/)
> - [Mapa de stalkeholders](https://www.racecomunicacao.com.br/blog/como-fazer-o-mapeamento-de-stakeholders/)
>
Lembre-se que você deve ser enumerar e descrever precisamente e personalizada todos os clientes ideais que sua solução almeja.

## Histórias de usuários

Com base na análise das personas, foram identificadas as seguintes histórias de usuários:

|EU COMO... `PERSONA`| QUERO/PRECISO ... `FUNCIONALIDADE` |PARA ... `MOTIVO/VALOR`                 |
|--------------------|------------------------------------|----------------------------------------|
|Usuário do sistema  | Registrar minhas tarefas           | Não esquecer de fazê-las               |
|Administrador       | Alterar permissões                 | Permitir que possam administrar contas |

Apresente aqui as histórias de usuários que são relevantes para o projeto da sua solução. As histórias de usuários consistem em uma ferramenta poderosa para a compreensão e elicitação dos requisitos funcionais e não funcionais da sua aplicação. Se possível, agrupe as histórias de usuários por contexto, para facilitar consultas recorrentes a esta parte do documento.

> **Links úteis**:
> - [Histórias de usuários com exemplos e template](https://www.atlassian.com/br/agile/project-management/user-stories)
> - [Como escrever boas histórias de usuário (user stories)](https://medium.com/vertice/como-escrever-boas-users-stories-hist%C3%B3rias-de-usu%C3%A1rios-b29c75043fac)
> - [User stories: requisitos que humanos entendem](https://www.luiztools.com.br/post/user-stories-descricao-de-requisitos-que-humanos-entendem/)
> - [Histórias de usuários: mais exemplos](https://www.reqview.com/doc/user-stories-example.html)
> - [9 common user story mistakes](https://airfocus.com/blog/user-story-mistakes/)

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

![Diagrama de Caso de Uso](https://github.com/user-attachments/assets/db1bf15c-eb2b-40d0-a40b-e9028b4d4188)
