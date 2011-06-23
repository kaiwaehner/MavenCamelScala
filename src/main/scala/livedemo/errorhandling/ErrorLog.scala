package livedemo.errorhandling

import org.apache.camel.scala.dsl.builder.RouteBuilder
import java.io.FileNotFoundException


trait ErrorLog { self: RouteBuilder =>

    handle[AbsurdException] {
    log("Sending ${id} to error log")
    to("log:errors")
  }

  handle[FileNotFoundException] {
    log("File not Found...")
    to("log:errors")
  }

}