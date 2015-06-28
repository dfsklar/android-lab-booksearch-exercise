# Book Search App

Android app that leverages the [OpenLibrary API](https://openlibrary.org/developers/api) to search books and display cover images. This app will be built on top of a base app(details provided below)

## Overview

The app does the following:

1. Fetch the books from the [OpenLibrary Search API](https://openlibrary.org/dev/docs/api/search) in JSON format
2. Deserialize the JSON data for each of the books into `Book` objects
3. Build an array of `Book` objects and create an `RecyclerView.Adapter` for those books
4. Define `onCreateViewHolder` to define how to inflate a layout for each book row and bind each book's data in `onBindViewHolder`.
5. Attach the adapter for the books to a RecyclerView to display the data on screen

To achieve this, there are four different components in this app:

1. `BookClient` - Responsible for executing the API requests and retrieving the JSON
2. `Book` - Model object responsible for encapsulating the attributes for each individual book
3. `BookRecyclerAdapter` - Responsible for mapping each `Book` to a particular view layout
4. `BookListActivity` - Responsible for fetching and deserializing the data and configuring the adapter

## Usage
This app is intended to be the base project on top of which new features can be added. To use it, clone the project and import it using the following steps:

![Imgur](http://i.imgur.com/x5iXb8Y.gif)

### Goal

Pair up and build a book search app that searches the [OpenLibrary API](https://openlibrary.org/developers/api) to search books by author or title.
* Display the list of books with its cover images using RecyclerView.
* Use SearchView to search for books.
* Add a detail view to display more information about the selected book from the list.
* Use a share intent to recommend books to friends.
* Show ProgressBar before network request.


1. Import base app
  * The app connects to the OpenLibrary API and displays a list of books. You will be building new features on top of this app.
  * Clone [android-booksearch-exercise repo](https://github.com/codepath/android-booksearch-exercise) on your machine. Import the project in IntelliJ:

    ![Import|600](http://i.imgur.com/x5iXb8Y.gif)

2. Test your app
  * Test to verify that the app runs without any errors.
  * If your app loads successfully, you should see the following output:

    ![Screenie|300](http://i.imgur.com/0zLvR7c.png)

3. Add SearchView to ActionBar
  * The app should allow you to search for books by its author or title. One of the preferred way to do this is by using a SearchView.
  * Refer [adding SearchView to ActionBar](http://guides.codepath.com/android/Extended-ActionBar-Guide#adding-searchview-to-actionbar) guide for more details.
  * Make sure to remove the call to `fetchBooks("Oscar Wilde")` from `onCreate()` method before testing the `SearchView`.
  
  ```java
  // Fetch the data remotely
  fetchBooks("Oscar Wilde");
  ```

4. Hook up Book Detail View
  * You will find `BookDetailActivity.java` and it's layout file `activity_book_detail.xml` in your project to display more information about the book selected from the list.
      * This activity is used to show book title, author and cover image.
  * Setup an item click listener for the books in list
  * Fire an intent when the user selects a book from the list
  * Pass the book through the intent and populate the detail view
  * Refer [Using Intents to Create Flows](http://guides.codepath.com/android/Using-Intents-to-Create-Flows) cliffnotes for guidelines on passing data between activities.
  * Change activity title to reflect the book title.
  * **(Bonus)** Get additional book information like publisher and pages count from the [Books API](https://openlibrary.org/dev/docs/api/books) and display in details view.

5. Add Share Intent
  * Add a share action item to the ActionBar of `BookDetailActivity` so you can share a book.
  * Share cover image by referring the guide on [sharing remote images](http://guides.codepath.com/android/Sharing-Content-with-Intents#overview_sharing-remote-images).
  * **(Bonus)** Share book title and cover image using the same intent.

6. Show Progress Bar
  * Display a ProgressBar while the book data is being fetched and hide it once the data is loaded in the RecyclerView.
  * Refer to the [implementing progress guide](http://guides.codepath.com/android/Handling-ProgressBars#progress-within-actionbar) guide to show and hide an indeterminate progressbar.

7. Run and test your app.
## Libraries

This app leverages two third-party libraries:

 * [Android AsyncHTTPClient](http://loopj.com/android-async-http/) - For asynchronous network requests
 * [Fresco](https://github.com/facebook/fresco) - For remote image loading
# android-facebook-booksearch-exercise
