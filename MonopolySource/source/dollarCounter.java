package source;



public class dollarCounter {
      
  //THIS METHOD IS FINISHED
  public static int[] dollarsCounts(int money){
    int[] dollarArray = new int[7];
    dollarArray[6] = money / 500;
    money = money % 500;
    dollarArray[5] = money / 100;
    money = money % 100;
    dollarArray[4] = money/50;
    money = money % 50;
    dollarArray[3] = money/20;
    money = money % 20;
    dollarArray[2] = money/10;
    money = money % 10;
    dollarArray[1] = money/5;
    money = money % 5;
    dollarArray[0] = money;

  return(dollarArray);

  }
}