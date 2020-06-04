aplikację na porcie 8000 można urochomić poleceniem docker-compose up

dostęp do api jest zabezpieczony za pomocą API_KEY : abc123

1. Swagger
http://localhost:8000/swagger-ui.html

(przykładowe zapytania)
- aktualne kursy dla listy walut:
metoda GET na url
http://localhost:8000/api/currencies

- dotępne waluty na których można wykonać przeliczenie
metoda GET na url
http://localhost:8000/api/currencies/codes

- przeliczenie na podstawie kursu wymiany dla następujących parametrów: kwota, z jakiej waluty, do jakiej waluty
metoda POST na url
http://localhost:8000/api/currencies/convert
{
  "amount": 10,
  "from": "EUR",
  "to": "PLN"
}

2. Aplikacja zintegorwana z bazą danych H2 (zapsiuje żądania do API)
http://localhost:8000/h2-console
JDBC URL : jdbc:h2:mem:history
User Name: sa
SELECT * FROM logs - zwraca wszystkie logi



