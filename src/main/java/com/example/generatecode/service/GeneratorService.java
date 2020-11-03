package com.example.generatecode.service;

import java.util.List;
import java.util.Map;

public interface GeneratorService {
	List<Map<String, Object>> list();

	byte[] generatorCode(String[] tableNames);
}
