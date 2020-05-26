# WorkManager

* Actually, WorkManager library has a local database that tracks all of the information and statues of all the work.
* This database is what enables WorkManager to guarantee the execution of the work even if the use exists from the app or user's device restarts and work get interrupted.
* We cannot get a returned value if the work is not finished.
* Android Jetpack periodic work request has a minimum period length of 15 minutes
