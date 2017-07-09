package com.hastybox.urlshortener

import com.google.inject.Module
import com.hastybox.urlshortener.api.{CreateController, RedirectController}
import com.hastybox.urlshortener.config.ShortenerModule
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.inject.Logging

/**
  * TODO: Comment
  *
  * @author Patrick Sy (patrick.sy@get-it.us)
  */
class UrlShortenerServer extends HttpServer with Logging {
  override protected def modules: Seq[Module] = Seq(
    ShortenerModule
  )

  override protected def start(): Unit = super.start()

  override protected def configureHttp(router: HttpRouter): Unit =
    router
      .add[RedirectController]
      .add[CreateController]
}

object UrlShortenerServerMain extends UrlShortenerServer
