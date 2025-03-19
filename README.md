
# 📚 Kütüphane Yönetim Sistemi

Bu proje, bir kütüphanedeki **kitapların, yazarların ve kullanıcıların** yönetilmesini sağlayan bir sistemdir.  
Kullanıcılar kitapları ödünç alabilir, belirlenen süre içinde iade edebilir ve gecikmelerde ceza uygulanır.

---

## 🚀 Özellikler  
✔ **Kullanıcı Yönetimi** → Kullanıcılar sisteme kayıt olabilir.  
✔ **Yazar Yönetimi** → Yazarlar sisteme eklenebilir.  
✔ **Kitap Yönetimi** → Kitaplar kaydedilebilir.  
✔ **Ödünç Alma & Geri Getirme** → Kullanıcılar kitapları ödünç alabilir.  
✔ **Ceza Sistemi** → Geç iade edilen kitaplar için ceza uygulanır.  

---

## 🛠 Kullanılan Teknolojiler  
- **Backend:** Java, Spring Boot  
- **Veritabanı:** MySQL  
- **ORM:** Hibernate (JPA)  
- **Bağımlılık Yönetimi:** Maven  

---

## 📌 API Endpointleri  

### ✍️ Yazar İşlemleri  
| Metot  | URL                              | Açıklama              |
|--------|----------------------------------|----------------------|
| `POST` | `/api/library/createAuthor`     | Yeni yazar ekler    |
| `DELETE` | `/api/library/deleteAuthor/{id}` | Yazarı siler        |
| `PUT`  | `/api/library/updateAuthor/{id}`  | Yazarı günceller    |
| `GET`  | `/api/library/getAuthorById/{id}` | Yazarı getirir      |
| `GET`  | `/api/library/getAuthorsList`    | Tüm yazarları getirir |

### 📖 Kitap İşlemleri  
| Metot  | URL                          | Açıklama              |
|--------|------------------------------|----------------------|
| `POST` | `/api/library/createBook`    | Yeni kitap ekler    |
| `DELETE` | `/api/library/deleteBook/{id}` | Kitabı siler        |
| `PUT`  | `/api/library/updateBook/{id}`  | Kitabı günceller    |
| `GET`  | `/api/library/getBookById/{id}` | Kitabı getirir      |
| `GET`  | `/api/library/getBookList`    | Tüm kitapları getirir |

### 📂 Kategori İşlemleri  
| Metot  | URL                                | Açıklama              |
|--------|------------------------------------|----------------------|
| `POST` | `/api/library/createCategory`     | Yeni kategori ekler    |
| `DELETE` | `/api/library/deleteCategoryById/{id}` | Kategoriyi siler        |
| `PUT`  | `/api/library/updateCategoryById/{id}`  | Kategoriyi günceller    |
| `GET`  | `/api/library/getCategoryById/{id}` | Kategoriyi getirir      |
| `GET`  | `/api/library/getCategoryList`    | Tüm kategorileri getirir |

### 👤 Kullanıcı İşlemleri  
| Metot  | URL                          | Açıklama              |
|--------|------------------------------|----------------------|
| `POST` | `/api/library/createUser`    | Yeni kullanıcı ekler  |
| `DELETE` | `/api/library/deleteUser/{id}` | Kullanıcıyı siler        |
| `PUT`  | `/api/library/updateUser/{id}`  | Kullanıcıyı günceller    |
| `GET`  | `/api/library/getUserById/{id}` | Kullanıcı bilgilerini getirir |
| `GET`  | `/api/library/getUserList`    | Tüm kullanıcıları listeler |

### 📦 Ödünç Alma İşlemleri  
| Metot  | URL                            | Açıklama                       |
|--------|--------------------------------|--------------------------------|
| `POST` | `/api/library/createBorrowBook` | Kitabı ödünç alır              |
| `GET`  | `/api/library/getBorrowBookList` | Tüm ödünç alınan kitapları listeler |
| `GET`  | `/api/library/getBorrowBookById/{id}` | Ödünç alınan belirli bir kitabı getirir |

### 🔄 İade İşlemleri  
| Metot  | URL                            | Açıklama                     |
|--------|--------------------------------|------------------------------|
| `POST` | `/api/library/createReturnBook?returnDate={date}` | Kitabı iade eder  |
| `GET`  | `/api/library/getReturnBookList` | Tüm iade edilen kitapları listeler |
| `GET`  | `/api/library/getReturnBookById/{id}` | İade edilen belirli bir kitabı getirir |
| `PUT`  | `/api/library/payFine/{id}` | Gecikme cezasını öder |

---

## 📞 İletişim  
📧 **E-posta:** [ornek@example.com](mailto:ornek@example.com)  
🐙 **GitHub:** [@ornekKullanici](https://github.com/ornekKullanici)  

---




