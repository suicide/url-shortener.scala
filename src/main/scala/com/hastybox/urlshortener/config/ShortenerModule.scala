package com.hastybox.urlshortener.config

import javax.inject.Singleton

import com.google.inject.Provides
import com.hastybox.urlshortener.shortener.{ShortenerService, SimpleShortenerService}
import com.twitter.inject.TwitterModule

/**
  * TODO: Comment
  *
  * @author Patrick Sy (patrick.sy@get-it.us)
  */
object ShortenerModule extends TwitterModule {

  @Singleton
  @Provides
  def shortenerService(): ShortenerService = {
    new SimpleShortenerService
  }

}
