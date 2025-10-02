Aplicação Java Spring Boot para gerenciamento e consulta de APIs.  
Este projeto pode ser executado via **Maven**, **Docker Hub** ou **Docker Compose**.

---

## 🔧 Requisitos

- **Java 17+**
- **Maven 3.9+**
- **Docker** instalado e rodando
- (Opcional) **Docker Compose** instalado

---

## 🚀 1. Executando com Maven

### Rodando a aplicação diretamente:
```bash
mvn spring-boot:run
Gerando o JAR (sem rodar os testes):
bash
Copiar código
mvn clean package -DskipTests
O JAR será gerado em:

bash
Copiar código
target/app.jar
Rodando a aplicação manualmente:

bash
Copiar código
java -jar target/app.jar
🚀 2. Executando via Docker Hub
A imagem já está publicada no Docker Hub:
👉 rafaooo/checkac

Comando para rodar:
bash
Copiar código
docker run -p 8080:8080 rafaooo/checkac
-p 8080:8080 → expõe a porta 8080 da aplicação localmente

rafaooo/checkac → nome da imagem publicada no Docker Hub

📦 3. Executando com Docker Compose
Crie um arquivo docker-compose.yml com o seguinte conteúdo:

yaml
Copiar código
version: '3.8'

services:
  app:
    image: rafaooo/checkac
    ports:
      - "8080:8080"
Para subir a aplicação:
bash
Copiar código
docker-compose up
Isso irá baixar a imagem do Docker Hub (se ainda não tiver) e iniciar a aplicação.

📚 4. Acessando o Swagger
Após iniciar a aplicação (via Maven, Docker ou Docker Compose), acesse no navegador:

👉 http://localhost:8080/swagger-ui/index.html

(alternativamente, pode estar disponível em http://localhost:8080/swagger-ui.html, dependendo da configuração)

🧪 5. Testando a API
Você pode usar:

Swagger UI (navegador)

Postman

cURL

Exemplo completo:

bash
Copiar código
docker run -p 8080:8080 rafaooo/checkac
Depois acesse:

bash
Copiar código
http://localhost:8080/swagger-ui/index.html
📤 6. Publicando a imagem no Docker Hub
O projeto está configurado para usar o Jib (plugin Maven oficial do Google).
Isso permite gerar e publicar imagens Docker sem precisar de Dockerfile.

Gerando a imagem localmente:
bash
Copiar código
mvn compile jib:dockerBuild -Dimage=rafaooo/checkac
Publicando a imagem no Docker Hub:
bash
Copiar código
mvn compile jib:build -Dimage=rafaooo/checkac
(necessário estar logado no Docker Hub via docker login)
