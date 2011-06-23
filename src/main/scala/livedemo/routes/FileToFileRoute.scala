package livedemo.routes

import org.apache.camel.scala.dsl.builder.RouteBuilder


class FileToFileRoute extends RouteBuilder{

  // Scala routes use the feature of "implicit conversion"
  // Thus, you do not need a "from" method call here
  "file://files/inbox?noop=true" to "file://files/outbox"

  // Scala also supports operator-overloading
  // ( "-->" instead of "to")
  "file://files/xxx?noop=true" log("copying file...") to "file://files/outbox" to "direct:goToException"


// A more complex example (using a closure to implement a Processor method):

//   val myProcessorMethod = (exchange: Exchange) => {
//     exchange.getIn.setBody("block test")
//   }
//
//   "timer://foo?fixedRate=true&delay=5s&period=10s" ==> {
//      process(myProcessorMethod)
//      to("log:block")
//   }

}