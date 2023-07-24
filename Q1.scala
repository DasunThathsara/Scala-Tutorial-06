package P6

object Q1 extends App{
  def encrypt(c:Char, key:Int):Char={
    if(c.isUpper){
      if(c == 'Z')
        ('A'.toInt + key - 1).toChar;
      else
        (c.toInt + key).toChar;
    }
    else if(c == ' '){
      ' ';
    }
    else{
      if(c == 'z')
        ('a'.toInt + key - 1).toChar;
      else
        (c.toInt + key).toChar;
    }
  }

  def decrypt(c:Char, key:Int):Char={
    if(c.isUpper){
      if(c == 'A')
        ('Z'.toInt - key + 1).toChar;
      else
        (c.toInt-key).toChar;
    }
    else if (c == ' ') {
      ' ';
    }
    else{
      if(c == 'a')
        ('z'.toInt - key + 1).toChar;
      else
        (c.toInt - key).toChar;
    }
  }

  def cipher(str:String, func:(Char, Int)=>Char, key:Int):String={
    str.map(func(_, key));
  }

  val str = "Dasun";
  val key = 1;
  println("Original String: " + str);
  println("Encrypted String: " + cipher(str, encrypt, key));
  println("Decrypted String: " + cipher(cipher(str, encrypt, key), decrypt, key));
}
