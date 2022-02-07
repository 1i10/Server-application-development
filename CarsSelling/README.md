## Разработка простого серверного приложения j2ee с использованием сервлетов  
  
В приложении предполагается выполнение следующих операций:  
* Отображение таблицы «CarsSelling»;
* Добавление новой позиции;
* Редактирование позиции;
* Удаление позиции.  
  

Для обработки требуемых запросов и для возвращения их результата были реализованы следующие сервлеты:  
* [ListCarsSelling.java](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/java/servlet/ListCarsSelling.java) (обрабатывает запрос на получение информации из таблицы БД и передает их странице [ListCarsSelling.jsp](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/webapp/ListCarsSelling.jsp));
* [InsertServlet.java](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/java/servlet/InsertServlet.java) (При запросе get выдает пользователю форму [insert.jsp](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/webapp/insert.jsp) для заполнения новой позиции. А при запросе post выполняется добавление этих данных в БД и перенаправление на главную страницу [ListCarsSelling.jsp](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/webapp/ListCarsSelling.jsp));
* [UpdateServlet.java](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/java/servlet/UpdateServlet.java) (В методе get получает параметр «code» и по нему ищется соответствующая позиция в БД. Если такая найдена, то осуществляется переход на форму для заполнения [update.jsp](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/webapp/update.jsp), в ином случае – на [notFound.jsp](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/webapp/notFound.jsp). При запросе post происходит добавление обновленных данных в БД);
* [DeleteServlet.java](https://github.com/1i10/Server-application-development/blob/master/CarsSelling/src/main/java/servlet/DeleteServlet.java) (Выполняется запрос post, при котором сервлет получает «code» строки и после удаляет ее в БД).  
  

##### Примеры  
  
*Главная страница веб-приложения*    
<img src="https://github.com/1i10/Server-application-development/blob/master/Examples/CarsSelling1.png" width="600" height="300" />  
  
*Заполнение формы для вставки новой позиции*  
<img src="https://github.com/1i10/Server-application-development/blob/master/Examples/CarsSelling2.png" width="600" height="300" />  
  
*Форма для редактирования позиции таблицы*  
<img src="https://github.com/1i10/Server-application-development/blob/master/Examples/CarsSelling3.png" width="600" height="300" />   
  
Если при обновлении передать несуществующую позицию, то будет отображена информация, о том, что такой позиции не существует. С данной страницы можно будет перейти на главную.  
<img src="https://github.com/1i10/Server-application-development/blob/master/Examples/CarsSelling4.png" width="600" height="300" />


