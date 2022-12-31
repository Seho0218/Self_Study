# GenieProject

기본세팅

1.gradle Update

	//providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	//뷰를 jsp로 사용하기 위해서 프레임워크를 추가한다.
	// https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-jasper
	implementation 'org.apache.tomcat.embed:tomcat-embed-jasper:9.0.58'
	// https://mvnrepository.com/artifact/javax.servlet/jstl
	implementation 'javax.servlet:jstl:1.2'
	// https://mvnrepository.com/artifact/javax.inject/javax.inject
	implementation group: 'javax.inject', name: 'javax.inject', version: '1'
	// https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload
	implementation 'commons-fileupload:commons-fileupload:1.4'


2.application.yml 파일 생성

-url 변경 -> genie
-포트번호 
-아이디 
-비밀번호 

3.mapper 파일 생성

4.필요 패키지 생성
-controller
-dao
-service
-vo
-interceptor

5.View 파일 생성 

6.인클루드 작업
@Component
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GenieProjectApplication.class);
	}
	@Bean
	public ConfigurableServletWebServerFactory configuraServletWebServerFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				super.postProcessContext(context);
				JspPropertyGroup jspPropertyGroup = new JspPropertyGroup();
				jspPropertyGroup.addUrlPattern("*.jsp");
				jspPropertyGroup.addUrlPattern("*.jspf");
				jspPropertyGroup.setPageEncoding("UTF-8");
				jspPropertyGroup.setScriptingInvalid("true");
				jspPropertyGroup.addIncludePrelude("/WEB-INF/views/inc/top.jspf");
				jspPropertyGroup.addIncludeCoda("/WEB-INF/views/inc/bottom.jspf");
				jspPropertyGroup.setTrimWhitespace("true");
				jspPropertyGroup.setDefaultContentType("text/html");
				
				JspPropertyGroupDescriptorImpl jspPropertyGroupDescriptor = new JspPropertyGroupDescriptorImpl(jspPropertyGroup);
				context.setJspConfigDescriptor(new JspConfigDescriptorImpl(Collections.singletonList(jspPropertyGroupDescriptor), 					Collections.emptyList()));
						
				
			}
		};
	}

}

7.genie, home 클라스 생성 

.genie{
	height: 15vh;
	width: 100%;
	background-size: cover;
	background-position: center; 
}

8.화면 구성시, home 

<sction class="home">
	자유롭게 변경가능!
</sction>
