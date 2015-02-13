//leetcode 2nd 2015/1/31
//Mingxuan Wang
//divide

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0){
			return Integer.MAX_VALUE;
		}
		
		long dividendTmp = Math.abs((long)dividend);
		long divisorTmp = Math.abs((long)divisor);
		long ret = 0;
		
		while (dividendTmp >= divisorTmp){
			long tmp = divisorTmp;
			int rst = 1;
			while (tmp <= dividendTmp){
				ret += rst;
				dividendTmp -= tmp;
				//bug here: rst and tmp must keep the same pace
				rst <<= 1;
				tmp <<= 1;
			}
		}
		
		ret = ((((dividend ^ divisor) >> 31) & 1) == 1) ? -ret : ret;
		
		if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE){
			return Integer.MAX_VALUE;
		}else{
			//bug here: forget (int)
			return (int)ret;
		}
		
    }
}