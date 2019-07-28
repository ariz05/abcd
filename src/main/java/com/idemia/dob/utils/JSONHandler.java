package com.idemia.dob.utils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.SystemException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONHandler {

	/**
	 * Logger object
	 */
	private static final Logger LOGGER = Logger.getLogger(JSONHandler.class);

	/**
	 * Instantiates a new JSON handler.
	 */
	private JSONHandler() {
	}

	/**
	 * Utility method to convert UserDetails POJO to JSON string
	 * 
	 * @param userDetails user details POJO
	 * @return mapped JSON string
	 * @throws SystemException
	 */
	public static String convertToJSONString(final Object userDetails) throws SystemException {
		// Create instance of ObjectMapper that will be used for JSON conversion
		LOGGER.trace("Converting UserDetails POJO to JSON string started:::");
		final ObjectMapper jsonMapper = new ObjectMapper();

		String jsonString = null;
		try {
			LOGGER.debug("UserDetails POJO for JSON conversion: \n" + userDetails);
			jsonString = jsonMapper.writeValueAsString(userDetails);
			LOGGER.debug("Converted JSON string: " + jsonString);

			// Get the JSON tree from mapped JSON string for tree manipulation
			final JsonNode jsonUserDetailsNode = jsonMapper.readTree(jsonString);

			// Convert modified JSON tree to JSON string for further processing
			jsonString = jsonMapper.writeValueAsString(jsonUserDetailsNode);
			LOGGER.debug("Final UserDetail JSON string: " + jsonString);
		} catch (IOException ioExp) {
			LOGGER.error("UserDetails POJO to JSON string failed.\n" + ioExp);
//			throw new SystemException(ioExp, PropertiesUtil.getProperty("ERR0009"));
		}
		LOGGER.trace("Converting UserDetails POJO to JSON string completed:::");
		// Return the mapped JSON string
		return jsonString;
	}

	/**
	 * Utility method to convert input string to specified POJO type
	 * 
	 * @param jsonString json string
	 * @param pojoClass  class type of POJO
	 * @return converted POJO object
	 * @throws SystemException
	 */
	public static <T> T convertJSONStringtoPOJO(final String jsonString, final Class<T> pojoClass)
			throws SystemException {
		LOGGER.trace("Converting JSON string to POJO started:::");
		// Create instance of ObjectMapper for json conversion
		LOGGER.debug("Converting JSON string to POJO: " + jsonString);
		final ObjectMapper jsonMapper = new ObjectMapper();
		T responseData = null;
		try {
			// Convert JSON string to POJO of type T
			responseData = jsonMapper.readValue(jsonString, pojoClass);
			LOGGER.debug("JSON string converted to POJO");
		} catch (IOException ioExp) {
			LOGGER.error("JSON string conversion to POJO failed.\n" + ioExp);
//			throw new SystemException(ioExp, PropertiesUtil.getProperty("ERR0009"));
		}
		LOGGER.trace("Converting JSON string to POJO completed:::");
		// Return converted POJO instance
		return responseData;
	}

	public static <T> T convertJSONStringtoPOJO(final String jsonString, final TypeReference<T> pojoClass)
			throws SystemException {
		LOGGER.trace("Converting JSON string to POJO started:::");
		// Create instance of ObjectMapper for json conversion
		LOGGER.debug("Converting JSON string to POJO: " + jsonString);
		final ObjectMapper jsonMapper = new ObjectMapper();
		T ldapUserDetailsJson = null;
		try {
			// Convert JSON string to POJO of type T
			ldapUserDetailsJson = jsonMapper.readValue(jsonString, pojoClass);
			LOGGER.debug("JSON string converted to POJO");
		} catch (IOException ioExp) {
			LOGGER.error("JSON string conversion to POJO failed.\n" + ioExp);
//			throw new SystemException(ioExp, PropertiesUtil.getProperty("ERR0009"));
		}
		LOGGER.trace("Converting JSON string to POJO completed:::");
		// Return converted POJO instance
		return ldapUserDetailsJson;
	}
	
	public static boolean isJSONValid(String data) {
	    try {
	        new JSONObject(data);
	    } catch (JSONException ex) {
	        try {
	            new JSONArray(data);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}

}
