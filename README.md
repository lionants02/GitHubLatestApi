# GitHubLatestApi


[![Build Status](https://travis-ci.org/lionants02/GitHubLatestApi.svg?branch=master)](https://travis-ci.org/lionants02/GitHubLatestApi.ini) [![Release](https://jitpack.io/v/lionants02/GitHubLatestApi.svg)](https://jitpack.io/#lionants02/GitHubLatestApi)  
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

เพิ่ม JitPack repository ที่ build script
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

เพิ่ม dependency
```
dependencies {
    implementation "com.github.lionants02:GitHubLatestApi:$latestVersion"
}
```

ใช้
```kotlin
    val github = GitHubLatestApi("ffc-nectec/airsync")
    val lastRelease = github.getLastRelease()
    
    println(lastRelease.body)
               
    println("Assets...")
    lastRelease.assets.forEach { 
        println(it.browser_download_url)
    } 
```
