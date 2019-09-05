class HelloWorld{
static def void main(String[] args){
		String rigletName = "Tycoon_8872";
		String serverIp = "http://23.101.140.72:3010";
		def JSONParser parser=new JSONParser();
		Object obj;
		obj = parser.parse(new FileReader(file+"/"+rigletName+"/json/"+jsonFile));
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject brmObj = (JSONObject) jsonObject.get("brm");
		JSONObject reposObj = (JSONObject) brmObj.get("repositories");
		JSONArray repoArr = (JSONArray) reposObj.get("repository");
		String toolName = "nexus";
		Object res = parser.parse(getServerInfo(rigletName, serverIp,toolName));
		JSONObject toolObj = (JSONObject) res;
		String url = (String) toolObj.get("url");
		/////////////FOR TESTIG////////////////
		url="http://18.224.155.110:8081/nexus";
		String userName="admin";
		String password="admin123";
		//String userName = (String) toolObj.get("userName");
        	//String password = (String) toolObj.get("password");
        	String repoName = "";
        	String key = "";

		//      Create Repository
		Object repo.upto(repoArr){
		JSONObject repoObj = (JSONObject) repo;
        	Boolean createStatus = (Boolean) repoObj.get("create");
        	if(createStatus) {
        		repoName= (String) repoObj.get("repository_name");
        		String repoType = (String) repoObj.get("repository_type");
        		String repoPolicy = (String) repoObj.get("repository_policy");
        		String provider = (String) repoObj.get("repository_provider");
        		String data ="";
        		int length=3;
        		println("repoName::::"+repoName);
			while (data == "") {  
        		  String repoNameKey=repoName.replaceAll(" ","");  
        		  if(repoNameKey.length() >= length) {
  		        	  key=repoNameKey.substring(0, Math.min(repoNameKey.length(), length)).toUpperCase();
  			       }else {
  	        		  String appendStr = "";
  	        		  int projLength = repoNameKey.length();
  	        		  int currentLength=length;
  	        		  int len = currentLength%projLength;
  	        		  int repeat = currentLength/projLength;
          			  println("data........."+repeat);
  	        		  for (int i=0;i<repeat;i++) { 
  	        			  appendStr = appendStr + repoNameKey;
  	        		  }
  	        		  appendStr=appendStr+repoName.substring(0, Math.min(repoNameKey.length(), len));
  	        		  key=appendStr.toUpperCase();
  	        	  }
  		          String checkUrl=url+"/service/local/repositories/"+key;
		          String checkKey= checkUrl(checkUrl,userName,password);
		          if (checkKey != "success") {
			        	 length=length + 1;
			      }else {
			    	  println("url "+url);
			    	  String projUrl = url+"/service/local/repositories";
		        	  boolean createProj = true;
		        	  while (createProj == true) {
		        		  String createRepoStatus=createProject(projUrl,userName,password,repoName,repoType,key,repoPolicy,provider);
		        		  if(createRepoStatus == "err") {
			        		  repoName = "rig-"+repoName;
			        	  }else {
			        		  println("err "+createRepoStatus);
			        		  createProj = false; 
			        		  data = "success";
                            }
                        } 
		        	}
			    }
            }
        }
    }
}
