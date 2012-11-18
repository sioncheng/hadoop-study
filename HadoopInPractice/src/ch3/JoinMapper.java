package ch3;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.lang.InterruptedException;

public class JoinMapper extends Mapper<LongWritable,Text,Text,TagedTextValue>{

	private Text documentId;
	
	/*@Override
	public void setup(Context context){
		FileSplit fileSplit = (FileSplit)context.getInputSplit();		
		documentId = new Text(fileSplit.getPath().getName());
	}*/
	
	@Override
	public void map(LongWritable key,Text value,Context context)
		throws IOException,InterruptedException{
		
		FileSplit fileSplit = (FileSplit)context.getInputSplit();		
		documentId = new Text(fileSplit.getPath().getName());
		
		String valueString = value.toString();	
		if(valueString.indexOf("#") == 0){
			return;
		}

		int i = valueString.indexOf(',');
		Text outputKey = new Text(valueString.substring(0,i));
		
		TagedTextValue ttv = new TagedTextValue();
		ttv.setTag(documentId.toString());
		ttv.setValue(valueString.substring(i+1));
		
		
		context.write(outputKey,ttv);
	}
}
