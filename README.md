alpha-queue
===========

A message queue with offline storage, retrieval and asynchronous processing inspired by
and forked from [Android Priority Job Queue](https://github.com/path/android-priority-jobqueue)

Why another library?
======================
* [Path's](https://github.com/path) Job Queue is a really good implementation but it suits more for applications that need fire and forget approach for sending messages to the server.
* Out of the box Job Queue did not allow to retrieve all the existing messages from the queue. This library adds some more API methods in addition to just retrieving all the existing messages.

Features
======================
* Persitant Jobs
* Jobs Executed in background


Credits
=========
[Android Priority Job Queue](https://github.com/path/android-priority-jobqueue)
