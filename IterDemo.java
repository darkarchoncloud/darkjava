import java.util.*;

class IterDemo {

public static void main(String[] args) {


ArrayList<String> al = new ArrayList<String>();


al.add("C");
al.add("A");
al.add("E");
al.add("B");
al.add("D");
al.add("F");

System.out.println("Original contents of al: ");

Iterator<String> itr = al.iterator();

while(itr.hasNext()) {

String temp = itr.next();
temp = temp + "$";
System.out.print(temp + " ");

}

System.out.println();

//ʵ����û�䣬iterator���ܸı�Collection����

itr = al.iterator();
while(itr.hasNext())
{
String temp = itr.next();
System.out.print(temp);
}

System.out.println();

ListIterator<String> litr = al.listIterator();

while(litr.hasNext()) {

String element = litr.next();
litr.set(element + "+");
}

//���ڱ��ˣ�listIterator���Ըı�Collection���ݡ�

System.out.print("Modified contents of al: ");
		itr = al.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}

System.out.println();

System.out.print("Modified list backwards: ");
		while (litr.hasPrevious()) {
			String element = litr.previous();
			System.out.print(element + " ");
		}
		System.out.println();


}
}