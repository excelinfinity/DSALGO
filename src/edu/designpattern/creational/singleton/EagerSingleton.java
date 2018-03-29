
/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 28 March'2018()
*/
class EagerSingleton{
  //initialize a constant Object
  private static final EagerSingleton ES= new EagerSingleton();

  private Integer number;
  //private constructor
  private EagerSingleton(){
    number = 30;
  }

  public EagerSingleton getInstance(){
    return ES;
  }
  public void setNumber(Integer n){
    number = n;
  }

  public Integer getNumber(){
    return number;
  }
}