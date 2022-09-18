# famileo test

Application android pour afficher/Chercher des artistes.

## Architecture

J'ai utilisé la clean architecture composé de:
Core ->Cette couche centient l'injection de dipendece de different module de l'application. 
Data->Définition abstraite de toutes les sources de données. 
Domain-> Contient la logique métier de l'application (Uses cases..)
presentation-> Couche qui interagit avec l'interface utilisateur.

## Libs

Pour L'injection de dépendances, j'ai utilisé le "Dagger" :

```sh
  implementation 'com.google.dagger:dagger:2.38.1'
    kapt 'com.google.dagger:dagger-compiler:2.38.1'
    implementation "com.google.dagger:dagger-android:2.38.1"
    implementation "com.google.dagger:dagger-android-support:2.38.1"
    kapt "com.google.dagger:dagger-android-processor:2.38.1"
```

Pour le parsing/sérialisation des données, j'ai utilisé le "kotlinx-serialization" :

```sh
 implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1"
    implementation "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
```

Le fameux retrofit2 pour les WS :

```sh
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation "com.squareup.okhttp3:okhttp:4.9.1"
    debugImplementation 'com.squareup.okhttp3:logging-interceptor:4.9.1'
```

Pour la partie navigation:

```sh
    implementation "androidx.navigation:navigation-fragment-ktx:2.5.2"
    implementation "androidx.navigation:navigation-ui-ktx:2.5.2"
```

La base de données local est "ROOM" :

```sh
   api "androidx.room:room-runtime:2.3.0"
    kapt "androidx.room:room-compiler:2.3.0"
        implementation "androidx.room:room-ktx:2.3.0"
  api "androidx.room:room-runtime:2.3.0"
  kapt "androidx.room:room-compiler:2.3.0"
  implementation "androidx.room:room-ktx:2.3.0"

```

Et lottie pour l'animation de chargement :

```sh
    implementation "com.airbnb.android:lottie:3.4.0"


```

Et finalement, j'ai integré "Timber" pour l'affichage du Log :

```sh
    implementation 'com.jakewharton.timber:timber:5.0.1'

```

## Démonstration

Ce GIF présente une démonstration de l'application.

![Alt Text](app/src/main/res/demo.gif)

## A améliorer/ ajouter

- Tests unitaires.
- Sauvegarder les details d'un artiste dans ROOM.
- Message d'erreur(pas de connexion internet, erreur de chargement des données).

## Temps de réalisation

- Dimanche 18/09: 8h.
