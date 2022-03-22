package general_2000_2099;

public class _2038_Delete_the_Color_If_Adjacent_Colors_are_Same {
	
	/*
	 * �Լ������˸�����
	 * �������ұ���һ�� String ��¼ "AAA" �� "BBB" �ĸ���
	 * "AAAA" �ͼ�������
	 * ��Ϊ ĳһ�� ɾ����ĸ����Ӱ�� ��һ��
	 * ���Ƚ�˭�Ķ������
	 * 
	 * @ �������õķ����Ǽ�¼ǰ����������ֵ��Ȼ��������Ⱦͼ���
	 * @ ����õķ����Ǽ�¼��ͬ��ĸ����������3�ͼ���
	 * */
	
	public boolean winnerOfGame(String colors) {
		if(colors.length() < 3) {
			return false;
		}
		
		char last, lastlast;
		lastlast = colors.charAt(0);
		last = colors.charAt(1);
		int a = 0, b = 0;
		for(int i = 2; i < colors.length(); i++) {
			char cur = colors.charAt(i);
			if(cur == last && last == lastlast) {
				if(last == 'A') a++;
				else b++;
			}
			lastlast = last;
			last = cur;
		}
		return a > b;
    }
	
	/*
	 * ��򵥵ķ���
	 * ÿ����һ�� "AAA"-��"AA" Ȼ������һ�� "BBB"-��"BB"
	 * �Ҳ���������
	 * ��ϧ ��ʱ��
	 * */
	
//	public boolean winnerOfGame(String colors) {
//		StringBuilder sb = new StringBuilder(colors);
//		while(true) {
//			int i;
//			if((i = sb.indexOf("AAA")) >= 0) {
//				sb.replace(i, i + 3, "AA");
//				System.out.println(sb.toString());
//			} else {
//				return false;
//			}
//			
//			if((i = sb.indexOf("BBB")) >= 0) {
//				sb.replace(i, i + 3, "BB");
//				System.out.println(sb.toString());
//			} else {
//				return true;
//			}
//		}
//    }
}
