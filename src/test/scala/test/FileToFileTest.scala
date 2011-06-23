package test


import org.apache.camel.scala.dsl.builder.{RouteBuilderSupport, RouteBuilder}
import org.apache.camel.{ContextTestSupport, Exchange}
import org.apache.camel.test.junit4.CamelTestSupport
import org.scalatest.junit.JUnitSuite
import livedemo.routes.FileToFileRoute
import java.io.File
import org.junit.{Assert, Test}


// Extend the CamelTestSupport (Java-Class) and mix in two further traits
// In this case you mix in the testing-framework "ScalaTest"
// => Powerful Scala-Feature: use traits to add more logic besides the CamelTestSupport
class FileToFileTest extends CamelTestSupport with RouteBuilderSupport with JUnitSuite {

  override def createRouteBuilder = new FileToFileRoute

  // Again basic (Java) JUnit and Camel stuff here:
  @Test
  def testFileToFile {
    println("testing...")

    template.sendBodyAndHeader("file://files/inbox", "content of template", Exchange.FILE_NAME, "template.txt")

    Thread.sleep(1000)

    val target = new File("files/outbox")
    Assert.assertTrue(target.exists())

  }
}