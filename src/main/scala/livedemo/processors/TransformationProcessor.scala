package livedemo.processors

import org.apache.camel.{Exchange, Processor}
import livedemo.errorhandling.AbsurdException


class TransformationProcessor extends Processor {

  def process(exchange: Exchange) {

    println("Oh oh, I will die now :-(")

    throw new AbsurdException("You have to die now!")

  }
}