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
    public void finHouse(){
        System.out.println("============查找房屋============");
        System.out.print("请输入要查找房屋编号(-1退出)：");
        int id = Utility.readInt();
        if(id==-1){
            System.out.println("============退出查找============");
            return;
        }
        int index=service.find(id);
        if (index!=-1){
            System.out.println("编号\t房主\t  电话\t\t  地址\t\t租金\t\t状态");
            System.out.println(service.getHouse(index));
            System.out.println("============查找成功============");
        }else {
            System.out.println("============未找到房屋============");
        }
    }
    public void delHouse(){
        System.out.println("============删除房屋============");
        System.out.print("请输入要删除房屋编号(-1退出)：");
        int id = Utility.readInt();
        if(id==-1){
            System.out.println("============退出删除============");
            return;
        }
        if(service.del(id)){
            System.out.println("============删除成功============");
            return;
        }
            System.out.println("============未找到房屋============");
    }
    public  void updateInfo(){
        System.out.println("============修改房屋信息============");
        System.out.print("请输入修改房屋编号：(-1退出)：");
        int id = Utility.readInt();
        if(id==-1){
            System.out.println("============退出删除============");
            return;
        }
        int index=service.find(id);
        if(index==-1){
            System.out.println("============未找到房屋============");
            return;
        }
        House house= service.getHouse(index);
        System.out.println("请输入姓名("+house.getName()+")：");
        String name = Utility.readString(5, house.getName());
        house.setName(name);

        System.out.println("请输入电话号码("+house.getPhone()+")：");
        String phone = Utility.readString(12, house.getPhone());
        house.setPhone(phone);

        System.out.println("请输入地址("+house.getAddress()+")：");
        String address = Utility.readString(5, house.getAddress());
        house.setAddress(address);

        System.out.println("请输入租金("+house.getRent()+")：");
        int rent = Utility.readInt();
        house.setRent(rent);

        System.out.println("请输入状态("+house.getState()+")：");
        String state = Utility.readString(20, house.getState());
        house.setState(state);

    }
    public void exit(){
        System.out.println("============退出系统============");
        char choice = Utility.readConfirmSelection();
        if(choice=='Y'){
            loop=false;
            return;
        }
        System.out.println("============返回主菜单============");
    }

    public void mainMenu(){
        do{
            System.out.println("============房屋出租系统============");
            System.out.println("1.新增房屋");
            System.out.println("2.查找房屋");
            System.out.println("3.删除房屋");
            System.out.println("4.修改房屋信息");
            System.out.println("5.房屋列表");
            System.out.println("6.退出系统");
            System.out.print("请输入你的选择：");
            char key = Utility.readMenuSelection();
            switch (key){
                case '1':
                    //新增房屋
                    addHouse();
                    break;
                case '2':
                    //查找房屋
                    finHouse();
                    break;
                case '3':
                    //删除房屋
                    delHouse();
                    break;
                case '4':
                    //修改房屋信息
                    updateInfo();
                    break;
                case '5':
                    //房屋列表
                    listHouse();
                    break;
                case '6':
                    //新增房屋
                    exit();
                    break;

            }
        }while (loop==true);
    }
}
