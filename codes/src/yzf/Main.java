package yzf;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        while(cnt>0){
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int res = 0;
            int people = n/6;
            res += people*Math.min(3*a,2*b);
            people = n%6;
            if(people==1 || people == 2){
                res += Math.min(a, b);
            } else if(people == 3){
                res += Math.min(2*a,b);
            } else if(people == 4){
                res += Math.min(Math.min(2*a,2*b),a+b);
            } else if(people == 5){
                res += Math.min(Math.min(3*a,2*b),a+b);
            }
            System.out.println(res);
            cnt--;
        }
    }
}
