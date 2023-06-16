# BonoBono 

A recipe finder app that shows a list of popular categories, and each category shows a list of meals and their details of instruction, and you can add your favourite meal in the local offline storage.


## Architecture 📐
* Project is in Clean architecture guidelines by Uncle Bob eho came up with the Clean Architecture concept in the year 2012.
* Clean architecture is also referred to as Onion architecture as it has different layers(Presentation, Domain, Data).

<p>
<img src="https://github.com/george-georgy/BonoBono/blob/main/Screenshots/Screenshot_00.png"/>
</p>

* Presentation: A layer that interacts with the view(UI) , in Android like Activities, Fragments, ViewModel.
  Domain: Contains entities and bussiness logic, The business logic put into so called "use case".usecases like fetching data from a network or reading data from database.
  Data: It would implement the interface exposed by domain layer and handle all incoming data (accessing a DB or API).

* Why Clean Architecture?
  Separation of Concerns — Separation of code in different modules or sections with specific responsibilities making it easier for maintenance and further modification.
  Loose coupling — flexible code anything can be easily be changed without changing the system.
  Easily Testable.

## Architecture Data Flow 📐
<p>
<img src="https://github.com/george-georgy/BonoBono/blob/main/Screenshoots/Screenshot_0.png"/>
</p>


## Screenshots

<p>
<img src="https://github.com/george-georgy/BonoBono/blob/main/Screenshoots/Screenshot_0.png" height=450 width=230 />
<img src="https://github.com/george-georgy/BonoBono /blob/main/Screenshoots/Screenshot_1.png" height=450 width=230 />
<img src="https://github.com/george-georgy/BonoBono /blob/main/Screenshoots/Screenshot_2.png" height=450 width=230 />
<img src="https://github.com/george-georgy/BonoBono /blob/main/Screenshoots/Screenshot_3.png" height=450 width=230 />
</p>

## Tech-stack 🛠
* [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
* [KTX](https://developer.android.com/kotlin/ktx) - Kotlin extensions for Android, providing concise and idiomatic APIs.
* [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - Asynchronous programming library for simplifying background operations.
* [Flow](https://kotlinlang.org/docs/flow.html) - Reactive stream library for asynchronous and data-driven programming.
* [Jetpack Compose](https://developer.android.com/jetpack/compose/documentation) - First class and official programming language for Android development.
* [Retrofit/OkHttp3](https://square.github.io/retrofit/)() - Networking libraries for making HTTP requests.
* [Room](https://developer.android.com/training/data-storage/room) - Persistence library for local database storage.
* [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency injection library for Android.
* [Navigation Component](https://developer.android.com/jetpack/compose/navigation) - Android Jetpack's library for navigating between screens.
* [ViewModel-ktx](https://developer.android.com/topic/libraries/architecture/viewmodel) - Part of the Android Architecture Components for managing UI-related data.
* [MaterialDesignComponents](https://m2.material.io/develop/android/docs/getting-started) - Library for implementing Material Design UI components.
* [Glide](https://github.com/bumptech/glide) - Glide is a fast and efficient open source media management and image loading framework.
