package code;

public class c59 {
    public static void main(String[] args) {
        int n=2;
        int[][] ans = Solution59.generateMatrix(n);

        for (int[] an : ans) {
            System.out.println();
            for (int i : an) {
                System.out.printf("%2d ",i);
            }
        }
    }
}


class Solution59 {
    public static int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        if(n==1) {
            ans[0][0] = 1;
            return ans;
        }
        int direction=0;//0 right 1 down 2 left 3 up
        int i=0,j=-1;//Coordinates
        int k = 1;
        boolean tag=true;
        while(tag){
            switch (direction){
                case 0:
                    j++;
                    for (; j < n; j++) {
                        if(ans[i][j]!=0)
                            break;
                        ans[i][j]=k;
                        k++;
                    }
                    j--;
                    direction=(direction + 1) % 4;
                    if(ans[i+1][j]!=0)
                        tag=false;
                    break;
                case 1:
                    i++;
                    for (; i < n; i++) {
                        if(ans[i][j]!=0)
                            break;
                        ans[i][j]=k;
                        k++;
                    }
                    i--;
                    direction=(direction + 1) % 4;
                    if(ans[i][j-1]!=0)
                        tag=false;
                    break;
                case 2:
                    j--;
                    for (; j >=0 ; j--) {
                        if(ans[i][j]!=0) {
                            break;
                        }
                        ans[i][j]=k;
                        k++;
                    }
                    j++;
                    direction=(direction + 1) % 4;
                    if(ans[i-1][j]!=0)
                        tag=false;
                    break;
                case 3:
                    i--;
                    for (; i >=0; i--) {
                        if(ans[i][j]!=0)
                            break;
                        ans[i][j]=k;
                        k++;
                    }
                    i++;
                    direction=(direction + 1) % 4;
                    if(ans[i][j+1]!=0)
                        tag=false;
                    break;
            }

        }
        return ans;
    }
}
