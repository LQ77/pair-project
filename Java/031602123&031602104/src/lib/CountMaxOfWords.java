package lib;
import java.util.*;
//统计最多的10个单词及其词频
public class CountMaxOfWords {
	public static void bbsort(int[] a, String[] wd, int size,int nn){
		int temp_a;
		String temp_wd;
		int t;
		if(size > nn)
			t = nn;
		else
			t = size;
		for(int i=0; i<t; i++){
			for(int j=i+1; j<t; j++){
				char[] w1 =wd[i].toCharArray();
				char[] w2 =wd[j].toCharArray();
				if((a[i] > a[j])||((w1[0] < w2[0])&&(a[i] == a[j]))){
					temp_a = a[j];
					a[j] = a[i];
					a[i] = temp_a;
					temp_wd = wd[j];
					wd[j] = wd[i];
					wd[i] = temp_wd;
				}
			}
		}
	}

	public static void Sort(Map<String, Integer> m, int nn){
		int s = m.size();
		int[] a = new int[nn];
		a[0] = 0;
		int type = 0,i = 0;
		String[] wd = new String[nn];
		for(Map.Entry<String, Integer> entry : m.entrySet()){
			String k = entry.getKey();
			int v = entry.getValue();
			if((type < nn)&&(type != s)){
				a[type] = v;
				wd[type] = k;
				type++;
			}
			i++;
			if((type == s)||(type == nn)){
				if((v > a[0])&&(i > type-1)){
					a[0] = v;
					wd[0] = k;
				}
				bbsort(a,wd,s,nn);
			}
		}
		int op;
		if(s > nn)
			op = nn;
		else
			op = s;
		for(i=op-1;i>=0;i--){
			System.out.println("<"+wd[i]+">: "+a[i]);	
		}
	}
	
}
