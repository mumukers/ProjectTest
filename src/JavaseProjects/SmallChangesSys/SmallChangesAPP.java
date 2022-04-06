package JavaseProjects.SmallChangesSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangesAPP {
    private static StringBuilder detail = new StringBuilder("---------零钱通明细---------");
    private static boolean login = true;
    private static double balance = 100.0;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static Scanner sc = new Scanner(System.in);
    private static double money = 0;

    public static void menu(){
  do

    {
        System.out.println("==========零钱通==========");

        System.out.println("\t  1.零钱通明细");
        System.out.println("\t  2.收益入账");
        System.out.println("\t  3.消费");
        System.out.println("\t  4.退   出");

        System.out.print("请输入你的选择：");
        int i = sc.nextInt();
        switch (i) {
            case 1://打印明细
                printDetails();
                break;
            case 2://收益入账
                moneyIN();
                break;
            case 3://消费
                moneyOut();
                break;
            case 4://退出
                userLogout();
                break;
            default:
                System.out.println("输入有误，请重新输入");
        }

    }while(login);
}

    private static void printDetails() {
        System.out.println(detail.toString());
    }

    private static void moneyIN() {
        System.out.print("请输入入账钱数：");
        money = sc.nextDouble();
        if (money <= 0) {
            System.out.println("输入有误");
        } else {
            balance += money;
            detail.append("\n收益入账 +" + money + "\t" + sdf.format(new Date()) + "\t余额为：" + balance);
        }
    }

    private static void moneyOut() {
        System.out.print("请输入消费钱数：");
        money = sc.nextDouble();
        if (money <= 0) {
            System.out.println("输入有误");
        } else if (balance - money < 0) {
            System.out.println("余额不足");
        } else {
            balance = balance - money;
            detail.append("\n消费支出 -" + money + "\t" + sdf.format(new Date()) + "\t余额为：" + balance);
        }

    }

    private static void userLogout() {
        String answer = "";
        while (true) {
            System.out.print("您是否要退出(Y/N):");
            answer = sc.next();
            if ("Y".equals(answer) || "N".equals(answer)) {
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
        if (answer.equals("Y")) {
            login = false;
        }
    }
}
