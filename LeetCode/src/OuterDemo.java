
public class OuterDemo{
public static void main(String[] args){
 Outer.method.show();
	}
}
 interface Inter
{
  void show();
}
class Outer{
  public static Inter method;
}
//补齐代
