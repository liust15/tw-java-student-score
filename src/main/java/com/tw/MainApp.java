package com.tw;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: 2018-04-04-04-52-17-1522817537
 * @description: 启动类，整体类
 * @author: liust
 * @create: 2018-04-12 14:23
 **/
public class MainApp {
    static MainApp mainApp = new MainApp();
    Map<String, Map<String, Object>> mapMap = new HashMap();
    public static void main(String[] args) {
        mainApp.menu();
    }
    //菜单
    public void menu() {
        System.out.println("1. 添加学生\n" + "2. 生成成绩单\n" + "3. 退出\n" + "请输入你的选择（1～3）：");
        String enterResult = new Util().getEnter();
        if (enterResult.equals("1")) {//添加学生信息
            Map<String, Object> map = new AddStudent().addStudent();
            mapMap.put((String) map.get("学号"), map);
            System.out.println("学生" + map.get("姓名") + "的成绩被添加\n");
        } else if (enterResult.equals("2")) {//查询学生信息
            System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
            new Search(mapMap).search();
        } else if (enterResult.equals("3")) {
            System.out.println("欢迎下次使用！");
            System.exit(0);
        }else {
            System.out.println("你的输入有误，请重新输入！");
        }
        menu();
    }

}
