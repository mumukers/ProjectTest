package JavaseProjects.single单例设计模式;

public class Hello {
    public static void main(String[] args) {
        for (String str:args){
            System.out.println(str);
        }
    }
}

class Girlfriend{
    //单例模式之饿汉式
    /*private String name;
    private static Girlfriend gr=new Girlfriend("zp");
    private Girlfriend(String name){
        this.name=name;
    }
    public static Girlfriend getInstance(){
        return gr;
    }*/

    //单例模式之懒汉式
    private String name;
    private static Girlfriend gr;
    private Girlfriend(String name){
        this.name=name;
    }
    public static Girlfriend getInstance(){
        if(gr==null){
            gr=new Girlfriend("张攀");
        }
        return gr;
    }
}
