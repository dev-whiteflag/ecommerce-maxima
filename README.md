
# Maxima E-commerce

> PoC (Prova de Conceito) de um e-commerce, basicamente o sistema consiste na criação de Pedidos (cliente + produtos + frete).

## Introdução

993044260

### Autenticação

A autenticação foi "mocada" em ambas as partes do sistema, as unicas que permaneceram foram entre os serviços de backend. Por exemplo, comunicação entre o `config` e o `discovery`. 

## Frontend

As credenciais para acessar o frontend é `user` e `user`.

## Backend

O Backend consiste de vários modulos, eles são: ``config, discovery, gateway, api, tax``. Os serviços utilizando Spring Boot ``2.3.4.RELEASE`` e Spring Cloud ``Hoxton.SR8``, rodando em OpenJDK 14 com source escrita em Java 11.

### Instruções

Cada um dos módulos do backend devem ser construidos individualmente utilizando `mvnw clean package -DskipTests`, após isso, é só executar o `docker-compose` através das instruções na introdução. É preciso skipar `context-load` testes em alguns modulos pois necessitam do `config` e o `discovery` estar sendo executado.

// TODO: colocar `spring.cloud.config.fail-fast=false` para os testes ignorarem a falta do `config`.

### ``config``

É um modulo que utiliza Spring para criar um Configuration Server, onde outros serviços irão retirar informações de configuração.

- Todos os serviços tem Spring Retry configurado ao comunicar com esse serviço, para que possamos usar-lo em uma network de docker. Em produção, _provavelmente_ não será necessário.
- "Repo" é uma pasta que simula um reposiório em nuvem que o ``config`` usa para procurar pelas informações.
- No Dockerfile, é criado um repositório local para simular o citado acima.

### Load Balancer

Sobre um Load Balancer, a combinação do ``discovery`` (utilizando Eureka) com ``gateway`` (utilizando Zuul) agem como um load balancer, o ``discovery`` registra as novas instancias do serviço e o ``gateway`` redireciona para as instancias de acordco com o Zuul.

## Metadata

Brenno Fagundes - dev.whiteflag@gmail.com

Distributed under the MIT license. See ``LICENSE`` for more information.

[github.com/dev-whiteflag/ecommerce-maxima](https://github.com/dev-whiteflag/ecommerce-maxima)

## Contributing

1. Fork it (<https://github.com/dev-whiteflag/ecommerce-maxima/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request
