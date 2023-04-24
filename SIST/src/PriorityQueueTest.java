import java.util.Collections;
import java.util.PriorityQueue;;
public class PriorityQueueTest {
	public static void main(String[] args) {
		// 우선순위가 낮은 순자 순
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		// 우선순위가 높은 숫자 순
		PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		// 우선순위큐에 값 추가
		priorityQueue.add(1);
		priorityQueue.add(2);
		priorityQueue.offer(3);
		// 첫번째 값을 반환하고 제거. 만일 비어있다면 null 반환
		System.out.println(priorityQueue.poll());
		// 첫번째 값 반환하고 제거. 비어있다면 예외 발생
		System.out.println(priorityQueue.remove());
		// 우선순위 큐 비우기
		priorityQueue.clear();
		
		// 우선순위 큐에서 우선순위가 가장 높은 값 출력
		priorityQueue.offer(2);
		priorityQueue.offer(1);
		priorityQueue.offer(3);
		System.out.println(priorityQueue.peek());
		priorityQueue2.offer(2);
		priorityQueue2.offer(1);
		priorityQueue2.offer(3);
		System.out.println(priorityQueue2.peek());
	}
}
