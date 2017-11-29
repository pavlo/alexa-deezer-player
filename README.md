# [SUSPENDED] alexa-deezer-player

Enables your Alexa (Amazon Echo) to stream media from Deezer.com

## Status

### TL;DR

Deezer's REST API is not sufficient enough to be leveraged on Alexa (and other a-like devices). 
The work on the skill has been suspended thus.

### A longer story

After a bit of playing with [Deezer's REST API](https://developers.deezer.com/api) it has been discovered that it does not return the URL to the full stream (versus a 30 seconds sample). This is so by design and Deezer development team had confirmed that. It is only possible to access the full stream through one of their SDKs - Android/iOS/Native. The SDKs however 'force' you to use the `Player` abstraction that incapsulates the not only of the details of the stream security but also the audio playback on the device which indeed makes it impossible to be leveraged in Alexa.

This subtle nuance was not quite obvious from their documentation so I decided to keep the suspended project here at Github versus removing it as someone might stumble up on the same issue in the future - it would save him/her some time and nerevs which is cool!

