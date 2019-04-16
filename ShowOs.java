package sunshineTravel;
import java.util.LinkedList;
import java.util.Scanner;
public class ShowOs {
	
	Scanner in = new Scanner(System.in);
	OrderSys oSy;
	LinkedList oList = new LinkedList();
	private String chos;
	int choose;
	
	//订单界面
		public void listSys() {
			System.out.println("************Welcome to use the Sunshine Travel Order System*************");
			//显示功能列表
			while(true) {
			System.out.println("What are you want: ");
			System.out.println("1. Place order, 2.Check order, 3.Add order, 4.Deleted order, 5.Exit");
			System.out.print("Input 1 to 6:");
			choose = in.nextInt();//选择需求
			switch(choose) {
			case 1:
				//下单
				System.out.println( "***********Place Order**************");
				System.out.println( "Please input the date:");
				int dates = in.nextInt();
				System.out.println("Please input the phone(11digits):");
				long phone= in.nextLong();
				if((phone+"").length()!=11) {
					try {
					throw new Exception();				
					}
					catch(Exception e) {
						System.out.println("The phone num shuld be 11 digits!");
					}
					
				}
				oSy= new OrderSys(dates,phone);			
				while(true) {					
					oList=oSy.Order();
					//结束循环
					System.out.println("Continue?(Y/N):");
					chos=in.next();
					if(chos.equalsIgnoreCase("N")) {	
						break;
					}	
				}
				
				System.out.println("The info below:");
				oSy.checkL();
				
				break;
			case 2:
				System.out.println( "***********Check Order**************");
				try {
				oSy.checkL();
				}catch(NullPointerException e) {
					System.out.print("There is null list.");
				}
				//查单
				break;
			case 3:
				//添加订单
				System.out.println( "***********Add Order**************");
				oSy.addL();
				break;
			case 4:
				//删除订单
				System.out.println( "***********delete Order**************");
				oSy.delList();
				break;
			case 5:
				//退出系统
				System.out.println( "***********Exit System**************");
				System.exit(0);
				break;
			default:
				System.out.println( "Input Error!Please input 1 to 5!");
				break;	
			}
			
		}
		}

}
