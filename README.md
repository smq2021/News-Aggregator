# NewsSphere: Personalized News Aggregator

## Overview

**NewsSphere** is an Android application designed to tackle the challenge of personalized news delivery. By aggregating news from various sources using the NewsAPI, it provides users with a seamless experience to explore news across multiple categories, search for niche topics, and access full articles with just a single click. This application enhances information accessibility for diverse user segments, making it a valuable tool for anyone looking to stay informed.

## Features

- **News Aggregation**: Collects news articles from various reputable sources, ensuring a wide range of perspectives.
- **Category Selection**: Users can explore news across 8 distinct categories, including:
  - General
  - Health
  - Entertainment
  - Business
  - Sports
  - Technology
  - Science
  - Top Headlines
- **Search Functionality**: Users can search for specific topics or keywords to find articles that interest them.
- **User-Friendly Interface**: Designed with a clean and intuitive interface for easy navigation.
- **Full Article Access**: Users can read full articles directly within the app, enhancing the reading experience.
- **Progress Indicator**: A linear progress indicator shows loading status while fetching news articles.

## Technologies Used

- **Programming Language**: Java
- **Android SDK**: Targeting Android API level 34
- **Libraries**:
  - [NewsAPI](https://newsapi.org/): For fetching news articles.
  - [Picasso](https://square.github.io/picasso/): For image loading and caching.
  - [AndroidX Libraries](https://developer.android.com/jetpack/androidx): For modern Android development practices.
- **Architecture**: MVVM (Model-View-ViewModel) pattern for better separation of concerns.

## Installation

To run the NewsSphere app locally, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/smq2021/NewsSphere-Personalized-News-Aggregator.git
   ```

2. **Open the Project**:
   Open the project in Android Studio.

3. **Add API Key**:
   - Create a file named `config.properties` in the `app/src/main/assets/` directory.
   - Add your NewsAPI key in the following format:
     ```
     API_KEY=your_api_key_here
     ```

4. **Build and Run**:
   - Connect your Android device or start an emulator.
   - Click on the "Run" button in Android Studio to build and launch the app.

## Usage

1. **Launch the App**: Open the NewsSphere app on your device.
2. **Explore Categories**: Tap on any of the category buttons to view news articles related to that category.
3. **Search for Articles**: Use the search bar to find articles on specific topics.
4. **Read Articles**: Click on any article to read the full content.



## Future Enhancements

- **User Authentication**: Allow users to create accounts and save their favorite articles.
- **Offline Reading**: Implement functionality to save articles for offline reading.
- **Push Notifications**: Notify users of breaking news or updates in their selected categories.
- **Dark Mode**: Provide a dark mode option for better readability in low-light conditions.



## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the developers of the NewsAPI for providing a robust platform for news aggregation.
- Special thanks to the open-source community for their contributions and support.

