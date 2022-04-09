package JavaseProjects.HouseRent.View;

import JavaseProjects.HouseRent.Server.Server;
import JavaseProjects.HouseRent.Utils.Utility;
import JavaseProjects.HouseRent.domain.House;

public class mainMenu {
    private boolean loop=true;
    private Server service=new Server(10);

    private void listHouse(){
        System.out.println("============房屋列表============");
        System.out.println("编号\t房主\t  电话\t\t  地址\t\t租金\t\t状态");
        service.list();
    }
    public void addHouse(){
        System.out.println("============新增房屋============");
        System.out.print("输入姓名：");
        String name = Utility.readString(5);
        System.out.print("输入电话号码：");
        String phone = Utility.readString(12);
        System.out.print("输入地址：");
        String address = Utility.readString(15);
        System.out.print("输入租金：");
        int rent = Utility.readInt();
        System.out.print("输入房屋状态：");
        String state = Utility.readString(3);
        House newhouse = new House(0, name, phone, address, rent, state);
        if(service.add(newhouse)){
            System.out.println("============添加成功============");
        }

    }
    public void delHouse(){

    }
    public void mainMenu(){
        do{
            System.out.println("1.新增房屋");
            System.out.println("2.查找房屋");
            System.out.println("3.删除房屋");
            System.out.println("4.修改房屋信息");
            System.out.println("5.房屋列表");
            System.out.println("6.退出系统");
            System.out.println("请输入你的选择：");
            char key = Utility.readMenuSelection();
            switch (key){
                case '1':
                    //新增房屋
                    addHouse();
                    break;
                case '2':
                    //查找房屋
                    break;
                case '3':
                    //删除房屋
                    break;
                case '4':
                    //修改房屋信息
                    break;
                case '5':
                    //房屋列表
                    listHouse();
                    break;
                case '6':
                    //新增房屋
                    loop=false;
                    break;

            }
        }while (loop==true);
    }
}
