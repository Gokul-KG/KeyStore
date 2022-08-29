package keystore

import btree.FileBPlusTree

case class StringKeyStore(file:String) {

    val ORDER = 100
    val bBlusTree =  new FileBPlusTree[String, String]( file, ORDER)
    def insert(key:String , value:String): Boolean = bBlusTree.insert(key, value)
    def update(key:String, value:String): Boolean =  bBlusTree.insert(key, value)
    def get(key:String):Option[String] =  bBlusTree.search(key)
    def delete(key:String): Boolean =  bBlusTree.delete(key)

}


case class KeyStore(dbPath:String) {

    import java.io.File

    val directory = new File(dbPath)
    if (!directory.exists) {
        directory.mkdir
        // If you require it to make the entire directory path including parents,
        // use directory.mkdirs(); here instead.
    }

    val fileName = dbPath+"/file"

    val startingKeyList = (('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9'))

    val startingKeyListMap = startingKeyList.map(char => (char, StringKeyStore(fileName+char))).toMap

    val otherKeyStore = StringKeyStore( fileName + "other")


    def findstotoreForKey(key:String) :StringKeyStore = {

       key.headOption.map( char => startingKeyListMap.getOrElse(char, otherKeyStore)).getOrElse(otherKeyStore)

    }


    def insert(key: String, value: String): Boolean = findstotoreForKey(key).insert(key, value)

    def update(key: String, value: String): Boolean = findstotoreForKey(key).insert(key, value)

    def get(key: String): Option[String] = findstotoreForKey(key).get(key)

    def delete(key: String): Boolean = findstotoreForKey(key).delete(key)



}





