package com.morgan.version;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VersionMap<String, String> ver = new VersionMapImpl<>();
		ver.put("Key1", "Value1");
		System.out.println(ver.get("Key1"));
		ver.setMaxSize(2);
		ver.put("Key1", "Value1");
		ver.put("Key2", "Value2");
		ver.put("Key3", "Value3");
		System.out.println(ver.get("Key1"));
		ver.put("Key2", "Value0");
		ver.put("Key2", "Value2");
		ver.snapshot();
		ver.put("Key1", "Value3");
		System.out.println(ver.get("Key1"));
		System.out.println(ver.getValVersion(1,"Key1"));
		
	}

}

