/** @important
 *  数飞机

 给出飞机的起飞和降落时间的列表，用 interval 序列表示. 请计算出天上同时最多有多少架飞机？

 注意事项

 如果多架飞机降落和起飞在同一时刻，我们认为降落有优先权。

 样例
 对于每架飞机的起降时间列表：[[1,10],[2,3],[5,8],[4,7]], 返回3。
 */
/
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     * 利用map 存储起点和着落时间点，相同的起飞时间 val+1, 相同的着落时间 val - 1
     * 利用 set 集合 排序遍历 依次累加map里时间点的val 更新最大数量
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        Map<Integer> map = new HashMap<>();
        Set<Integer> set = new Set<>();
        for(int i=0; i<airplanes.size(); i++){
            int start = airplanes[i].start;
            int end = airplanes[i].end;
            map.put(start, map.containsKey(start) ? map.get(start) + 1 : 1);
            map.put(end, map.containsKey(end) ? map.get(end) - 1, -1);
            set.add(start);
            set.add(end);
        }
        Iterator<Integer> temp = set.iterator();
        int count = 0;
        int maxAir = Integer.MIN_VALUE;
        while(temp.hasNext()){
            count += map.get(temp.next());
            maxAir = Math.max(maxAir, count);
        }
        return maxAir;
    }
}