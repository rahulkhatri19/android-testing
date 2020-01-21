TO-DO Notes - Code for 5.1-5.3 Testing Codelab
============================================================================

Code for the Advanced Android Kotlin Testing Codelab 5.1-5.3

Introduction
------------

TO-DO Notes is an app where you to write down tasks to complete. The app displays them in a list.
You can then mark them as completed or not, filter them and delete them.

![App main screen, screenshot](screenshot.png)

This codelab has four branches, representing different code states:

* [starter_code](https://github.com/googlecodelabs/android-testing/tree/starter_code)
* [end_codelab_1](https://github.com/googlecodelabs/android-testing/tree/end_codelab_1)
* [end_codelab_2](https://github.com/googlecodelabs/android-testing/tree/end_codelab_2)
* [end_codelab_3](https://github.com/googlecodelabs/android-testing/tree/end_codelab_3)

The codelabs in this series are:
* [Testing Basics](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-basics)
* [Introduction to Test Doubles and Dependency Injection](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-test-doubles)
* [Survey of Testing Topics](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-survey)


Pre-requisites
--------------

You should be familiar with:

* The Kotlin programming language, including [Kotlin coroutines](https://developer.android.com/kotlin/coroutines) and their interaction with [Android Jetpack components](https://developer.android.com/topic/libraries/architecture/coroutines).
* The following core Android Jetpack libraries: [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel),
 [LiveData](https://developer.android.com/topic/libraries/architecture/livedata),
  [Navigation Component](https://developer.android.com/guide/navigation) and 
  [Data Binding](https://developer.android.com/topic/libraries/data-binding).
* Application architecture, following the pattern from the [Guide to app architecture](https://developer.android.com/jetpack/docs/guide) and [Android Fundamentals codelabs](https://developer.android.com/courses/kotlin-android-fundamentals/toc).


Getting Started
---------------

1. Download and run the app.
2. Check out one of the codelabs mentioned above.

License
-------

Copyright 2019 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.

Resources
-----
_____

 - Test Driven Development: To learn more about [Test Driven Development in Android, you can watch Test-Driven Development on Android with the Android Testing Support Library (Google I/O '17)](https://youtu.be/pK7W5npkhho?t=222) (note the Android Testing Support Library has been replaced by [AndroidX Test](https://developer.android.com/training/testing/set-up-project) which you'll learn about later).

 - **Naming Convention**: Given/When/Then which is Similar to Arrange, Act, Assert (AAA).
 subjectUnderTest_actionOrInput_resultState, here subject is what are we testing.

```kt
  @Test
       fun getActiveAndCompleteStatus_zeroComplete_returnZeroHundred() {
   //        Given total 1 task: 0 completed task and 1 active task
           val task = listOf(Task("title", "description", false))
   //        When you call getActiveAndCompletedStats
           val result = getActiveAndCompletedStats(task)
   //        Then there are 100% active task and 0% complete task
           assertEquals(0f, result.completedTasksPercent)
           assertEquals(100f, result.activeTasksPercent)
       }
```

- Assertion Frameworks:
  [Hamcrest](http://hamcrest.org/)
  [Truth Library](https://truth.dev/)

 - [Fundamentals of Testing](https://developer.android.com/training/testing/fundamentals)
 - For more information go to [Developing Android Apps with Kotlin](https://classroom.udacity.com/courses/ud9012) Course's Lesson 5: App Architecture (UI Layer) - Concept 18. Exercise: Add End Game Event, Concept 22. Exercise: Add a ViewModelFactory

 - [Dagger](https://dagger.dev)
 - [Dagger 2 Codelab](https://codelabs.developers.google.com/codelabs/android-dagger/#0)
 - [Dependency Injection Documentation](https://developer.android.com/training/dependency-injection)

 - If you'd like to avoid building a separate factory for each view model, check out the [Architecture Blueprints reactive sample](https://github.com/android/architecture-samples/tree/reactive), which shows a slightly more complicated version of the tests you are building. It includes a generic [ViewModelFactory](https://github.com/googlesamples/android-architecture/blob/reactive/app/src/main/java/com/example/android/architecture/blueprints/todoapp/ViewModelFactory.kt) that can generate any view model needed and this [extension function](https://github.com/googlesamples/android-architecture/blob/reactive/app/src/main/java/com/example/android/architecture/blueprints/todoapp/util/FragmentExt.kt).
