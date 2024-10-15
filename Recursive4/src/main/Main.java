package main;

public class Main {

	public static void main(String[] args) {
		System.out.println("1: " + problem1(8,12));
		System.out.println("2: " + problem2(problem2(problem2(problem2(problem2(10))))));
		System.out.println("3: " + problem3(30, 12));
		System.out.println("4: " + problem4(32));
		System.out.println("5: " + problem5(5));
		System.out.println("6: " + problem6(35, 8));
		int sum = 0;
		for(int i = 1;i <= 10;i++) {
			sum += problem7(i);
		}
		System.out.println("7: " + sum);
		System.out.println("8: " + problem8(problem8(problem8(problem8(18)))));
	}
	public static int problem8(int x) {
		if(x>=10) {
			return problem8(x-5)-2;
		} else if(x >= 7) {
			return problem8(x+4)+6;
		} else {
			return x-4;
		}
	}
	public static int problem7(int x) {
		if(x == 1) {
			return 1;
		}
		return problem7(x-1)+5;
	}
	public static int problem6(int x, int y) {
		if(x>=y) {
			return problem6(x-y,y+2)+y;
		} else {
			return x*x-y;
		}
	}
	public static int problem5(int x) {
		if(x == 1)
			return 8;
		return 2 * problem5(x-1)-4;
	}
	public static int problem4(int x) {
		if(x%2==0) {
			return problem4((x/2)-1) + 3;
		}else if(x>0) {
			return 2 *problem4(x-3)-5;
		} else {
			return x*x-3;
		}
	}
	public static int problem3(int x, int y) {
		if(x > y) {
			return Math.max(problem3(x-4, y+3), problem3(y,x));
		} else {
			return x*y;
		}
	}
	public static int problem1(int x, int y) {
		if(x < y) {
			return problem1(x+1,y-2) + 3;
		} else if(x == y) {
			return x*x + y*y;
		} else {
			return problem1(y-1, x)-1;
		}
	}

	public static int problem2(int x) {
		if(x > 7) {
			return problem2(x-5)-3;
		} else if (x > 3) {
			return problem2(x+2)+2;
		} else {
			return x + 5;
		}
	}
}

/*
1: 136
2: 7
3: 396
4: 10
5: 68
6: 41
7: 235
8: -6
*/
