package me.xtrm.delta.loader.api.data;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class LoaderData {

	private String mainClass;
	
	private List<String> repositories;
	private List<String> libraries;
	
	public String getMainClass() {
		return mainClass;
	}
	
	public List<String> getRepositories(){
		return repositories;
	}
	
	public List<String> getLibraries() {
		return libraries;
	}
	
	public static LoaderData parse(InputStream is) {
		Yaml yaml = new Yaml(new Constructor(LoaderData.class));
		return yaml.load(is);
	}
	
	public static void main(String[] args) {
		Yaml yaml = new Yaml();
		StringWriter sw = new StringWriter();
		Map<String, Object> owo = new HashMap<>();
		
		owo.put("mainClass", "me.xtrm.delta.loader.DeltaLoader");
		
		owo.put("repositories", Arrays.asList("https://nkosmos.github.io/maven/", "https://jcenter.bintray.com/", "https://repo1.maven.org/maven2/"));
		owo.put("libraries", Arrays.asList("me.xtrm.delta:delta-api:1.2.0", "club.minnced:discord-rpc-release:v3.4.0", "club.minnced:java-discord-rpc:2.0.1", "net.java.dev.jna:jna:4.4.0", "com.thealtening.api:api:4.0.1", "com.thealtening.auth:auth:3.0.2", "me.xtrm.delta:delta-client:b4"));
		
		yaml.dump(owo, sw);
		System.out.println(sw.toString());
	}
}
