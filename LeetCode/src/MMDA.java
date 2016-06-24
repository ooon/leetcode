import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Info{
	
	public String content;
	public Date time  = new Date();
}

//实现一个按内容去重，按时间逆序的非递归排序算法：
public class MMDA {
	
	
	public Info[] duplicate_remove(Info arr[]){
		//按时间排序
		Map<String,Integer> dic = new HashMap<String,Integer>();
		Info[] result = MergeSort (arr,arr.length);
		//按内容去重
		Info[] copy = new Info[result.length];
		int j = 0;
		for(int i = 0 ; i < result.length ; i ++){
			if(!dic.containsKey(result[i].content)){
				dic.put(result[i].content, 1);
				copy[j++] = result[i];
			}
		}
		return copy;
		
	}
	
	//Info为信息数组，包括时间与内容
	public Info[] MergeSort(Info arr[],int length){
		Info temp[] = new Info[length];
	    int i = 1;
	    //开始以间隔为1的进行归并，也就是说，第一个元素跟第二个进行归并。第三个与第四个进行归并；
	    //然后，再以间隔为2的进行归并，1-4进行归并，5-8进行归并；
	    //再以2*2的间隔，同理，知道2*k超过数组长度为止。
	    //归并的最后一段可能会有不足  比如  3  3  1这三段去归并。
	    while(i<length){
	        Merge(arr,temp,i,length);
	        i *= 2;
	    }
	    return temp;
	}
	/**
	 * 
	 * @param arr 所有数
	 * @param temp 等量的新的空间
	 * @param k 路归并排序
	 * @param length 长度
	 */
	public void Merge(Info []arr,Info []temp,int k,int length){
	    int i = 0,j;
	    while(i <= length-2*k){
	        sort(arr,temp,i,i+k-1,i+2*k-1);
	        i += 2*k;
	    }
	    if(i < length-k+1)//如过剩余个数比一个k长度还多...那么就在进行一次合并
	        sort(arr,temp,i,i+k-1,length-1);
	    else{
	    	for(j=i;j<length;j++)
	            temp[j] = arr[j];
	    }
	    for(i=0;i<length;i++)
	        arr[i] = temp[i];
	}
	void sort(Info []arr,Info []temp,int begin,int m,int end){
	    int i=begin,j=m+1,k,h;
	    for(k=i; i<=m && j<=end;k++){
	        if(arr[i].time.after( arr[j].time))
	        	temp[k] = arr[i++];
	        else
	        	temp[k] = arr[j++];
	    }
	    if(i <= m){
	        for(h=0; h<=m-i;h++)
	        	temp[k+h] = arr[i+h];
	    }else{
	        for(h=0; h<=end-j;h++)
	        	temp[k+h] = arr[j+h];
	    }
	}




		
	// 归并排序的实现
	public static void main(String[] args) {

//		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 ,-11};
//		MMDA mm = new MMDA();
//		mm.MergeSort(nums, nums.length);
//		System.out.println(Arrays.toString(nums));
//		MMDA.sort(nums, 0, nums.length-1);
//		System.out.println(Arrays.toString(nums));
	}
}
	

