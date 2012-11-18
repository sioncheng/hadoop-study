package ch3;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.IOException;
import java.io.DataOutput;

public class TagedTextValue implements Writable{

	private Text tag = new Text();
	public void setTag(String tag){
		this.tag.set(tag);
	}
	public String getTag(){
		return this.tag.toString();
	}
	
	private Text value = new Text();
	public void setValue(String value){
		this.value.set(value);
	}
	public String getValue(){
		return this.value.toString();
	}
	
	
	public void readFields(DataInput in) 
			throws IOException{
		
		tag.readFields(in);
		value.readFields(in);
	}
	
	public void write(DataOutput out)
		throws IOException{
		
		tag.write(out);
		value.write(out);
	}
}
