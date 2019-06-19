

## Highlights

This project focuses on architecture and testability

* Overall 78% line coverage
* 96% Coverage on class , 97% Coverage on method, 96% Coverage on line in the screens
* Activities are unit tested with Robolectric 4 , they can be also used as espresso tests with little or no effort
* Android Architectural components and AndroidX is used
* Some parts are developed with TDD and project architecture is suitable for TDD
* Retrofit, RxJava is used
* Used https://jsonresume.org/schema/ any resume with this format is supported.

## Todo
* Better design, colors etc.
* No external images is used they could be updated from web
* Currently data is cached , Room can be used for database
* Initially Koin is used for dependency injection but there was an error in testing with multiple viewmodels
* Hack for testing done with ViewModel Factories should be replaced with DI

