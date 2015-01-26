
/*
 * Quick-find implementation for the Dynamic Connectivity Problem
 * Author: Chafic Najjar
 */

import java.util.StringTokenizer;
import java.io.*;

public class QuickFind {

    private static int count;
    private static int[] id;

    public QuickFind(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++)
            id[i] = i;
    }

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("tinyUF.txt");
            BufferedReader br = new BufferedReader(fr);

            int count = Integer.parseInt(br.readLine());

            QuickFind quickFind = new QuickFind(count);

            String line;
            while( (line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, " ");
                int p = Integer.parseInt(tokenizer.nextToken());
                int q = Integer.parseInt(tokenizer.nextToken());
                if (union(p, q))
                   System.out.println(p + "-" + q); 
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } 
    }

    public static int getCount() {
        return count;
    }

    public static boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static int find(int p) {
        return id[p]; 
    }

    public static boolean union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return false;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pId)
                id[i] = qId;
        count--;
        return true;
    }

}
