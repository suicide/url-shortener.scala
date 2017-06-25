package com.hastybox.urlshortener

import com.google.inject.Module
import com.twitter.inject.Logging
import com.twitter.inject.server.TwitterServer

/**
  * TODO: Comment
  *
  * @author Patrick Sy (patrick.sy@get-it.us)
  */
class UrlShortenerServer extends TwitterServer with Logging{
  override protected def modules: Seq[Module] = super.modules

  override protected def start(): Unit = super.start()
}

object UrlShortenerServerMain extends UrlShortenerServer
