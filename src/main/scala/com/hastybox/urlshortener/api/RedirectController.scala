package com.hastybox.urlshortener.api

import javax.inject.Inject

import com.hastybox.urlshortener.shortener.ShortenerService
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

/**
  * TODO: Comment
  *
  * @author Patrick Sy (patrick.sy@get-it.us)
  */
class RedirectController @Inject() (shortenerService: ShortenerService) extends Controller {

  get("/:id") { request: Request =>

    def notFound = () => response.notFound

    request.getParam("id") match {
      case id: String => shortenerService
        .find(id)
        .map(url =>
          response
            .movedPermanently
            .location(url))
        .getOrElse(notFound())

      case _ => notFound()
    }
  }

}
