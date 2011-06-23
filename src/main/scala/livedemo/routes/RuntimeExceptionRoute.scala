package livedemo.routes

import org.apache.camel.scala.dsl.builder.RouteBuilder
import livedemo.processors.TransformationProcessor
import livedemo.errorhandling.ErrorLog
import livedemo.beans.TransformationBean

class RuntimeExceptionRoute extends RouteBuilder with ErrorLog {


  "direct:goToException" bean(new TransformationBean) process(new TransformationProcessor)

  // alternative for calling a bean: bean(classOf[TransformationBean]
}