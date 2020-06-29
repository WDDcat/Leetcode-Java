import java.util.Arrays;

public class _1300_Sum_of_Mutated_Array_Closest_to_Target {
	public int findBestValue(int[] arr, int target) {
		
		/*
		 * 	�������⻹����һЩ��
		 * 	
		 * 	������
		 * 	Ȼ�����
		 * 	���������������ֶ�����������Ļ������ܺͳ�û��target
		 * 	û������һ��
		 * 	���˾���target - �������ǰ��ģ��ܺ� Ȼ����� �������µĸ��� �õ���ֵ
		 * 	
		 * 	��һ������ʱ��û���ǵ��Ӻ͵ľ���ֵ֮����С����û���ǳ���targetʱ�����
		 * 	���Ǽ���double�ж�����ľ�ֵ�Ƿ����0.5���ж�
		 * */
		Arrays.sort(arr);
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			//i->length = length - i
			if(sum + arr[i] * (arr.length - i) <= target) {
				sum += arr[i];
			}
			else {
				double need = (target - sum) / (arr.length - i);
				double judge = need - (int) need;
				return (judge > 0.5) ? ((int) need + 1) : (int) need;
			}
		}
		return arr[arr.length - 1];
    }
}
