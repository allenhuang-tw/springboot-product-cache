# 📦 Product 商品查詢系統（Spring Boot + Redis + PostgreSQL）

本專案是一個簡單的商品查詢系統，採用 Spring Boot 架構，整合 Redis 快取與 PostgreSQL 資料庫，並透過 Docker Compose 一鍵啟動。

---

## 🚀 專案特色

- ✅ RESTful 商品查詢 API（支援 ID 查詢）
- ✅ 整合 Redis 快取（@Cacheable）
- ✅ 使用 PostgreSQL 儲存商品資料
- ✅ 初始資料自動建立（搭配 `data.sql`）
- ✅ 全容器化部署，一鍵啟動！

---

## 🧱 技術架構

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Redis + Spring Cache
- PostgreSQL 15
- Docker / Docker Compose

---

## ⚙️ 環境建置步驟

### 1️⃣ Maven 打包 Spring Boot 專案

```bash
./mvnw clean package -DskipTests
```

這會產出 `target/product.jar`

---

### 2️⃣ 啟動 Docker Compose

```bash
docker-compose up --build
```

啟動後會包含：
- app: Spring Boot 應用
- db: PostgreSQL
- redis: Redis 快取服務

---

### 3️⃣ 測試商品查詢 API

```bash
GET http://localhost:8080/products/1
```

回傳：

```json
{
  "id": 1,
  "name": "Apple iPhone 15",
  "price": 35000
}
```

---

## 🧪 Redis 快取測試

- 第一次查詢時，會從資料庫撈資料並寫入 Redis。
- 之後相同查詢會直接命中快取，提升效能。
- 可查看 log 印出是否有「查資料庫中...」訊息作為辨識。


