��#   S p r i n t _ 4 
 Структура проекта
1. Пакет pageobject
      Назначение: Содержит классы с селекторами и методами для взаимодействия с объектами страниц.
      Особенности: Каждый класс в пакете представляет определенную страницу и предоставляет методы для взаимодействия с элементами интерфейса, что позволяет облегчить реализацию и поддержку тестов.
2. Класс BaseUiTest
      Описание: Родительский класс для всех UI тестов.
      Функции:
            Содержит шаги before и after для подготовки и завершения каждого тест-кейса.
           Включает общие методы, используемые во всех UI тестах, что обеспечивает единый стандарт подготовки тестов и очистки после их завершения.
3. Класс CreateOrderTestData
      Наследование: Наследуется от BaseUiTest.
      Методы:
            createOrderWithAllAttributes — создает заказ через верхнюю или нижнюю кнопку на странице, основываясь на заданных атрибутах.
            Возвращаемое значение: Метод возвращает Id заказа, который отображается пользователю после создания.
      Назначение:
            Класс служит основой для создания заказа с полным набором атрибутов.
            Используется как родитель для тест-классов CreateOrderE2ETest и OrderAttributeValidationTest, что позволяет легко применять параметризацию для расширения покрытия тестов.
4. Класс CreateOrderE2ETest
      Наследование: Наследуется от CreateOrderTestData.
      Описание: Содержит параметризованные тесты для создания заказа через верхнюю или нижнюю кнопку.
      Тесты:
            createOrderTopOrderButtonWithAllAttrTest
            createOrderBottomOrderButtonWithAllAttrTest
      Проверки: Валидирует, что после создания пользователь попадает на страницу с отображением Id заказа, подтверждая успешное создание заказа.
5. Класс OrderAttributeValidationTest
      Наследование: Наследуется от CreateOrderTestData.
      Назначение: Содержит тесты для проверки корректного отображения атрибутов заказа.
      Описание: Этот класс добавлен для валидации атрибутов заказа, несмотря на то, что такие тесты не требовались в проектной документации. Валидации гарантируют, что данные, введенные пользователем, корректно                 отображаются в заказе.
      Особенности: Класс может быть также параметризован для повышения гибкости.
6. Класс CheckStatusOrderTest
      Наследование: Наследуется от BaseUiTest.
      Назначение: Проверяет обработку ошибок, если пользователь вводит неверный номер заказа.
      Будущее развитие: Может быть расширен тестами для проверки других статусов заказа (например, "Курьер едет к вам", "Курьер на месте").
7. Класс ErrorHandlingInputAttributesTest
      Наследование: Наследуется от BaseUiTest.
      Описание: Содержит тест-кейсы, связанные с обработкой ошибок при заполнении полей формы заказа.
      Назначение: Гарантирует, что система корректно реагирует на некорректные вводные данные, предотвращая возможные ошибки пользователя.
8. Класс LinksMainPageTest
      Наследование: Наследуется от BaseUiTest.
      Назначение: Проверяет работу ссылок на главной странице сервиса.
      Тесты:
            checkLinkAfterClickYandexLogoTest
            checkLinkAfterClickScooterLogoTest
      Проверки: Валидирует, что переходы по ключевым ссылкам выполняются корректно.
9. Класс CheckListImportantQuestionsTest
      Наследование: Наследуется от BaseUiTest.
      Назначение: Содержит тесты для проверки FAQ на главной странице.
      Описание: Проверяет правильность отображения и функционирования раздела важных вопросов на главной странице сервиса.


Report:
[INFO] Results:
[INFO] 
[ERROR] Failures: 
                    //Нужно создать дефект поскольку ожидалась ссылка на стартовую страницу яндекс.
[ERROR]   LinksMainPageTest.checkLinkAfterClickYandexLogoTest:60 Is not expected page expected:<https://[yandex.ru]> but was:<https://[dzen.ru/?yredirect=true]>
                    //Ряд дефектов поскольку атрибуты в созданном заказе не соответсвуют значениям которые были указаны при создании заказа.
[ERROR]   OrderAttributeValidationTest.validateAddressOrderAttrTest:53 The "Address" attribute on the order tracking page differs from the one specified when creating the order. expected:<[лзХюБФЧкаГ]д.47 кв12> but was:<[оГТШФвяЬмн]д.47 кв12>
[ERROR]   OrderAttributeValidationTest.validateFirstNameOrderAttrTest:31 The "First Name" attribute on the order tracking page differs from the one specified when creating the order. expected:<[НэЗжоЦаСйл]> but was:<[УнГХЮПЖзНЯ]>
[ERROR]   OrderAttributeValidationTest.validateLastNameOrderAttrTest:42 The "Last Name" attribute on the order tracking page differs from the one specified when creating the order. expected:<[НлЗЧФРРЭУЛ]> but was:<[ничШмлэРеГ]>
[ERROR]   OrderAttributeValidationTest.validateMetroStationOrderAttrTest:64 The "Metro Station" attribute on the order tracking page differs from the one specified when creating the order. expected:<[Павелец]кая> but was:<[Автозаводс]кая>
[ERROR]   OrderAttributeValidationTest.validateRentalPeriodOrderAttrTest:75 The "Rental Period" attribute on the order tracking page differs from the one specified when creating the order. expected:<[сутки]> but was:<[пятеро суток]>
[ERROR]   OrderAttributeValidationTest.validateTelephoneNumberOrderAttrTest:86 The "Rental Period" attribute on the order tracking page differs from the one specified when creating the order. expected:<+79[05178698]1> but was:<+79[96074364]1>
[ERROR] Errors:
                  //Дефект на орфографическую ошибку "Я жизу за МКАДом" 
[ERROR]   СheckListImportantQuestionsTest.СheckListImportantQuestionsTest:56 » NoSuchElement Unable to locate element: .//div[contains(@id,'accordion__heading') and contains(text(),'Я живу за МКАДом, привезёте?')]
For documentation on this error, please visit: https://www.selenium.dev/documentation/webdriver/troubleshooting/errors#no-such-element-exception
Build info: version: '4.25.0', revision: '8a8aea2337'
System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '11.0.24'
Driver info: org.openqa.selenium.firefox.FirefoxDriver
Command: [62cde7da-56fb-4a74-8355-b40f738d6c13, findElement {using=xpath, value=.//div[contains(@id,'accordion__heading') and contains(text(),'Я живу за МКАДом, привезёте?')]}]
Capabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 131.0.3, moz:accessibilityChecks: false, moz:buildID: 20241011205646, moz:debuggerAddress: 127.0.0.1:21685, moz:geckodriverVersion: 0.35.0, moz:headless: false, moz:platformVersion: 10.0, moz:processID: 13820, moz:profile: C:\Users\E151~1\AppData\Loc..., moz:shutdownTimeout: 60000, moz:webdriverClick: true, moz:windowless: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://127.0.0.1:21685/devtoo..., se:cdpVersion: 85.0, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, userAgent: Mozilla/5.0 (Windows NT 10....}
Session ID: 62cde7da-56fb-4a74-8355-b40f738d6c13
[INFO] 
[ERROR] Tests run: 29, Failures: 7, Errors: 1, Skipped: 0
[INFO] 
 
