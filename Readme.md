### Моделер
Используется этот: https://camunda.com/download/modeler/
Но в нем надо в получившейся xml менять comunda:expression на activity:expression

например так: xmlns:camunda="http://activiti.org/bpmn"
```aidl
<bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL"
                  xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI"
                  xmlns:dc="http://www.omg.org/spec/DD/20100524/DC"
                  xmlns:camunda="http://activiti.org/bpmn" 
                  xmlns:di="http://www.omg.org/spec/DD/20100524/DI" 
                  xmlns:modeler="http://camunda.org/schema/modeler/1.0" 
                  id="Definitions_0lhksge" 
                  targetNamespace="http://bpmn.io/schema/bpmn" 
                  exporter="Camunda Modeler" 
                  exporterVersion="4.12.0" 
                  modeler:executionPlatform="Camunda Platform" 
                  modeler:executionPlatformVersion="7.15.0">
<bpmn:serviceTask id="NotificateBySms" camunda:expression="${orderService.notificateSms()}">
```

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

