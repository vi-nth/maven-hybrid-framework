package environmentConfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;


@Sources({"classpath:${envOwner}.properties"})
public interface Environment extends Config {
	String osName();
	
	@Key("app.url")
	String appUrl();
	
	@Key("app.username")
	String appUser();
	
	@Key("app.password")
	String appPassword();

}
