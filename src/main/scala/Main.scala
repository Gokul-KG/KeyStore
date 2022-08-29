import keystore._
object Main extends App {
  val dbPath = "StringKeyStoreFile"
  
  val stringKeyStore =  KeyStore("tmp")
  println("Created store with key and value type as String")

  println("Adding new key and value")

  stringKeyStore.insert("key", "value")

  println("Get key")

  val res = stringKeyStore.get("key")

  println("found value : " + res.get )



  println("updating  key with newvalue")

  stringKeyStore.insert("key", "newvalue")

  println("Get key")

  val res2 = stringKeyStore.get("key")

  println("found value : " + res2.get )

   

  println("delete  key")

  stringKeyStore.delete("key")

  println("Get key")

  val res3 = stringKeyStore.get("key")

  println("found value : " + res3 )


  
}