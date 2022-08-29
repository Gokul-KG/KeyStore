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


