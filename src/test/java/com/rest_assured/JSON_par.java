package com.rest_assured;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import com.sun.xml.bind.v2.runtime.reflect.ListIterator;

public class JSON_par {

	@Test
	public void json() throws IOException, ParseException {

		File f = new File(
				"C:\\Users\\heman\\eclipse-workspace\\AdactinProject\\src\\test\\java\\com\\rest_assured\\payload.json");

		FileReader fr = new FileReader(f);

		JSONParser p = new JSONParser();

		Object parse = p.parse(fr);

		JSONObject ob = (JSONObject) parse;

		Object object = ob.get("team");

		String string = object.toString();
		System.out.println(string);

		Assert.assertEquals("India", string);

		System.out.println("sucess");

	}

	@Test
	public void test_jsonArray() throws IOException, ParseException {
		File f = new File(
				"C:\\Users\\heman\\eclipse-workspace\\AdactinProject\\src\\test\\java\\com\\rest_assured\\payload.json");

		FileReader fr = new FileReader(f);

		JSONParser p = new JSONParser();

		Object parse = p.parse(fr);

		JSONObject ob = (JSONObject) parse;

		Object object = ob.get("player");

		String string = object.toString();
		System.out.println(string);

		Assert.assertEquals("Dhoni", string);

		System.out.println("sucess");
	}

}
