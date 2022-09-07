# Poc sobre resiliência na comunicação entre microserviços com a biblioteca Resilience4J

Esse projeto tem como propósito testar as principais features da biblioteca Resilience4J para projetos Java. O projeto foi criado com Java 18 e spring boot 2.7.3, com Maven como gerenciador de dependências.

## Instalação e execução desse projeto

### Pré requisitos

- Para rodar este projeto você precisa:
  - Java 1
  - Maven 
  - Go


- Opcionalmente:
  - Docker (Para subir o Prometheus e Grafana para exibir dashboards de métricas)


### Execução
1. Execute a aplicação java através da sua ide, ou do comando `mvn spring-boot:run`
2. Execute a aplicação que está na pasta `golang` que está na raiz do projeto através do comando:
`go run .\golang\server.go`  esse comando subirá um servidor REST na porta 8001 que receberá as requisições de SKU e Shipping usadas pela aplicação Java. Podemos derrubar essa aplicação vez em quando para testar a resiliência de circuit breaker;

**Endpoints da aplicação:**
- http://localhost:8080/sku -> Endpoint que tem um circuit breaker com threshold de 50%.
- http://localhost:8080/shipping -> Endpoint com retry com exponential backoff de * 2.
- http://localhost:8080/discount -> Endpoint com rate limiter de 3 requisições a cada 8 segundos.


**Opcionalmente**: Caso queira configurar o prometheus e o grafana para visualizar as informações do que está acontecendo no nosso servidor:

Execute o comando `docker-compose up` na pasta raiz do projeto
Para mais informações de configuração dessas ferramentas siga o passo a passo abaixo:

https://medium.com/@valdenirsantana/obervabilidade-no-spring-boot-utilizando-o-actuator-prometheus-e-grafana-156eca15cf80


**Documentação oficial da biblioteca**: https://resilience4j.readme.io/docs/getting-started
