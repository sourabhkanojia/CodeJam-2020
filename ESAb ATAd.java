import java.awt.*;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t=sc.nextInt(),b=sc.nextInt();
        while(t-->0){
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<b;i++){
                ans.append("2");
            }
            int right=1,position=0,cmm=0,left=0;
            while(position<b/2){
                if(right>=11&&right%10==1){
                    if(cmm!=0){
                        System.out.println(cmm);
                        char ch=sc.next().charAt(0);
                        if(ch!=ans.charAt(cmm-1)){
                            for(int k=0;k<b;k++){
                                if(ans.charAt(k)=='1'){
                                    ans.replace(k,k+1,"0");
                                }
                                else if(ans.charAt(k)=='0'){
                                    ans.replace(k,k+1,"1");
                                }
                            }
                        }
                    }
                    else{
                        System.out.println(2);
                        char ch=sc.next().charAt(0);
                    }
                    if(left!=0){
                        System.out.println(left);
                        char ch=sc.next().charAt(0);
                        if(ch!=ans.charAt(left-1)){
                            ans.reverse();
                        }
                    }
                    else{
                        System.out.println(2);
                        char ch=sc.next().charAt(0);
                    }
                }
                else{
                    System.out.println(position+1);
                    String ch=sc.next();
                    ans.replace(position,position+1,ch);
                    int temp=b-position;
                    System.out.println(temp);
                    ch=sc.next();
                    ans.replace(temp-1,temp,ch);
                    if(ans.charAt(position)==ans.charAt(temp-1)){
                        cmm=position+1;
                    }
                    else{
                        left=position+1;
                    }
                    position++;
                }
                right+=2;
            }
            System.out.println(ans);
            char ver=sc.next().charAt(0);
            if(ver=='N'){
                return;
            }
        }
    }
}
//Case #x: k r c
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
