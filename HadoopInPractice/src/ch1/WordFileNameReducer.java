package ch1;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

import java.lang.Iterable;
import java.io.IOException;
import java.lang.InterruptedException;
import java.lang.StringBuilder;


public class WordFileNameReducer 
	extends Reducer<Text,Text,Text,Text> {
	
	private Text docIds = new Text();
	
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context)
		throws IOException,InterruptedException{

		StringBuilder sb = new StringBuilder();			
		for(Text docId : values){
			sb.append(docId.toString());
			sb.append(",");
		}
		docIds.set(sb.toString());
	
		context.write(key,docIds);
	}
}
