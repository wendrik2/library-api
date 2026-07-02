# Library API

REST API pro správu knihovny postavené na Spring Boot. Umožňuje evidenci knih (CRUD), validaci vstupních dat a jednotné zpracování chyb přes globální exception handler.

## Tech stack

- Java 17, Spring Boot 3.5
- Spring Data JPA / Hibernate
- PostgreSQL
- Bean Validation (Jakarta)
- Lombok
- Maven

## Endpoints

| Metoda | URL | Popis |
|---|---|---|
| GET | `/api/books` | Seznam všech knih |
| GET | `/api/books/{id}` | Detail knihy podle ID |
| POST | `/api/books` | Vytvoření nové knihy |
| PUT | `/api/books/{id}` | Aktualizace knihy |
| DELETE | `/api/books/{id}` | Smazání knihy |

### Ukázka požadavku

```
POST /api/books
Content-Type: application/json

{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "publishedYear": 2018
}
```

## Spuštění lokálně

1. Vytvořte PostgreSQL databázi a nastavte přístupové údaje v `src/main/resources/application.properties`
2. Spusťte aplikaci:
   ```
   ./mvnw spring-boot:run
   ```
3. API bude dostupné na `http://localhost:8080/api/books`

## Ošetření chyb

- `404 Not Found` — kniha s daným ID neexistuje (`BookNotFoundException`)
- `400 Bad Request` — chyba validace vstupních dat, s podrobným popisem podle pole

## Plánovaná rozšíření

- [ ] Samostatná entita `Author` s vazbou na `Book` (aktuálně je autor jen textové pole)
- [ ] Unit a integrační testy (JUnit 5, Mockito, Testcontainers)
- [ ] DTO vrstva místo přímého vracení JPA entit v API
- [ ] Zabezpečení pomocí Spring Security + JWT
- [ ] Stránkování a filtrování výsledků (`Pageable`)
