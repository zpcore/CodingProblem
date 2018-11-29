import java.util.*;


class Interval {
	int start;
	int end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return "["+String.valueOf(start)+","+String.valueOf(end)+"]";
	}
}

class MinMeetingRoom {

	public static void main(String[] args) {
		MinMeetingRoom solution = new MinMeetingRoom();
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(0,1));
		intervals.add(new Interval(0,5));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(7,10));
		intervals.add(new Interval(8,9));
		Interval[] input = intervals.toArray(new Interval[intervals.size()]);
		List<List<Interval>>  result = solution.minMeetingRoom(input);
		for(List<Interval> a:result) {
			for(Interval b:a) System.out.print(b+",");
			System.out.println();
		}
	}

	public List<List<Interval>> minMeetingRoom(Interval[] intervals) {
		Map<Interval,Integer> hm = new HashMap<>(); // map interval to the meeting room
		Arrays.sort(intervals,(a,b)->a.start-b.start);
		List<List<Interval>> res = new ArrayList<>();
		PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);
		Deque<Integer> emptyRoom = new ArrayDeque<>();
		for(Interval interval:intervals) {
			while(!pq.isEmpty() && pq.peek().end<=interval.start) {
				int room = hm.get(pq.poll());
				emptyRoom.add(room);
			}
			pq.add(interval);
			if(res.size()<pq.size()) { // add new room
				hm.put(interval,res.size());
				List<Interval> newOpenRoom = new ArrayList<>();
				newOpenRoom.add(interval); 
				res.add(newOpenRoom);
			}else { // use previous empty room (any number in newEmptyRoom is fine)
				int targetRoom = emptyRoom.pollFirst(); // just use the first empty room
				res.get(targetRoom).add(interval);
				hm.put(interval,targetRoom);
			}
		}
		return res;
	}
}