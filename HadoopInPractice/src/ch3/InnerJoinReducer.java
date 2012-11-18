package ch3;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

import java.lang.Iterable;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.InterruptedException;

public class InnerJoinReducer extends Reducer<Text,TagedTextValue,Text,Text> {

	@Override
	public void reduce(Text key,Iterable<TagedTextValue> values,Context context)
		throws IOException,InterruptedException{
		
		String customerValue = null;
		ArrayList<String> orderValues = new ArrayList<String>();
		
		for(TagedTextValue ttv : values){
			if(ttv.getTag().indexOf("customers") >= 0){
				customerValue = ttv.getValue();

			}
			else{
				orderValues.add(ttv.getValue());
			}
			
		}
		
		if(orderValues.size() <= 0 || customerValue == null )
			return;
		

		for(String order : orderValues){
			String joinedValue = key.toString() + "," +  customerValue + "," + order ;
			
			context.write(new Text(""), new Text(joinedValue));
		}
	}
}
