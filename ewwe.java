import java.util.*;

class Solution {
    public int[] solution(int n, int m, int[] x, int[] y, int[] z) {

        int[] answer = new int[m];

        int [][] map = new int[n][n];

        for(int i=0; i<m; i++) {
            map[x[i]-1][y[i]-1] = z[i];
            map[y[i]-1][x[i]-1] = z[i];
        }

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 200000;
                }
            }
        }
        for(int i=0; i<map.length; i++) {
            map[i][i] = 0;
        }

        ArrayList[][] list = new ArrayList[m][m];
        for(int i=0; i<list.length; i++) {
            for(int j=0; j<list.length; j++) {
                list[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<m; i++) {
            list[x[i]-1][y[i]-1].add(i+1);
            list[y[i]-1][x[i]-1].add(i+1);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k =0; k<n; k++) {
                    if(map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i]+map[i][k];
                        list[j][k].clear();
                        list[j][k].addAll(list[j][i]);
                        list[j][k].addAll(list[i][k]);
                    }
                }
            }
        }

        Map<Integer, Integer> result = new HashMap<Integer,Integer>();
        for(int i=0; i<m; i++) {
            result.put(i,0);
        }
        for(int i=0; i<list.length; i++) {
            for(int j=0; j<list[i].length; j++) {
                for(int k=0; k<list[i][j].size(); k++) {
                    result.put((int)list[i][j].get(k)-1, result.get((int)list[i][j].get(k)-1)+1);
                }
            }
        }

        List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(result.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer,Integer>>() {

            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                if(o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o1.getKey() - o2.getKey();
                }
            }
        });

        for(int i=0; i<entryList.size(); i++) {
            answer[i] = entryList.get(i).getKey()+1;
        }
        return answer;
    }
}