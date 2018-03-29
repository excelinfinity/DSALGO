class BillPughSingleton{
  private BillPughSingleton(){}

  private static class BillPughHelper{
    private static final BillPughSingleton instance = new BillPughSingleton();
  }

  public static BillPughSingleton getInstance(){
    return BillPughHelper.instance;
  }
}