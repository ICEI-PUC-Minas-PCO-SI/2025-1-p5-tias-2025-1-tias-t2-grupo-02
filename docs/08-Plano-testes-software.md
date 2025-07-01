# Plano de testes de software

<span style="color:red">Pré-requisitos: <a href="02-Especificacao.md"> Especificação do projeto</a></span>, <a href="05-Projeto-interface.md"> Projeto de interface</a>


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

<br>

| **Caso de teste**  | **CT-003 – Adicionar Medicamento ao Estoque**  |
|:---: |:---: |
| Requisito associado | RF-007 – Adicionar medicamentos ao estoque |
| Objetivo do teste | Verificar se o usuário consegue adicionar corretamente um novo medicamento ao estoque vinculado a um paciente. |
| Passos | - Acessar o sistema através do navegador <br> - Navegar até a seção “Medicamentos” <br> - Clicar em “Adicionar Itens” <br> - Preencher os campos obrigatórios (Nome do Paciente, Descrição (Nome do Medicamento), Posologia / Dosagem, Quantidade, Data de Validade, Data de Adição) <br> - Clicar no botão “Salvar” |
| Critério de êxito | - O medicamento deve ser salvo com sucesso e aparecer na listagem de estoque associado ao paciente informado. |
| Responsável pela elaboração do caso de teste | Pedro, Igor |

<br>

| **Caso de teste**  | **CT-004 – Autenticação de Usuário**  |
|:---: |:---: |
| Requisito associado | RF-006 – Autenticação de usuário |
| Objetivo do teste | Verificar se o usuário consegue se autenticar no sistema utilizando suas credenciais. |
| Passos | - Acessar o sistema através do navegador <br> - Informar o e-mail do usuário cadastrado <br> - Informar a senha correspondente <br> - Clicar no botão “Entrar” |
| Critério de êxito | - O sistema deve validar as credenciais e redirecionar o usuário para a página inicial do sistema. |
| Responsável pela elaboração do caso de teste | Eduarda |

<br>

| **Caso de teste**  | **CT-005 – Busca Rápida por Pacientes**  |
|:---: |:---: |
| Requisito associado | RF-005 – Busca Rápida por Pacientes |
| Objetivo do teste | Verificar se o sistema permite localizar rapidamente pacientes cadastrados a partir de um termo de busca. |
| Passos | - Acessar o sistema através do navegador <br> - Navegar até a seção “Pacientes” <br> - Localizar o campo de busca <br> - Digitar parte do nome, CPF ou status de um paciente <br> - Verificar se a lista é filtrada automaticamente conforme o termo inserido |
| Critério de êxito | - O sistema deve exibir os pacientes que correspondem ao termo digitado, atualizando a lista em tempo real ou após a busca. |
| Responsável pela elaboração do caso de teste | Diogo |



