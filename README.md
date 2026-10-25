# Reorderable

### A fork of [Reorderable](https://github.com/Calvin-LL/Reorderable) for [ReadBear](https://github.com/Tulis12/ReadBear)

Reorderable is a library for reordering items in Jetpack Compose. This fork currently focuses on LazyVerticalGrid, which is the only component required by ReadBear. Other components may work, but have not been tested.

## Changes from the original

- Adds `onHoverStart` and `onHoverEnd` callbacks to the reorderable state, allowing you to react when an item is hovered over or no longer hovered over during a drag operation.

## Use cases

- [ReadBear](https://github.com/Tulis12/ReadBear) useful for adding item to a folder (hover over it and drop in)

## Usage

### Version Catalog

If you're using Version Catalog, add the following to your `libs.versions.toml` file:

```toml
[versions]
#...
reorderable = "3.2.1-tulis.1"

[libraries]
#...
reorderable = { module = "sh.calvin.reorderable:reorderable", version.ref = "reorderable" }
```

or

```toml
[libraries]
#...
reorderable = { module = "io.github.tulis12:reorderable", version = "3.2.1-tulis.1" }
```

then

```kotlin
dependencies {
    // ...
    implementation(libs.reorderable)
}
```

### Gradle

If you're using Gradle instead, add the following to your `build.gradle` file:

#### Kotlin DSL

```kotlin
dependencies {
    // ...
    implementation("io.github.tulis12:reorderable:3.2.1-tulis.1")
}
```

#### Groovy DSL

```groovy
dependencies {
    // ...
    implementation 'io.github.tulis12:reorderable:3.2.1-tulis.1'
}
```
