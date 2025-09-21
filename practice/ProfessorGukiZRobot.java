import java.util.Scanner;
public class ProfessorGukiZRobot{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int xi= sc.nextInt();
        int yi= sc.nextInt();
        int xd= sc.nextInt();
        int yd= sc.nextInt();
        System.out.println(Math.max(Math.abs(xi-xd), Math.abs(yi-yd)));
    }
}