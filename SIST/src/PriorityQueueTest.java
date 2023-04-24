import java.util.Collections;
import java.util.PriorityQueue;;
public class PriorityQueueTest {
	public static void main(String[] args) {
		// �켱������ ���� ���� ��
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		// �켱������ ���� ���� ��
		PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		// �켱����ť�� �� �߰�
		priorityQueue.add(1);
		priorityQueue.add(2);
		priorityQueue.offer(3);
		// ù��° ���� ��ȯ�ϰ� ����. ���� ����ִٸ� null ��ȯ
		System.out.println(priorityQueue.poll());
		// ù��° �� ��ȯ�ϰ� ����. ����ִٸ� ���� �߻�
		System.out.println(priorityQueue.remove());
		// �켱���� ť ����
		priorityQueue.clear();
		
		// �켱���� ť���� �켱������ ���� ���� �� ���
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
