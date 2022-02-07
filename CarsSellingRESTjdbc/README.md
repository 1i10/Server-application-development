## Разработка ресурса REST/JSON сервиса   

Для работы с БД (таблица «CarsSelling»), разрабатывается REST сервис для выполнения операций: отображение таблицы, добавление новой позиции, редактирование позиции, удаление позиции.  
При разработке сервиса будут использоваться следующие технологии:  
* Spring Boot;
* Spring Data JDBC.  

Тестирование запросов REST будет осуществляться с использованием [Postman](https://www.postman.com/).  
  
Rest запрос **GET** *http://localhost:8080/ListCarsSelling* для отображения данных таблицы.    
<details><summary>Содержимое JSON</summary>
  [  
    {  
        "code": 4,  
        "manufacturer": "Mercedes",  
        "model": "Mercedes-Benz GLK",  
        "color": "Black",  
        "transmission": "Manual",  
        "body_type": "Crossover",  
        "price": 1990000.0  
    },  
    {  
        "code": 5,  
        "manufacturer": "Toyota",  
        "model": "Toyota Prius",  
        "color": "Green",  
        "transmission": "Manual",  
        "body_type": "Hatchback",  
        "price": 1885000.0  
    },  
    {  
        "code": 6,  
        "manufacturer": "Citroen",  
        "model": "Citroen C4 Aircross",  
        "color": "Red",  
        "transmission": "Automatic",  
        "body_type": "Crossover",  
        "price": 1279000.0  
    },  
    {  
        "code": 10,  
        "manufacturer": "sdfada111",  
        "model": "asdsad111",  
        "color": "adassd",  
        "transmission": "Manual",  
        "body_type": "Compact",  
        "price": 1111231.0  
    }  
]  
</details>
  
Rest запрос **POST** *http://localhost:8080/ListCarsSelling* для добавления данных в таблицу.  
<details>
    <summary>Вставляемые данные</summary>
    {
    "manufacturer": "sada111",
    "model": "1sffwf44",
    "color": "adas",
    "transmission": "Automatic",
    "body_type": "Sedan",
    "price": 2222.0
}
</details>  
  
<details>
    <summary>Таблица после добавления</summary>
    [
    {
        "code": 4,
        "manufacturer": "Mercedes",
        "model": "Mercedes-Benz GLK",
        "color": "Black",
        "transmission": "Manual",
        "body_type": "Crossover",
        "price": 1990000.0
    },
    {
        "code": 5,
        "manufacturer": "Toyota",
        "model": "Toyota Prius",
        "color": "Green",
        "transmission": "Manual",
        "body_type": "Hatchback",
        "price": 1885000.0
    },
    {
        "code": 6,
        "manufacturer": "Citroen",
        "model": "Citroen C4 Aircross",
        "color": "Red",
        "transmission": "Automatic",
        "body_type": "Crossover",
        "price": 1279000.0
    },
    {
        "code": 10,
        "manufacturer": "sada111",
        "model": "asdsad",
        "color": "adas",
        "transmission": "Manual",
        "body_type": "Compact",
        "price": 111111.0
    },
    {
        "code": 12,
        "manufacturer": "sada111",
        "model": "1sffwf44",
        "color": "adas",
        "transmission": "Automatic",
        "body_type": "Sedan",
        "price": 2222.0
    }
]
</details>  
  
Rest запрос **PUT** *http://localhost:8080/ListCarsSelling/{code}* для редактирования данных в таблице.  
<details>
    <summary>Обновление содержимого с кодом 10 на:</summary>
    {
        "code": 10,
        "manufacturer": "sdfada111",
        "model": "asdsad111",
        "color": "adassd",
        "transmission": "Manual",
        "body_type": "Compact",
        "price": 1111231.0
    }
</details>  

Rest запрос **DELETE** *http://localhost:8080/ListCarsSelling/{code}* для удаления данных в таблице.  
<details>
    <summary>Содержимое JSON после удаления позиции с кодом 12</summary>
    [
    {
        "code": 4,
        "manufacturer": "Mercedes",
        "model": "Mercedes-Benz GLK",
        "color": "Black",
        "transmission": "Manual",
        "body_type": "Crossover",
        "price": 1990000.0
    },
    {
        "code": 5,
        "manufacturer": "Toyota",
        "model": "Toyota Prius",
        "color": "Green",
        "transmission": "Manual",
        "body_type": "Hatchback",
        "price": 1885000.0
    },
    {
        "code": 6,
        "manufacturer": "Citroen",
        "model": "Citroen C4 Aircross",
        "color": "Red",
        "transmission": "Automatic",
        "body_type": "Crossover",
        "price": 1279000.0
    },
    {
        "code": 10,
        "manufacturer": "sdfada111",
        "model": "asdsad111",
        "color": "adassd",
        "transmission": "Manual",
        "body_type": "Compact",
        "price": 1111231.0
    }
]
</details>




