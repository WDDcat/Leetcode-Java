public class _76MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		/*
		 * 	һ��ʼ�뵽��һ�����ӶȺܸߵķ�����
		 * 	һ��ѭ������s�ִ��ĳ��ȣ�һ��ѭ�����Ʊ�����һ��ѭ�������ж�s���Ƿ���t�е��ַ�
		 * 	����ʱ�临�Ӷȱ�����ʵ��û�а취������⡣
		 * 	
		 * 	������һ���������ʵ��
		 * 	ʹ�� int[128] �����ĳһ�ַ����и����ַ����ֵĴ���,
		 * 	��ΪASCII��ֻ��0-127
		 * 	a[ch]++ �Ϳ��Խ��ַ�ch��������һ
		 * 
		 * 	Ȼ����ѧϰ�˻���������㷨�����Լ���ʵ��ǰ����ѭ���Ĺ���������O(n^2)��ΪO(n)
		 * 	����ָ�룬��ָ���ƶ�����һ�������Ӵ���λ�ã���ָ���ƶ�����һ���������ִ���λ��
		 * 	��¼��ʱ��״̬�ͳ��ȡ�
		 * 	�ظ������������¸��̵�״̬�ͳ��ȡ�
		 * 	����minR�ĳ�ʼֵ��Ϊ-1��Ϊ��ʵ��s="a" t = "b"�������Ӧ����""
		 * */
		
		if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
		
		int[] needs = new int[128];	//ͳ��t���ַ����ִ���
		int[] windows = new int[128];	//�����������ַ����ִ���
		
		for(char ch : t.toCharArray()) {
			needs[ch]++;
		}
		
		int l = 0, r = 0;
		int count = 0;
		
		int minLength = s.length() + 1;
		int minL = 0, minR = -1;
		
		while(r < s.length()) {
			char ch = s.charAt(r);
			if(needs[ch] > windows[ch]) {
				count++;
			}
			
			windows[ch]++;
			
			while(count == t.length()) {
				ch = s.charAt(l);
				if(needs[ch] == windows[ch]) {
					count--;
				}
				if(r - l + 1 < minLength) {
					minLength = r - l + 1;
					minL = l;
					minR = r;
				}
				windows[ch]--;
				l++;
			}
			r++;
		}
		
		return s.substring(minL, minR + 1);
    }
}
