
### CURL для создания заявки
```
curl --location --request POST 'http://localhost:8080/orders/' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "test order 3"}'
```

### CURL для получения списка заявок
```
curl --location --request GET 'http://localhost:8080/orders/' \
--header 'Content-Type: application/json' \
--data-raw ''
```

### CURL для получения списка задач, ожидающих подтверждение
```
curl --location --request GET 'http://localhost:8080/orders/awaiting' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "test order 1"}'
```

### CURL для подтверждения заявки
```
curl --location --request POST 'http://localhost:8080/orders/accept/0a95d514-a554-11ec-aa9b-0242c351126a' \
--header 'Content-Type: application/json' \
--data-raw ''
```

