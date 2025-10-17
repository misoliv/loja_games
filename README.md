# Jogada Perfeita - Backend

<br />

<div align="center">
   <img width="512" height="512" src="https://ik.imagekit.io/milenasoliv10/logo_loja.png?updatedAt=1760735635874" title="source: imgur.com" /> 
</div>


<br /><br />

## 1. Descrição

Loja dedicada aos amantes de jogos de tabuleiro, com ampla variedade de títulos nacionais e importados.
Compre com facilidade e receba em casa os melhores boardgames para todas as idades e estilos de jogo.

Entre os principais recursos que uma loja de games oferece, destacam-se:

- Criação, edição e exclusão de produtos;
- Associação de produtos e categorias específicas;
- Visualização de produtos por categoria.

------

## 2. Sobre esta API

A API da Loja de Games foi desenvolvida em Java, utilizando o framework Spring, e segue os princípios da Arquitetura MVC e REST. Ela disponibiliza endpoints para o gerenciamento dos recursos Produto e Categoria, com testes de CRUD (Create, Read, Update e Delete) realizados por meio do Insomnia.

### 2.1. Principais Funcionalidades

1. Consulta, criação e gerenciamento de categoria para classificar produtos
2. Criação, edição, listagem e remoção de produtos
3. Associação de produtos a categorias
4. Consulta que retorna todos os produtos com preço maior que o valor informado, ordenados em ordem crescente.
5. Consulta que retorna todos os produtos com preço menor que o valor informado, ordenados em ordem decrescente.

------

## 3. Diagrama de Classes

O Diagrama de Classes é um modelo visual usado na programação orientada a objetos para representar a estrutura de um sistema. Ele exibe classes, atributos, métodos e os relacionamentos entre elas, como associações, heranças e dependências.

Esse diagrama ajuda a planejar e entender a arquitetura do sistema, mostrando como as entidades interagem e se conectam. É amplamente utilizado nas fases de design e documentação de projetos.

classDiagram
    direction LR

```` mermaid
    class tb_categorias {
        <<Entity>>
        +BIGINT id
        +VARCHAR(255) tipo
        +getId() BIGINT
        +setId(BIGINT) void
        +getTipo() String
        +setTipo(String) void
    }

    class tb_produtos {
        <<Entity>>
        +BIGINT id
        +DOUBLE avaliacao
        +VARCHAR(1000) descricao
        +VARCHAR(255) foto
        +VARCHAR(100) marca
        +VARCHAR(100) nome_jogo
        +INT numero_jogadores
        +DECIMAL(38,2) preco
        +BIGINT categoria_id
        +getId() BIGINT
        +setId(BIGINT) void
        +getAvaliacao() Double
        +setAvaliacao(Double) void
        +getDescricao() String
        +setDescricao(String) void
        +getFoto() String
        +setFoto(String) void
        +getMarca() String
        +setMarca(String) void
        +getNomeJogo() String
        +setNomeJogo(String) void
        +getNumeroJogadores() Integer
        +setNumeroJogadores(Integer) void
        +getPreco() BigDecimal
        +setPreco(BigDecimal) void
        +getCategoriaId() BIGINT
        +setCategoriaId(BIGINT) void
    }

    tb_categorias "1" --> "N" tb_produtos : contém
```
<br />
------

## 4. Diagrama Entidade-Relacionamento (DER)

O DER (Diagrama Entidade-Relacionamento) do projeto Loja Games representa de forma visual como os dados estão organizados no banco de dados relacional e como as entidades se relacionam entre si.

<div align="center">
    <img src="https://ik.imagekit.io/milenasoliv10/der.png?updatedAt=1760737795627" title="source: imgur.com" />
</div>

------

## 5. Tecnologias utilizadas

| Item                          | Descrição       |
| ----------------------------- | ----------------|
| **Servidor**                  | Apache Tomcat   |
| **Linguagem de programação**  | Java            |
| **Framework**                 | SpringBoot      |
| **ORM**                       | JPA + Hibernate |
| **Banco de dados Relacional** | MySQL           |

------

## 6. Requisitos
 
<br />
 
Para executar os códigos localmente, você precisará:
 
- [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Banco de dados [MySQL](https://dev.mysql.com/downloads/)
- [STS](https://spring.io/tools)
- [Insomnia](https://insomnia.rest/download) ou [Postman](https://www.postman.com/)
 
<br />
 
## 7. Como Executar o projeto no STS
 
<br />
 
### 7.1. Importando o Projeto
 
1. Clone o repositório do Projeto [Loja de Games](https://github.com/misoliv/loja_games) dentro da pasta do *Workspace* do STS
 
```bash
git clone https://github.com/misoliv/loja_games
```
 
2. **Abra o STS** e selecione a pasta do *Workspace* onde você clonou o repositório do projeto
3. No menu superior do STS, clique na opção: **File 🡲 Import...**
4. Na janela **Import**, selecione a opção: **General 🡲 Existing Projects into Workspace** e clique no botão **Next**
5. Na janela **Import Projects**, no item **Select root directory**, clique no botão **Browse...** e selecione a pasta do Workspace onde você clonou o repositório do projeto
6. O STS reconhecerá o projeto automaticamente
7. Marque o Projeto Loja Games no item **Projects** e clique no botão **Finish** para concluir a importação
 
<br />
 
### 7.2. Executando o projeto
 
1. Na Guia **Boot Dashboard**, localize o  **Projeto Loja Games**
2. Selecione o **Projeto Loja Games**
3. Clique no botão **Start or Restart** <img src="https://i.imgur.com/wdoZqWP.png" title="source: imgur.com" width="4%"/> para iniciar a aplicação
4. Caso seja perguntado se você deseja autorizar o acesso ao projeto via rede, clique no botão **Permitir Acesso**
5. Acompanhe a inicialização do projeto no console do STS
6. Verifique se o banco de dados `db_lojagames` foi criado corretamente e se as tabelas foram geradas automaticamente.
7. Utilize o [Insomnia](https://insomnia.rest/) para testar os endpoints.
 
<br />
 
> [!TIP]
>
> Ao acessar a URL `http://localhost:8080` em seu navegador, a interface do Swagger será carregada automaticamente, permitindo a visualização e a interação com os endpoints da API, bem como a consulta dos modelos de dados utilizados.
 
<br />

## 8. Contribuição
 
<br />
 
Este repositório é parte de um projeto educacional, mas contribuições são sempre bem-vindas! Caso tenha sugestões, correções ou melhorias, fique à vontade para:
 
- Criar uma **issue**
- Enviar um **pull request**
- Compartilhar com colegas que estejam aprendendo Java!
 
<br />
 
##  9. Contato
 
<br />
 
Desenvolvido por [**Milena**](https://github.com/misoliv)
Para dúvidas, sugestões ou colaborações, entre em contato via GitHub ou abra uma issue!
