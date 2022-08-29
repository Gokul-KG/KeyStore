package keystore

import scala.reflect.io.Directory
import java.io.File

import org.scalatest.FunSuite
import scala.concurrent.duration._


class KeyStoreSuite extends FunSuite {
  

   test("testing huge data insertion") {
    
    val dir = "testDir"
    val directory = new Directory(new File(dir))

    val store =  KeyStore(dir)


    val deadline = 10.seconds.fromNow

    while(deadline.hasTimeLeft) {
        val key = scala.util.Random.alphanumeric.take(10).mkString
        store.insert(key, key)  
    }

    store.insert("testkey", "value")

    assert(store.get("testkey").get == "value")

     directory.deleteRecursively()
  }
}