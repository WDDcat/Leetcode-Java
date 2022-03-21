package general_0700_0799;
import java.util.ArrayList;
import java.util.List;

public class _739_Daily_Temperatures {
	
	/*
	 * 	�Լ�������ķ���
	 * 	��һ��union�洢δ�ҵ������¶ȵ�λ�ú��¶�ֵ
	 * 	
	 * 	�������飬i<i+1ʱ�Ͱ�ans[i] = 1
	 * 	�������ȷ���ͷŽ�һ����������List��
	 * 	ÿ�α�����һ��������������list�ǲ�����ֵ
	 * 	�еĻ�������һ���С�ڵ�ǰ���Ķ��ó���λ�����������ȥ
	 * 
	 * 	Ȼ���ֲ���������һ��[76,76,...,76,76]
	 * 	���ּ���һ��bool��raise��
	 * 	���¶ȵ���ʱ��true
	 * 	����ֻ����һ��������ʱ�Ż������������
	 * 	���û�и��ߵĻ���˵�����ߵ�ֵ���޷����㣬���ֵ�϶�Ҳ����
	 * */
	
	private class Union{
		int pos;
		int num;
		Union(int p, int n) {
			pos = p;
			num = n;
		}
	}
	
	public int[] dailyTemperatures(int[] T) {
		boolean raise = false;
		List<Union> unpredict = new ArrayList<>();
		int[] ans = new int[T.length];

		for (int i = 1; i < T.length; i++) {
			if (T[i] > T[i - 1]) {
				ans[i - 1] = 1;
				raise = true;
			} else {
				Union union = new Union(i - 1, T[i - 1]);
				unpredict.add(union);
				raise = false;
			}
			if (unpredict.size() > 0 && raise) {
				System.out.println(i + " in");
				for (int j = 0; j < unpredict.size(); j++) {
					if (T[i] > unpredict.get(j).num) {
						System.out.println(T[i] + " > " + unpredict.get(j).num);
						ans[unpredict.get(j).pos] = (i - unpredict.get(j).pos);
						System.out.println("ans[" + unpredict.get(j).pos + "] = " + (i - unpredict.get(j).pos));
						unpredict.remove(j--);
					}
				}
			}
		}
		ans[T.length - 1] = 0;
		for (int i = 0; i < unpredict.size(); i++) {
			ans[unpredict.get(i).pos] = 0;
		}
		return ans;
	}

	@SuppressWarnings("unused")
	private void print(List<Union> list) {
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).pos + ":" + list.get(i).num + " -> ");
		}
		System.out.println("]");
	}
}