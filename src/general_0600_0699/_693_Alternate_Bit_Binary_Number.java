package general_0600_0699;

public class _693_Alternate_Bit_Binary_Number {
	
	/*
	 * ��ѧ����һ���·���
	 * ���� n �Ķ���������   1010101b
	 * n >> 1 ����       0101010b
	 * m = n + n>>1 ���� 1111111b
	 * 
	 * ����ж������� m �Ƿ�����ȫ 1
	 *     m =   01111111b
	 * m + 1 =   10000000b
	 * m & m+1 = 00000000b
	 */
	
	public boolean hasAlternatingBits(int n) {
        int m = n ^ (n >> 1);
        return (m & (m + 1)) == 0;
    }
	
//	/*
//	 * ���ϳ�2��Ȼ���¼��һ�γ�2�Ľ��
//	 * ���������� (double) n / 2.0 �� n / 2 ���жϳ�2֮�������
//	 * ���������ⶼ׼��push�� ͻȻ�뵽 �������� % ȡ�����ʽ����zz�ˡ�
//	 * */
//	
//	public boolean hasAlternatingBits(int n) {
//		int last = -1;
//		while(n > 0) {
//			if((double) n / 2.0 == n / 2) {
//				if(last == 0) return false;
//				last = 0;
//			} else {
//				if(last == 1) return false;
//				last = 1;
//			}
//			n /= 2;
//		}
//		return true;
//    }
}
