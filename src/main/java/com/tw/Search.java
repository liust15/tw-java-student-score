package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: student-grade-command-basic-java
 * @description:
 * @author: liust
 * @create: 2018-04-12 14:59
 **/
public class Search {
    Map<String, Map<String, Object>> mapMapScore;

    public Search(Map<String, Map<String, Object>> mapMap) {
        this.mapMapScore = mapMap;
    }

    public void search() {
        String[] idArray = new Util().getEnter().split("，");
        StringBuffer stringBuffer = new StringBuffer("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================");
        int count = 0;
        int allSum = 0;
        List<Integer> list = new ArrayList<>();
        for (String str : idArray) {
            Map<String, Object> map = getStuById(str);
            if (map == null) break;
            count++;
            String name = String.valueOf(map.get("姓名"));
            int math = isExists(map, "数学");
            int chinese = isExists(map, "语文");
            int english = isExists(map, "英语");
            int programme = isExists(map, "编程");
            int sum = (int) map.get("总分");
            int ave = (int) map.get("平均分");
            allSum += sum;
            list.add(sum);
            stringBuffer.append("\n" + name + "|" + math + "|" + chinese + "|" + english + "|" + programme + "|" + ave + "|" + sum);
        }
        stringBuffer.append("\n========================\n" +
                "全班总分平均数：" + isZero(allSum, count) + "\n" +
                "全班总分中位数：" + new Util().GetMedian(list));
        System.out.println(stringBuffer);
    }  //判断是否存在

    //得到平均分
    public double isZero(int sum, int count) {
        if (count == 0)
            return 0;
        return sum / count;
    }

    public int isExists(Map<String, Object> map, String string) {
        int score = 0;
        try {
            score = (int) map.get(string);
        } catch (Exception e) {
            return 0;
        }
        return score;
    }

    //根据学号获取学生信息
    public Map getStuById(String id) {
        if (!mapMapScore.containsKey(id)) {
            return null;
        }
        return mapMapScore.get(id);
    }
}
