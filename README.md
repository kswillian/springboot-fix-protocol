# springboot-fix-protocol
Exemplo de implementação da biblioteca QuickFIX/J para realizar troca de mensagens via protocolo FIX.

## Pré Requisitos

Para que seja possível rodar as aplicações é necessário atender alguns requisitos
- Java 11+
- Maven 3.3+

## Compilando e inicializando

Assim como todo o projeto Mave, deve ser realizada a geração do código fonte. Segue exemplo abaixo:

```bash
mvn clean install
```

Execute os dois projetos separadamente. As definições de portas já estão definidas no projeto.
- springboot-fix-protocol-producer
  - port: 8081
- springboot-fix-protocol-consumer
  - port: 8080
  
## Testes
  
A aplicação producer é basicamente o produtor de mensagens via protocolo Fix, nele foi configurado um endpoint para que seja possivel enviar uma requisição POST sem nenhum payload gerar uma mensagem para que seus consumidores possam receber e processar. Abaixo segue o endpoint do produtor de mensagens:
  
```bash
http://localhost:8081/order
```
