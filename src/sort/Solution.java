package sort;

public class Solution {
	public static void main(String[] args){
		StringBuffer str = new StringBuffer("We Are Happy");
		System.out.println(new Solution().replaceSpace(str));
	}
	
	
    public String replaceSpace(StringBuffer str) {
    	return str.toString().replaceAll(" ", "%20");
    }
}
