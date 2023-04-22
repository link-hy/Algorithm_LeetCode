package Com.Spring2023;

import java.util.HashSet;
import java.util.Set;

public class c2 {
    public static void main(String[] args) {
        String[] expeditions = {"Alice->Dex","","Dex"};
        System.out.println(Solutionc2.adventureCamp(expeditions));
    }
}

class Solutionc2 {
    public static int adventureCamp(String[] expeditions) {
        /**
         * 处理第一个
         */
        int ans=-1;// 最大新到访的个数
        // 拆解字符串到hashset
        Set<String> setstr0=new HashSet<>();
        int count0;

        if(expeditions[0].length()!=0){
            count0=1;
            for (int i = 0; i < expeditions[0].length(); i++) {
                if (expeditions[0].charAt(i) == '-')
                    count0++;
            }

            int bigen = 0, end;
            for (int i = 0; i < count0; i++) {//取出已知的营地
                end = bigen;
                while (end < expeditions[0].length() && expeditions[0].charAt(end) != '-') {
                    end++;
                }
                setstr0.add(expeditions[0].substring(bigen, end));
                bigen = end + 2;
            }
        }

        int index=10000;//记录下标最小
        for (int i = 1; i < expeditions.length; i++) {//看当前有几个 包含前面的
            /**
             * 处理第i个记录
             */
            if(expeditions[i].length()==0)
                continue;

            int countexp=1;//有多少个地方
            for (int j = 0; j < expeditions[i].length(); j++) {
                if (expeditions[i].charAt(j) == '-')
                    countexp++;
            }

            Set<String> setstr=new HashSet<>();

            int bigen = 0, end;
            for (int j = 0; j < countexp; j++) { //取出记录i到达的营地
                end = bigen;
                while (end < expeditions[i].length() && expeditions[i].charAt(end) != '-') {
                    end++;
                }
                setstr.add(expeditions[i].substring(bigen, end));
                bigen = end + 2;
            }

            //比较 setstr0  - setstr****************还要把 setstr的内容加入setstr0
            count0=setstr0.size();
            int countn=setstr.size();

            if(count0==0){//初始营地为空
                if(ans<countn){//当前 new到访记录更多
                    ans=countn;
                    index=i;
                }
            }else{
                int k=0;
                for (String s : setstr) {//看初始到访记录是否存在于当前到访记录
                    if(setstr0.contains(s))
                        k++;
                }

                if(countn-k <= 0)//当前new到访记录 0
                    continue;
                if(ans<countn-k){//当前 new到访记录更多
                    ans=countn-k;
                    index=i;
                }
            }

            setstr0.addAll(setstr);

        }
        if(index==10000)//不变，表示没新的到访地
            return -1;
        return index;
    }
}
