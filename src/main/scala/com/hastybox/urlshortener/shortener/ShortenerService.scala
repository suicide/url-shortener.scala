package com.hastybox.urlshortener.shortener

import java.util.concurrent.ConcurrentHashMap

/**
  * TODO: Comment
  *
  * @author Patrick Sy (patrick.sy@get-it.us)
  */
trait ShortenerService {

  def shorten(url: String): String

  def find(id: String): Option[String]

}

class SimpleShortenerService extends ShortenerService {
  import scala.collection.JavaConverters._

  private[this] var idCounter = 0
  private[this] val store = new ConcurrentHashMap[String, String]() asScala

  override def shorten(url: String): String = {
    idCounter += 1
    val id = idCounter.toString

    store.put(id, url)

    id
  }

  override def find(id: String): Option[String] = {
    store.get(id)
  }
}
