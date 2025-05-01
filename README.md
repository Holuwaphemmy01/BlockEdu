

---

# 📚 BlockEdu – Backend

BlockEdu is a decentralized academic credential issuance and verification platform. It enables universities to issue tamper-proof digital credentials, students to store them permanently, and employers to instantly verify them. The backend is built with Spring Boot and integrates PostgreSQL, Sui Blockchain, and Sui Walrus Storage.

---

## 🔧 Tech Stack

| Technology      | Description                                |
|----------------|--------------------------------------------|
| Spring Boot     | Java-based backend framework               |
| PostgreSQL      | Relational database for storing metadata   |
| Sui Blockchain  | Immutable ledger for credential verification |
| Walrus Storage  | Decentralized file storage system for documents |
| Maven/Gradle    | Dependency & build management              |

---

## 📂 Features

### 🎓 For Universities (Credential Issuers)
- Issue verifiable digital certificates and transcripts.
- Manage credential issuance dashboard.
- Automatically store and sign credentials on Sui Blockchain.

### 👨‍🎓 For Students (Credential Owners)
- Receive and store credentials securely.
- Access credentials anytime via dashboard.
- Share verifiable links or QR codes.

### 🏢 For Employers/Verifiers
- Verify authenticity via link or QR code.
- Eliminate credential fraud.
- Real-time, contactless verification.

---

## 🏗️ Project Structure

```
blockedu-backend/
├── src/
│   ├── main/
│   │   ├── java/com/blockedu/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── config/
│   │   │   └── BlockEduApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── static/
├── pom.xml / build.gradle
└── README.md
```

---

## 🔐 Security

- ✅ JWT Authentication for user sessions.
- ✅ Role-based access (Admin, Issuer, Student, Verifier).
- ✅ Blockchain-integrated validation for credential immutability.

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- PostgreSQL
- Sui CLI & Wallet (for blockchain operations)
- Maven or Gradle

### Clone the repository

```bash
git clone https://github.com/yourusername/blockedu-backend.git
cd blockedu-backend
```

### Configure `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/blockedu
    username: your_db_user
    password: your_db_password

sui:
  node-url: https://fullnode.mainnet.sui.io:443
  wallet-address: your_wallet_address
  private-key: your_private_key

walrus:
  base-url: https://api.walrus.storage
  api-key: your_api_key
```

### Run the application

```bash
./mvnw spring-boot:run
```


---

## 📡 API Endpoints (Sample)

| Endpoint                            | Method | Description                       |
|-------------------------------------|--------|-----------------------------------|
| `/api/credentials/issue`            | POST   | Issue a new credential            |
| `/api/credentials/student/{id}`     | GET    | Get student credentials           |
| `/api/credentials/verify/{hash}`    | GET    | Verify a credential using Sui     |
| `/api/users/register`               | POST   | User registration (student/issuer) |
| `/api/auth/login`                   | POST   | User login                        |

---

## 📦 Storage Flow

1. Credential file uploaded → Stored in **Walrus Storage**.
2. File hash & metadata → Stored in **PostgreSQL**.
3. Credential hash & signature → Written to **Sui Blockchain**.

---

## 📃 License

This project is licensed under the [MIT License](LICENSE).

---
