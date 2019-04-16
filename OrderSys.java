package sunshineTravel;
import java.util.LinkedList;
import java.util.Scanner;
public class OrderSys {
	
	protected int dates;
	protected long phone;
	private int choose;
	private String chos;
	private String name;
	private int age;
	
	public OrderSys(int dates,long phone) {
		this.dates=dates;
		this.phone=phone;
	}
	
	LinkedList<Edult> guestList = new LinkedList<Edult>();//存放顾客信息
	Edult person;
	Scanner in = new Scanner(System.in);
	
	//下单功能
	public LinkedList<Edult> Order() {
		System.out.println( "Are you a 1.Edult,2.Elder(over 65),3.Child(input 1-3):");
		choose = in.nextInt();
		System.out.print( "Name:");
		name = in.next();
		System.out.print( "Age:");
		age = in.nextInt();
		switch(choose) {
		case 1:
			person=new Edult(name,age);
			break;
		case 2:
			if(age<65) {
			System.out.println("Not over 65,you are Eldut.");
			person=new Edult(name,age);
			}else {
			person=new Elder(name,age);
			}
			break;
		case 3:
			System.out.print("Woubld you need the bed(Y/N):");
			chos=in.next();
			if(chos.equalsIgnoreCase("Y")) {
				System.out.print("Will cause 30rmb fee,please note.");
			    person=new Child(name,age,30);	
			}else {
				person=new Child(name,age,0);		
			}
			break;
		default:
			break;
		}		
		guestList.add(person);
		
		return guestList;
	}
	
	//查单功能
	public void checkL() {
		for(Object p :guestList) {
			Edult pp =(Edult)p;
			System.out.println("Name: "+pp.name+" Cost:"+pp.cost);
		}
	}
	//添加功能
	public void addL() {
		System.out.println( "Are you a 1.Edult,2.Elder(over 65),3.Child(input 1-3):");
		choose = in.nextInt();
		System.out.print( "Name:");
		name = in.next();
		System.out.print( "Age:");
		age = in.nextInt();
		switch(choose) {
		case 1:
			person=new Edult(name,age);
			break;
		case 2:
			if(age<65) {
			System.out.println("Not over 65,you are Eldut.");
			person=new Edult(name,age);
			}else {
			person=new Elder(name,age);
			}
		break;
		case 3:
			System.out.print("Woubld you need the bed(Y/N):");
			chos=in.next();
			if(chos.equalsIgnoreCase("Y")) {
				System.out.print("Will cause 30rmb fee,please note.");
			    person=new Child(name,age,30);	
			}else {
				person=new Child(name,age,0);		
			}
			break;
		default:
			break;
	  }
		guestList.add(person);
	
	}
	//删除功能
	public void delList() {
		System.out.print("Which name you want to deleted?");
		String n = in.next();
		for(Object a : guestList) {
			Edult aa = (Edult)a;
			if(aa.name.equals(n)) {
				guestList.remove(aa);
				break;
			}
		}
		
	}
}
