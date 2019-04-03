# RESTAPI
Pastas

-APIDoc

Dentro da pasta APIDoc está oo openapi.json, com toda a definição da API. Também está contido um arquivo html que descreve a api
legivelmente via navegador. Com todos os métodos e parâmetros necessários para fornecer os métodos.

-DB

Dentro da pasta DB está contido o arquivo SQL com a descrição do banco de dados. Eu inseri esse arquivo, pois eu modelei assim o banco. No entanto como eu usei o Hibernate com anotações no projeto, só é necessária a existencia de um DB chamado fishstoreproducts. Isso pois o hibernate apaga a tabela previamente existente no banco de dados, assim também é necessária a inserção de produtos conforme a API for executada.

-RESTAPI

Dentro da pasta RESTAPI está o Snapshot JAR que pode ser executado diretamente. Ele irá rodar a API sem necessidade de nova compilação 
ou execução de um mvn clean install. 
Juntamente está o projeto Java utilizado no Eclipse para criar a API, com a organização do projeto e todos os arquivos fonte de interesse
para análise.





