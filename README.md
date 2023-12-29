# ghactions-java-gradle-webappforcontainers
Template Java Gradle para GitHub Actions, com as configurações de:

- Build
- Testes com Coverage
- Análise de SonarQube
- Docker (build, trivy scan, push) - _ghcr.io, dockerhub, azurecr.io_
- Terraform (Azure Web App for Containers)

A ideia deste template é tornar uma aplicação Java Gradle (Spring Boot) plug-and-play com a pipeline descrita anteriormente.

# Sobre

![template-hld](./screenshots/template-hld.png)


# Status Badges

[![Build](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/build.yml/badge.svg)](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/build.yml)

[![Build and Tests](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/build-and-tests.yml/badge.svg)](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/build-and-tests.yml)

[![SonarQube](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/sonarqube.yml/badge.svg)](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/sonarqube.yml)

[![Docker](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/docker.yml/badge.svg)](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/docker.yml)

[![Create Azure App Service (Web App for Containers)](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/az-webappforcontainers-create.yml/badge.svg)](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/az-webappforcontainers-create.yml)

[![Destroy Azure App Service (Web App for Containers)](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/az-webappforcontainers-destroy.yml/badge.svg)](https://github.com/rapharw/ghactions-java-gradle-webappforcontainers/actions/workflows/az-webappforcontainers-destroy.yml)

# Tecnologias

- Java 11
- Gradle
- Spring Boot
- GitHub Actions
- SonarQube (9.9-community)
- Docker
- Aqua Trivy
- Terraform
- Azure (Web App for Containers)

# GitHub Actions 

## Secrets e Variables

Criar as seguintes Secrets e Variables no GitHub:

![secrets.png](screenshots/secrets.png)

![variables.png](screenshots/variables.png)

**OBS**: Desta forma, a solução estará apta a executar todo fluxo de pipeline proposto.

## Workflows

**OBS**: Para criar um novo workflow, basta criar um arquivo `.yml` na pasta `.github/workflows/` do seu repositório, e configurá-lo apropriadamente.

A seguir encontram-se os workflows existentes.

### Build

Arquivo `build.yml`

### Build e Testes com Coverage

Arquivo `build-and-tests.yml`

**Pré-requisitos**:

- JaCoCo Report Tests configurado (ver `build.gradle`)

### Build, Testes com Coverage e SonarQube

Arquivo `sonarqube.yml`

**Pré-requisitos**:

- JaCoCo Report Tests configurado (ver `build.gradle`)
- Secrets configuradas (`SONARQUBE_API_TOKEN`, `SONARQUBE_HOST`)
- Arquivo `sonar-project.properties` configurado

### Build e Docker (Login, Build, Scan - _Aqua Trivy_, e Push)

Este exemplo utiliza `CONTAINER REGISTRY` dos providers abaixo, para armazenamento das imagens de container:

- GitHub (`ghcr.io`)
   ![container-registry-github.png](./screenshots/container-registry-github.png)
- DockerHub (`docker.io`)
   ![container-registry-dockerhub.png](./screenshots/container-registry-dockerhub.png)
- Azure (`azurecr.io`)
   ![container-registry-acr.png](./screenshots/container-registry-acr.png)

#### Habilitar Workflow Permissions

![docker-workflow-permissions.png](./screenshots/docker-workflow-permissions.png)

### Terraform (Criar e Destruir Azure Web App for Containers)

Para executar o workflow de criação IaC, informar os seguintes inputs:

![workflow-tf-azure.png](./screenshots/workflow-tf-azure.png)


## Status Badge (workflows)

Para criar um status badge, siga os passos abaixo, e inclua o código gerado no seu `README.md`

1. Crie uma status badge

    ![status-badge-example-001](./screenshots/status-badge-example-001.png)

2. Copie o código gerado

    ![status-badge-example-002](./screenshots/status-badge-example-002.png)

3. Cole o código no seu `README.md`

    ![status-badge-example-003](./screenshots/status-badge-example-003.png)
