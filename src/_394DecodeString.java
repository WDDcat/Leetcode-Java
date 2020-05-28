import java.util.Stack;

public class _394DecodeString {
	public String decodeString(String s) {
		/*
		 * 	���������ʽ��ֵ
		 * 	2[a3[bc]]  -->> 2 *(a + 3 * (bc))
		 * 	���ջ��¼һ�¾�����~
		 * 	����������Ҫ��StringBuilderȥ��
		 * 	����ֱ�����ַ�����ӵ���ʽ���ᳬʱ*/
		
		Stack<String> stack = new Stack<>();
		int num = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch >= 48 && ch <= 57) {
				num = num * 10 + (ch - 48);
			}
			else if(ch == '[') {
				stack.push(String.valueOf(num));
				num = 0;
				stack.push("[");
			}
			else if(ch == ']') {
				String unit = "";
				while(true) {
					String string = stack.pop();
					if(string.equals("[")) break;
					unit = string + unit;
				}
				int count = Integer.valueOf(stack.pop());
				String string = "";
				for(int j = 0; j < count; j++) {
					string += unit;
				}
				stack.push(string);
			}
			else {
				stack.push(String.valueOf(ch));
			}
		}
		String ans = "";
		while(!stack.isEmpty()) {
			ans = stack.pop() + ans;
		}
		return ans;
    }
}
