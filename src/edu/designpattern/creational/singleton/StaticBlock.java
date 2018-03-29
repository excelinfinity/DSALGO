import java.util.*;
import java.io.*;
import java.lang.*;
class StaticBlock{

  private static StaticBlock instance;

  private StaticBlock() {}

  static{
    try{
      instance = new StaticBlock();
    }catch(Exception e){
      throw new RuntimeException("error during creating singleton class");
    }
  }

  public static StaticBlock getInstance(){
    return instance;
  }
}