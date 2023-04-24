package Com.c0423;
// leetcode c6390
import java.util.*;


public class c3 {
    public static void main(String[] args) {
        int[] nums = {1,-1,-3,-2,3};

        int k = 3, x = 2;
        int[] ans = Solution3.getSubarrayBeauty(nums,k,x);
        for (int an : ans) {
            System.out.print(an + "  ");
        }
    }
}


// map自动排序
class Solution3 {
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];//存放返回结果
        Map<Integer,Integer> nmap=new TreeMap<>();// key 数字 ： value 个数
        for (int i = 0; i < nums.length; i++) { //遍历每一个数字
            if(!nmap.containsKey(nums[i])){//集合中不包含这个数字
                nmap.put(nums[i], 1);
            }else{
                nmap.put(nums[i], nmap.get(nums[i])+1);//集合中包含这个数字,对其 value + 1
            }

            if(i >= k-1){
                int j=0;
                for (int key: nmap.keySet()) {
                    j+=nmap.get(key);
                    if(j >= x) {
                        result[i - k + 1] = key < 0 ? key : 0;
                        break;
                    }
                }

                if(nmap.get(nums[i - k + 1])==1){//集合中包含 1 个这个数字
                    nmap.remove(nums[i - k + 1]);
                }else{
                    nmap.put(nums[i - k + 1], nmap.get(nums[i - k + 1]) - 1);//集合中包含多个这个数字,对其 value - 1
                }
            }
        }

        return result;
    }
}


/*
//数组 hash
class Solution3 {
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];//存放返回结果
        int[] count = new int[101];//数字范围是 -50 ~ 50,共计 100 个
        for (int i = 0; i < nums.length; i++) { //遍历每一个数字
            count[nums[i] + 50]++;//存入一个数
            if (i >= k - 1) {//存入了 k 个数
                for (int j = 0, c = 0; j < 50 && c < x; j++) {
                    c += count[j]; //记录到达第几小
                    if (c >= x) { //到达第 x 小
                        result[i - k + 1] = j - 50;//j 是数组下标，实际值需要 -50
                    }
                }
                count[nums[i - k + 1] + 50]--; //下一步后面将增加一个数，此时去掉前面的一个数
            }
        }
        return result;
    }
}*/

/*
// 暴力排序
class Solution3 {
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int length = nums.length;
        int[] ans=new int[length-k+1];

        for (int i = 0; i < length-k+1; i++) {
            int num=findx(nums,i,k,x);
            if(num<0)
                ans[i]=num;
            else ans[i]=0;
        }
        return ans;
    }
    private static int findx(int[] nums, int i, int k, int x) {
        int[] tems=new int[k];
        for (int j = 0; j < k; j++) {
            tems[j]=nums[i];
            i++;
        }
        Arrays.sort(tems);
        return tems[x-1];
    }
}
*/

