def call(){
    def repoUrl= "http://18.224.155.110:8081/nexus/service/local/repositories"
    /*def proc= "curl -u admin:admin123 http://18.224.155.110:8081/nexus/service/local/repositories".execute()
    Thread.start { System.err << proc.err }
    proc.waitFor()*/
    
    def response = "curl -v -k -X POST -H \"Content-Type: application/json\" http://admin:admin123@http://18.224.155.110:8081/nexus/service/local/repositories".execute().text

    println response
    }
