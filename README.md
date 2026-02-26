🌍 EcoTrack API: Monitor de Pegada de Carbono

O EcoTrack é uma API REST moderna desenvolvida para ajudar usuários a monitorar seu impacto ambiental diário. Através do registro de atividades de consumo (como transporte e alimentação), a aplicação calcula automaticamente a emissão de CO₂ equivalente, permitindo uma visão clara da pegada de carbono individual.
🚀 Tecnologias Utilizadas

    Java 21: Utilizando os recursos mais recentes como Records para DTOs.

    Spring Boot 3.4: Base da aplicação para injeção de dependência e gerenciamento de contexto.

    Spring Data JPA: Abstração da camada de persistência.

    MySQL 8.0: Banco de dados relacional para armazenamento seguro.

    Docker & Docker Compose: Containerização de toda a infraestrutura, facilitando o ambiente de desenvolvimento.

    Lombok: Para redução de código boilerplate e aumento da produtividade.

🛠️ Funcionalidades Principais

    Gestão de Atividades: Cadastro de tipos de consumo (ex: Gasolina, Carne Bovina, Energia Elétrica) com seus respectivos fatores de emissão.

    Gestão de Usuários: Cadastro de perfis para acompanhamento individualizado.

    Cálculo Automatizado de Emissões: Ao registrar um consumo, o sistema executa a lógica de negócio no Service, multiplicando a quantidade consumida pelo fator de emissão da atividade, gravando o resultado final em tempo real.

    Histórico de Logs: Consulta de todos os consumos registrados com data e impacto ambiental gerado.

🏗️ Arquitetura do Projeto

O projeto segue as melhores práticas de desenvolvimento, com separação clara de responsabilidades:

    Controllers: Porta de entrada da API, gerenciando os endpoints e as respostas HTTP.

    Services: Camada onde reside a inteligência do negócio (cálculos matemáticos e validações).

    Repositories: Interface de comunicação direta com o banco de dados via JPA.

    Entities/Records: Representação do modelo de dados e objetos de transferência (DTOs).
