# People Registration CRUD

CRUD People registration project developed as a proof of concept.

## Preview:

|Desktop | Mobile|
|-|-|
|![ImagePreview](readme-img/desktop_image.png)|![ImagePreview](readme-img/mobile_image.png)|

Então podemos atualizar seu README para incluir uma seção **"Como Rodar o Projeto"** explicando o passo a passo de forma clara.
Como estamos falando de um CRUD JSF + PrimeFaces + JPA no WildFly com PostgreSQL, o texto ficaria mais ou menos assim:

---

## 🛠 Como Rodar o Projeto

### **Pré-requisitos**

* **Java 17+** instalado
* **Maven 3.8+** instalado 
* **PostgreSQL 14+** instalado e rodando 
* **WildFly 27+** (ou outro servidor de Aplicações compatível )

---

### **1️⃣ Configurar o Banco de Dados**

1. Crie um banco de dados no PostgreSQL:

   ```sql
   CREATE DATABASE cadastro_pessoas;
   ```

### **2️⃣ Compilar e Gerar o WAR**

No terminal, dentro da pasta do projeto:

```bash
mvn clean package
```

O arquivo `.war` será gerado em:

```
target/cadastro-pessoas.war
```

---

### **3️⃣ Configurar o DataSource no WildFly**
Obs: Considere **$WILDFLY_HOME** === Caminho para a pasta onde o WildFly foi salvo


1. Adicione um usuário (Management User):

   ```bash
   $WILDFLY_HOME/bin/add.bat
   ```

1. Inicie o WildFly:

   ```bash
   $WILDFLY_HOME/bin/standalone.bat
   ```
2. Acesse o painel de administração:

   ```
   http://localhost:9990
   ```
3. Após o Login, vá em **Configuration → Subsystems → Datasources & Drivers → Datasources → Add → Add DataSource**
4. Configure:

   * **Name**: `PostgresDS`
   * **JNDI Name**: `java:/PostgresDS`
   * **Driver**: PostgreSQL (`org.postgresql.Driver`)
   * **URL**: `jdbc:postgresql://localhost:5432/cadastro_pessoas`
   * **User**: `seu_usuário`
   * **Password**: `sua_senha`

---

### **4️⃣ Fazer o Deploy no WildFly**

1. Vá em **Deployments → Add → Upload Deployment** 
2. Faça o upload do arquivo .war gerado anteriormente

---

### **5️⃣ Acessar o Sistema**

Após o deploy, abra no navegador:

```
http://localhost:8080/cadastro-pessoas
```

---

### **⚠ Observações**

* Por ser um projeto para o desafio, ss tabelas serão recriadas automaticamente a cada inicialização, pois o `persistence.xml` está configurado com `drop-and-create`:

  ```xml
  <property name="jakarta.persistence.schema-generation.database.action" value="drop-and-create"/>
  ```

---

## Tools used:

- Java SDK 21
- Java Server Faces (JSF)
- PrimeFaces
- JPA Hibernate
- EJB
- PostgreSQL

## Future Plans:

- Unit Tests
- Table Pagination
- Filters
- Check people addresses

## Contact:
- LinkedIn: [https://www.linkedin.com/in/jonas-felix-dev/](https://www.linkedin.com/in/jonas-felix-dev/)
- Email: [jonasfelixdesouza21@gmail.com](mailto:jonasfelixdesouza21@gmail.com)
