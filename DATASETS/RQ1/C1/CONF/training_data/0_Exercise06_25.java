public static String convertMillis(long millis) {
    // Compute the total seconds
    long totalSeconds = millis / 1000;

    // Extract the number of hours
    int hours = (int) (totalSeconds / 3600);

    // Extract the number of remaining minutes
    int minutes = (int) ((totalSeconds % 3600) / 60);

    // Extract the number of remaining seconds
    int seconds = (int) (totalSeconds % 60);

    // Return the formatted string
    return hours + ":" + minutes + ":" + seconds;
}