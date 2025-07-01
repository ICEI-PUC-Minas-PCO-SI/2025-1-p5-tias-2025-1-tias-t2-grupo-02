# Plano de testes de software

<span style="color:red">Pré-requisitos: <a href="02-Especificacao.md"> Especificação do projeto</a></span>, <a href="05-Projeto-interface.md"> Projeto de interface</a>

O plano de testes de software é gerado a partir da especificação do sistema e consiste em casos de teste que deverão ser executados quando a implementação estiver parcial ou totalmente pronta. Apresente os cenários de teste utilizados na realização dos testes da sua aplicação. Escolha cenários de teste que demonstrem os requisitos sendo satisfeitos.

Enumere quais cenários de testes foram selecionados para teste. Neste tópico, o grupo deve detalhar quais funcionalidades foram avaliadas, o grupo de usuários que foi escolhido para participar do teste e as ferramentas utilizadas.

Não deixe de enumerar os casos de teste de forma sequencial e garantir que o(s) requisito(s) associado(s) a cada um deles esteja(m) correto(s) — de acordo com o que foi definido na <a href="02-Especificacao.md">Especificação do projeto</a>.

Por exemplo:

| **Caso de teste**  | **CT-001 – Cadastrar Paciente**  |
|:---: |:---: |
| Requisito associado | RF-001	Cadastro de Pacientes |
| Objetivo do teste | Verificar se o usuário consegue se cadastrar na aplicação. |
| Passos |	- Acessar o sistema através do navegador <br> - Navegar até a seção “Pacientes” <br> - Clicar em  “ Cadastrar novo Paciente” <br> - Preencher os campos obrigatórios (Nome Completo, Data de Nascimento, CPF, RG, Tipo Sanguíneo, Plano de Saúde, Carteirinha, Doenças Crônicas, Nome (Contato de Emergência), Parentesco, Telefone, E-mail) <br> - Clicar no botão “Cadastrar Paciente” |
| Critério de êxito | - O cadastro foi realizado com sucesso. |
| Responsável pela elaboração do caso de teste | Ana Clara. |

<br>

| **Caso de teste**  | **CT-002 – Editar Dados Paciente**  |
|:---: |:---: |
| Requisito associado | RRF-002 – Edição de dados de paciente |
| Objetivo do teste | Verificar se o usuário consegue editar os dados de um paciente cadastrado. |
| Passos | - Acessar o sistema através do navegador <br> - Navegar até a seção “Pacientes” <br> - Selecionar um paciente já cadastrado <br> - Clicar no botão “Editar” <br> - Alterar um ou mais campos obrigatórios (Nome Completo, Data de Nascimento, CPF, RG, Tipo Sanguíneo, Plano de Saúde, Carteirinha, Doenças Crônicas, Nome (Contato de Emergência), Parentesco, Telefone, E-mail) <br> - Clicar no botão “Salvar alterações” |
| Critério de êxito | - Os dados atualizados devem ser salvos com sucesso e refletidos na listagem de pacientes. |
| Responsável pela elaboração do caso de teste | Ana Flavia |


## Ferramentas de testes (opcional)

Comente sobre as ferramentas de testes utilizadas.
 
> **Links úteis**:
> - [IBM - criação e geração de planos de teste](https://www.ibm.com/developerworks/br/local/rational/criacao_geracao_planos_testes_software/index.html)
> - [Práticas e técnicas de testes ágeis](http://assiste.serpro.gov.br/serproagil/Apresenta/slides.pdf)
> - [Teste de software: conceitos e tipos de testes](https://blog.onedaytesting.com.br/teste-de-software/)
> - [Criação e geração de planos de teste de software](https://www.ibm.com/developerworks/br/local/rational/criacao_geracao_planos_testes_software/index.html)
> - [Ferramentas de teste para JavaScript](https://geekflare.com/javascript-unit-testing/)
> - [UX Tools](https://uxdesign.cc/ux-user-research-and-user-testing-tools-2d339d379dc7)
