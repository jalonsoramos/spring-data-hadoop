package com.autentia.tutoriales;

import java.io.IOException;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirQualityMapper extends Mapper<Object, Text, Text, DoubleWritable> {

	private static final String SEPARATOR = ";";

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		final String[] values = value.toString().split(SEPARATOR);

		final String co = format(values[1]);
		final String province = format(values[10]);

		if (NumberUtils.isNumber(co.toString())) {
			context.write(new Text(province), new DoubleWritable(NumberUtils.toDouble(co)));
		}
	}

	private String format(String value) {
		return value.trim();
	}
}