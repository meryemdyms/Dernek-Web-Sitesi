# Dernek Web Sitesi REST & WebSocket API

Bu proje, bir dernek için temel **REST API** ve **WebSocket** altyapısını sunar.  
Kullanıcı/​Admin ayrımıyla yetkilendirme, JWT tabanlı kimlik doğrulama, duyuru ve haber yönetimi ile gerçek zamanlı bildirimler içerir.

##  Proje Özeti
- **Kayıt & Giriş**  
  - Kullanıcı ve admin rolleriyle kayıt olma (`/api/auth/register`).  
  - JWT üreten `/api/auth/authenticate` endpoint’iyle giriş.  
  - Role göre erişim kontrolü:  
    - `ROLE_ADMIN` → Haber ve duyuru ekleme/güncelleme/silme  
    - `ROLE_USER` → Sadece listeleme ve görüntüleme
   
- **Duyuru & Haber Yönetimi**  
  - Admin’e özel CRUD endpoint’leri (`/api/admin/...`).  
  - Kullanıcıya yalnızca listeleme endpoint’leri (`/api/user/...`).
  - DTO’lar ve Mapper katmanı ile domain-kaynak ayrımı.

- **Hata Yönetimi**  
  - Tüm `BaseException` altı hatalar `GlobalExceptionHandler` ile `400 Bad Request` formatında,  
    `{ status, exception: { hostName, path, createTime, message } }` dönecek şekilde yakalanıyor.  
  - Yetkisiz erişimlerde (403) Spring Security’nin default entry point’i devrede.

- **WebSocket Entegrasyonu**  
  - `/ws-endpoint` adresinde **STOMP + SockJS** tabanlı gerçek zamanlı duyuru yayını.  
  - Admin yeni bir duyuru kaydettiğinde, bağlı tüm kullanıcılara `/topic/duyurular` üzerinden iletim.
 
---

## Nasıl Çalışır?

- **Kayıt / Giriş**  
  1. `POST /api/auth/register` → `{ username, password, role }`  
  2. `POST /api/auth/authenticate` → `{ username, password }` → `{"token": ...}`

- **Admin Operasyonları**  
  - `POST /api/admin/haber/kaydet`  
  - `PUT /api/admin/duyuru/guncelle/{id}`  
  - `DELETE /api/admin/duyuru/sil/{id}`

- **Kullanıcı Operasyonları**  
  - `GET /api/user/haber/listele`  
  - `GET /api/user/duyuru/listele`


 

