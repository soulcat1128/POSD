# Pattern Oriented Software Design 2024 Fall Midterm Lab Test

__Duration__: 2024/10/28 15:15~18:00

The folders `src/` and `pom.xml` in this repository are the code skeleton of this exam. You need to finish the implementation. 

Please follow the instructions in the problem statement to implement the required classes.

## Notes
- **If your code fails to compile on the [Jenkins](http://140.124.181.97:8080/) server, you'll get 0 POINT**.
- Your program should be able to handle unexpected input data; that is, you should handle errors if necessary.
- You should make your unit test fail if the program that should throw an exception runs without throwing one.
- Any submission after the end time of the test will not be graded.
- **Commit and push your code early and often**. You can commit and push as many times as you want. The last commit before the end of the test will be graded.

## Category
- [Allowed Resources](#allowed-resources)
- [Scoring criteria](#scoring-criteria)
- [Midterm Template](#midterm-template)
- [Problem Statement](#problem-statement)
    - [Specification 1: Store books and bundles. (20%)](#specification-1-store-books-and-bundles-20)
    - [Specification 2: Discount the book or the bundle. (20%)](#specification-2-discount-the-book-or-the-bundle-20)
    - [Specification 3: Iterate the structure. (30%)](#specification-3-iterate-the-structure-30)
    - [Specification 4: Calculate the total price in a shopping cart. (30%)](#specification-4-calculate-the-total-price-in-a-shopping-cart-30)
- [Final Remarks](#final-remarks)
- [File structure](#file-structure)

## Allowed Resources
You can use following resources to complete the midterm problems.

- [Java class documentation](https://docs.oracle.com/javase/8/docs/api/allclasses-noframe.html)
- [JUnit 5 documentation](https://junit.org/junit5/docs/current/api/index.html)
- [Dictionary](https://dictionary.cambridge.org/zht/)
- Physical English version text book - "Design Patterns: Elements of Reusable Object-Oriented Software"
- Your homework code in [GitLab](http://140.124.181.100/)
- The code written [in class](http://140.124.181.100/yccheng/posd2024f)
- [Environment Setting in GitLab](http://140.124.181.100/course/posd2024f_ta/tree/environment_setting)

**!!Attention!!**
- All the other resources, including GitHub Copilot, chatGPT, stack overflow, other websites, etc., are forbidden.
- You must turn off your mobile phone during the midterm exam, or you will be considered as cheating.
Violation of the rules:
- First time : Deduct 50 points
- Second time: Calculated as 0 points
- If you have any problems, please raise your hand and let TA know.

## Scoring criteria
1. 10 points are deducted if the pattern implementation is wrong.
2. 2 points are deducted for each test if the test is not written or if it does not pass the test on Jenkins.
    - For each method, you should have at least one test to cover it.
    - You should have at least one test to check exceptions.
3. 2 points are deducted for a missing override annotation.

## Midterm Template
To start the midterm, you need to follow the steps below:
1. **Clone** your homework repository.
2. Clean the `src/` folder and `pom.xml` file in your homework repository.
1. **Download** the template code from this repository.
3. Copy the `src/` folder and `pom.xml` file from the template code to your homework repository.

## Problem Statement
In the midterm exam, you'll build an e-bookstore system to manage and sell books or bundles. In the e-book store system, it contains several books or bundles. The bundle groups similar books together, e.g., the `Harry Potter` series. The bundle can also include the book or the bundle. The system can offer discounts on a book or a bundle in the bookstore. The system supports structure traversal to find books or bundles. When a customer needs to check out, the system calculates the total price for the customer.

- Example of a book:
    <img src="./images/book.png" height="100" style="border: 2px solid">

- Example of a bundle:
    <img src="./images/bundle.png" height="100" style="border: 2px solid">, <img src="./images/bundle2.png" height="100" style="border: 2px solid">

(Figure reference: `goodreads.com` & `books.com.tw`)

The system will have the following features that need to be implemented:

1. Store books and bundles.
2. Discount the book or the bundle.
3. Iterate the structure.
4. Calculate the total price in a shopping cart.

Each specification is finished by using the corresponding pattern described below.

## Specification 1: Store books and bundles. (20%)
- Use **composite pattern** with `Item` as *Component*, `Book` as *Leaf*, and `Bundle` as *Composite* to build your system.
- Implement the following classes: `Item`, `Book`, and `Bundle`.

- The `Item` interface has the following methods:
    - `String getTitle()`: returns the title of the item.
    - `void add(Item item)`: adds an item to the item. The default implementation throws a `BookStoreException` with the message `Only bundle can add the item.`.

- The `Book` class has the following methods:
    - `Book(String title, double price)`: the class's constructor. The `title` is the book's title, and the `price` is the book's price.
        - If the title is empty or blank string, throw an `IllegalArgumentException` with the message `The book should have a title.`.
            - Hint: You can find helpful methods to handle the blank string in the `String` class.
        - If the price is less than 0, throw an `IllegalArgumentException` with the message `The price should be greater than or equal to 0.`.
    - `String getTitle()`: returns the book's title.
    - `double getPrice()`: returns the book's price.

- The `Bundle` class has the following methods:
    - `Bundle(String title)`: the class's constructor. The `title` is the title of the bundle.
        - If the title is empty or blank string, throw an `IllegalArgumentException` with the message `The bundle should have a title.`.
    - `String getTitle()`: returns the bundle's title.
    - `void add(Item item)`: adds an item to the bundle.

## Specification 2: Discount the book or the bundle. (20%)
- Use **decorator pattern** to discount a book, a bundle, or a discount item in the bookstore.
- Implement the following class: `DiscountItem`.

- The `DiscountItem` class has the following methods:
    - `DiscountItem(Item item, double discount)`: the class's constructor. The `item` is the item to discount, and the `discount` is the discount between 0 and 1.
        - The discount of 0.1 means 10% off, 0.5 means 50% off, 0.9 means 90% off, etc.
        - If the discount is less than 0 or greater than 1, throw an `IllegalArgumentException` with the message `The discount should be between 0 and 1.`. 
    - `Item getItem()`: returns the item before the discount.
    - `double getDiscount()`: returns the discount value.
    - `String getTitle()`: returns the discount item's title. 
        - The title of the `DiscountItem` is generated by the following rules: `<{ITEM_TITLE}> is on sale! {DISCOUNT}% off!`
            1. Example 1: Given a discount on a book:
                ```
                DiscountItem, discount 0.1
                └── Happy Potter, $100
                ```
                - The title of the `DiscountItem` is `<Happy Potter> is on sale! 10% off!`
        
            2. Example 2: Given a discount on a bundle:
                ```
                DiscountItem, discount 0.2
                └── Fake Potter Series
                    ├── Happy Potter, $100
                    └── Angry Potter, $200
                ```
                - The title of the `DiscountItem` is `<Fake Potter Series> is on sale! 20% off!`

            3. Example 3: Given a discount on a discount item:
                ```
                NewDiscountItem, discount 0.5
                └── DiscountItem, discount 0.2
                    └── Fake Potter Series
                        ├── Happy Potter, $100
                        └── Angry Potter, $200
                ```
                - The title of the `NewDiscountItem` is `<<Fake Potter Series> is on sale! 20% off!> is on sale! 50% off!`
        - Hint: You can use `DecimalFormat` to format the discount.
    
- Since a `DiscountItem` is a group of items selling together, a `DiscountItem` CANNOT `add` the item on it.
- However, A `DiscountItem` can be bundled with other books, bundles, or discount items to become a new discount item.

## Specification 3: Iterate the structure. (30%)
- Use **iterator pattern** to iterate the structure of the book store.

- Implement the following classes: `NullIterator` and `DFSIterator`.

- The `NullIterator` class implements on `Iterator` interface and override the following methods:
    - `boolean hasNext()`: returns `false`.
    - `Item next()`: throws a `NoSuchElementException` with the message `No more element.`.

- The `DFSIterator` class implements on `Iterator` interface and has the following methods:
    - `DFSIterator(Item item)`: the class's constructor. The `item` is the item to be iterated.
    - `boolean hasNext()`: returns `true` if the iteration has more elements.
    - `Item next()`: returns the next element in the iteration.
        - If there are no more elements to return, throw a `NoSuchElementException` with the message `No more element.`.
    - The `DFSIterator` should iterate the items in the depth-first search order.
        
        <img src="./images/DFS.gif" height="200" style="border: 2px solid"> (reference: `en.wikipedia.org`)
    - For example, given the following structure with a bundle containing another bundle and a book:
    ```
    Bundle1
    ├── Bundle2
    │   ├── Book1, $1
    │   └── Book2, $2
    └── Book3, $3
    ```
    - The `DFSIterator` iterates the `Bundle1` will be in the order of `Bundle1`, `Bundle2`, `Book1`, `Book2`, and `Book3`.

- Add the following methods in the `Item` interface:
    - `Iterator<Item> iterator()`: returns a `Iterator` for the bundle and the discount item. The default implementation returns a `NullIterator`.
    - `Iterator<Item> dfsIterator()`: returns a `DFSIterator` for the item. 

    - If the item is a book,
        - `iterator()` returns a `NullIterator`.
        - `dfsIterator()` iterates the book itself
            - For example, given a book `Book1`:
            - The `DFSIterator` iterates the `Book1` itself. That is, the `DFSIterator.next()` in `Book1` is `Book1`.
    - If the item is a bundle, 
        - `iterator()` returns an iterator to iterate its items.
        - `dfsIterator()` iterates the bundle with the DFS order. (As the example above.)
    - If the item is a discount item, 
        - `iterator()` returns an iterator depending on the decorated item.
        - `dfsIterator()` iterates the discount item with the DFS order.
            - For example, given the following structure with a discount item containing a bundle and two books:
            ```
            DiscountItem, discount 0.1
            └── Fake Potter Series
                ├── Happy Potter, $100
                ├── Bundle
                │   └── Sad Potter, $150
                └── Angry Potter, $200
            ```
            - The `DFSIterator` iterates the `DiscountItem` will be in the order of `DiscountItem`, `Happy Potter`, `Bundle`, `Sad Potter`, `Angry Potter`.

## Specification 4: Calculate the total price in a shopping cart. (30%)
- Use the **visitor pattern** to calculate the total prices of all items in shopping cart.
    - **Notice**: **DO NOT** calculate and get the price from `Bundle` and `DiscountItem`. Otherwise, **you will get no points**. The visitor pattern is used to separate the price calculation from the item. 
- Implement the following class: `PriceVisitor`.

- The `Item` interface adds the following method:
    - `void accept(ItemVisitor<T> visitor)`: accept the visitor to visit the item.

- The `ItemVisitor` interface has the following methods:
    - `void visitBook(Book book)`: visit the book.
    - `void visitBundle(Bundle bundle)`: visit the bundle.
    - `void visitDiscountItem(DiscountItem discountItem)`: visit the discount item.
    - `T getResult()`: return the result of the visitor.

- `PriceVisitor` implements the `ItemVisitor` interface and computes the total price of some items bought by the customer. The `PriceVisitor` class has the following methods:
    - `PriceVisitor()`: the class's constructor.
    - `void visitBook(Book book)`: add the price of the book to the total price.
    - `void visitBundle(Bundle bundle)`: add the price of all the items in the bundle to the total price.
    - `void visitDiscountItem(DiscountItem discountItem)`: add the discount price of the item to the total price.
    - `double getResult()`: return the total price of the items.

- The discount value is calculated by the following formula: `price * ( 1 - discount )`.

    1. Example 1: Given a book:
        ```
        Happy Potter, $100
        ```
        - The price of the book is `$100`.

    2. Example 2: Given a bundle:
        ```
        Fake Potter Series
        ├── Happy Potter, $100
        └── Angry Potter, $200
        ```
        - The price of the bundle is: `$100 + $200 = $300`.

    3. Example 3: Given a discount item:
        ```
        DiscountItem, discount 0.1
        └── Happy Potter, $100
        ```
        - The price of the discount item is: `$100 * 0.9 = $90`.
            
    4. Example 4: Given a discount book another discount:
        ```
        NewDiscountItem, discount 0.5
        └── DiscountItem, discount 0.2
            └── Happy Potter, $100
        ```
        - The price of the discount item is: `$100 * 0.8 * 0.5 = $40`.

- The `PriceVisitor` should be able to calculate the total price of the items in the shopping cart containing a list of items:
    - Sample code:
        ```java
        List<Item> shoppingCart = new ArrayList<>();
        // Add some items to the shopping cart
        PriceVisitor priceVisitor = new PriceVisitor();
        for (Item item : shoppingCart) {
            item.accept(priceVisitor); // Accept the visitor to visit the item
        }
        double totalPrice = priceVisitor.getResult(); // Get the total price of the shopping cart
        ```

## Final Remarks
Congratulations! You have finished the midterm exam. Please check the following things before you leave:
- The code is committed and pushed to your remote repository.
- The status of Jenkins is passed.
- 62 tests is passed in the TA's test.
- Make sure you follow the instructions and requirements.
- Check your code and make sure it is well-formatted and readable.
- Clean the unused code and remove unnecessary comments.

## File structure
```
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── org
    │           └── ntut
    │               └── posd2024f
    │                   └── midterm
    │                       ├── Book.java
    │                       ├── BookStoreException.java
    │                       ├── Bundle.java
    │                       ├── DFSIterator.java
    │                       ├── DiscountItem.java
    │                       ├── Item.java
    │                       ├── ItemVisitor.java
    │                       ├── NullIterator.java
    │                       └── PriceVisitor.java
    └── test
        └── java
            └── org
                └── ntut
                    └── posd2024f
                        └── midterm
                            ├── BookTest.java
                            ├── BundleTest.java
                            ├── DFSIteratorTest.java
                            ├── DiscountItemTest.java
                            ├── ItemTest.java
                            ├── NullIteratorTest.java
                            └── PriceVisitorTest.java
``` 