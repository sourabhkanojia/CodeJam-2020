import java.io.*;
import java.util.*;
import java.awt.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        int z=1;
        while(t-->0) {
            int n = sc.nextInt();
            Point[] p = new Point[n];
            for (int i = 0; i < n; i++) p[i] = new Point(sc.nextInt(), sc.nextInt());
            LinkedList<Node> ll = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int s = p[i].x, e = p[i].y;
                ll.add(new Node(s, 's', i));
                ll.add(new Node(e, 'e', i));
            }
            Collections.sort(ll, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.x==o2.x){
                        if(o1.c=='e')return -1;
                        else return 1;
                    }
                    else return o1.x-o2.x;
                }
            });
            boolean f=false;
            char[] c = new char[n];
            int cameron = -1, jamie = -1;
            for (Node node : ll) {
                if (node.c == 's') {
                    if (cameron == -1) {
                        cameron = node.i;
                        c[node.i] = 'C';
                    }
                    else if(jamie==-1) {
                        jamie = node.i;
                        c[node.i] = 'J';
                    }
                    else {
                        f=true;
                        break;
                    }
                } else {
                    if (cameron == node.i) cameron = -1;
                    else jamie = -1;
                }
            }
            if(f) sb.append("Case #"+z+": IMPOSSIBLE");
            else {
                sb.append("Case #"+z+": ");
                for (int i = 0; i < n; i++) sb.append(c[i]);
            }
            sb.append("\n");
            z++;
        }
        System.out.println(sb);
    }
}
class Node{
    int x,i;
    char c;
    public Node(int x,char c,int i){
        this.x=x;
        this.c=c;
        this.i=i;
    }
}
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
