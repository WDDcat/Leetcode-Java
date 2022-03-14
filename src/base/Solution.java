package base;
import general_0500_0599._599_Minimum_Index_Sum_of_Two_Lists;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_599_Minimum_Index_Sum_of_Two_Lists test = new _599_Minimum_Index_Sum_of_Two_Lists();
		
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"KFC", "Shogun", "Burger King"};
		
		String[] list = test.findRestaurant(list1, list2);
		for(String s : list) {
			System.out.println(s);
		}
		return;
		
	}

}
