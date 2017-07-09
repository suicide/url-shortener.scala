package com.hastybox.urlshortener.api

import javax.inject.Inject

import com.hastybox.urlshortener.shortener.ShortenerService
import com.twitter.finatra.http.Controller
import com.twitter.finatra.request.QueryParam
import com.twitter.finatra.validation.NotEmpty

/**
  * TODO: Comment
  *
  * @author Patrick Sy (patrick.sy@get-it.us)
  */
class CreateController @Inject()(shortenerService: ShortenerService) extends Controller {

  post("/") { request: CreateRequest =>
    val id = shortenerService.shorten(request.url)

    response.created
      .location(id)
  }

}

case class CreateRequest(
                          @NotEmpty url: String
                        )
