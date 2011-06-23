package livedemo.beans

import org.apache.log4j.Logger

class TransformationBean {

  // use a Java Library (log4j):
  val logger = Logger.getLogger(this.getClass.getName)

  def transform(input: String): String = {

    logger.info("input before transformation: " + input)
    val output = input.reverse.toString
    logger.info("output after transformation: " + output)
    output

  }
}