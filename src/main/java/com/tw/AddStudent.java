package com.tw;
import java.util.HashMap;
import java.util.Map;
/**
 * @program: student-grade-command-basic-java
 * @description: 添加学生信息
 * @author: liust
 * @create: 2018-04-12 14:51
 **/
public class AddStudent {
    public Map<String, Object> addStudent() {
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
        String[] studentArray = new Util().getEnter().split("，");
        int sum = 0;
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("姓名", studentArray[0]);
            map.put("学号", studentArray[1]);
            for (int i = 2; i < studentArray.length; i++) {
                String[] studentScore = studentArray[i].split("：");
                if (isCheck(studentScore[0]).equals(null)) {
                    addStudent();
                }
                map.put(studentScore[0], Integer.valueOf(studentScore[1]));
                sum += Integer.valueOf(studentScore[1]);
            }
            map.put("总分", sum);
            map.put("平均分", sum / 4);
        } catch (Exception e) {
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
            addStudent();
        }
        return map;
    }
    //检查各科成绩格式是否正确
    public String isCheck(String string) {
        if (string.equals("数学") || string.equals("语文") || string.equals("编程") || string.equals("英语")) {
            return string;
        } else {
            return null;
        }
    }
}
