package livedemo

import org.apache.camel.impl.DefaultCamelContext
import org.apache.log4j.Logger
import routes.{RuntimeExceptionRoute, FileToFileRoute}

object CamelStarter extends App {

  // use a Java library (Log4j):
  val logger = Logger.getLogger(this.getClass.getName)

  // use the CamelContext as you do it with Java
  val camelContext = new DefaultCamelContext
  camelContext.addRoutes(new FileToFileRoute)
  camelContext.addRoutes(new RuntimeExceptionRoute)

  logger.info("starting...")
  camelContext.start

  Thread.sleep(2000)

  logger.info("stopping...")
  camelContext.stop

}