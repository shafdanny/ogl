package fr.unice.polytech.ogl.islac.tool;

public interface JSONTools {
	
	public Object getData(String json, String...key);	
	public String generateJSONString(Object...parameter);
}
