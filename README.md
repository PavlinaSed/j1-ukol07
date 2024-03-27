# Task 7 - Library
Implement a simple application to keep track of books. The application will list books from a JSON file and will be able to list all books by the selected author 
and all books published in the specified year.

You don't have to follow the exact order of the steps below - for example, it may be useful to write a test before or in parallel with the implementation 
of the ncode it will test.

1. The application will contain only two more classes, `Book`  and `BookService`, in addition to the `Application` class. Therefore, create both new classes directly 
in package `cz.czechitas.ukol07`.
1. The `Book` class will be a JavaBean and will represent a single book. Take a look at the JSON structure of `src/main/resources/cz/czechitas/ukol07/knihy.json` 
and follow the structure of the class (properties) with the JSON structure of the file.
2. In the `BookService` class, the field will be of type `List<Book>`. Populate the contents of this file in the class constructor. Use `ObjectMapper` to retrieve it. 
   1. To load, use an `InputStream`, which you create by calling `BookService.class.getResourceAsStream("books.json")`. This will load the books.json file, 
   which is stored in `src/main/java` in the same package as the `BookService` class. Remember that the `InputStream` must be closed when finished - use 
   the `try-with-resources` construct.
   1. To load the `List` itself, use the following construct:
       ```java
       objectMapper.readValue(inputStream, new TypeReference<List<Book>>(){})
       ```
      The code `objectMapper.readValue(inputStream, List<Book>.class)` cannot be used for historical reasons. If you need to read a collection or any other
      generic type, you need to use a construct with the `TypeReference` class.
1. In the `BookService` class, create an appropriately named method that returns a list (`List`) of all books.
1. In the `BookService` class, create a suitably named method that returns a list (`List`) of all books by the specified author (the author's name will be the method parameter).
   The returned list can be empty.
1. In the `BookService` class, create a suitably named method that returns a list (`List`) of all books published in the specified year (the year is the method parameter).
   The returned list can be empty.
1. Write tests for the methods in the `BookService` class. Don't forget to test the edge cases - the method for selecting books by author or ork will not return any book
   or returns multiple books.
1. In the Application class, create a `main` trigger method. In this method, create an instance of the `BookService` class.
1. Print the total number of books in our small database to the console (using `System.out`).
1. List in the console the names of all the books written by Karel Čapek.
1. List all the books first published in 1845. The listing will be in the form *author name: book title*.

## Bonus

1. As a bonus, you can validate the values passed to the setters of the `Book` class. If the parameter is incorrect, it is useful to throw an `IllegalArgumentException` exception:
    1. The author name should not be empty (`null` or an empty String).
    1. The book title should not be empty (`null` or an empty String).
    1. We will only consider printed books, so the year of publication should not be earlier than the invention of the printing press - use 1440 as the cutoff year.
1. Implement tests on the validations implemented in the setters - i.e. whether correct values pass and incorrect ones fail (throw an exception).




# Úkol 7 – Knihovna

Implementujte jednoduchou aplikaci pro evidenci knížek. Aplikace nače seznam knížek z JSON souboru a bude umět vypsat všechny knížky od zvoleného autora a také
všechny knížky vydané v zadaném roce.

Nemusíte dodržet přesné pořadí kroků uvedených níže – např. se může hodit napsat si test před implementací nkódu, který bude testovat, nebo souběžně s ním.

1. Aplikace bude obsahovat vedle třídy `Aplikace` už jen dvě další třídy, `Kniha` a `KnihaSluzba`. Obě nové třídy proto vytvořte přímo v
   package `cz.czechitas.ukol07`.
1. Třída `Kniha` bude JavaBean a bude reprezentovat jednu knížku. Podívejte se na strukturu JSON souboru `src/main/resources/cz/czechitas/ukol07/knihy.json` a
   strukturu třídy (properties) navhněte podle struktury JSON souboru.
2. Ve třídě `KnihaSluzba` bude field typu `List<Kniha>`. Obsah tohoto souboru naplňte v konstruktoru třídy. Pro načtení použijte `ObjectMapper`.
    1. Pro načtení použijte `InputStream`, který vytvoříte voláním `KnihaSluzba.class.getResourceAsStream("knihy.json")`. Tímto způsobem načtetesoubor
       knihy.json, který je uložen
       v `src/main/java` ve stejném package, jako třída `KnihaSluzba`. Nezapomeňte, že `InputStream` se musí po dokončení zavřít – použijte
       konstrukci `try-with-resources`.
    1. Pro samotné načtení `List`u použijte následující konstrukci:
       ```java
       objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>(){})
       ```
       Kód `objectMapper.readValue(inputStream, List<Kniha>.class)` z historických důvodů nejde použít. Pokud potřebujete načíst kolekci nebo jakýkoli jiný
       generický typ, je potřeba použít konstrukci s třídou `TypeReference`.
1. Ve třídě `KnihaSluzba` vytvořte vhodně pojmenovanou metodu, která vrátí seznam (`List`) všech knih.
1. Ve třídě `KnihaSluzba` vytvořte vhodně pojmenovanou metodu, která vrátí seznam (`List`) všech knih od zadaného autora (jméno autora bude parametr metody).
   Vrácený seznam může být prázdný.
1. Ve třídě `KnihaSluzba` vytvořte vhodně pojmenovanou metodu, která vrátí seznam (`List`) všech knih vydaných v zadaném roce (rok bude parametr metody).
   Vrácený seznam může být prázdný.
1. Napište testy pro metody ve třídě `KnihaSluzba`. Nezapomeňte otestovat i okrajové případy – metoda pro výběr knih dle autora nebo orku nevrátí žádnou knížku
   nebo vrátí více knih.
1. Ve třídě Aplikace vytvořte spouštěcí metodu `main`. V této metodě vytvořte instanci třídy `KnihaSluzba`.
1. Vypište do konzole (pomocí `System.out`) celkový počet knížek v naší malé databázi.
1. Vypište do konzole názvy všech knížek, které napsal Karel Čapek.
1. Vypište všechny knížky vydané poprvé v roce 1845. Výpis bude ve tvaru *jméno autora: název knihy*.

## Bonus

1. Jako bonus můžete validovat hodnoty předávané do setterů třídy `Kniha`. Pokud je parametr chybný, je vhodné vyhodit výjimku `IllegalArgumentException`:
    1. Jméno autora by nemělo být prázdné (`null` ani prázdný String).
    1. Název knihy by neměl být prázdný (`null` ani prázdný String).
    1. Budeme uvažovat pouze tištěné knihy, takže rok vydání by neměl být starší, než je vynález knihtisku – použijte jako hraniční rok 1440.
1. Implementujte testy na validace implementované v setterech – tj. zda správné hodnoty projdou a chybné neprojdou (vyhodí výjimku).
