package btree

import java.io.{File, RandomAccessFile, ByteArrayInputStream, ByteArrayOutputStream, DataInputStream, DataInput, DataOutputStream, DataOutput}

import org.scalatest.FunSuite

class BasicSuite extends FunSuite {
  

   test("testing persistance with Integer key") {
    
    val file = newfile
    val t = new FileBPlusTree[Int, String]( file, 3)
    t.insert(1, Seq(3, 4, 5) )
	t.close
		
	val t1 = FileBPlusTree[Int, Any]( file )	
	

    assert(t1.search(1).get == Seq(3, 4, 5))
  }

  test("testing persistance with String key") {
    
    val file = newfile
    val key = "test"
    val t = new FileBPlusTree[String, Any]( file, 3)
    t.insert(key, Seq(3, 4, 5) )
	t.close
		
	val t1 = FileBPlusTree[String, Any]( file )	
	

    assert(t1.search(key).get == Seq(3, 4, 5))
  }

  test("updating key") {
    
    val file = newfile
    val key = "test"
    val t = new FileBPlusTree[String, Any]( file, 3)
    t.insert(key, Seq(3, 4, 5) )
	t.close
		
	val t1 = FileBPlusTree[String, Any]( file )	
	

    assert(t1.search(key).get == Seq(3, 4, 5))

    t1.insert(key, Seq(1, 1, 5))
    t.close
    val t2 = FileBPlusTree[String, Any]( file )	
    assert(t2.search(key).get == Seq(1, 1, 5))

  }

  test("delete key") {
    
    val file = newfile
    val key = "test"
    val t = new FileBPlusTree[String, Any]( file, 3)
    t.insert(key, Seq(3, 4, 5) )
	t.close
		
	val t1 = FileBPlusTree[String, Any]( file )	
	

    assert(t1.search(key).get == Seq(3, 4, 5))

    t1.delete(key)
    t.close
    val t2 = FileBPlusTree[String, Any]( file )	
    assert(t2.search(key) == None)

  }

}




