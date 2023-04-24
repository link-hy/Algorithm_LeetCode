package Com.Spring2023;

public class c1 {
    public static void main(String[] args) {
        int[] s={6,2,2,6,9,8,5,7};
        int[]ans=Solutionc1.supplyWagon(s);
        for (int an : ans) {
            System.out.print(an+" ");
        }
    }
}

class Solutionc1 {
    public static int[] supplyWagon(int[] supplies) {
        int lengthA= supplies.length/2;//整理后的车队长度
        int length= supplies.length;//原车队长度
        int k=1,j=1,min=0;// min - k;  i - j

        while(length>lengthA) {//对车队长度修整并递减
            int sum=1000000;//要求整合最小的，那我取一个最大的，来记录
            boolean tag=true;
            j=1;
            for (int i = 0; i < supplies.length&&j< supplies.length; i++) {//遍历车队，i j 是相邻的两辆车
                //1. 找车 i
                while (supplies[i]==0) {//数值为 0，表示车子已经被合并，不存在了
                    i++;
                    if(i>= supplies.length){
                        tag=false;//结束标志
                        break;
                    }
                }
                if(!tag)//结束标志，结束 for 循环
                    break;

                //2. 找车 j
                j=i+1;
                if(j>= supplies.length)
                    break;
                while (supplies[j]==0) {
                    j++;
                    if(j>= supplies.length){
                        tag=false;
                        break;
                    }
                }
                if(!tag)//结束标志，结束 for 循环
                    break;

                if(supplies[i]+supplies[j]<sum){//找到较小的相邻两车
                    min=i;
                    k=j;
                    sum=supplies[i]+supplies[j];
                }

            }
            //找到当前车队最小的相邻两车，合并
            supplies[min]=supplies[min]+supplies[k];
            supplies[k]=0;
            length--;
        }

        //返回新车队数组
        int[] ans=new int[lengthA];
        j=0;
        for (int i = 0; i < lengthA&&j< supplies.length; i++,j++) {
            while (supplies[j]==0)
                j++;
            ans[i]=supplies[j];
        }
        return ans;
    }
}
